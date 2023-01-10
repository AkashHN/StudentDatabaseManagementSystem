package com.sortinglogic;

import java.util.Comparator;

import com.jsp.Student;

public class SortStudentByAge implements Comparator<Student>{

	@Override
	public int compare(Student e1, Student e2) {
		return e1.getAge()-e2.getAge();
	}

}
