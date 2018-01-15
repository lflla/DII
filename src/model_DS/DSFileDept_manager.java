package model_DS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model_DTO.DTOdepartment;
import model_DTO.DTOdept_manager;
import interfaceDAO.IDAOManagement;
import java.util.ArrayList;

public class DSFileDept_manager implements IDAOManagement {

    public ArrayList<DTOdept_manager> lista = new ArrayList<>();
    File fileDept_manager;

    public DSFileDept_manager(String ruta) throws FileNotFoundException, IOException {
        boolean eof = false;
        fileDept_manager = new File(ruta);
        fileDept_manager.createNewFile();

        FileInputStream fis = new FileInputStream(fileDept_manager);
        DataInputStream dis = new DataInputStream(fis);
        DTOdept_manager e;

        while (!eof) {
            e = new DTOdept_manager();
            try {
                e.setDept_no(dis.readInt());
                e.setEmp_no(dis.readInt());
                e.setFrom_date(dis.readUTF());
                e.setTo_date(dis.readUTF());
                lista.add(e);
            } catch (EOFException eofe) {
                eof = true;
            }
        }
    }

    @Override
    public void create(Object a) {
        DTOdept_manager dept_manager = (DTOdept_manager) a;
        lista.add(dept_manager);
    }

    @Override
    public void update(Object a) {
        DTOdept_manager dept_manager = (DTOdept_manager) a;
        DTOdept_manager aux;

        for (int i = 0; i < lista.size(); i++) {
            aux = (DTOdept_manager) lista.get(i);
            if (dept_manager.getDept_no() == aux.getDept_no()) {
                lista.remove(i);
                lista.add(dept_manager);
            }
        }
    }

    @Override
    public void delete(Object a) {
        DTOdept_manager dept_manager = (DTOdept_manager) a;
        lista.remove(dept_manager);
    }

    @Override
    public ArrayList readAll() {
        return lista;
    }

    @Override
    public void saveInFile() {
        DTOdept_manager dept_manager;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(this.fileDept_manager, true);
            DataOutputStream dos = new DataOutputStream(fos);
            int contador = 0;
            while (contador < lista.size()) {
                dept_manager = (DTOdept_manager) lista.get(contador);
                dos.writeInt(dept_manager.getDept_no());
                dos.writeInt(dept_manager.getEmp_no());
                dos.writeUTF(dept_manager.getFrom_date());
                dos.writeUTF(dept_manager.getTo_date());
                contador++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSFileEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DSFileEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista.clear();
    }

    @Override
    public boolean read(Object a) {
        boolean sePuedeLeer = false;
        if (!lista.isEmpty()) {
            DTOdept_manager dept = (DTOdept_manager) a;
            DTOdept_manager aux;
            int i = 0;
            do {
                aux = (DTOdept_manager) lista.get(i);
                if (dept.getDept_no() == aux.getDept_no()) {
                    sePuedeLeer = true;
                }
                i++;
            } while (i < lista.size() || sePuedeLeer == true);
        } else {
            sePuedeLeer = true;
        }
        return sePuedeLeer;
    }
}
