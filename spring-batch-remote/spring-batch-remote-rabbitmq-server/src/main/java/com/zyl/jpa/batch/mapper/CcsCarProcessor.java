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
	public static boolean reStart = false;
	
	
	@Autowired
	ZYLGomeTestRepository zYLGomeTestRepository;
	
	@Override
	public CcsCar process(CcsCar c) throws Exception {
		System.out.println(c.getOrg());
		
		/*if(i > 20){
			if(!reStart){
				reStart = true;
				throw new Exception();
			}
		}*/
		i++;
		System.out.println(c.getCardId());
		System.out.println(c.getAcctNbr());
		
		String a = UUID.randomUUID().toString();
		ZylGomeTest t = new ZylGomeTest(a,String.valueOf(c.getCardId()),Short.parseShort("20"),GomeType.gome02,50L,"测试哈哈哈",new BigDecimal("123"),1);
		zYLGomeTestRepository.save(t);
		return c;
	}

}
