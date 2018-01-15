/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.ModelManagementDepartment;
import model_DTO.DTOdepartment;

/**
 *
 * @author Administrador
 */
public class ControllerDepartment implements ActionListener {

    model.ModelManagementDepartment miModeloDepart;
    DTOdepartment departamento;
    int filas;

    public ControllerDepartment() throws IOException {

        miModeloDepart = new ModelManagementDepartment();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        departamento = new DTOdepartment(Integer.parseInt(view.ViewDepartF.jTextField6.getText()), view.ViewDepartF.jTextField5.getText());
        filas = view.ViewDepartF.jTable1.getRowCount();
        System.out.println("filas:  " + filas);
        int u = 0;
        Boolean repetido = false;

        if (e.getActionCommand().equals(view.ViewDepartF.ANADIR)) {

            while (u < filas && repetido == false) {
                if ((Integer.parseInt((String) view.ViewDepartF.model.getValueAt(u, 0))) == (Integer.parseInt(view.ViewDepartF.jTextField6.getText()))) {
                    repetido = true;
                }
                u++;
            }

            if (!repetido) {
                miModeloDepart.guardarDepartment(departamento);

                view.ViewDepartF.model.addRow(new Object[view.ViewDepartF.jTable1.getRowCount()]);
                System.out.println("numFilas;  " + view.ViewDepartF.jTable1.getRowCount());

                for (int i = 0; i < view.ViewDepartF.jTable1.getColumnCount() - 1; i++) {
                    view.ViewDepartF.model.setValueAt(view.ViewDepartF.jTextField6.getText(), filas, 0);
                    view.ViewDepartF.model.setValueAt(view.ViewDepartF.jTextField5.getText(), filas, 1);
                }
            } else {
                new view.ViewErrorF("El nºDepartamento " + view.ViewDepartF.jTextField6.getText() + " ya existe.");
            }

        }

        if (e.getActionCommand().equals(view.ViewEmployeeF.ACTUALIZAR)) {

            miModeloDepart.actualizarDepartment(departamento);
            System.out.println("pulsa actualizar");
            int i = 0;
            Boolean encontrado = false;

            while (i < filas && encontrado == false) {
                if ((Integer.parseInt((String) view.ViewDepartF.model.getValueAt(i, 0))) == (Integer.parseInt(view.ViewDepartF.jTextField6.getText()))) {
                    encontrado = true;
                    view.ViewDepartF.model.setValueAt(departamento.getDept_name(), i, 1);
                }
                i++;
            }

        }

        if (e.getActionCommand().equals(view.ViewEmployeeF.BORRAR)) {
            miModeloDepart.borrarDepartment(departamento);
            int i = 0;
            Boolean encontrado = false;
            while (i < filas && encontrado == false) {
                if ((Integer.parseInt((String) view.ViewDepartF.model.getValueAt(i, 0))) == (Integer.parseInt(view.ViewDepartF.jTextField6.getText()))) {
                    encontrado = true;
                    view.ViewDepartF.model.removeRow(i);
                }
                i++;
            }
        }

        if (e.getActionCommand().equals(view.ViewEmployeeF.GUARDARCAMBIOS)) {
            miModeloDepart.gardarCambios();
        }

    }

}
