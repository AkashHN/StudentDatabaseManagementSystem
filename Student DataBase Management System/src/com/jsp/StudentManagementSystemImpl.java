package com.jsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidChoiceException;
import com.customexception.StudentNotFoundException;
import com.sortinglogic.SortStudentByAge;
import com.sortinglogic.SortStudentById;
import com.sortinglogic.SortStudentByMarks;
import com.sortinglogic.SortStudentByName;

/**
 * 
 * @author AkashGowda
 * @since  2022
 * 
 * we are adding implementation for 8 abstract methods StudentManagementSystem
 *
 */

public class StudentManagementSystemImpl implements StudentManagementSystem {

	Map<String, Student> dataBase = new LinkedHashMap<String, Student>();
	Scanner scanner = new Scanner(System.in);


	@Override
	public void addStudent() {
		System.out.println("Enter Name:");
		String name =scanner.next();
		System.out.println("Enter Age:");
		int age = scanner.nextInt();
		System.out.println("Enter Marks:");
		int marks = scanner.nextInt();
		Student student = new Student(name, age, marks);
		dataBase.put(student.getId(), student);
		System.out.println("Student Record Inserted Successfuly");
		System.out.println("Your Student ID is: "+student.getId());
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student ID: ");
		String id = scanner.next();
		id=id.toUpperCase();
		if(dataBase.containsKey(id)) {
			Student obj = dataBase.get(id);
			System.out.println("---------------------------");
			System.out.println("Student ID: "+obj.getId());
			System.out.println("Student Name: "+obj.getName());
			System.out.println("Student Age: "+obj.getAge());
			System.out.println("Student Marks: "+obj.getMarks());
		}
		else {
			try {
				throw new StudentNotFoundException("Enter the Valid ID");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());			}
		}
	}

	@Override
	public void displayAllStudents() {
		Set<String> keys = dataBase.keySet();
		System.out.println("Students Record are as Follows");
		System.out.println("-------------------------------");
		if(dataBase.size()!=0) {
			for(String key:keys) {
				System.out.println(dataBase.get(key));
			}
		}
		else {
			try {
				throw new StudentNotFoundException("No Student record Available to display");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());			}
		}
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter the Student ID to be removed");
		String id = scanner.next().toUpperCase();
		if(dataBase.containsKey(id)) {
			dataBase.remove(id);
			System.out.println("Student record deleted Successfuly");
		}
		else {
			try {
				throw new StudentNotFoundException("Enter the valid ID");
			}catch (Exception e) {
				System.err.println(e.getMessage());			}
		}
	}

	@Override
	public void removeAllStudents() {
		System.out.println(dataBase.size()+" Numbers of Student are Present");
		dataBase.clear();
		System.out.println("Students Record Deleted Successfuly");
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student ID: ");
		String id = scanner.next().toUpperCase();
		if(dataBase.containsKey(id)) {
			Student obj = dataBase.get(id);
			System.out.println("1.Update Name\n2.Update Age\n3.Update Marks");
			System.out.println("Enter your choice: ");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name:");
				obj.setName(scanner.next());
				break;

			case 2:
				System.out.println("Enter Age:");
				obj.setAge(scanner.nextInt());
				break;

			case 3:
				System.out.println("Enter Marks:");
				obj.setAge(scanner.nextInt());
				break;

			default:
				try {
					throw new InvalidChoiceException("Enter the Valid choice"); 
				}
				catch (Exception e) {
					System.err.println(e.getMessage());				}
				break;
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Enter the Valid ID");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudents() {
		System.out.println("Number Of Students present are :"+dataBase.size());
	}
	@Override
	public void sortStudents() {
		/**
		 * Converting map into Set
		 * keys are Student Id and datatype is String
		 */
		Set<String> keys = dataBase.keySet();
		/**
		 * Achieving upcasting between List & ArrayList 
		 * list can store Student Objects
		 */
		List<Student> list=new ArrayList<Student>();
		for (String key : keys) {
			list.add(dataBase.get(key));
		}
		System.out.println("1.Sort By Id\n2.Sort By Name\n3.Sort By Age\n4.Sort By Marks");
		System.out.println("Enter Your Choice: ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			Collections.sort(list,new SortStudentById());
			display(list);
			break;
		case 2:
			Collections.sort(list,new SortStudentByName());
			display(list);
			break;
		case 3:
			Collections.sort(list,new SortStudentByAge());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			display(list);
			break;

		default:
			try {
				throw new InvalidChoiceException("Enter Valid Choice");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}

	private static void display(List<Student> list) {
		for (Student student : list) {
			System.out.println(student);
		}
	}
}