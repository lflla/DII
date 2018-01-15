
package model_DTO;

public class DTOdept_manager {

	private int dept_number;
	private int emp_number;
	private String from_date="";
	private String to_date="";

	public DTOdept_manager() {
		// TODO Auto-generated constructor stub
	}

	public DTOdept_manager(int dept_no, int emp_no, String from_date, String to_date) {
		this.dept_number = dept_no;
		this.emp_number = emp_no;
		this.from_date = from_date;
		this.to_date = to_date;
	}

	public int getDept_no() {
		return dept_number;
	}

	public void setDept_no(int dept_no) {
		this.dept_number = dept_no;
	}

	public int getEmp_no() {
		return emp_number;
	}

	public void setEmp_no(int emp_no) {
		this.emp_number = emp_no;
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
