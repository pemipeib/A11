import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class A01 {

    //    Variables locales
//    Cambiar directorio para pruebas
    static String dirTrabajo = "/home/pedro/programas/java/A11";

    public static void main(String[] args) {

        int opt = 0;

        do {
            opt = menu();
            opciones(opt);
        } while (opt != 5);
    }

    public static int menu() {
        int opt = 0;

        Scanner pedirDatos = new Scanner(System.in);

        String menu = "Seleciona una opción\n" +
                "1. Crear fichero1.txt\n" +
                "2. Dame un nombre de fichero a crear\n" +
                "3. Ver contenido del directorio\n" +
                "4. Nombre, ruta absoluta y relativa y otros parámetros de fichero1.txt\n" +
                "5. salir";

        do {
            try {
                System.out.println(menu);
                opt = pedirDatos.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Solo números");
                pedirDatos.nextLine();
            }
        } while (opt < 1 || opt > 5);

        return opt;
    }

    public static void opciones(int opt) {

        switch (opt) {
            case 1:
                crearFichero("fichero1.txt");
                break;
            case 2:
                crearFichero(nombre(1));
                break;
            case 3:
                verContenidoDir(nombre(2));
                break;
            case 4:
                verInf(nombre(3));
                break;
        }
    }

    //    Crea un fichero con el nombre del parametro que se pasa
    public static void crearFichero(String nomFichero) {

//        Crea el objeto File
        File file1 = new File(dirTrabajo, nomFichero);

        try {
            if (file1.createNewFile()) {
                System.out.println("Fichero " + nomFichero + " creado");
            } else {
                System.out.println("Fichero no creado");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero");
        }

    }

    //    Muestra el contenido de un directorio
    public static void verContenidoDir(String nombreDir) {
        File file2 = new File(nombreDir);

        if (file2.exists()) {
//        Lee el contenido de un directorio y lo guarda como un array
            String[] contenido = file2.list();

            if (contenido == null || contenido.length == 0) {
                System.out.println("El directorio está vacio o no existe");
            } else {
                for (String cont : contenido) System.out.println(cont);
            }
        } else {
            System.out.println(nombreDir + " no existe");
        }

    }

    public static void verInf(String nombre) {
        File file3 = new File(nombre);

//        Comrueba si existe el nombre pedido
        if (file3.exists()) {
//            Comprueba si es un directorio o un fichero
            if (file3.isDirectory()) {
                System.out.println(file3.getName() + " Es un directorio");
            } else {
                System.out.println(file3.getName() + " es un fichero");
                System.out.println("La ruta absoluta de " + file3.getName() + " es " + file3.getAbsolutePath());
                System.out.println("La ruta relativa de " + file3.getName() + " es " + file3.getPath());
                String escribe = file3.canWrite() ? "Se puede escribir" : "No se puede escribir";
                System.out.println(escribe);
                String leer = file3.canRead() ? "Se puede leer" : "No se puede leer";
                System.out.println(leer);
                String ejecutar = file3.canExecute() ? "Se puede ejecutar" : "No se puede ejecutar";
                System.out.println(ejecutar);
                System.out.println("El tamaño de " + file3.getName() + " es " + file3.length() + " bytes");
            }
        } else {
            System.out.println("El nombre introducido no existe");
        }

    }

    //    Pide el nombre según el paramatro pasado y devuelve el string introducido
    public static String nombre(int opt) {
        String nombreFichero = "";

        Scanner pedirDatos = new Scanner(System.in);

        switch (opt){
            case 1:
                System.out.println("Dime el nombre del fichero");
                break;
            case 2:
                System.out.println("Dime el nombre del directorio");
                break;
            case 3:
                System.out.println("Dime el nombre de un fichero o un directorio");
                break;
        }

        nombreFichero = pedirDatos.next();

        return nombreFichero;
    }
}
