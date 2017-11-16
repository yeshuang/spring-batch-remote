
package com.zyl.jpa.batch.chunk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.step.item.Chunk;
import org.springframework.batch.core.step.item.ChunkProcessor;
import org.springframework.batch.core.step.skip.NonSkippableReadException;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipListenerFailedException;
import org.springframework.batch.integration.chunk.ChunkHandler;
import org.springframework.batch.integration.chunk.ChunkRequest;
import org.springframework.batch.integration.chunk.ChunkResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryException;
import org.springframework.util.Assert;

public class ChunkProcessorChunkHandler<S> implements ChunkHandler<S>, InitializingBean {

	private static final Log logger = LogFactory.getLog(ChunkProcessorChunkHandler.class);

	@Autowired
	private ChunkProcessor<S> chunkProcessor;

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(chunkProcessor, "chunkProcessor对象不能为空 ");
	}

	public ChunkResponse handleChunk(ChunkRequest<S> chunkRequest){

		if (logger.isDebugEnabled()) {
			logger.debug("执行请求参数: " + chunkRequest);
		}

		StepContribution stepContribution = chunkRequest.getStepContribution();

		Throwable failure = process(chunkRequest, stepContribution);
		if (failure != null) {
			return new ChunkResponse(false, chunkRequest.getSequence(), chunkRequest.getJobId(), stepContribution, failure.getClass().getName()
					+ ": " + failure.getMessage());
		}
 
		return new ChunkResponse(true, chunkRequest.getSequence(), chunkRequest.getJobId(), stepContribution);

	}

	public Throwable process(ChunkRequest<S> chunkRequest, StepContribution stepContribution){

		Chunk<S> chunk = new Chunk<S>(chunkRequest.getItems());
		Throwable failure = null;
		try {
			chunkProcessor.process(stepContribution, chunk);
		}
		catch (SkipLimitExceededException e) {
			failure = e;
		}
		catch (NonSkippableReadException e) {
			failure = e;
		}
		catch (SkipListenerFailedException e) {
			failure = e;
		}
		catch (RetryException e) {
			failure = e;
		}
		catch (JobInterruptedException e) {
			failure = e;
		}
		catch (Exception e) {
			failure = e;
		}

		return failure;

	}

}
