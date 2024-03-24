import java.io.*;
import java.util.Scanner;

/* Haz un programa que lea el contenido de un fichero llamado fichero3.txt donde hayan varias
líneas de texto (por ejemplo tu nombre en una línea, el mail en otra, el teléfono en otra …) y
muestra por pantalla su contenido.
Utiliza la clase BufferedReader.
 */
public class A03 {

    static String dirTrabajo = "/home/pedro/programas/java/A11";

    public static void main(String[] args) {
        crearLeerFichero("Fichero3.txt");
    }

    public static void crearLeerFichero(String nombre){
        //        Crea el objeto File
        File file = new File(dirTrabajo, nombre);

        String textoFichero=
                "Nombre -> Pedro Miguel Pérez Ibáñez\n" +
                "Email -> pedroperez@peperez.es\n" +
                "Teléfono -> 123456789";

        try {
            if (file.createNewFile()) {
                //        Poner el texto en el fichero
                try{
                    FileWriter texto= new FileWriter(file);
                    BufferedWriter bufferTexto= new BufferedWriter(texto);
                    bufferTexto.write(textoFichero);
                    bufferTexto.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println(nombre + " creado");
            } else {
                System.out.println(nombre + " no creado o ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Borrar fichero para pruebas
//        file.delete();

//        Leer contenido del fichero
        if (file.exists()) {
            try {
                FileReader leer= new FileReader(file);
                BufferedReader bufferLeer= new BufferedReader(leer);

                String leido;

//                lee las líneas una a una hasta que devuelve null
                while ((leido = bufferLeer.readLine()) != null) {
                    System.out.println(leido);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("El fichero "+ nombre +" no existe");
        }

    }

}
