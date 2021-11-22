import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class OrdenaryContar {
    

    
    public static void main(String[] args) {
        //Esta hecho para palabras pero es escalable a palabras
        Scanner sc= new Scanner(System.in);
        System.out.println("Escribe tu palabra");
        String txt= sc.nextLine().toLowerCase();
    char[] carac = txt.toCharArray();
    //Arreglo 
    HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
       	for (int i = 0; i < carac.length; i++) {
            if (dic.containsKey(carac[i])) //Si ya existe la letra se suma 1 al valor
            {
                dic.replace(carac[i], dic.get(carac[i]) + 1);
            }
            else
            {           //Si no existe, lo crea y se le asigna el valor 1 por ser la primera vez
            dic.put(carac[i], 1);
            }            
        }
        System.out.println(dic);
        Arrays.sort(carac); //Ordeno alfabeticamente
        String s= new String(carac);
        System.out.println(s);
    }
}



