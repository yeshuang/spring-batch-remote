package com.zyl.jpa.batch.mapper;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyl.jpa.domain.ZylGomeTest;
import com.zyl.jpa.enums.GomeType;
import com.zyl.jpa.model.ZYLGomeTestRepository;

public class CcsCarProcessor implements ItemProcessor<CcsCar,CcsCar>{

	public static int i = 0;

	@Autowired
	ZYLGomeTestRepository zYLGomeTestRepository;
	
	@Override
	public CcsCar process(CcsCar c) throws Exception {

		synchronized (this) {
			i++;
			if(i == 58){
				throw new Exception();
			}
		}

		String a = UUID.randomUUID().toString();
		ZylGomeTest t = new ZylGomeTest(a,String.valueOf(c.getCardId()),Short.parseShort("20"),GomeType.gome02,50L,"测试哈哈哈",new BigDecimal("123"),1);
		zYLGomeTestRepository.save(t);
		return c;
	}

}
