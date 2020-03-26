package com.imooc.service.impl;

import com.imooc.service.WelcomeService;
import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {
	@Override
	public void hello(String name) {
		System.out.println("欢迎：" + name);
	}
}
