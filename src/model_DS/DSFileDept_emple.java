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
import model_DTO.DTOdept_emple;
import interfaceDAO.IDAOManagement;
import java.util.ArrayList;

public class DSFileDept_emple implements IDAOManagement {

    public ArrayList<DTOdept_emple> lista = new ArrayList<>();
    File fileDept_emple;

    public DSFileDept_emple(String ruta) throws FileNotFoundException, IOException {
        boolean eof = false;
        fileDept_emple = new File(ruta);
        fileDept_emple.createNewFile();

        FileInputStream fis = new FileInputStream(fileDept_emple);
        DataInputStream dis = new DataInputStream(fis);
        DTOdept_emple e;

        while (!eof) {
            e = new DTOdept_emple();
            try {
                e.setEmp_no(dis.readInt());
                e.setDept_no(dis.readUTF());
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
        DTOdept_emple dept_emple = (DTOdept_emple) a;
        lista.add(dept_emple);
    }

    @Override
    public void update(Object a) {
        DTOdept_emple dept_emple = (DTOdept_emple) a;
        DTOdept_emple aux;

        for (int i = 0; i < lista.size(); i++) {
            aux = (DTOdept_emple) lista.get(i);
            if (dept_emple.getEmp_no() == aux.getEmp_no()) {
                lista.remove(i);
                lista.add(dept_emple);
            }
        }
    }

    @Override
    public void delete(Object a) {
        DTOdept_emple dept_emple = (DTOdept_emple) a;
        lista.remove(dept_emple);
    }

    @Override
    public ArrayList readAll() {
        return lista;
    }

    @Override
    public void saveInFile() {
        DTOdept_emple dept_emple;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(this.fileDept_emple, true);
            DataOutputStream dos = new DataOutputStream(fos);
            int contador = 0;
            while (contador < lista.size()) {
                dept_emple = (DTOdept_emple) lista.get(contador);
                dos.writeInt(dept_emple.getEmp_no());
                dos.writeUTF(dept_emple.getDept_no());
                dos.writeUTF(dept_emple.getFrom_date());
                dos.writeUTF(dept_emple.getTo_date());
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
            DTOdept_emple dept_emple = (DTOdept_emple) a;
            DTOdept_emple aux;
            int i = 0;
            do {
                aux = (DTOdept_emple) lista.get(i);
                if (dept_emple.getEmp_no() == aux.getEmp_no()) {
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
