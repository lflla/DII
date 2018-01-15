/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import model_DAO.DAOManagementFactorySalary;
import model_DTO.DTOdept_manager;
import model_DTO.DTOsalary;
import interfaceDAO.IDAOManagement;

/**
 *
 * - gerardo 07/11/2017
 */
public class ModelManagementSalary {

    private IDAOManagement cDAO;

    public ModelManagementSalary() throws FileNotFoundException, IOException {
        DAOManagementFactorySalary paco = DAOManagementFactorySalary.getInstance();
        cDAO = paco.createDAO();
    }

   
    // DTOmanager
    public void guardarSalary(DTOsalary d) {
        cDAO.create( d);
    }

    public void borrarSalary(DTOsalary d) {
        cDAO.delete(d);
    }

    public void actualizarSalary(DTOsalary d) {
         cDAO.update(d);
    }

    public DTOdept_manager leerTodosSalary(DTOsalary d) {
        return null;
    }
    
     public void gardarCambios() {
         cDAO.saveInFile();
    }

}
