package com.sortinglogic;

import java.util.Comparator;
/**
 * Sorting Student by Name
 */

import com.jsp.Student;

public class SortStudentByName implements Comparator<Student> {

	@Override
	public int compare(Student e1, Student e2) {
		return e1.getName().compareTo(e2.getName());
	}

}
