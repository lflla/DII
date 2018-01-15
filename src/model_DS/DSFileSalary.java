/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model_DTO.DTOsalary;
import interfaceDAO.IDAOManagement;
import java.util.ArrayList;

public class DSFileSalary implements IDAOManagement {

    public ArrayList<DTOsalary> lista = new ArrayList<>();
    File fileSalary;

    public DSFileSalary(String ruta) throws FileNotFoundException, IOException {
        boolean eof = false;
        fileSalary = new File(ruta);
        fileSalary.createNewFile();

        FileInputStream fis = new FileInputStream(fileSalary);
        DataInputStream dis = new DataInputStream(fis);
        DTOsalary e;

        while (!eof) {
            e = new DTOsalary();
            try {
                e.setEmp_no(dis.readInt());
                e.setSalary(dis.readFloat());
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
        DTOsalary sal = (DTOsalary) a;
        lista.add(sal);

    }

    @Override
    public void update(Object a) {
        DTOsalary sal = (DTOsalary) a;
        DTOsalary aux;

        for (int i = 0; i < lista.size(); i++) {
            aux = (DTOsalary) lista.get(i);
            if (sal.getEmp_no() == aux.getEmp_no()) {
                lista.remove(i);
                lista.add(sal);
            }
        }
    }

    @Override
    public void delete(Object a) {
        DTOsalary sal = (DTOsalary) a;
        lista.remove(sal);
    }

    @Override
    public ArrayList readAll() {
        return lista;
    }

    @Override
    public void saveInFile() {
        DTOsalary sal;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(this.fileSalary, true);
            DataOutputStream dos = new DataOutputStream(fos);
            int contador = 0;
            while (contador < lista.size()) {
                sal = (DTOsalary) lista.get(contador);
                dos.writeInt(sal.getEmp_no());
                dos.writeFloat(sal.getSalary());
                dos.writeUTF(sal.getFrom_date());
                dos.writeUTF(sal.getTo_date());
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
            DTOsalary dept = (DTOsalary) a;
            DTOsalary aux;
            int i = 0;
            do {
                aux = (DTOsalary) lista.get(i);
                if (dept.getEmp_no() == aux.getEmp_no()) {
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
