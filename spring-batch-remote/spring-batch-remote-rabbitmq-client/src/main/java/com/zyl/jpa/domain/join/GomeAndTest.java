package com.zyl.jpa.domain.join;

import com.zyl.jpa.enums.GomeType;

public class GomeAndTest {

	private Integer id;
	private String name;
	private Integer age;
	private String card;
	private String uuid;
	private Character v;
	private GomeType gometype;
	private Long num;
	private String comment;
	
	public GomeAndTest(Integer id, String name, Integer age, String card,
			String uuid, Character v, GomeType gometype, Long num,
			String comment) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.card = card;
		this.uuid = uuid;
		this.v = v;
		this.gometype = gometype;
		this.num = num;
		this.comment = comment;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Character getV() {
		return v;
	}
	public void setV(Character v) {
		this.v = v;
	}
	public GomeType getGometype() {
		return gometype;
	}
	public void setGometype(GomeType gometype) {
		this.gometype = gometype;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
