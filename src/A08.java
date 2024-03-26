/*Se debe crear un fichero llamado dni.txt con 20 DNIs aleatorios. Los DNI tienen 8
números,así que si algún DNI tiene longitud menor a 8, se deberá rellenar con 0 's por la
izquierda.
Posteriormente se creará un fichero llamado nif.txt en el que se guardarán los DNI junto con
la letra que le corresponda.
El string con las letras es el siguiente: "TRWAGMYFPDXBNJZSQVHLCKE" . Como ya se
sabe, la letra del NIF es la que ocupa la posición correspondiente al resto de dividir DNI
entre 23.*/

import java.io.*;
import java.util.ArrayList;

public class A08 {
    //    Poner el directorio a usar
    //    static String directorio = "/home/pedro/Documentos/";
    static String directorio = "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    static ArrayList<String> dni = new ArrayList<>();

    static File file1 = new File(directorio, "dni.txt");
    static File file2 = new File(directorio, "nif.txt");

    public static void main(String[] args) {
        leerFicheroDNI();

    }

    public static void crearFicheroDNI(){
        int num1 = 0;
        String num2;

        if (file1.exists()) {
            file1.delete();
        }

//        Crear fichero dni.txt
        try {

            FileWriter texto = new FileWriter(file1);
            BufferedWriter bufferTexto = new BufferedWriter(texto);

//            Generar numeros aleatorios de 8 cifras
            for (int i = 0; i <= 20; i++) {
                num1 = (int) Math.floor(Math.random() * 100000000);
                num2 = String.valueOf(num1);

//                Si es de 7 cifras añade un 0
                if (num1 <= 9999999) {
                    num2 = 0 + num2;
                }

                bufferTexto.write(num2);
                bufferTexto.newLine();
            }

            bufferTexto.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerFicheroDNI() {

        crearFicheroDNI();

//        Leer fichero y ponerlo en un arraylist
        try {
            FileReader leer1 = new FileReader(file1);
            BufferedReader bufferLeer1 = new BufferedReader(leer1);

            String leido1;
            //                lee las líneas una a una hasta que devuelve null
            while ((leido1 = bufferLeer1.readLine()) != null) {

                dni.add(leido1);
            }

            escribirFicheroNIF();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirFicheroNIF() {

        if (file2.exists()) {
            file2.delete();
        }

        try {
            FileWriter texto = new FileWriter(file2);
            BufferedWriter bufferTexto = new BufferedWriter(texto);

            for (int i = 0; i < dni.size(); i++) {
                String nif = ponerLetra(dni.get(i));
                bufferTexto.write(nif);
                bufferTexto.newLine();
            }

            bufferTexto.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String ponerLetra(String dni) {

//        Variables
        int num = 0;
        int numeroDNI = Integer.parseInt(dni);
        String nif;
        String letra = "TRWAGMYFPDXBNJZSQVHLCKE";
        char caracter;
        char[] letraArry = letra.toCharArray();

        num = numeroDNI % 23;
        caracter = letraArry[num];
        nif = dni + "-" + caracter;

        return nif;
    }
}
