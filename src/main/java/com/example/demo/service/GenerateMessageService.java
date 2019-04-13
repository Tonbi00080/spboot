package com.example.demo.service;

public class GenerateMessageService {
	public String output(String ... args) {
		StringBuffer msgSb = new StringBuffer();
		for(String arg: args) {
			msgSb.append(arg);
		}
		String msg = new String(msgSb);
		return msg;
	}

}
