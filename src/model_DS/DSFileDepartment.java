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
import interfaceDAO.IDAOManagement;
import java.util.ArrayList;

public class DSFileDepartment implements IDAOManagement {

    public ArrayList<DTOdepartment> lista = new ArrayList<>();
    File fileDepartment;

    public DSFileDepartment(String ruta) throws FileNotFoundException, IOException {
        boolean eof = false;
        fileDepartment = new File(ruta);
        fileDepartment.createNewFile();

        FileInputStream fis = new FileInputStream(fileDepartment);
        DataInputStream dis = new DataInputStream(fis);
        DTOdepartment e;

        while (!eof) {
            e = new DTOdepartment();
            try {
                e.setDept_number(dis.readInt());
                e.setDept_name(dis.readUTF());
                lista.add(e);
            } catch (EOFException eofe) {
                eof = true;
            }
        }
    }

    @Override
    public void create(Object a) {
        DTOdepartment dept = (DTOdepartment) a;
        lista.add(dept);

        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i).getDept_number() + "  ");
            System.out.print(lista.get(i).getDept_name());
            System.out.println();
        }
        System.out.println("--------------");
    }

    @Override
    public void update(Object a) {
        DTOdepartment dept = (DTOdepartment) a;
        boolean encontrado= false;
        int i = 0;
        while ( i < lista.size()  && encontrado== false) {
            if(lista.get(i).getDept_number() == dept.getDept_number()){
                lista.get(i).setDept_name(dept.getDept_name());
                encontrado= true;
            }
            i++;
        }

    }

    @Override
    public void delete(Object a) {
        DTOdepartment dept = (DTOdepartment) a;
        boolean encontrado= false;
        int i = 0;
        while ( i < lista.size()  && encontrado== false) {
            if(lista.get(i).getDept_number() == dept.getDept_number()){
                lista.remove(i);
                encontrado= true;
            }
            i++;
        }

    }

    @Override
    public ArrayList readAll() {
        return lista;
    }

    @Override
    public void saveInFile() {
        DTOdepartment dept;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(this.fileDepartment);
            DataOutputStream dos = new DataOutputStream(fos);
            int contador = 0;
            while (contador < lista.size()) {
                dept = (DTOdepartment) lista.get(contador);
                dos.writeInt(dept.getDept_number());
                dos.writeUTF(dept.getDept_name());
                contador++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSFileEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DSFileEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean read(Object a) {
        boolean sePuedeLeer = false;
        if (!lista.isEmpty()) {
            DTOdepartment dept = (DTOdepartment) a;
            DTOdepartment aux;
            int i = 0;
            do {
                aux = (DTOdepartment) lista.get(i);
                if (dept.getDept_number() == aux.getDept_number()) {
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
