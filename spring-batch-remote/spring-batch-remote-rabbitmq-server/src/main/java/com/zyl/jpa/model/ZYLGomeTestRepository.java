package com.zyl.jpa.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.zyl.jpa.domain.ZylGomeTest;
import com.zyl.jpa.domain.join.GomeAndTest;

public interface ZYLGomeTestRepository extends JpaRepository<ZylGomeTest,String> ,QueryDslPredicateExecutor<ZylGomeTest> {
	
	public ZylGomeTest findByNameAndAgeLessThan(String name,short age);
	
	@Modifying
	public int deleteByUuid(String uuid);
	
	@Query("select new com.zyl.jpa.domain.join.GomeAndTest(b.id,b.name,b.age,b.card,b.uuid,b.v,a.gometype,a.num,a.comment) from ZylGomeTest a ,ZylGome b where a.uuid = b.uuid and a.uuid= :uuid")
	public GomeAndTest findGomeAndTest(@Param("uuid") String uuid);

}
