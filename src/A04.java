/* Haz un programa con dos métodos que llamarás desde el principal:
● Un método (insertaralumnos) para insertar los elementos de un array en un fichero
(fichero4.txt). Será un array con el nombre de los alumnos de la clase. Se debe
insertar cada nombre dentro del fichero en una línea diferente. se debe utilizar la
clase BufferedWriter.
● Otro método (elminaralumno) que pida al usuario el nombre del alumno que se
quiere borrar del fichero y lo elimine. */

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class A04 {
//    Poner el directorio a usar
//    static String directorio= "c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\";
    static String directorio= "/home/pedro/programas/java/A11";

    static File file = new File(directorio, "Fichero4.txt");
    public static void main(String[] args) {
        insertarAlumnos();
        elminaralumno();
    }

    public static void insertarAlumnos(){

        String[] alumnos= {
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
                try{
                    FileWriter texto= new FileWriter(file);
                    BufferedWriter bufferTexto= new BufferedWriter(texto);
                    for (String alumno : alumnos){
                        bufferTexto.write(alumno);
                        bufferTexto.newLine();
                    }
                    bufferTexto.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            } else {
                System.out.println("Fichero4.txt no creado o ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void elminaralumno(){
        ArrayList<String> alumnos= new ArrayList<>();

        Scanner pedirDatos= new Scanner(System.in);

        boolean salir= false;

        String alu= "", leido;;

        //        Leer contenido del fichero
        if (file.exists()) {
            try {
                FileReader leer= new FileReader(file);
                BufferedReader bufferLeer= new BufferedReader(leer);

//                lee las líneas una a una hasta que devuelve null
                while ((leido = bufferLeer.readLine()) != null) {
                    alumnos.add(leido);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("El fichero " + file.getName() + " no existe");
        }

//        Pedir el nombre del alumno
        do {

            try {
                System.out.println("Dime el nombre del alumno a eliminar");
                for (String alumno : alumnos){
                    System.out.println(alumno);
                }
                alu= pedirDatos.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Solo números");
                pedirDatos.nextLine();
            }

//            Recorre el arayList y elimina alumno
            for (int i = 0; i < alumnos.size(); i++) {
                if (alu.equalsIgnoreCase(alumnos.get(i))){
                    alumnos.remove(alumnos.get(i));
                    System.out.println("El alumno " + alu + " ha sido eliminado del fichero");
                    salir= true;
//                    Borra fichero4.txt
                    if (file.exists()){
                        file.delete();
                    }
                }
            }
        }while (!salir);

//        Crea otra vez y añado el contenido del arrayList a fichero4.txt
        try {
            if (file.createNewFile()) {
//          Poner el texto en el fichero
                try{
                    FileWriter texto= new FileWriter(file);
                    BufferedWriter bufferTexto= new BufferedWriter(texto);
                    for (String alumno : alumnos){
                        bufferTexto.write(alumno);
                        bufferTexto.newLine();
                    }
                    bufferTexto.close();
                }catch (IOException e){
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
