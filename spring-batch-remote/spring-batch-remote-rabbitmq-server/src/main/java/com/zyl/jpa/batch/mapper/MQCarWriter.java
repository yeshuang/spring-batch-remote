package com.zyl.jpa.batch.mapper;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.integration.chunk.ChunkRequest;
import org.springframework.batch.integration.chunk.ChunkResponse;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyl.jpa.batch.rpc.BatchService;

public class MQCarWriter extends StepExecutionListenerSupport implements ItemWriter<CcsCar>{

	public static Semaphore semaphore = new Semaphore(16);
	
	@Autowired
	public BatchService<CcsCar> batchService;
	
	private final LocalState localState = new LocalState();
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		localState.setStepExecution(stepExecution);
	}
	
	@Override
	public void write(List<? extends CcsCar> list) throws Exception {
		semaphore.acquire();

		ChunkRequest<CcsCar> chunkRequest = localState.getRequest(list);
		ChunkResponse respone = batchService.handleChunk(chunkRequest);
		if(respone != null && !respone.isSuccessful()){
			semaphore.release();
            throw new Exception();
		}
		
		semaphore.release();
	}
	
	private static class LocalState {

		private final AtomicInteger current = new AtomicInteger(-1);

		private StepExecution stepExecution;

		public <T> ChunkRequest<T> getRequest(List<? extends T> items) {
			return new ChunkRequest<T>(current.incrementAndGet(), items, getJobId(), createStepContribution());
		}

		public StepContribution createStepContribution() {
			return stepExecution.createStepContribution();
		}

		public Long getJobId() {
			return stepExecution.getJobExecution().getJobId();
		}

		public void setStepExecution(StepExecution stepExecution) {
			this.stepExecution = stepExecution;
		}
	}
}
