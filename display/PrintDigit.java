/*
 * Genera la matriz que contiene los carácteres
 * para imprimir un dígito determinado
 * Luisa F Montoya 
 */
package display;

public class PrintDigit extends PrintLines{
    private int val;
    int row = (2*size) + 3;
    int col = size + 2;
    String matriz[][] = new String[col][row];

    public PrintDigit(int val, int size) {
        super(size);//Inicializa size para saber el tamaño de las líneas
        this.val = val;//Inicializa val para saber qué dígito se desea imprimir
    }
    
    //**Crea la matriz con los carácteres, según el dígito indicado**//
    public String[][] printval(){
        PrintLines line = new PrintLines(size);
        //**Inicializa la matriz con espacios en blanco**//
        for(int i = 0; i < (row); i++){
            for(int j = 0; j < (col); j++){
                matriz[j][i] = " ";
            }
        }
        
        //**Pregunta el dígito para generar su matriz**//
        switch(val){
            case 0:
                line.PrintH(0, matriz);
                line.PrintH(row-1, matriz);
                line.PrintV(col-1, matriz, 1);
                line.PrintV(col-1, matriz, col);                
                line.PrintV(0, matriz, 1);
                line.PrintV(0, matriz, col);
                break;
            case 1:
                line.PrintV(col-1, matriz, 1);
                line.PrintV(col-1, matriz, col);
                break;
            case 2:
                line.PrintH(0, matriz);                
                line.PrintH(col-1, matriz);
                line.PrintH(row-1, matriz);
                line.PrintV(col-1, matriz, 1);  
                line.PrintV(0, matriz, col);
                break;
            case 3:
                line.PrintH(0, matriz);
                line.PrintH(col-1, matriz);
                line.PrintH(row-1, matriz);
                line.PrintV(col-1, matriz, 1);
                line.PrintV(col-1, matriz, col); 
                break;
            case 4:
                line.PrintH(col-1, matriz);
                line.PrintV(col-1, matriz, 1);
                line.PrintV(col-1, matriz, col);                
                line.PrintV(0, matriz, 1);
                break;
            case 5:
                line.PrintH(0, matriz);
                line.PrintH(col-1, matriz);
                line.PrintH(row-1, matriz);
                line.PrintV(col-1, matriz, col);                
                line.PrintV(0, matriz, 1);
                break;
            case 6:
                line.PrintH(0, matriz);
                line.PrintH(col-1, matriz);
                line.PrintH(row-1, matriz);
                line.PrintV(col-1, matriz, col);                
                line.PrintV(0, matriz, 1);
                line.PrintV(0, matriz, col);
                break;
            case 7:
                line.PrintH(0, matriz);
                line.PrintV(col-1, matriz, 1);
                line.PrintV(col-1, matriz, col); 
                break;
            case 8:
                line.PrintH(0, matriz);
                line.PrintH(col-1, matriz);
                line.PrintH(row-1, matriz);
                line.PrintV(col-1, matriz, 1);
                line.PrintV(col-1, matriz, col);                
                line.PrintV(0, matriz, 1);
                line.PrintV(0, matriz, col);
                break;
            case 9:
                line.PrintH(0, matriz);
                line.PrintH(col-1, matriz);
                line.PrintH(row-1, matriz);
                line.PrintV(col-1, matriz, 1);
                line.PrintV(col-1, matriz, col);                
                line.PrintV(0, matriz, 1);
                break;
            default:
                break;
        }
        
        return matriz;
    }
}
