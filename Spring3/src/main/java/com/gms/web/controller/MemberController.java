package com.gms.web.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gms.web.domain.MemberDTO;
import com.gms.web.service.MemberService;
import com.gms.web.service.impl.MemberServiceImpl;
@Controller
@RequestMapping("/member")
public class MemberController {
	static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberDTO member;
	@Autowired MemberService memberService;
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void add(@ModelAttribute("member") MemberDTO member) {
		logger.info("\n --------- MemberController {} !!--------","add()");
		System.out.println("name is : "+ member.getName());
		memberService.add(member);
	}
	@RequestMapping("/list")
	public void list() {}
	@RequestMapping("/search")
	public void search() {}
	@RequestMapping("/retrieve")
	public void retrieve() {}
	@RequestMapping("/count")
	public void count() {}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public void modify(@ModelAttribute("member") MemberDTO member) {
		logger.info("\n --------- MemberController {} !!--------","modify()");
		memberService.modify(member);	
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public void remove(@ModelAttribute("member") MemberDTO member) {
		logger.info("\n --------- MemberController {} !!--------","remove()");
		memberService.remove(member);
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("member") MemberDTO member, Model model, HttpSession session) {
		logger.info("\n --------- MemberController {} !!--------","login()");
		Map<String, String> map = new HashMap<>();
		if(memberService.login(member)) {
			System.out.println("로그인성공");
			map.put("userid", member.getUserid());
			model.addAttribute("user",memberService.retrieve(map));
		}else {
			System.out.println("로그인실패");
		}
		return "login__success";
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("\n --------- MemberController {} !!--------","logout()");
		return "redirect:/";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
