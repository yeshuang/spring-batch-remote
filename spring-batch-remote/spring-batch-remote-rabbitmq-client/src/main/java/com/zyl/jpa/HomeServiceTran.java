package com.zyl.jpa;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.jpa.domain.ZylGomeTest;
import com.zyl.jpa.enums.GomeType;
import com.zyl.jpa.model.ZYLGomeTestRepository;

/**
 * Handles requests for the application home page.
 */
@Service
public class HomeServiceTran {

	@Autowired
	ZYLGomeTestRepository zYLGomeTestRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
	public void saveWithNoTran(ZylGomeTest t) throws Exception{
		 t.setComment("fdsfdsf");
	}
}
