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
import model_DTO.DTOTitle;
import interfaceDAO.IDAOManagement;
import java.util.ArrayList;

public class DSFileTitle implements IDAOManagement {

    public ArrayList<DTOTitle> lista = new ArrayList<>();

    File fileTitle;

    public DSFileTitle(String ruta) throws FileNotFoundException, IOException {
        boolean eof = false;
        fileTitle = new File(ruta);
        fileTitle.createNewFile();

        FileInputStream fis = new FileInputStream(fileTitle);
        DataInputStream dis = new DataInputStream(fis);
        DTOTitle e;

        while (!eof) {
            e = new DTOTitle();
            try {
                e.setEmp_no(dis.readInt());
                e.setTitle(dis.readUTF());
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
        DTOTitle dept_title = (DTOTitle) a;
        lista.add(dept_title);
        
    
    }

    @Override
    public void update(Object a) {
        DTOTitle dept_title = (DTOTitle) a;
        DTOTitle aux;

        for (int i = 0; i < lista.size(); i++) {
            aux = (DTOTitle) lista.get(i);
            if (dept_title.getEmp_no() == aux.getEmp_no()) {
                lista.remove(i);
                lista.add(dept_title);
            }
        }
    }

    @Override
    public void delete(Object a) {
        DTOTitle dept_title = (DTOTitle) a;
        lista.remove(dept_title);
    }

    @Override
    public ArrayList readAll() {
        return lista;
    }

    @Override
    public void saveInFile() {
        DTOTitle sal;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(this.fileTitle, true);
            DataOutputStream dos = new DataOutputStream(fos);
            int contador = 0;
            while (contador < lista.size()) {
                sal = (DTOTitle) lista.get(contador);
                dos.writeInt(sal.getEmp_no());
                dos.writeUTF(sal.getTitle());
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
            DTOTitle dept_title = (DTOTitle) a;
            DTOTitle aux;
            int i = 0;
            do {
                aux = (DTOTitle) lista.get(i);
                if (dept_title.getEmp_no() == aux.getEmp_no()) {
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
