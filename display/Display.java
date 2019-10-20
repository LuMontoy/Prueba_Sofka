/*
 * Imprime líneas de datos en formato LCD según tamaño indicado
 * Luisa F Montoya 
 */
package display;

public class Display {

    public static void main(String[] args) {
        DataIn ReadData = new DataIn();
        ReadData.read();//Lectura de datos
        int cantData = ReadData.getCantLines();//Cantidad de líneas ingresadas
        int[] size = new int[cantData];//Vector con el tamaño de cada línea de datos
        String[] number = new String[cantData];//Vector con el número a imprimir en cada línea        
        int conLine = 0;//Contador líneas que se imprimen                
        
        size = ReadData.getSize();
        number = ReadData.getNumber();
        
        //**Ciclo para imprimir cada línea**//
        System.out.println("\n*************** DATOS EN DISPLAY LCD ***************\n");
        while (conLine != cantData){
            int row = (2*size[conLine] + 3);
            int col = size[conLine] + 2;
            int cantDig = number[conLine].length();//Toma la cantidad de dígitos a imprimir en esta línea
            int pos = 0;//Vbles para barrer los arreglos
            int h = 0;//Vbles para barrer los arreglos
            
            String num[][] = new String[col][row];//Matriz que almacena un solo dígito de la línea
            String[][] dato = new String[(col*cantDig)+cantDig-1][row];//Matriz que almacena todos los dígitos de la línea
            //**Ciclo para inicializar la matriz con espacios en blanco**//
            for(int i = 0; i < row; i++){
                for(int j = 0; j < ((col*cantDig)+cantDig-1); j++){
                    dato[j][i] = "  ";
                }
            }
            
            //**Ciclo para generar la matriz de cada dígito de la línea**//
            while (pos != cantDig){
                int val = Integer.parseInt(number[conLine].substring(pos,pos+1));//Almacena solo el primer dígito del número a imprimir
                PrintDigit ensayo = new PrintDigit(val,size[conLine]);//Objeto de la clase PrintDigit

                num = ensayo.printval();//Método que genera la matriz del dígito correspondiente
                //**Ciclo para almacenar la matriz de un solo dígito en la matríz que guarda todos los dígitos de una línea**//
                for(int i = 0; i < (row); i++){
                    for(int j = 0; j < (col); j++){
                        dato[h+j][i] = num[j][i];                
                    }            
                }
                h = (col+1)*(pos+1);//Vble encargada de actualizar la posición para almacenar el siguiente dígito del número
                pos++;//Incrementa contador para pasar al siguiente dígito de una misma línea
            }   
            
            //**Ciclo para imprimir la matriz que contiene todos los dígitos de una línea**//
            for(int i = 0; i < (row); i++){
                for(int j = 0; j < (col*cantDig)+cantDig-1; j++){
                    System.out.print(dato[j][i]);             
                }            
                System.out.print("\n");
            }
            
            conLine++;//Incrementa contador para pasar a la siguiente línea
            System.out.println("\n");
        }
    }    
}
