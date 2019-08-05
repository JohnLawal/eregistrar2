package com.jlawal.demo.eregistrarlab.utility;

public enum AppStrings {
	HOME_PAGE("home/index"), STUDENT_LIST_PAGE("students/list"), NEW_STUDENT_PAGE("students/new"),
	EDIT_STUDENT_PAGE("students/edit"), DELETE_STUDENT_PAGE("students/delete"), SITE_ROOT("eregistrar/");
	private String val;

	AppStrings(String string) {
		this.val = string;
	}

	public String val() {
		return this.val;
	}
}
