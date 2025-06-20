package com.kh.practice1;

import com.kh.practice1.model.UserInfo;

public class Application {

	public static void main(String[] args) {

		UserInfo user = new UserInfo();
		
		user.changeName("김수한무거북이와두루미삼천갑자동방삭치치카포사리사리센터");
		
		System.out.println(user.printName());
		
	}
}
