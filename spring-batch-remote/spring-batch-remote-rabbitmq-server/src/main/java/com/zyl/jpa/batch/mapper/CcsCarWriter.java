package com.zyl.jpa.batch.mapper;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class CcsCarWriter implements ItemWriter<CcsCar>{

	@Override
	public void write(List<? extends CcsCar> list) throws Exception {
		for(CcsCar car:list){
			System.out.println("write:" + car);
		}
	}
}
