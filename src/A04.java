import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class A04 {
    //    Poner el directorioUso a usar
    static String directorioUso = "/home/pedro/Documentos/A11/src";
//    static String directorioUso = "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\src\\";

    static File file = new File(directorioUso, "Fichero4.txt");

    public static void main(String[] args) {
        insertarAlumnos();
        elminaralumno();
    }

    public static void insertarAlumnos() {

        String[] alumnos = {
                "alumno 1",
                "alumno 2",
                "alumno 3",
                "alumno 4",
                "alumno 5",
                "alumno 6",
                "alumno 7",
                "alumno 8",
                "alumno 9"
        };

        try {
            if (file.createNewFile()) {
                //        Poner el texto en el fichero
                try {
                    FileWriter texto = new FileWriter(file);
                    BufferedWriter bufferTexto = new BufferedWriter(texto);
                    for (String alumno : alumnos) {
                        bufferTexto.write(alumno);
                        bufferTexto.newLine();
                    }
                    bufferTexto.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Fichero4.txt no creado o ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void elminaralumno() {
        ArrayList<String> alumnos = new ArrayList<>();

        Scanner pedirDatos = new Scanner(System.in);

        boolean salir = false;

        String alu = "", leido;

        //        Leer contenido del fichero
        if (file.exists()) {
            try {
                FileReader leer = new FileReader(file);
                BufferedReader bufferLeer = new BufferedReader(leer);

//                lee las líneas una a una hasta que devuelve null
                while ((leido = bufferLeer.readLine()) != null) {
                    alumnos.add(leido);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El fichero " + file.getName() + " no existe");
        }

//        Pedir el nombre del alumno
        do {

            try {
                System.out.println("Dime el nombre del alumno a eliminar");
                for (String alumno : alumnos) {
                    System.out.println(alumno);
                }
                alu = pedirDatos.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Solo números");
                pedirDatos.nextLine();
            }

//            Recorre el arayList y elimina alumno
            for (int i = 0; i < alumnos.size(); i++) {
                if (alu.equalsIgnoreCase(alumnos.get(i))) {
                    alumnos.remove(alumnos.get(i));
                    System.out.println("El alumno " + alu + " ha sido eliminado del fichero");
                    salir = true;
//                    Borra fichero4.txt
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        } while (!salir);

//        Crea otra vez y añado el contenido del arrayList a fichero4.txt
        try {
            if (file.createNewFile()) {
//          Poner el texto en el fichero
                try {
                    FileWriter texto = new FileWriter(file);
                    BufferedWriter bufferTexto = new BufferedWriter(texto);
                    for (String alumno : alumnos) {
                        bufferTexto.write(alumno);
                        bufferTexto.newLine();
                    }
                    bufferTexto.close();

                    if (file.exists()) {
                        System.out.println("Fichero Fichero4.txt creado");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Fichero4.txt no creado o ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
