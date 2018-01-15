/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LectorDeBinario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lectorEmployee {

    public static void main(String[] args) {

        RandomAccessFile a = null;
        try {
            a = new RandomAccessFile("FileDepartment.DAT", "rwd");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lectorEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        Boolean finFichero = true;
        while (finFichero) {
            try {
                System.out.println(a.readInt());
                System.out.println(a.readUTF());
            } catch (IOException e) {
                finFichero = false;
            }
        }

    }

}
