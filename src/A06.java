import java.io.*;
import java.util.ArrayList;

public class A06 {
    //    Poner el directorioUso a usar
    static String directorioUso = "/home/pedro/Documentos/A11/src";
//    static String directorioUso = "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    static File file1 = new File(directorioUso, "Fichero06a.txt");
    static File file2 = new File(directorioUso, "Fichero06b.txt");
    static File file3 = new File(directorioUso, "FicherounionA06.txt");

    public static void main(String[] args) {

        unirFichero();
    }

    public static void unirFichero() {

        ArrayList<String> linea1 = new ArrayList<>();
        ArrayList<String> linea2 = new ArrayList<>();

        String leido1 = null;
        String leido2 = null;

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

                bufferTexto.write(linea1.get(i));

                for (int j = 0; j < linea2.size(); j++) {

                    bufferTexto.write(" --> " + linea2.get(j));
                }
                bufferTexto.newLine();
                bufferTexto.write("--------------------------------");
                bufferTexto.newLine();
            }

            bufferTexto.close();

            if (file3.exists()) {
                System.out.println("Fichero FicherounionA06.txt creado.\n" +
                        "Comparar con ficheros Fichero06a.txt y Ficheros06b");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
