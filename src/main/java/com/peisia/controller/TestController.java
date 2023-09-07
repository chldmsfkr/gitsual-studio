package com.peisia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.service.TestService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
//@AllArgsConstructor
@Controller
public class TestController {
		
	@Setter(onMethod_ = @Autowired)
	private TestService service;
	
	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
//	public void getOnePlusTwo() {
		log.info("getOnePlusTwo ==========================================");
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one) + Integer.parseInt(two); 
		
		log.info("(���� ��Ʈ�ѷ���) 1 ���ϱ� 2�� = " + sum);
		
		model.addAttribute("sum",sum);
	}
	
	/* ���� 1 */
	@GetMapping("/updateVisitantCount")
	public void updateVisitantCount() {
		log.info("========================================== : ��Ʈ�ѷ����� updateVisitantCount() ������");
		service.updateVisitantCount();
		
		log.info("(���� ��Ʈ�ѷ���) ������Ʈ �� ����");
	}
	
	/* ���� 2 */
	@GetMapping("/insertDoodle")
	public void insertDoodle() {
		log.info("========================================== : ��Ʈ�ѷ����� insertDoodle() ������");
		service.insertDoodle();
		log.info("(���� ��Ʈ�ѷ���) insert �� ����");
	}
	
	/* ���� 3 */
	@GetMapping("/delTest")
	public void delTest() {
		log.info("========================================== : ��Ʈ�ѷ����� delTest() ������");
		service.delTest();
		log.info("(���� ��Ʈ�ѷ���) delTest �� ����");
	}	
}
