/*
A partir de dos ficheros de texto se creará un tercer fichero cuyo contenido se obtendrá de
las combinaciones de cada línea del primer fichero y todas las líneas del segundo fichero.
Puedes escoger entre solicitar al usuario el nombre de los ficheros y la tira de separación
entre las dos líneas, que también se deberá de insertar, o directamente ponerlo en el
código.
*/

import java.io.*;
import java.util.ArrayList;

public class A06 {
//    static String directorio = "/home/pedro/Documentos/";
    static String directorio= "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    static File file1 = new File(directorio, "Fichero06a.txt");
    static File file2 = new File(directorio, "Fichero06b.txt");
    static File file3 = new File(directorio, "Ficherounion.txt");
    public static void main(String[] args) {

        unirFichero();
    }

    public static void unirFichero() {

        ArrayList<String> linea1= new ArrayList<>();
        ArrayList<String> linea2= new ArrayList<>();

        String leido1= null;
        String leido2= null;

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

            try {
                FileReader leer = new FileReader(file1);
                BufferedReader bufferLeer = new BufferedReader(leer);

//                lee las líneas una a una hasta que devuelve null
                while ((leido1 = bufferLeer.readLine()) != null) {
                    linea1.add(leido1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                FileReader leer = new FileReader(file2);
                BufferedReader bufferLeer = new BufferedReader(leer);

//                lee las líneas una a una hasta que devuelve null
                while ((leido2 = bufferLeer.readLine()) != null) {
                    linea2.add(leido2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < linea1.size(); i++) {

                for (int j = 0; j < linea2.size(); j++) {

                        bufferTexto.write(linea1.get(i) + " --> " + linea2.get(j));
                    bufferTexto.newLine();
                }
                bufferTexto.write("--------------------------------");
                bufferTexto.newLine();
            }

            bufferTexto.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
