/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import model_DTO.DTOemployee;
import model_DAO.DAOManagementFactoryEmployee;
import model_DAO.DAOManagementFactoryManager;
import model_DTO.DTOdept_manager;
import interfaceDAO.IDAOManagement;
import javafx.scene.paint.Color;

/**
 *
 * - gerardo 07/11/2017
 */
public class ModelManagementManager {

    private IDAOManagement cDAO;

    public ModelManagementManager() throws FileNotFoundException, IOException {
        DAOManagementFactoryManager paco = DAOManagementFactoryManager.getInstance();
        cDAO = paco.createDAO();
    }

   
    // DTOmanager
    public void guardarManager(DTOdept_manager d) {
        cDAO.create( d);
    }

    public void borrarManager(DTOdept_manager d) {
        cDAO.delete( d);
    }

    public void actualizarManager(DTOdept_manager d) {
        cDAO.update(d);
    }

    public DTOdept_manager leerTodosManager(DTOdept_manager d) {
        return null;
    }
    
     public void gardarCambios() {
         cDAO.saveInFile();
    }

}
