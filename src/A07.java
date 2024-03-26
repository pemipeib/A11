/*
A partir de un fichero de texto se creará otro cuyo contenido se obtendrá a partir del
primero. El fichero creado contendrá sólo las líneas del primer fichero que superen o igualen
un número determinado de caracteres. Se solicitará al usuario el nombre de los ficheros y el
tamaño mínimo que debe de contener la línea.
*/

import java.io.*;

public class A07 {
    //    Poner el directorio a usar
    //    static String directorio = "/home/pedro/Documentos/";
    static String directorio = "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    static File file1 = new File(directorio, "Fichero07.txt");
    static File file2 = new File(directorio, "FicheroResultado.txt");

    public static void main(String[] args) {
        lineas();
    }

    public static void lineas() {

        if (file2.exists()) {
            file2.delete();
        }

        try {

            FileReader leer1 = new FileReader(file1);
            BufferedReader bufferLeer1 = new BufferedReader(leer1);

            FileWriter texto = new FileWriter(file2);
            BufferedWriter bufferTexto = new BufferedWriter(texto);

            String leido1;
            //                lee las líneas una a una hasta que devuelve null
            while ((leido1 = bufferLeer1.readLine()) != null) {
//                 Si la cantidad de caracteres es igual o mayor de 45, escribe la línea.
                if (leido1.length() >= 45) {
                    bufferTexto.write(leido1);
                    bufferTexto.newLine();
                }
            }

            bufferTexto.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
