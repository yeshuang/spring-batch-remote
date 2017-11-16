
package com.zyl.jpa.batch.chunk;

import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.listener.MulticasterBatchListener;
import org.springframework.batch.core.step.item.Chunk;
import org.springframework.batch.core.step.item.ChunkProcessor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

public class SimpleChunkProcessor<I, O> implements ChunkProcessor<I>, InitializingBean {

	private ItemProcessor<? super I, ? extends O> itemProcessor;

	private ItemWriter<? super O> itemWriter;

	private final MulticasterBatchListener<I, O> listener = new MulticasterBatchListener<I, O>();
 
	public SimpleChunkProcessor() {
		this(null, null);
	}

	public SimpleChunkProcessor(ItemProcessor<? super I, ? extends O> itemProcessor, ItemWriter<? super O> itemWriter) {
		this.itemProcessor = itemProcessor;
		this.itemWriter = itemWriter;
	}
 
	public void setItemProcessor(ItemProcessor<? super I, ? extends O> itemProcessor) {
		this.itemProcessor = itemProcessor;
	}
 
	public void setItemWriter(ItemWriter<? super O> itemWriter) {
		this.itemWriter = itemWriter;
	}
 
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(itemWriter, "ItemWriter must be set");
		Assert.notNull(itemProcessor, "ItemProcessor must be set");
	}
 
	public void setListeners(List<? extends StepListener> listeners) {
		for (StepListener listener : listeners) {
			registerListener(listener);
		}
	}
 
	public void registerListener(StepListener listener) {
		this.listener.register(listener);
	}
 
	protected MulticasterBatchListener<I, O> getListener() {
		return listener;
	}
 
	public final O doProcess(I item) throws Exception {

		if (itemProcessor == null) {
			@SuppressWarnings("unchecked")
			O result = (O) item;
			return result;
		}

		try {
			listener.beforeProcess(item);
			O result = itemProcessor.process(item);
			listener.afterProcess(item, result);
			return result;
		}
		catch (Exception e) {
			listener.onProcessError(item, e);
			throw e;
		}

	}
 
	public final void doWrite(List<O> items) throws Exception {

		if (itemWriter == null) {
			return;
		}

		try {
			listener.beforeWrite(items);
			writeItems(items);
			doAfterWrite(items);
		}
		catch (Exception e) {
			doOnWriteError(e, items);
			throw e;
		}

	}
 
	public void doAfterWrite(List<O> items) {
		listener.afterWrite(items);
	}
	public void doOnWriteError(Exception e, List<O> items) {
		listener.onWriteError(e, items);
	}

	public void writeItems(List<O> items) throws Exception {
		if (itemWriter != null) {
			itemWriter.write(items);
		}
	}

	@Transactional(value="transactionManager",rollbackFor=Exception.class,propagation = Propagation.REQUIRES_NEW)
	public void process(StepContribution contribution, Chunk<I> inputs) throws Exception {

		initializeUserData(inputs);

 		if (isComplete(inputs)) {
			return;
		}
 
		Chunk<O> outputs = transform(contribution, inputs);
 
		contribution.incrementFilterCount(getFilterCount(inputs, outputs));
 
		write(contribution, inputs, getAdjustedOutputs(inputs, outputs));

	}
 
	public void initializeUserData(Chunk<I> inputs) {
		inputs.setUserData(inputs.size());
	}
 
	public int getFilterCount(Chunk<I> inputs, Chunk<O> outputs) {
		return (Integer) inputs.getUserData() - outputs.size();
	}
 
	public boolean isComplete(Chunk<I> inputs) {
		return inputs.isEmpty();
	}
 
	public Chunk<O> getAdjustedOutputs(Chunk<I> inputs, Chunk<O> outputs) {
		return outputs;
	}
 
	public void write(StepContribution contribution, Chunk<I> inputs, Chunk<O> outputs) throws Exception {
		try {
			doWrite(outputs.getItems());
		}
		catch (Exception e) {
 
			inputs.clear();
			throw e;
		}
		contribution.incrementWriteCount(outputs.size());
	}

	public Chunk<O> transform(StepContribution contribution, Chunk<I> inputs) throws Exception {
		Chunk<O> outputs = new Chunk<O>();
		for (Chunk<I>.ChunkIterator iterator = inputs.iterator(); iterator.hasNext();) {
			final I item = iterator.next();
			O output;
			try {
				output = doProcess(item);
			}
			catch (Exception e) {
				inputs.clear();
				throw e;
			}
			if (output != null) {
				outputs.add(output);
			}
			else {
				iterator.remove();
			}
		}
		return outputs;
	}

}
