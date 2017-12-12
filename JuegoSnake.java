package practicas;
import java.util.*;

public class JuegoSnake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner seleccionador = new Scanner(System.in);
		Scanner destring = new Scanner(System.in);
		int opcion = 0;
		Jugador usuario[] = new Jugador[3];
		usuario[0] = new Jugador();
		usuario[1] = new Jugador();
		usuario[2] = new Jugador();
		while(opcion!=4){
			
			System.out.println("''Bienvenido al menú de Snake''");
			System.out.println("1 - Iniciar Juego");
			System.out.println("2 - Regresar al juego");
			System.out.println("3 - Historial");
			System.out.println("4 - Salir");
			System.out.println("Selecciona una opción de las anteriores, por favor");
			opcion = seleccionador.nextInt();
			
			switch(opcion){
			
			case 1:
				
				System.out.println("Elíge una casilla, por favor");
				for(int i=0;i<3;i++){
					
					System.out.println((i+1) + ") " + usuario[i].dameNombreJugador());
					
				}
				int slot = seleccionador.nextInt();                       //Para casilla
				System.out.println("Tu nombre, por favor");               
				String nombree = destring.nextLine();
				System.out.println("Fecha de nacimiento, (aaaa/mm/dd) presionando entrar al terminar de poner cada uno");
				int aaaa = seleccionador.nextInt();
				int mm = seleccionador.nextInt();
				int dd = seleccionador.nextInt();
				usuario[slot-1].estableceNombreJugador(nombree);
				usuario[slot-1].estableceFechaNacimiento(aaaa, mm, dd);
				System.out.println("Estableciendo margenes para tu tablero, te recomendamos introducir el simbolo: #");
				String simbolo = destring.nextLine();
				usuario[slot-1].estableceTablero(simbolo);
				usuario[slot-1].establecePorcentajes();
				usuario[slot-1].estableceDolar();
				usuario[slot-1].estableceNumeral();
				usuario[slot-1].establecePosicionSnake();
				String jugando = "a";
				while(jugando.equalsIgnoreCase("d") || jugando.equalsIgnoreCase("s")
						|| jugando.equalsIgnoreCase("a") || jugando.equalsIgnoreCase("w")){
					
					usuario[slot-1].mostrarTablero();
					System.out.println("Tus puntos son: " + usuario[slot-1].damePuntos());
					System.out.println("Movimientos: " + usuario[slot-1].dameMovimientos());
					System.out.println("Nombre: " + usuario[slot-1].dameNombreJugador());
					System.out.println("Para moverte d: derecha, s: abajo, a: izquierda, w: arriba, cualquier otra tecla: salir");
					jugando = destring.nextLine();
					if(jugando.equalsIgnoreCase("d")){
						
						usuario[slot-1].avanzaDerecha();
						
					} else if(jugando.equalsIgnoreCase("s")){
						
						usuario[slot-1].avanzaAbajo();
						
					} else if(jugando.equalsIgnoreCase("a")){
						
						usuario[slot-1].avanzaIzquierda();
						
					} else if(jugando.equalsIgnoreCase("w")){
						
						usuario[slot-1].avanzaArriba();
						
					} else if(jugando.equalsIgnoreCase("t")){
						
						System.out.println("Saliendo");
						
					} else {
						
						System.out.println("Elíge una opcion correcta, por favor");
						
					}
					
				}
					
			break;
			
			case 2:
				
				System.out.println("Elíge tu nombre, por favor");
				for(int i=0;i<3;i++){
					
					System.out.println((i+1) + ") " + usuario[i].dameNombreJugador());
					
				}
				slot = seleccionador.nextInt();
				jugando = "a";
				while(jugando.equalsIgnoreCase("d") || jugando.equalsIgnoreCase("s")
						|| jugando.equalsIgnoreCase("a") || jugando.equalsIgnoreCase("w")){
					
					usuario[slot-1].mostrarTablero();
					System.out.println("Tus puntos son: " + usuario[slot-1].damePuntos());
					System.out.println("Movimientos: " + usuario[slot-1].dameMovimientos());
					System.out.println("Nombre: " + usuario[slot-1].dameNombreJugador());
					System.out.println("Para moverte d: derecha, s: abajo, a: izquierda, w: arriba, cualquier otra tecla: salir");
					jugando = destring.nextLine();
					if(jugando.equalsIgnoreCase("d")){
						
						usuario[slot-1].avanzaDerecha();
						
					} else if(jugando.equalsIgnoreCase("s")){
						
						usuario[slot-1].avanzaAbajo();
						
					} else if(jugando.equalsIgnoreCase("a")){
						
						usuario[slot-1].avanzaIzquierda();
						
					} else if(jugando.equalsIgnoreCase("w")){
						
						usuario[slot-1].avanzaArriba();
						
					} else if(jugando.equalsIgnoreCase("t")){
						
						System.out.println("Saliendo");
						
					} else {
						
						System.out.println("Elíge una opcion correcta, por favor");
						
					}
					
				}
				
			break;
			
			case 3:
				
				System.out.println("Información de Usuarios\nSelecciona tu nombre!");
				for(int i=0;i<3;i++){
					
					System.out.println((i+1) + ") " + usuario[i].dameNombreJugador());
					
				}
				int ver = seleccionador.nextInt();
				System.out.println("Hola " + usuario[ver-1].dameNombreJugador() + " con fecha de "
						+ "nacimiento " + usuario[ver-1].dameFechaNacimiento());
				System.out.println("Tu puntaje es de: " + usuario[ver-1].damePuntos() + 
						" con " + usuario[ver-1].dameMovimientos() + " movimientos");
				
			break;
			
			case 4:
				
				System.out.println("Saliendo");
				
			break;
			
			default:
				
				System.out.println("Opción invalida");
				
			break;
			
			}//Llave de switch
			
		}//Llave de while
			seleccionador.close();
			destring.close();
	}//LLAVE CIERRE DEL MAIN, todo lo que esta dentro de esta llave puede ser cortado

}
