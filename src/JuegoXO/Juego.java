/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoXO;

/**
 *
 * @author Leonel Thomas
 */
public class Juego {
    
    public static void main(String[] args) {
        logica lg=new logica();
        Scanner leer=new Scanner(System.in);
        int op;
        try{
         do{   
        System.out.println("JUEGO DE \"x\" Y \"0\"" );
        System.out.println("1. Jugar"
                + "\n2 .ver partidas"
                + "\n3. Cambiar letra del Jugador"
                + "\n4. Cambiar Nombre del jugador "
        +"\n5. Salir");
        op=leer.nextInt();
        switch(op){
            case 1:
               lg.autoLlenado();
               lg.imprimirTablero();
               lg.jugar();
                break;

            case 2:
                System.out.println("Lista de partidas: ");
                String m="Archivo.txt";
                muestraContenido(m);
                break;

            case 3:
               lg.asignarSimbolo();
                break;

            case 4:
                lg.asignarNombre();
                break;
        }
         }while(op !=5);
        }catch(Exception e){
            System.out.println(e);
        }
    }
        
    

}
