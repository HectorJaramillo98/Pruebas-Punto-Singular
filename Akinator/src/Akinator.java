/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Akinator {
    
  public static String consultapositiva[]= 
    {
        "select *from animal where huevo=1"," and plumas=1"," and pelo=1"," and vuela=1",
        " and nada=1"," and depredador=1"," and domestico=1"  
            //" and dientes=1"," and vertebrado=1"," and venenoso=1"," and patas>0"," and cola=1",
    };   
  public static String consultanegativa[]= 
    {
        "select *from animal where huevo=0"," and plumas=0"," and pelo=0"," and vuela=0",
        " and nada=0"," and depredador=0"," and domestico=0"    
            //" and dientes=0"," and vertebrado=0"," and venenoso=0"," and patas=0"," and cola=0",
    };        
    public static String preguntas[]= 
    {
        "Viene de un huevo?","tiene plumas?","tiene pelo?","vuela?",
        "nada?","Es un depredador?","Es domestico?"
            //"tiene dientes?","Es vertebrado?","Es venenoso?", "tiene patas?","tiene cola?",
    };
public static void main(String[] args) throws SQLException 
    {
        List<String> candidatos= new ArrayList<>();
        List<String> idList= new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        String consulta="";
        String url = "jdbc:mysql://localhost:3306/animales";
        String user = "root";
        String pass = "hector123";
        System.out.println("Conectando…");
      System.out.println("Insertando …");
      ResultSet rs2 = null;
      try(Connection conexion = (Connection) DriverManager.getConnection(url, user,pass))
      {
        System.out.println("Conectado!!");
         Statement s = (Statement) conexion.createStatement();
       // ResultSet rs = s.executeQuery ("select *from animal where patas=4 and pelo=1");
       Encontrado:
          for (int i = 0; i < preguntas.length; i++) 
          {
              System.out.println("Su animal "+preguntas[i]);
             String respuesta= sc.nextLine().toLowerCase();
              if (respuesta.equals("si")) 
              {
                  consulta+=consultapositiva[i];
              }
              else if(respuesta.equals("no"))
              {
                  consulta+=consultanegativa[i];    
              }
              rs2 = s.executeQuery (consulta);
              while(rs2.next()) 
             {
                //System.out.println(rs2.getString(2));
                 if (i==6) 
                 {
                     candidatos.add(rs2.getString(2));
                     idList.add(rs2.getString(1));
                     break Encontrado;
                 }
                 else
                 {
                    candidatos.add(rs2.getString(2));
                 }
             }
              //System.out.println(consulta);
              //String animal=rs2.getString(2);
              if (candidatos.size()==1) 
              {                 
                 System.out.println("Estoy pensando en el animal "+candidatos.get(0));                  
                 break Encontrado;
              }  
              else
              {
               candidatos.clear();
              }
             
          }
       String tempfinal="";
          if (idList.isEmpty()) 
          {
              System.out.println("No hay animal con dichas caracteristicas");
          }
          else
          { 
       String sentencia="select *from animal where id=";
       sentencia+=idList.get(0);
       rs2=s.executeQuery(sentencia);
       while(rs2.next()) 
       {
       tempfinal=rs2.getString(2);
       }
       System.out.println("Su animal"+tempfinal+"?");
       String respuesta=sc.nextLine();
          if (respuesta.toLowerCase().equals("si")) {
              System.out.println("Siempre supe que era "+candidatos.get(0));
          }
          else
          {
              candidatos.remove(0);
               
              if (candidatos.isEmpty()) 
              {
                  System.out.println("Imposible XD");
              }
              else
              {
                  System.out.println("Haz ganado \nTambien pense en los siguientes animales"); 
                  for (int i = 0; i <candidatos.size()-1; i++) {
                      candidatos.get(i);
                  }
              }
          }
      }
      }catch(SQLException e)
      {
        System.out.println(e.getMessage());
      }    
    }
}

