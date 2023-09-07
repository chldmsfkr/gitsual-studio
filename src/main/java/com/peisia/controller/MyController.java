package com.peisia.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/getData")
	@ResponseBody
	public String getData() {
		// 데이터를 생성하거나 가져옴
		String data = "<p>Hello, World!</p>";
		return data;
	}
}