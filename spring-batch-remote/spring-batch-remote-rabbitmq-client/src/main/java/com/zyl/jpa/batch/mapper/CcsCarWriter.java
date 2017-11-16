package com.zyl.jpa.batch.mapper;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class CcsCarWriter implements ItemWriter<CcsCar>{

	public static int k = 0;

	@Override
	public void write(List<? extends CcsCar> list) throws Exception {
		
		/*synchronized (this) {
			k++;
			if(k == 6){
				throw new Exception();
			}
		}*/
		for(CcsCar car:list){
			System.out.println("write:" + car);
		}
	}
}
