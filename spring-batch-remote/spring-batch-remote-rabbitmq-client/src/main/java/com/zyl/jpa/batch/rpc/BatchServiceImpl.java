package com.zyl.jpa.batch.rpc;

import org.springframework.batch.integration.chunk.ChunkRequest;
import org.springframework.batch.integration.chunk.ChunkResponse;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyl.jpa.batch.chunk.ChunkProcessorChunkHandler;
import com.zyl.jpa.batch.mapper.CcsCar;

public class BatchServiceImpl implements BatchService<CcsCar> {

	@Autowired
	ChunkProcessorChunkHandler<CcsCar> chunkProcessorChunkHandler;

	public ChunkResponse handleChunk(ChunkRequest<CcsCar> chunkRequest) {

		return chunkProcessorChunkHandler.handleChunk(chunkRequest);
	}

}
