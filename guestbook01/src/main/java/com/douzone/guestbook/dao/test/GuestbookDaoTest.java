package com.douzone.guestbook.dao.test;

import java.util.List;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;
import java.util.List;



public class GuestbookDaoTest {
	public static void main(String[] args) {
		 insertTest();
		findAllTest();
		delete();
	}

	private static void delete() {
		GuestbookVo vo = new GuestbookVo();
		vo.setPassword("");
		
	}

	private static void findAllTest() {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		for(GuestbookVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		GuestbookVo vo = new GuestbookVo();
		vo.setName("");
		vo.setPassword("");
		vo.setMessage("");
		vo.setRegDate("");
		
		new GuestbookDao().insert(vo);
	}
}