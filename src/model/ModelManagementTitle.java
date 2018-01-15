/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import model_DAO.DAOManagementFactoryTitle;
import model_DTO.DTOdept_manager;
import interfaceDAO.IDAOManagement;
import model_DTO.DTOTitle;

/**
 *
 * - gerardo 07/11/2017
 */
public class ModelManagementTitle {

    private IDAOManagement cDAO;

    public ModelManagementTitle() throws FileNotFoundException, IOException {
        DAOManagementFactoryTitle paco = DAOManagementFactoryTitle.getInstance();
        cDAO = paco.createDAO();
    }

   
    // DTOmanager

    public void guardarTitle(DTOTitle d) {
        cDAO.create( d);
    }

    public void borrarTitle(DTOTitle d) {
        cDAO.delete( d);
    }

    public void actualizarTitle(DTOTitle d) {
        cDAO.update(d);
    }

    public DTOdept_manager leerTodosTitle(DTOTitle d) {
        return null;
    }
    
     public void gardarCambios() {
         cDAO.saveInFile();
    }

}
