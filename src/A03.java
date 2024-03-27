import java.io.*;

public class A03 {
    //    Poner el directorioUso a usar
    static String directorioUso = "/home/pedro/Documentos/A11/src";
//    static String directorioUso = "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    public static void main(String[] args) {
        crearLeerFichero("Fichero3.txt");
    }

    public static void crearLeerFichero(String nombre) {
        //        Crea el objeto File
        File file = new File(directorioUso, nombre);

        String textoFichero =
                "Nombre -> Pedro Miguel Pérez Ibáñez\n" +
                        "Email -> pedroperez@peperez.es\n" +
                        "Teléfono -> 123456789";

        try {

            if (file.exists()) {
                file.delete();
            }

            if (file.createNewFile()) {
//        Poner el texto en el fichero
                try {
                    FileWriter texto = new FileWriter(file);
                    BufferedWriter bufferTexto = new BufferedWriter(texto);
                    bufferTexto.write(textoFichero);
                    bufferTexto.close();

                    if (file.exists()) {
                        System.out.println("Fichero Fichero3.txt creado");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(nombre + " creado");
            } else {
                System.out.println(nombre + " no creado o ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Leer contenido del fichero
        if (file.exists()) {
            try {
                FileReader leer = new FileReader(file);
                BufferedReader bufferLeer = new BufferedReader(leer);

                String leido;

//                lee las líneas una a una hasta que devuelve null
                while ((leido = bufferLeer.readLine()) != null) {
                    System.out.println(leido);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El fichero " + nombre + " no existe");
        }
    }
}
