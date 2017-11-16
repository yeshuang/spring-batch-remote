package com.zyl.jpa.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.zyl.jpa.domain.ZylGome;

public interface ZYLGomeRepository extends JpaRepository<ZylGome,Integer>,QueryDslPredicateExecutor<ZylGome>{

}
