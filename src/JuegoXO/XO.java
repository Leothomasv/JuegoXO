/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoXO;

import static JuegoXO.Juego.muestraContenido;
import java.util.Scanner;

/**
 *
 * @author Leonel Thomas
 */
public class XO {
    
    public static void main(String[] args) {
        Juego JG=new Juego();
        Scanner leer=new Scanner(System.in);
        
        int op;
        try{
         do{   
        System.out.println("JUEGO DE \"x\" Y \"0\"" );
        System.out.println("1. Jugar"
                + "\n2. Ver partidas"
                + "\n3. Cambiar Letra del Jugador"
                + "\n4. Cambiar Nombre del jugador "
        +"\n5. Salir");
             System.out.print("Ingrese opcion deseada: ");
         op=leer.nextInt();
        switch(op){
            case 1:
               JG.autoLlenado();
               JG.imprimirTablero();
               JG.jugar();
                break;

            case 2:
                System.out.println("Lista de partidas: ");
                String m="Archivo.txt";
                muestraContenido(m);
                break;

            case 3:
               JG.asignarSimbolo();
                break;

            case 4:
                JG.asignarNombre();
                break;
        }
         }while(op !=5);
        }catch(Exception e){
            System.out.println(e);
        }
    }
        
    

}
