package edu.ycp.cs320.aroby.model;

public class Student extends Account {
	private int student_id, year;
	private String major;
	
	public int getStudentID() {
		return student_id;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setStudentID(int student_id) {
		this.student_id = student_id;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
}