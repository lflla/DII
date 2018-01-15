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
import model_DS.DSFileDept_emple;

/**
 *
 * @author Administrador
 */
public class DAOManagementFactoryDept_emple {

    private static DAOManagementFactoryDept_emple instance = null;

    private DAOManagementFactoryDept_emple() {
    }

    public static DAOManagementFactoryDept_emple getInstance() {
        if (instance == null) {
            instance = new DAOManagementFactoryDept_emple();
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
            cDAO =  new DSFileDept_emple("FileDept_emple.DAT");
        } else {
            cDAO = new ejemploContactoMySQL();      
        }

        return cDAO;
    }
}
