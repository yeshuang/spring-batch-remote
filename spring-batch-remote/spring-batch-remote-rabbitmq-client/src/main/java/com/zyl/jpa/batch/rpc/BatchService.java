package com.zyl.jpa.batch.rpc;

import java.io.Serializable;

import org.springframework.batch.integration.chunk.ChunkRequest;
import org.springframework.batch.integration.chunk.ChunkResponse;

public interface BatchService<S extends Serializable>  {
	public ChunkResponse handleChunk(ChunkRequest<S> chunkRequest);
}
