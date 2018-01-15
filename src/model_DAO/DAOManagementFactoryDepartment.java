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

/**
 *
 * @author Administrador
 */
public class DAOManagementFactoryDepartment {

    private static DAOManagementFactoryDepartment instance = null;

    private DAOManagementFactoryDepartment() {
    }

    public static DAOManagementFactoryDepartment getInstance() {
        if (instance == null) {
            instance = new DAOManagementFactoryDepartment();
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
            cDAO =  new DSFileDepartment("FileDepartment.DAT");
        } else {
            cDAO = new ejemploContactoMySQL();      
        }

        return cDAO;
    }
}
