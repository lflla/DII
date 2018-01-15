/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model_DTO;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 
 */
public class DTOemployee {

    private int emp_no;
    private String birth_date="";
    private String first_name="";
    private String last_name="";

    public DTOemployee(){
        
    }
    public DTOemployee(int emp_no,String birth_date,String first_name,String last_name){
        this.emp_no=emp_no;
        this.birth_date=birth_date;
        this.first_name=first_name;
        this.last_name=last_name;
    }
    
    public int getEmp_no() {
        return emp_no;
    }

    /**
     * @param emp_no the emp_no to set
     */
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    /**
     * @return the birth_date
     */
    public String getBirth_date() {
        return birth_date;
    }

    /**
     * @param birth_date the birth_date to set
     */
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
}
