package com.douzone.emaillist.dao.test;

import java.util.List;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmaillistVo;

public class EmaillistDaoTest {
	public static void main(String[] args) {
		 insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<EmaillistVo> list = new EmaillistDao().findAll();
		for(EmaillistVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		EmaillistVo vo = new EmaillistVo();
		vo.setFirstName("또2");
		vo.setLastName("치2");
		vo.setEmail("ddochi@gmail.com");
		
		new EmaillistDao().insert(vo);
	}
}