package com.imooc.entity.factory;

import com.imooc.entity.User;

public class StaticFactory {
	public static User getUser() {
		return new User();
	}


}