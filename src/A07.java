import java.io.*;

public class A07 {
    //    Poner el directorioUso a usar
    static String directorioUso = "/home/pedro/Documentos/A11/src";
//    static String directorioUso = "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    static File file1 = new File(directorioUso, "Fichero07.txt");
    static File file2 = new File(directorioUso, "FicheroResultado.txt");

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

            if (file2.exists()) {
                System.out.println("Fichero FicheroResultado.txt creado.\n" +
                        "Comparar con fichero Fichero07.txt");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
