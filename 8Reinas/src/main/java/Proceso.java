import com.sun.xml.internal.fastinfoset.sax.SAXDocumentSerializerWithPrefixMapping;
import java.util.ArrayList;
import java.lang.Math;

/**
 *
 * Jaramillo Regino Hector
 */
public class Proceso {
    

    public Boolean Reinas8(int[] lista)
    {

        boolean a=false;
           int[][] tablero = new int[8][8];
           for (int n = 0; n < tablero.length;n++) //Columnas
            for(int i = 0;i < tablero[0].length;i++) //Filas
                tablero[n][i]= 0;
        
           for (int i = 0; i < lista.length-1; i++) {
            tablero[lista[i+1]][lista[i]]=1; 
            i++;
           }    
        System.out.println("Mapa de Representacion: 0=Posiciones vacias, 1=Posicion de las Reinas");
         for (int n = 0; n < tablero.length;n++)//Columnas
           {
            for(int i = 0;i < tablero[0].length;i++) //Filas
            {
                System.out.print(tablero[n][i]+" ");
                if (i==7) System.out.print("\n");
            }
           } 
        Amenaza:
  for (int n = 0; n < tablero.length;n++)//Columnas
           {
            for(int i = 0;i < tablero[0].length;i++) //Filas
            {
                if (tablero[n][i]==1) { //Comprobacion de renglones
                    if (tablero[n][i]==tablero[i][n]) {
                      System.out.println("la Reina en la posicion:"+"("+ (i+1) + "," + (n+1) + ") esta en posicion de ataque." );
                      break Amenaza;
                    }
                    else if(Math.abs(lista[0]-lista[i+2])==Math.abs((lista[1]-lista[i+3]))&&i<4)//Comprobacion de diagonales con principio "misma distancia de X que de Y" 
                    {                                                                          //
                    System.out.println("la Reina en la posicion:"+"("+ (i+1) + "," + (n+1) + ") esta en posicion de ataque." );
                    break Amenaza;
                    }
                    else if(Math.abs(lista[2]-lista[i+2])==Math.abs((lista[3]-lista[i+3]))&& i<4)
                    {
                    System.out.println("la Reina en la posicion:"+"("+ (i+1) + "," + (n+1) + ") esta en posicion de ataque." );
                    break Amenaza;
                    }
                    else if(Math.abs(lista[4]-lista[i+2])==Math.abs((lista[5]-lista[i+3]))&& i<4)
                    {
                    System.out.println("la Reina en la posicion:"+"("+ (i+1) + "," + (n+1) + ") esta en posicion de ataque." );
                    break Amenaza;
                    }
                   else
                    {a=true;}    
                }
            }
           }
         
         
         
        return a;
    }
}
