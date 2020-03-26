package com.imooc.controller;

import com.imooc.service.WelcomeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController implements ApplicationContextAware, BeanNameAware {
	@Autowired
	private WelcomeService welcomeService;
	private String myName;
	private ApplicationContext applicationContext;

	public void handleRequest() {
		welcomeService.hello("我爱你，小圆");
		System.out.println("我是谁："+ myName);
		String []beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("召唤容器神兽，通过容器获得：" + beanDefinitionName);
		}
	}

	@Override
	public void setBeanName(String name) {
		this.myName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
