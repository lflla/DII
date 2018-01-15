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
import interfaceDAO.IDAOManagement;

/**
 *
 * - gerardo 07/11/2017
 */
public class ModelManagementEmployee {

    private IDAOManagement cDAO;

    public ModelManagementEmployee() throws FileNotFoundException, IOException {
        DAOManagementFactoryEmployee paco = DAOManagementFactoryEmployee.getInstance();
        cDAO = paco.createDAO();
    }

    // DTOemployee
    public void guardarEmployee(DTOemployee d) {
        cDAO.create( d);
    }

    public void borrarEmployee(DTOemployee d) {
        cDAO.delete( d);
    }

    public void actualizarEmployee(DTOemployee d) {
        cDAO.update( d);
    }

    public List leerTodosEmployee() {
        return cDAO.readAll();
    }

    public boolean leerEmployee(DTOemployee d) {
        return cDAO.read( d);
    }
    
    public void gardarCambios() {
         cDAO.saveInFile();
    }
    
    
    
/*
    // DTOdepart
    public void guardarDepartment(DTOdepartment d) {
        cDAO.create((IDAOManagement) d);
    }

    public void borrarDepartment(DTOdepartment d) {
        cDAO.delete((IDAOManagement) d);
    }

    public void actualizarDepartment(DTOdepartment d) {
        cDAO.update((IDAOManagement) d);
    }

    public List leerTodosDepartment(DTOdepartment d) {
        return cDAO.readAll();
    }

    public boolean leerDepartment(DTOdepartment d) {
        return cDAO.read((IDAOManagement) d);
    }

    // DTOSalary
    public void guardarSalary(DTOsalary d) {
        cDAO.create((IDAOManagement) d);
    }

    public void borrarSalary(DTOsalary d) {
        cDAO.delete((IDAOManagement) d);
    }

    public boolean actualizarSalary(DTOsalary d) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public DTOsalary leerTodosSalary(DTOsalary d) {
        return null;
    }

    // DTOtitle
    public void guardarTitle(DTOtitle d) {
        cDAO.create((IDAOManagement) d);
    }

    public void borrarTitle(DTOtitle d) {
        cDAO.delete((IDAOManagement) d);
    }

    public boolean actualizarTitle(DTOtitle d) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public DTOtitle leerTodosTitle(DTOtitle d) {
        return null;
    }

    // DTOmanager
    public void guardarManager(DTOdept_manager d) {
        cDAO.create((IDAOManagement) d);
    }

    public void borrarManager(DTOdept_manager d) {
        cDAO.delete((IDAOManagement) d);
    }

    public boolean actualizarManager(DTOdept_manager d) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    public DTOdept_manager leerTodosManager(DTOdept_manager d) {
        return null;
    }*/

}
