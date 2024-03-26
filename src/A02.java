import java.io.*;
import java.util.Scanner;

/*
Haz un programa para leer el contenido de un fichero llamado fichero1.txt donde haya
contenido (por ejemplo, tu nombre y apellidos).
Después inserta una cadena de texto dentro de otro fichero llamado fichero2.txt. Los
ficheros los puedes crear en el directorio que desees.
 */
public class A02 {

    static String dirTrabajo = ".\\src\\";

    public static void main(String[] args) {

        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        crearLeerFichero("Fichero1.txt", 1);
        crearLeerFichero("Fichero2.txt", 2);
    }

    public static void crearLeerFichero(String nombre, int opt) {
        //        Crea el objeto File
        File file = new File(dirTrabajo, nombre);

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

//        pedirDatos.close(); Da error

        return textoFichero;

    }
}
