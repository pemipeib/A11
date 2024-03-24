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

//    static File file = new File("/home/pedro/programas/java/A11", "Fichero4.txt");
    static File file = new File("c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\", "Fichero4.txt");
    static File file1 = new File("c:\\Grado superior\\PRG\\11\\para enviar\\Unidad11\\", "Fichero4b.txt");
    public static void main(String[] args) {
        insertarAlumnos();
        elminaralumno();
    }

    public static void insertarAlumnos(){

        String[] alumnos= {
                "alumno1",
                "alumno2",
                "alumno3",
                "alumno4",
                "alumno5",
                "alumno6",
                "alumno7",
                "alumno8",
                "alumno9",
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

        do {

            try {
                System.out.println("Dime el nombre del alumno a eliminar");
                for (String alumno : alumnos){
                    System.out.println(alumno);
                }
                alu= pedirDatos.next();
            }catch (InputMismatchException e){
                System.out.println("Solo números");
                pedirDatos.nextLine();
            }

            for (int i = 0; i < alumnos.size(); i++) {
                boolean cadena= alu.equals(alumnos.get(i));
                if (cadena == true){
                    alumnos.remove(alumnos.get(i));
                    salir= false;
                }
            }
        }while (salir == true);

        try {
            if (file1.createNewFile()) {
                //        Poner el texto en el fichero
                try{
                    FileWriter texto= new FileWriter(file1);
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
                System.out.println("Fichero4b.txt no creado o ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
