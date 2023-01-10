package com.sortinglogic;

import java.util.Comparator;
/**
 * sorting Student by Id
 */

import com.jsp.Student;

public class SortStudentById implements Comparator<Student> {

	@Override
	public int compare(Student e1, Student e2) {
		return e1.getId().compareTo(e2.getId());
	}
	
}
