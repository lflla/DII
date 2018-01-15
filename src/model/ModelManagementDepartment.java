/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import model_DAO.DAOManagementFactoryDepartment;
import model_DTO.DTOdepartment;
import interfaceDAO.IDAOManagement;
import java.util.ArrayList;

/**
 *
 * - gerardo 07/11/2017
 */
public class ModelManagementDepartment {

    private IDAOManagement cDAO;

    public ModelManagementDepartment() throws FileNotFoundException, IOException {
        DAOManagementFactoryDepartment paco = DAOManagementFactoryDepartment.getInstance();
        cDAO = paco.createDAO();
    }


    // DTOdepart
    public void guardarDepartment(DTOdepartment d) {
        cDAO.create(d);
    }

    public void borrarDepartment(DTOdepartment d) {
        cDAO.delete(d);
    }

    public void actualizarDepartment(DTOdepartment d) {
        cDAO.update( d);
    }

    public ArrayList leerTodosDepartment() {
        return cDAO.readAll();
    }

    public boolean leerDepartment(DTOdepartment d) {
        return cDAO.read( d);
    }
    
     public void gardarCambios() {
         cDAO.saveInFile();
    }


}
