package com.jsp;

import java.util.Scanner;
import com.customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {

		StudentManagementSystem managementSystem= new StudentManagementSystemImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------");

		while(true) {
			System.out.println("1.Add Student\n2.Display Student\n3.Display All Students\n4.Remove Student");
			System.out.println("5.Remove All Students\n6.Update Student\n7.Count Student\n8.Sort Students");
			System.out.println("9.Exit");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				managementSystem.addStudent();
				break;
			case 2:
				managementSystem.displayStudent();
				break;
			case 3:
				managementSystem.displayAllStudents();
				break;
			case 4:
				managementSystem.removeStudent();
				break;
			case 5:
				managementSystem.removeAllStudents();
				break;
			case 6:
				managementSystem.updateStudent();
				break;
			case 7:
				managementSystem.countStudents();
				break;
			case 8:
				managementSystem.sortStudents();
				break;
			case 9:
				System.out.println("Thank You!!!!");
				System.exit(0);
				sc.close();

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			System.out.println("---------------------------------------------");
		}
	}
}
