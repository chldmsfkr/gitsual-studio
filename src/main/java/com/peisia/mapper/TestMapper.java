package com.peisia.mapper;

import com.peisia.spring.dto.TestDto;

public interface TestMapper {
	public TestDto getData1();
	public TestDto getData2();
	public TestDto getData3();
	public TestDto getData4();
	
	public void updateVisitantCount();	//����1
	
	public void insertDoodle();			//����2
	
	public void delTest();				//����3
}