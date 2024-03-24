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

    static File file = new File("/home/pedro/programas/java/A11", "Fichero4.txt");
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
                "alumno 9",
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
//                System.out.println("Fichero4.txt creado");
            } else {
                System.out.println("Fichero4.txt no creado o ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //        Borrar fichero para pruebas
//        file.delete();


    }

    public static void elminaralumno(){
        ArrayList<String> alumnos= new ArrayList<>();

        Scanner pedirDatos= new Scanner(System.in);

        boolean salir= true;

        String alu= "";

        //        Leer contenido del fichero
        if (file.exists()) {
            try {
                FileReader leer= new FileReader(file);
                BufferedReader bufferLeer= new BufferedReader(leer);

                String leido;

//                System.out.println("El listado de alumnos es:");

//                lee las líneas una a una hasta que devuelve null
                while ((leido = bufferLeer.readLine()) != null) {
//                    System.out.println(leido);
                    alumnos.add(leido);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("El fichero "+ file.getName() +" no existe");
        }

        do {//todo no funciona el equals

            try {
                System.out.println("Dime el nombre del alumno a eliminar");
                alu= pedirDatos.next();
            }catch (InputMismatchException e){
                System.out.println("Solo números");
                pedirDatos.nextLine();
            }

            for (String alumno : alumnos){

                boolean com= alumno.equals(alu);
                System.out.println(com);
                if (alu.equalsIgnoreCase(alumno)){
                    System.out.println(alumno);
                    alumnos.remove(alumnos);
                    file.delete();
                    salir= false;
                }

            }

//            for (int i = 0; i < alumnos.size(); i++) {
//
//                if (alumnos.get(i).equals(alu)){
//                    System.out.println(alumnos.get(i));
//                    alumnos.remove(alumnos.get(i));
//                    file.delete();
//                    salir= false;
//                }
//            }

        }while (salir == true);

//        try {
//            if (file.createNewFile()) {
//                //        Poner el texto en el fichero
//                try{
//                    FileWriter texto= new FileWriter(file);
//                    BufferedWriter bufferTexto= new BufferedWriter(texto);
//                    for (String alumno : alumnos){
//                        bufferTexto.write(alumno);
//                        bufferTexto.newLine();
//                    }
//                    bufferTexto.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
////                System.out.println("Fichero4.txt creado");
//            } else {
//                System.out.println("Fichero4.txt no creado o ya existe");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
