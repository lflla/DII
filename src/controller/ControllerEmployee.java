/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.ModelManagementDept_emple;
import model.ModelManagementEmployee;
import model.ModelManagementManager;
import model.ModelManagementSalary;
import model.ModelManagementTitle;
import model_DTO.DTOTitle;
import model_DTO.DTOdept_emple;
import model_DTO.DTOdept_manager;
import model_DTO.DTOemployee;
import model_DTO.DTOsalary;

import view.ViewEmployeeF;
import view.ViewErrorF;

/**
 *
 * @author Administrador
 */
public class ControllerEmployee implements ActionListener {

    // MODEL
    model.ModelManagementDept_emple miModeloDept_emple;
    model.ModelManagementEmployee miModeloEmployee;
    model.ModelManagementSalary miModeloSalary;
    model.ModelManagementTitle miModeloTitle;
    model.ModelManagementManager miModeloManager;
    //DTO 
    DTOemployee empleado;
    DTOsalary salario;
    DTOdept_emple dept_emple;
    DTOTitle titulo;
    DTOdept_manager manager;

    int filas = 0;

    public ControllerEmployee() throws IOException {
        miModeloDept_emple = new ModelManagementDept_emple();
        miModeloEmployee = new ModelManagementEmployee();
        miModeloSalary = new ModelManagementSalary();
        miModeloTitle = new ModelManagementTitle();
        miModeloManager = new ModelManagementManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        filas = view.ViewEmployeeF.jTable1.getRowCount();
        System.out.println("filas:  " + filas);

        //JTable
        empleado = new DTOemployee();
        empleado.setEmp_no(Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()));
        empleado.setBirth_date(ViewEmployeeF.jTextField5.getText());
        empleado.setFirst_name(view.ViewEmployeeF.jTextField10.getText());
        empleado.setLast_name(view.ViewEmployeeF.jTextField11.getText());

        salario = new DTOsalary();
        salario.setEmp_no(Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()));
        salario.setSalary(Float.parseFloat(view.ViewEmployeeF.jTextField12.getText()));

        dept_emple = new DTOdept_emple();
        dept_emple.setEmp_no(Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()));
        dept_emple.setDept_no(view.ViewEmployeeF.jTextField13.getText());

        titulo = new DTOTitle();
        titulo.setEmp_no(Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()));
        titulo.setTitle(view.ViewEmployeeF.jTextField14.getText());

        manager = new DTOdept_manager();
        manager.setEmp_no(Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()));
        manager.setDept_no(Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()));

        if (e.getActionCommand().equals(view.ViewEmployeeF.ANADIR)) {
            System.out.println("añadir");
            int u = 0;
            Boolean repetido = false;

            while (u < filas && repetido == false) {
                if ((Integer.parseInt((String) view.ViewEmployeeF.model.getValueAt(u, 0))) == (Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()))) {
                    repetido = true;
                }
                u++;
            }

            if (!repetido) {
                //GUARDAR en Listas
                miModeloEmployee.guardarEmployee(empleado);
                miModeloDept_emple.guardarDept_emple(dept_emple);
                miModeloSalary.guardarSalary(salario);
                miModeloManager.guardarManager(manager);
                miModeloTitle.guardarTitle(titulo);

                //actualizar jTable
                view.ViewEmployeeF.model.addRow(new Object[view.ViewEmployeeF.jTable1.getRowCount()]);

                for (int i = 0; i < view.ViewEmployeeF.jTable1.getColumnCount() - 1; i++) {
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField6.getText(), filas, 0);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField5.getText(), filas, 1);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField10.getText(), filas, 2);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField11.getText(), filas, 3);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField12.getText(), filas, 4);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField13.getText(), filas, 5);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField14.getText(), filas, 6);
                    if (view.ViewEmployeeF.jRadioButton1.isSelected()) {
                        view.ViewEmployeeF.model.setValueAt("S", filas, 7);
                    } else {
                        view.ViewEmployeeF.model.setValueAt("N", filas, 7);
                    }
                }
            } else {
                new ViewErrorF("El nºempleado " + view.ViewEmployeeF.jTextField6.getText() + " ya existe.");
            }
        }

        if (e.getActionCommand().equals(view.ViewEmployeeF.ACTUALIZAR)) {

            //GUARDAR en Listas
            miModeloEmployee.actualizarEmployee(empleado);
            miModeloDept_emple.actualizarDept_emple(dept_emple);
            miModeloSalary.actualizarSalary(salario);
            miModeloManager.actualizarManager(manager);
            miModeloTitle.actualizarTitle(titulo);

            System.out.println("pulsa actualizar");
            int i = 0;
            Boolean encontrado = false;

            while (i < filas && encontrado == false) {
                System.out.println("i: " + i);
                if ((Integer.parseInt((String) view.ViewEmployeeF.model.getValueAt(i, 0))) == (Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()))) {
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField6.getText(), i, 0);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField5.getText(), i, 1);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField10.getText(), i, 2);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField11.getText(), i, 3);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField12.getText(), i, 4);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField13.getText(), i, 5);
                    view.ViewEmployeeF.model.setValueAt(view.ViewEmployeeF.jTextField14.getText(), i, 6);
                    if (view.ViewEmployeeF.jRadioButton1.isSelected()) {
                        view.ViewEmployeeF.model.setValueAt("S", filas, 7);
                    } else {
                        view.ViewEmployeeF.model.setValueAt("N", filas, 7);
                    }
                    encontrado = true;
                }
                i++;
            }

        }

        if (e.getActionCommand().equals(view.ViewEmployeeF.BORRAR)) {
            System.out.println("pulsa BORRAR");

            //Borrar en Listas
            miModeloEmployee.borrarEmployee(empleado);
            miModeloDept_emple.borrarDept_emple(dept_emple);
            miModeloSalary.borrarSalary(salario);
            miModeloManager.borrarManager(manager);
            miModeloTitle.borrarTitle(titulo);

            int i = 0;
            Boolean encontrado = false;

            while (i < filas && encontrado == false) {
                System.out.println("i: " + i);
                if ((Integer.parseInt((String) view.ViewEmployeeF.model.getValueAt(i, 0))) == (Integer.parseInt(view.ViewEmployeeF.jTextField6.getText()))) {

                    view.ViewEmployeeF.model.removeRow(i);

                    encontrado = true;
                }
                i++;
            }
        }

        if (e.getActionCommand().equals(view.ViewEmployeeF.GUARDARCAMBIOS)) {
            miModeloDept_emple.gardarCambios();
            miModeloEmployee.gardarCambios();
            miModeloManager.gardarCambios();
            miModeloSalary.gardarCambios();
            miModeloTitle.gardarCambios();
        }

    }

}
