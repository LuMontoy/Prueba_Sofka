/*
 * Lectura de datos ingresados por consola
 * Almacena número de líneas ingresadas, size de cada línea
 *                          Número a imprimir en cada línea. 
 * Luisa F Montoya 
 */
package display;

import java.util.Scanner;

public class DataIn {
    private boolean lastLine = false;//Indica fin ingreso de datos
    private String data;//Almacenará el dato ingresado
    private int cantLines = 0;//Cantidad de líneas ingresadas
    private int[] size = new int[20];//Almacena parte 1 de los datos ingresados_antes de la coma_
    private String[] number = new String[20];//Almacena parte 2 de los datos ingresados_después de la coma_
    Scanner entrada = new Scanner(System.in);
    boolean validacion = true;//Utilizada para la validación de datos

    public int getCantLines() {
        return cantLines;
    }

    public int[] getSize() {
        return size;
    }

    public String[] getNumber() {
        return number;
    }

    //**Lee y almacena los datos ingresados**//
    public void read(){         
            System.out.println("\n*************** DISPLAY LCD ***************\n");
            System.out.println("Cada línea debe contener dos números separados por una coma");
            System.out.println("El primero es el tamaño y el segundo el número a imprimir");
            System.out.println("Para terminar ingrese 0,0 \n");
            System.out.println("\n*************** INGRESO DE DATOS ***************\n");
            
        //**Se ejecuta hasta que se ingrese 0,0**//
        while(lastLine == false){
            validacion = true;
            System.out.print("Digite los datos de la línea " +(cantLines+1) +" : ");
            data = entrada.next();
            
            //Identifica si es la última línea//HAY QUE HACER VALIDACIÓN DE DATOS
            if(data.equals("0,0")){ //Fin lectura de datos _El usuario ingreso "0,0"_
                lastLine = true;
            }
            else {//Se ingresan más datos en una nueva línea                
                //cantNum = data.length();
                try{//Validación del formato de ingreso de datos
                size[cantLines] = Integer.parseInt(data.substring(0, data.indexOf(',')));//toma dato que está antes de la coma
                int numero = Integer.parseInt(data.substring(data.indexOf(',')+1, data.length()));//toma dato que está después de la coma      
                }catch(Exception e){//Formato ingreso de datos incorrecto (se pide de nuevo el dato)
                    System.out.println("**ALERTA: Los datos ingresados deben ser numéricos y estar separados por una coma**");
                    validacion =false;
                }
                if(0 >= size[cantLines] || size[cantLines] >= 11){//Validación dato tamaño desde 1 hasa 10
                    System.out.println("**ALERTA: El tamaño debe ser un número entero desde 1 hasta 10**");
                    validacion = false;
                }
                
                
                if(validacion ==true){ //Formato ingreso de datos correcto (se almacenan)
                number[cantLines] = data.substring(data.indexOf(',')+1, data.length());//toma datos que están después de la coma
                cantLines++;//Incrementa contador de líneas ingresadas       
                }                 
            }            
        }
    }
}
