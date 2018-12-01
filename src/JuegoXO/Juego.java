/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoXO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Leonel Thomas
 */
public class Juego {
    String tablero[][];
    String X,o;
    private String jugadores[];
    Random v;
    Scanner lee=new Scanner(System.in);
    File b;
    BufferedWriter bw;


    public Juego() {
        this.tablero=new String[3][3];
        v=new Random();
        X="x";
        o="0";
        jugadores=new String[2];
        jugadores[0]="Jugador "+X;
        jugadores[1]="Jugador "+o;
        b=new File("Archivo.txt");

    }
    public void autoLlenado(){
        for(int x=0;x<tablero.length;x++){
            for(int y=0;y<tablero[x].length;y++){
                tablero[x][y]="-";
            }
        }
    }

    public void imprimirTablero(){
        for (int x=0; x < tablero.length; x++) {

        for (int y=0; y < tablero[x].length; y++) {
      System.out.print("|"+tablero[x][y]);
        }
              System.out.println("|");
        }
    }

    public boolean marcarJugada(int fila,int columna){
        if(tablero[fila][columna].equals(X) || tablero[fila][columna].equals(o)){
            return false;
        }
        return true;
    }

    public void asignarNombre(){
    System.out.println("\nSeleccione a que jugador quiere cambiarle el Nombre:"
            + "\n1. "+jugadores[0]
            +"\n2. "+jugadores[1]);
    System.out.println("Seleccione una Opcion:");
    int opc=lee.nextInt();
    switch (opc){
        case 1:
            System.out.println("Ingrese el nuevo nombre:");
            String name=lee.next();
            if(name.equals(jugadores[1])||  name.equals(jugadores[0])){
                System.out.println("Ese nombre ya esta en uso!!!!!!");
            }else{
                System.out.println("Cambio completado");
                 jugadores[0]=name;
            }
            break;
        case 2:
               System.out.println("Ingrese el nuevo nombre:");
               String name1=lee.next();
            if(name1.equals(jugadores[0]) || name1.equals(jugadores[1])){
                System.out.println("Ese nombre ya esta en uso!!!!!!");
            }else{
                System.out.println("Cambio completado");
                 jugadores[1]=name1;
            }
            break;
        default:
            System.out.println("Ingrese Opcion valida!!!!!!!!!!");
            break;
     }

    }

    public void asignarSimbolo(){
        System.out.println("\nSeleccione a que jugador quiere cambiarle el Simbolo:"
                + "\n1. "+jugadores[0]
                +"\n2. "+jugadores[1]);
        System.out.println("Seleccione una Opcion:");
        
        int opc=lee.nextInt();
        switch (opc){
            case 1:
                System.out.println("Ingrese el nuevo Simbolo:");
                String name=lee.next();
                if(name.equals(o)|| name.equals(X)){
                    System.out.println("Ese nombre ya esta en uso!!!!!!");
                }else{
                    System.out.println("Cambio completado");
                     X=name;
                }
                break;
            case 2:
                   System.out.println("Ingrese el nuevo Simbolo:");
                   String name1=lee.next();
                if(name1.equals(o) || name1.equals(X)){
                    System.out.println("Ese nombre ya esta en uso!!!!!!");
                }else{
                    System.out.println("Cambio completado");
                     o=name1;
                }
                break;
            default:
                System.out.println("Ingrese Opcion valida!!!!!!!!!!");
                break;
        }

    }
    public void fileSaver(String x)throws IOException{
        if(b.exists()){
              bw = new BufferedWriter(new FileWriter(b,true));
          bw.write("\n"+x);
        }else{
            bw = new BufferedWriter(new FileWriter(b,true));
          bw.write("\n"+x);
        }
        bw.close();
    }
     
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader c = new BufferedReader(f);
            while((cadena = c.readLine())!=null) {
                System.out.println(cadena);
            }
            c.close();
        }

        public String escojerP(){
            return jugadores[v.nextInt(2)];
        }

        public boolean revisarGanador(){
            int h=0;
            int j=0;
            int h1=0,j1=0,b=0,v=0,h2=0,j2=0,h3=0,j3=0;
            int m=tablero.length-1;
            int n=tablero.length-1;

         try{
             for (int x=0; x < tablero.length; x++) {
            h=0;
            j=0;h1=0;j1=0;h2=0;j2=0;v=0;b=0;h3=0;j3=0;
            m=tablero.length-1;
            n=tablero.length-1;

      for (int y=0; y < tablero[x].length; y++) {
          if(tablero[b][y].equals(X)){
              b++;
              h2++;
               if(h2==tablero.length){
                 return true;
             }
          }else if(tablero[v][y].equals(o)){
              v++;
              j2++;
              if(j2==tablero.length){
                 return true;
             }
          }

          if(tablero[m][y].equals(X)){
              m--;
              h3++;
               if(h3==tablero.length){
                 return true;
             }
          }else if(tablero[n][y].equals(o)){
              n--;
              j3++;
              if(j3==tablero.length){
                 return true;
             }
          }
          
          if(tablero[x][y].equals(X)){
             h++;
             if(h==tablero.length){
                 return true;
             }
          }else if(tablero[x][y].equals(o)){
             j++;
             if(j==tablero.length){
                return true; 
             }
          }

          if(tablero[y][x].equals(X)){
              h1++;
              if(h1==tablero.length){
                return true; 
             }
          }else if(tablero[y][x].equals(o)){
             j1++;
             if(j1==tablero.length){
                return true; 
             }
          }
      }
    }
         }catch(Exception e){
             System.out.println("error: "+e);
         }
        return false;    
        }

        public void jugar(){
        Scanner leer=new Scanner(System.in);
        System.out.println("El primer turno se escoje automaticamente");
        String player=escojerP();
        String turno="";
        boolean ganador=false;
        boolean revisar=true;
        
        if(player.equals(jugadores[0])){
            System.out.println("\nEmpieza "+player);
            turno=X;
        }else{
            System.out.println("\nEmpieza "+player);
            turno=o;
        }

        do{
        if(turno.equals(X)){
            System.out.println("Turno de "+jugadores[0]);
            System.out.println("Escoja la fila: ");
            int q=leer.nextInt();
            System.out.println("Escoja la Columna: ");
            int w=leer.nextInt();
            revisar=marcarJugada(q,w);
            if(revisar==true){
            tablero[q][w]=X;
            imprimirTablero();
            ganador=revisarGanador();
            turno=o;
            
            if(ganador==true){
            try{  
                String b="El ganador de la partida fue: "+ jugadores[0];
            System.out.println("Gano "+X);
            fileSaver(b);
              }catch(IOException e){
                  System.out.println(e.getMessage());
              }
            }

            }else{
                System.out.println("Espacio Ocupado!!!");
        }

        }else if(turno.equals(o)){
           System.out.println("Turno de "+jugadores[1]);
           System.out.println("Escoja la fila: ");
            int q=leer.nextInt();
            System.out.println("Escoja la Columna: ");

            int w=leer.nextInt();
            revisar=marcarJugada(q,w);
            if(revisar==true){
            tablero[q][w]=o;
            imprimirTablero();
            ganador=revisarGanador();
            turno=X;
            
            if(ganador==true){
              try{  
                String b="El ganador de la partida fue: "+ jugadores[1];
            System.out.println("Gano "+o);
            fileSaver(b);
              }catch(IOException e){
                  System.out.println(e.getMessage());
              }
            }
            }else{
                System.out.println("Espacio Ocupado!!!!!");
            }
        }
        }while(ganador !=true);

    }
}

