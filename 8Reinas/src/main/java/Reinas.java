import java.util.ArrayList;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL CORE i5
 */
public class Reinas
{
        
    public static void main(String[] args) 
    {
   Scanner sc = new Scanner(System.in);
   ArrayList<Character> lista = new ArrayList<>();
    while(lista.size()!=16) //Validacion en caso de que no ingresen las 8 reinas
    {
    lista.clear();
    System.out.println("Ingrese las posiciones de las 8 reinas con el siguiente formato: \n['|X,Y|','|X,Y|','|X,Y|','|X,Y|','|X,Y|','|X,Y|','|X,Y|','|X,Y|']    Cambiar simbolo '|' por parentesis");
    String posiciones = sc.nextLine();   
            for(int i = 0; i< posiciones.length(); i ++)
            {
                if(Character.isDigit(posiciones.charAt(i)))
                    lista.add(posiciones.charAt(i));

            }
        if (lista.contains(9)||lista.contains(0)) 
        { 
            lista.clear();
            
        }
     
    }
                        
        int[] ar= new int[lista.size()];
         for (int i = 0; i < lista.size(); i++) {
             //System.out.println(lista.get(i));
             ar[i]=Character.getNumericValue(lista.get(i)-1); //ALL convertir de ASCII a numeros normales
             //System.out.println(ar[i]);
        }
        Proceso p=new Proceso();
        System.out.println(p.Reinas8(ar));
         
    }
}
         
            

    

    
    
    



