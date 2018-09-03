package com.gms.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gms.web.domain.MemberDTO;
import com.gms.web.mapper.MemberMapper;
import com.gms.web.mapper.MemberMapper;
import com.gms.web.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper memberDAO;
	@Override
	public void add(MemberDTO p) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy");
		String year= date.format(new Date());
		int age = Integer.parseInt(year) - (Integer.parseInt(p.getSsn().substring(0, 2))+1899);
		p.setAge(String.valueOf(age));
		char gd = p.getSsn().charAt(7);
		String gender = "";
		if(gd=='1'||gd=='3'){
			gender = "남";
			}else if(gd=='2'||gd=='4'){
			gender = "여";
			}else if(gd=='5'||gd=='6'){
			gender = "외국인";
			}else{
			gender = "다시 입력하세요";
			}
			p.setGender(gender);
		System.out.println("age : " + age);
		System.out.println("성별을 정하는 숫자 : " + gd);
		System.out.println("성별 : " + gender);
		memberDAO.insert(p);
	}

	@Override
	public List<?> list(Map<?, ?> p) {
		return memberDAO.selectList(p);}

	@Override
	public List<?> search(Map<?, ?> p) {
		return memberDAO.selectSome(p);}

	@Override
	public MemberDTO retrieve(Map<?, ?> p) {
		return memberDAO.selectOne(p);
	}

	@Override
	public int count(Map<?, ?> p) {
		return memberDAO.count(p);}

	@Override
	public void modify(MemberDTO p) {
		memberDAO.update(p);		
	}

	@Override
	public void remove(MemberDTO p) {
		memberDAO.delete(p);
			}

	@Override
	public boolean login(MemberDTO p) {
		return memberDAO.login(p).equals("1");
	}

}
