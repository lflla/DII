/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model_DTO;

import java.util.Calendar;

/**
 *
 * - Gerardo 6/11/2017
 */
public class DTOdept_emple {
	private int emp_no;
	private String dept_no="";
	private String from_date="";
        private String to_date="";

	
	public DTOdept_emple() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DTOdept_emple(int emp_no, String dept_no, String from_date, String to_date) {
		this.emp_no = emp_no;
		this.dept_no = dept_no;
		this.from_date = from_date;
		this.to_date = to_date;
	}


	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
}
