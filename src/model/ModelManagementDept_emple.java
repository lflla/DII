/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import interfaceDAO.IDAOManagement;
import java.util.ArrayList;
import model_DAO.DAOManagementFactoryDept_emple;
import model_DTO.DTOdept_emple;

/**
 *
 * - gerardo 07/11/2017
 */
    public class ModelManagementDept_emple {

    private IDAOManagement cDAO;

    public ModelManagementDept_emple() throws FileNotFoundException, IOException {
        DAOManagementFactoryDept_emple paco = DAOManagementFactoryDept_emple.getInstance();
        cDAO = paco.createDAO();
    }


    // DTOdepart
    public void guardarDept_emple(DTOdept_emple d) {
        cDAO.create(d);
    }

    public void borrarDept_emple(DTOdept_emple d) {
        cDAO.delete(d);
    }

    public void actualizarDept_emple(DTOdept_emple d) {
        cDAO.update( d);
    }

    public ArrayList leerTodosDept_emple() {
        return cDAO.readAll();
    }

    public boolean leerDept_emple(DTOdept_emple d) {
        return cDAO.read( d);
    }
    
     public void gardarCambios() {
         cDAO.saveInFile();
    }


}
