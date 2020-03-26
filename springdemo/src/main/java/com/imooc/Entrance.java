package com.imooc;

import com.imooc.controller.WelcomeController;
import com.imooc.entity.User;
import com.imooc.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * spring 启动类
 */
@Configuration
@ComponentScan(value = "com.imooc")
public class Entrance {
	public static void main1(String[] args) {
		System.out.println("hello world");
		String xmlPath = "//Users/blusk123/SourceProject/spring-framework/springdemo/src/main/resources/spring-config.xml";
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		WelcomeService welcomeService = applicationContext.getBean("welcomeService", WelcomeService.class);
		welcomeService.hello("小猪佩奇");

		User user1a = (User) applicationContext.getBean("user1");
		User user1b = (User) applicationContext.getBean("user1");

		User user2a = (User) applicationContext.getBean("user2");
		User user2c = (User) applicationContext.getBean("user2");

		User user3a = (User) applicationContext.getBean("user3");
		User user3b = (User) applicationContext.getBean("user3");
		System.out.println(applicationContext.getBean("userFactory"));
		System.out.println("无参构造方法：" + user1a);
		System.out.println("无参构造方法：" + user1b);
		System.out.println("静态工厂：" + user2a);
		System.out.println("静态工厂：" + user2c);
		System.out.println("实例工厂：" + user3a);
		System.out.println("实例工厂：" + user3b);
		//取出factoryBean创建的Bean实例
		System.out.println(applicationContext.getBean("user4"));
		//取出factoryBean
		System.out.println(applicationContext.getBean("&user4"));

	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Entrance.class);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		WelcomeController welcomeController = (WelcomeController) context.getBean("welcomeController");
		welcomeController.handleRequest();
		User user5 = (User) context.getBean("user5");
		System.out.println("CustomizedBeanDefinitionRegistryPostProcessor创建的Bean：" + user5);
	}
}
