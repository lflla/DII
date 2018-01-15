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
import model_DTO.DTOemployee;
import interfaceDAO.IDAOManagement;
import java.util.ArrayList;

public class DSFileEmployee implements interfaceDAO.IDAOManagement {

    public ArrayList<DTOemployee> lista = new ArrayList<>();
    File fileEmployee;

    public DSFileEmployee(String ruta) throws FileNotFoundException, IOException {
        boolean eof = false;
        fileEmployee = new File(ruta);
        fileEmployee.createNewFile();

        FileInputStream fis = new FileInputStream(fileEmployee);
        DataInputStream dis = new DataInputStream(fis);
        DTOemployee e;

        while (!eof) {
            e = new DTOemployee();
            try {
                e.setEmp_no(dis.readInt());
                e.setBirth_date(dis.readUTF());
                e.setFirst_name(dis.readUTF());
                e.setLast_name(dis.readUTF());
                lista.add(e);
            } catch (EOFException eofe) {
                eof = true;
            }
        }
    }

    @Override
    public void create(Object a) {
        DTOemployee empl = (DTOemployee) a;
        lista.add(empl);
    }

    @Override
    public void update(Object a) {
        DTOemployee empl = (DTOemployee) a;
        DTOemployee aux;
        
        System.out.println("sadad");
        boolean encontrado= false;
        int i = 0;
        while ( i < lista.size()  && encontrado== false) {
            if(lista.get(i).getEmp_no() == empl.getEmp_no()){
                lista.get(i).setBirth_date(empl.getBirth_date());
                lista.get(i).setFirst_name(empl.getFirst_name());
                lista.get(i).setLast_name(empl.getLast_name());
                encontrado= true;
            }
            i++;
        }
        System.out.println("fgfdhfgh");
        for (int q = 0; q < lista.size(); q++) {
            System.out.println("LISTA");
            System.out.println(lista.get(q).getBirth_date());
            System.out.println(lista.get(q).getEmp_no());
            System.out.println(lista.get(q).getFirst_name());
            System.out.println(lista.get(q).getLast_name());
        }
        
        /*for (int i = 0; i < lista.size(); i++) {
            aux = (DTOemployee) lista.get(i);
            if (empl.getEmp_no() == aux.getEmp_no()) {
                lista.remove(i);
                lista.add(empl);
            }
        }*/
    }

    @Override
    public void delete(Object a) {
        DTOemployee empl = (DTOemployee) a;
        boolean encontrado= false;
        int i = 0;
        while ( i < lista.size()  && encontrado== false) {
            if(lista.get(i).getEmp_no() == empl.getEmp_no()){
                lista.remove(i);
                encontrado= true;
            }
            i++;
        }
        //lista.remove(empl);
    }

    @Override
    public ArrayList readAll() {
        return lista;
    }

    @Override
    public void saveInFile() {
        DTOemployee empl;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(this.fileEmployee);
            DataOutputStream dos = new DataOutputStream(fos);
            int contador = 0;
            while (contador < lista.size()) {
                empl = (DTOemployee) lista.get(contador);
                dos.writeInt(empl.getEmp_no());
                dos.writeUTF(empl.getBirth_date());
                dos.writeUTF(empl.getFirst_name());
                dos.writeUTF(empl.getLast_name());
                contador++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DSFileEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DSFileEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        //lista.clear();
    }

    @Override
    public boolean read(Object a) {
        boolean sePuedeLeer = false;
        if (!lista.isEmpty()) {
            DTOemployee dept = (DTOemployee) a;
            DTOemployee aux;
            int i = 0;
            do {
                aux = (DTOemployee) lista.get(i);
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
