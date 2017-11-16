package com.zyl.jpa;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.jpa.domain.QZylGomeTest;
import com.zyl.jpa.domain.ZylGome;
import com.zyl.jpa.domain.ZylGomeTest;
import com.zyl.jpa.domain.join.GomeAndTest;
import com.zyl.jpa.enums.GomeType;
import com.zyl.jpa.model.ZYLGomeRepository;
import com.zyl.jpa.model.ZYLGomeTestRepository;

/**
 * Handles requests for the application home page.
 */
@Service
public class HomeService{

	@Autowired
	ZYLGomeRepository zYLGomeRepository;

	@Autowired
	ZYLGomeTestRepository zYLGomeTestRepository;
	
	@Transactional
	public String ZYLGomeRepository(){
		ZylGome a = new ZylGome();
		a.setName("fvsdfdsf");
		zYLGomeRepository.save(a);
		a.setUuid("fdsfdsfsd");
		return a.getUuid();
	}
	
	@Transactional
	public void ZYLGomeTestRepository(){
		
		String a = UUID.randomUUID().toString();
		ZylGomeTest t = new ZylGomeTest(a,"1",Short.parseShort("20"),GomeType.gome02,50L,"测试哈哈哈",new BigDecimal("123"),1);
		
		t = zYLGomeTestRepository.findOne("16ffb2dc-704d-4290-a6f7-e4cb78412828");
		t.setName(String.valueOf(new Random().nextInt(100)));
	}
	
	
	public void a9999(){
		System.out.println(123456);
	}
	
	@Transactional
	public void findGomeAndTest(String uuid){
		GomeAndTest z = zYLGomeTestRepository.findGomeAndTest(uuid);
		System.out.println(z.getComment());
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void read(){
		QZylGomeTest qZylGomeTest = QZylGomeTest.zylGomeTest;
		Iterable<ZylGomeTest> zylGomeTest = zYLGomeTestRepository.findAll(qZylGomeTest.num.eq(1l));
		Iterator<ZylGomeTest> i= zylGomeTest.iterator();
		
		while(i.hasNext()){
			ZylGomeTest z = i.next();
			System.out.println(z.getUuid());
		}
		
		System.out.println("---------------------------------------------");

		zylGomeTest = zYLGomeTestRepository.findAll(qZylGomeTest.num.eq(1l));
		i= zylGomeTest.iterator();
		System.out.println(zYLGomeTestRepository.count(qZylGomeTest.num.eq(1l)));
		while(i.hasNext()){
			ZylGomeTest z = i.next();
			System.out.println(z.getUuid());
		}
	}
	
	@Transactional
	public void write(){
		String a = UUID.randomUUID().toString();
		ZylGomeTest t = new ZylGomeTest(a,"1",Short.parseShort("20"),GomeType.gome02,1L,"测试哈哈哈",new BigDecimal("123"),1);
		zYLGomeTestRepository.save(t);
	}

	@Transactional
	public void remove(){
		QZylGomeTest qZylGomeTest = QZylGomeTest.zylGomeTest;
		zYLGomeTestRepository.delete(zYLGomeTestRepository.findAll(qZylGomeTest.num.lt(5)));
		System.out.println("delete");
	}

	@Transactional()
	public void saveWithTran() throws Exception{
		String a = UUID.randomUUID().toString();
		ZylGomeTest t = new ZylGomeTest(a,"1",Short.parseShort("20"),GomeType.gome02,50L,"测试哈哈哈",new BigDecimal("123"),1);
		t=zYLGomeTestRepository.save(t);
		
		String b = UUID.randomUUID().toString();
		ZylGomeTest z = new ZylGomeTest(b,"1",Short.parseShort("20"),GomeType.gome02,50L,"测试哈哈哈",new BigDecimal("123"),1);
		z=zYLGomeTestRepository.save(z);
		this.saveWithTran1();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveWithTran1() throws Exception{
		String a = UUID.randomUUID().toString();
		ZylGomeTest t = new ZylGomeTest(a,"1",Short.parseShort("20"),GomeType.gome02,50L,"测试哈哈哈",new BigDecimal("123"),1);
		zYLGomeTestRepository.save(t);
		a = UUID.randomUUID().toString();
		ZylGomeTest t2 = new ZylGomeTest(a,"1",Short.parseShort("20"),GomeType.gome02,50L,"测试哈哈哈",new BigDecimal("123"),1);
		zYLGomeTestRepository.save(t2);
	}

    @Autowired
    HomeServiceTran homeServiceTran;

	public void write1() {

		
	}
 

}
