package com.peisia.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/getData")
	@ResponseBody
	public String getData() {
		// �����͸� �����ϰų� ������
		String data = "<p>Hello, World!</p>";
		return data;
	}
}