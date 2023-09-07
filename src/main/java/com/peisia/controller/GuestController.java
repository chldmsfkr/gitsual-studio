package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.peisia.domain.GuestVO;
import com.peisia.service.GuestService;
import com.peisia.spring.mi.vo.kw.KWeatherVo;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*")
@AllArgsConstructor
@Controller
public class GuestController {

	private GuestService service;

	@GetMapping("/getList")
	public void getList(Model model) {
		model.addAttribute("list", service.getList());
	}

	@GetMapping({ "/read", "/modify" })
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("��Ʈ�ѷ� ==== �۹�ȣ ===============" + bno);
		model.addAttribute("read", service.read(bno));
	}

	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("��Ʈ�ѷ� ==== �۹�ȣ ===============" + bno);
		service.del(bno);
		return "redirect:/guest/getList"; // å p.245 ����
	}

	@PostMapping("/write")
	public String write(GuestVO gvo) {
		service.write(gvo);
		return "redirect:/guest/getList"; // å p.245 ����
	}

	@GetMapping("/write") // å p.239 /write �ߺ������� �̰� �۾��� ȭ���� ���� url ����
	public void write() {

	}

	@PostMapping("/modify")
	public String modify(GuestVO gvo) {
		service.modify(gvo);
		return "redirect:/guest/getList";
	}

	@RequestMapping("/w")
	public void w() {
		//// �츮���� ���� api ////
		// ���ڵ� ����Ű
		String API_KEY = "TDf%2Fho9nOMC2Ho71ocCWLwhwgKl9KBhSyyX67Pylaw%2BN0V7GQsIt%2B7UaJQsN9X%2FrpsIc%2FJJR%2Bltqo30nKyUXjA%3D%3D";

		String API_URL = "https://apis.data.go.kr/1360000/" + "AsosDalyInfoService/getWthrDataList"
				+ "?numOfRows=10&pageNo=1&dataCd=ASOS" + "&dateCd=DAY&startDt=20100101&endDt=20100102"
				+ "&stnIds=108&dataType=JSON&serviceKey=" + API_KEY;

//				* ���� * https �ƴ� http ��. https �� �������� ������ ó���� �ؾ���.	
		RestTemplate restTemplate = new RestTemplate();

		//// **** �߿� **** uri
		URI uri = null; // java.net.URI ����Ʈ �ϼ�
		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		String s = restTemplate.getForObject(uri, String.class); //
		log.info("====== �츮���� ���� �� ������? " + s);

		KWeatherVo kw = restTemplate.getForObject(uri, KWeatherVo.class); // �ڱ� Ŭ������ �ٲٽÿ�..
		log.info("==== json ==== : �츮���� ���� �� ������? : " + kw.response.body.dataType);
		String location = kw.response.body.items.item.get(0).stnNm;
		String tMin = kw.response.body.items.item.get(0).minTa;
		String tMax = kw.response.body.items.item.get(0).maxTa;
		String ddara = String.format("==== json ==== : ������ �����Դϴ�~ ���� %s �� ��������� %s �� �ְ� ����� %s �����ϴ�. ���������ϴ�.", location,
				tMin, tMax);
		log.info(ddara);
	}

	@RequestMapping("/test")
	public void test(HttpServletRequest request, Model m) {
		setCp(m, request.getContextPath());
		m.addAttribute("a", "��");
		m.addAttribute("b", "��");
	}

	public void setCp(Model m, String cp) {
		m.addAttribute("cp", cp);
		log.info("==== ���ؽ�Ʈ �н���:" + cp);
	}

	@RequestMapping("/test2")
	public void test2() {

	}

	@RequestMapping("/testapi")
	public void testapi() {

	}
}
