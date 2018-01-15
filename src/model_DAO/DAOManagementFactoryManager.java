/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model_DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import model_DS.DSFileDepartment;
import model_DS.DSFileEmployee;
import model_DS.ejemploContactoMySQL;
import interfaceDAO.IDAOManagement;
import model_DS.DSFileDept_manager;

/**
 *
 * @author Administrador
 */
public class DAOManagementFactoryManager {

    private static DAOManagementFactoryManager instance = null;

    private DAOManagementFactoryManager() {
    }

    public static DAOManagementFactoryManager getInstance() {
        if (instance == null) {
            instance = new DAOManagementFactoryManager();
        }
        return instance;
    }

    public IDAOManagement createDAO() throws FileNotFoundException, IOException {

        File f = new File("config.properties");
        Properties p = new Properties();
        p.load(new FileInputStream(f));

        String imp = p.getProperty("baseDatos");

        IDAOManagement cDAO ;
        
        if ("File".equals(imp)) {
            cDAO =  new DSFileDept_manager("FileManager.DAT");
        } else {
            cDAO = new ejemploContactoMySQL();      
        }

        return cDAO;
    }
}
