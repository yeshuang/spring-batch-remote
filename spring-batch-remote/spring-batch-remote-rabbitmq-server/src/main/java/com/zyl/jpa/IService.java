package com.zyl.jpa;


public abstract class IService {

	public abstract String ZYLGomeRepository();
	public abstract void ZYLGomeTestRepository();
	public abstract void findGomeAndTest(String uuid);
	public abstract void saveWithTran() throws Exception;
	public abstract void saveWithTran1() throws Exception;
	public abstract void read();
	public abstract void write();
	public abstract void write1();
}
