package com.jsp;

public class Student {

	private String id;
	private int age;
	private String name;
	private int marks;

	private static  int count=101;

	public Student( String name, int age, int marks) {
		super();
		this.id="JSP"+count;
		this.age = age;
		this.name = name;
		this.marks=marks;
		count++;
	}

	public String getId() {
		return id;
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks;
	}
	
	
}
