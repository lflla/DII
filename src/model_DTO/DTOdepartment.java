/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model_DTO;

/**
 *
 *  -  Gerardo 6/11/2017
 */
public class DTOdepartment {

	private int dept_number;
	private String dept_name="";

	public DTOdepartment() {
		// TODO Auto-generated constructor stub
	}

	public DTOdepartment(int dept_number, String dept_name) {
		this.dept_number = dept_number;
		this.dept_name = dept_name;
	}

	public int getDept_number() {
		return dept_number;
	}

	public void setDept_number(int dept_number) {
		this.dept_number = dept_number;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

}
