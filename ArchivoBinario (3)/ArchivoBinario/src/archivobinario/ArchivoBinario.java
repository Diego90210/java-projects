/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivobinario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Amaury
 */
public class ArchivoBinario {

    public static Estudiante e  = new Estudiante("Fulano",987654,2210112,4);
    //Objeto estudiante
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ruta_archivo = "archivo.dat";
        //objeto estudiante
        Estudiante est = new Estudiante("De Tal", 123456, 2210111,3);
        //Se crea un vector de 2 estudiantes 
        Estudiante lista [] = new Estudiante [2];
        lista [0] = e;
        lista [1] = est;
        //System.out.println(est);
        escribirBinario(ruta_archivo, lista);
        //nEst es el vector almacenado en el archivo binario
      Estudiante nEst[] = leerBinario(ruta_archivo);
        System.out.println("Los datos de los estudiantes son");
        //Imprimimos cada uno de los objetos
        for (int i=0; i<nEst.length; i++)
            System.out.println(nEst[i]);
        //Modificamos el valor de algun objeto
        nEst[0].setCedula(123);
        // volvemos a escribir
        escribirBinario(ruta_archivo, nEst);
        //escribirBinario(ruta_archivo, est);
        // se lee nuevamente del archivo
        Estudiante nEst2 [] =  leerBinario(ruta_archivo);
        // Se imprimen los datos modificados
        System.out.println("");
        System.out.println("*****");
        
        System.out.println("Los datos modificados del estudiante son");
        for (int i=0; i<nEst2.length; i++)
            System.out.println(nEst2[i]);
        
        
    }
    public static void escribirBinario (String ruta, Estudiante[] obj){
        try {
            //Se crea un Stream para guardar archivo
            FileOutputStream f =new FileOutputStream( ruta );
            ObjectOutputStream file = new ObjectOutputStream(f);
            //Se escribe el objeto en archivo
            file.writeObject(obj);
            //se cierra archivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static Estudiante[] leerBinario(String ruta)
    {
        try {
            //Stream para leer archivo
            ObjectInputStream file = new ObjectInputStream(new FileInputStream( ruta ));
            //Se lee el objeto de archivo y este debe convertirse al tipo de clase que corresponde
            //Se hace un Casting de Object a Estudiante
            Estudiante nEst[] = (Estudiante[]) file.readObject();
            //se cierra archivo
            file.close();
            //Se utilizan metodos de la clase asi como variables guardados en el objeto
            //System.out.println(nEst);
            return nEst;
        } catch (ClassNotFoundException | IOException ex) {
             System.out.println(ex);
             
        }
        return null;
    }
}
