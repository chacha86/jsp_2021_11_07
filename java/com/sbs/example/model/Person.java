package com.sbs.example.model;

public class Person {

	private int age;
	private String name;

	void introduce() {
		System.out.println("안녕하세요 " + age + "살 " + name + "입니다.");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
