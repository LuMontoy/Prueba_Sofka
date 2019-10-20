/*
 * Genera las líneas horizontales y 
 * verticales con las que se construye cada dígito
 * Luisa F Montoya 
 */
package display;

public class PrintLines {
   protected int size;

    public PrintLines(int size) {
        this.size = size;//Inicializa size para saber el tamaño de las líneas
    }
    
    //**Genera una línea horizontal en la fila que se le indique**//
    public void PrintH(int row, String[][] matriz){
        for(int i = 1; i < size+1; i++){
            matriz[i][row] = "-";
        }
    }
    
    //**Genera una línea vertical en la fila que se le indique**//
    public void PrintV(int col, String[][] matriz, int pos){
        for(int i = 0; i < size; i++){
            matriz[col][i+pos] = "|";
        }
    }
   
   
}
