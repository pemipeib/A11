/*
A partir de dos ficheros de texto se creará un tercer fichero cuyo contenido se obtendrá
uniendo la información de los dos ficheros iniciales. Cada línea del fichero creado estará
formada por la unión de la misma línea de los dos ficheros leídos. Puedes escoger entre
solicitar al usuario el nombre de los ficheros y la tira de separación entre las dos líneas, que
también se deberá insertar, o directamente ponerlo en el programa.
*/

import java.io.*;

public class A05 {
    //    Poner el directorio a usar
//    static String directorio = "/home/pedro/Documentos/";
    static String directorio= "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    static File file1 = new File(directorio, "Fichero05a.txt");
    static File file2 = new File(directorio, "Fichero05b.txt");
    static File file3 = new File(directorio, "Ficherounion.txt");

    public static void main(String[] args) {
        unirFichero();
    }


    public static void unirFichero() {

        if (file3.exists()) {
            file3.delete();
        }

        try {

            FileReader leer1 = new FileReader(file1);
            BufferedReader bufferLeer1 = new BufferedReader(leer1);

            FileReader leer2 = new FileReader(file2);
            BufferedReader bufferLeer2 = new BufferedReader(leer2);

            FileWriter texto = new FileWriter(file3);
            BufferedWriter bufferTexto = new BufferedWriter(texto);

//                lee las líneas una a una hasta que devuelve null.
//            Da problemas si no se pone una variable como , en este caso, leido1 o leido2
            String leido1, leido2;
            while ((leido1 = bufferLeer1.readLine()) != null && (leido2 = bufferLeer2.readLine()) != null) {
                bufferTexto.write(leido1 + " --> " + leido2);
                bufferTexto.newLine();
                bufferTexto.write("--------------------------------");
                bufferTexto.newLine();

            }

            bufferTexto.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
