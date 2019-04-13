package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


public class GenerateMessageServiceTest {
	@Test
	public void testOutput() {
		GenerateMessageService gms = new GenerateMessageService();
		String output = gms.output("Jenkins","Test");
		
		// テスト成功パターン
		assertEquals("JenkinsTest", output);
		//　テスト失敗パターン
//		assertEquals(sdf.format(cal.getTime()),cs.calcDate());
	}
}
