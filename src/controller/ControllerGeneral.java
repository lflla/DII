/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model_DS.DSFileDepartment;
import model_DS.DSFileDept_emple;
import model_DS.DSFileDept_manager;
import model_DS.DSFileEmployee;
import model_DS.DSFileSalary;
import model_DS.DSFileTitle;
import model_DTO.DTOTitle;
import model_DTO.DTOdept_emple;
import model_DTO.DTOdept_manager;
import model_DTO.DTOemployee;
import model_DTO.DTOsalary;
import view.ViewDepartF;
import view.ViewEmployeeF;

/**
 *
 * @author Administrador
 */
public class ControllerGeneral implements ActionListener {

    private ViewEmployeeF viewEmployeeF;
    private ViewDepartF viewDepartF;

    public ControllerGeneral() throws IOException {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(view.ViewGeneralF.EMPLEADO)) {
            System.out.println("PULSA EMPLEADO");

            try {
                DSFileEmployee empleado = new DSFileEmployee("FileEmployee.DAT");
                ArrayList listaEmpleados = (ArrayList) empleado.readAll();

                DSFileDept_emple dept_emple = new DSFileDept_emple("FileDept_emple.DAT");
                ArrayList listaDept_emple = (ArrayList) dept_emple.readAll();

                DSFileDept_manager dept_manager = new DSFileDept_manager("FileManager.DAT");
                ArrayList listaDept_manager = (ArrayList) dept_manager.readAll();

                DSFileTitle dept_Title = new DSFileTitle("FileTitle.DAT");
                ArrayList listaDept_dept_Title = (ArrayList) dept_Title.readAll();

                DSFileSalary dept_Salary = new DSFileSalary("FileSalary.DAT");
                ArrayList listaSalary = (ArrayList) dept_Salary.readAll();

                ArrayList<ArrayList> listaListas = new ArrayList<>();
                listaListas.add(listaEmpleados);
                listaListas.add(listaDept_emple);
                listaListas.add(listaDept_manager);
                listaListas.add(listaDept_dept_Title);
                listaListas.add(listaSalary);

                ViewEmployeeF viewEmployeeF = new view.ViewEmployeeF(listaListas);

            } catch (IOException ex) {
                System.out.println("Error vista general");
            }

        }

        if (e.getActionCommand().equals(view.ViewGeneralF.DEPARTAMENTO)) {
            System.out.println("PULSA DEPARTAMENTO");

            try {
                DSFileDepartment depart = new DSFileDepartment("FileDepartment.DAT");
                ArrayList listaDepart = (ArrayList) depart.readAll();
                view.ViewDepartF viewDepartF = new view.ViewDepartF(listaDepart);
            } catch (IOException ex) {
                Logger.getLogger(ControllerGeneral.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * @return the viewEmployeeF
     */
    public ViewEmployeeF getViewEmployeeF() {
        return viewEmployeeF;
    }

    /**
     * @param viewEmployeeF the viewEmployeeF to set
     */
    public void setViewEmployeeF(ViewEmployeeF viewEmployeeF) {
        this.viewEmployeeF = viewEmployeeF;
    }

    /**
     * @return the viewDepartF
     */
    public ViewDepartF getViewDepartF() {
        return viewDepartF;
    }

    /**
     * @param viewDepartF the viewDepartF to set
     */
    public void setViewDepartF(ViewDepartF viewDepartF) {
        this.viewDepartF = viewDepartF;
    }

}
