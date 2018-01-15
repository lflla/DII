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
import model_DS.ejemploContactoMySQL;
import interfaceDAO.IDAOManagement;
import model_DS.DSFileTitle;

/**
 *
 * @author Administrador
 */
public class DAOManagementFactoryTitle {

    private static DAOManagementFactoryTitle instance = null;

    private DAOManagementFactoryTitle() {
    }

    public static DAOManagementFactoryTitle getInstance() {
        if (instance == null) {
            instance = new DAOManagementFactoryTitle();
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
            cDAO =  new DSFileTitle("FileTitle.DAT");
        } else {
            cDAO = new ejemploContactoMySQL();      
        }

        return cDAO;
    }
}
