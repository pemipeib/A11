import java.io.*;
import java.util.Scanner;

public class A02 {

    //    Poner el directorioUso a usar
    static String directorioUso = "/home/pedro/Documentos/A11/src";
//    static String directorioUso = "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    public static void main(String[] args) {

        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        crearLeerFichero("Fichero1.txt", 1);
        crearLeerFichero("Fichero2.txt", 2);
    }

    public static void crearLeerFichero(String nombre, int opt) {
        //        Crea el objeto File
        File file = new File(directorioUso, nombre);

        try {
            if (file.createNewFile()) {
                //        Poner el texto en el fichero
                try {

                    FileWriter texto = new FileWriter(file);
                    BufferedWriter bufferTexto = new BufferedWriter(texto);
                    bufferTexto.write(textoFichero(opt));
                    bufferTexto.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(nombre + " creado");

            } else {
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Leer contenido del fichero
        if (file.exists()) {
            try {

                FileReader leer = new FileReader(file);
                BufferedReader bufferLeer = new BufferedReader(leer);
                String leido = bufferLeer.readLine();
                System.out.println("El contenido de " + nombre + " es " + leido);

            } catch (IOException e) {

                e.printStackTrace();

            }
        } else {

            file.delete();
//            todo arreglar el duplicado
            iniciarPrograma();

        }
    }

    public static String textoFichero(int opt) {
        String textoFichero = "";

        Scanner pedirDatos = new Scanner(System.in);

        switch (opt) {
            case 1:
                System.out.println("Dime tu nombre completo");
                break;
            case 2:
                System.out.println("Escribe lo que quieras");
                break;
        }

        textoFichero = pedirDatos.next();

        return textoFichero;
    }
}
