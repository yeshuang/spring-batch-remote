package com.zyl.jpa.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zyl.jpa.domain.CcsOrder;

public interface OrderRepository extends JpaRepository<CcsOrder,Long>{

}
