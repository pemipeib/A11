import java.io.*;

public class A05 {
    //    Poner el directorioUso a usar
    static String directorioUso = "/home/pedro/Documentos/A11/src";
//    static String directorioUso= "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    static File file1 = new File(directorioUso, "Fichero05a.txt");
    static File file2 = new File(directorioUso, "Fichero05b.txt");
    static File file3 = new File(directorioUso, "FicherounionA05.txt");

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

            if (file3.exists()) {
                System.out.println("Fichero FicherounionA05.txt creado.\n" +
                        "Comparar con ficheros Fichero05a.txt y Ficheros05b");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
