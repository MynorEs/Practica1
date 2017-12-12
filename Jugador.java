package practicas;
import java.util.*;

public class Jugador {
	
	public Jugador(){
		
		nombre = "slot vacio";
		GregorianCalendar fecha = new GregorianCalendar(agno, mes, dia);
		fechaNac = fecha.getTime();
		tableroJuego = new String[35][70];
		puntos = 10;
		movimientos = 0;
		
	}
	
	public String dameNombreJugador(){
		
		return nombre;
		
	}
	
	public Date dameFechaNacimiento(){
		
		return fechaNac;
		
	}
	
	public void estableceTablero(String simb){
		
		for(int i=0;i<35;i++){//CONSTRUCCIÓN DE TABLERO EN ESTE FOR
			
			for(int j=0;j<70;j++){
				
				tableroJuego[i][j] = " ";
				tableroJuego[0][j] = simb;
				tableroJuego[i][0] = simb;
				tableroJuego[i][69] = simb;
				tableroJuego[34][j] = simb;
				
			}//for
			
			
		}//for
		
	}//Llave tablero
	
	public void establecePorcentajes(){
		
		//10 puntos, 1 caracter al snake, 40 signos en tablero
		int contador = 0;
		while(contador<=40){
					
			int numeroiporcentaje;
			int numerojporcentaje;
			numeroiporcentaje = (int)(Math.random()*100);//Alución a las i'es
			numerojporcentaje = (int)(Math.random()*100);//alución a las j's
					
			if(numeroiporcentaje>0 && numeroiporcentaje<34){
						
				if(numerojporcentaje>0 && numerojporcentaje<69){
							
					tableroJuego[numeroiporcentaje][numerojporcentaje] = "%";
					contador+=1;
							
				}
						
			}
					
		}
		
	}//Finaliza metodo porcentajes
	
	public void estableceDolar(){
		
		//Quita 10 puntos, quita 1 caracter al snake, 30 signos
		int contador1 = 0;
		while(contador1<=30){
							
			int numeroidolar;
			int numerojdolar;
			numeroidolar = (int)(Math.random()*100);//Alución a las i'es
			numerojdolar = (int)(Math.random()*100);//alución a las j's
							
			if(numeroidolar>0 && numeroidolar<34){
								
				if(numerojdolar>0 && numerojdolar<69){
							
					if(tableroJuego[numeroidolar][numerojdolar].equals(" ")){
								
						tableroJuego[numeroidolar][numerojdolar] = "$";
						contador1+=1;
								
					}
									
				}
								
			}
							
		}
		
	}//Finaliza metodo dolar
	
	public void estableceNumeral(){
		
		int contador2 = 0;
		while(contador2<=20){
									
			int numeroinumeral;
			int numerojnumeral;
			numeroinumeral = (int)(Math.random()*100);//Alución a las i'es
			numerojnumeral = (int)(Math.random()*100);//alución a las j's
									
			if(numeroinumeral>0 && numeroinumeral<34){
										
				if(numerojnumeral>0 && numerojnumeral<69){
									
					if(tableroJuego[numeroinumeral][numerojnumeral].equals(" ")){
										
						tableroJuego[numeroinumeral][numerojnumeral] = "#";
						contador2+=1;
										
					}
											
				}
										
			}
									
		}
		
	}//Finaliza metodo numeral
	
	public void mostrarTablero(){
		
		for(int i=0;i<35;i++){
			
			for(int j=0;j<70;j++){
				
				 System.out.print(tableroJuego[i][j]);
				
			}
			System.out.println("");//SALTO PARA MOSTRAR 70 COLUMNAS
		}	
			
	}//Finaliza metodo mostrar Matriz
	
	public void estableceNombreJugador(String nombre){
		
		this.nombre = nombre;
		
	}
	
	public void estableceFechaNacimiento(int agno, int mes, int dia){
		
		this.agno = agno;
		this.mes = mes;
		this.dia = dia;
		
	}
	
	public void establecePosicionSnake(){
		
		numeroisnake = (int)(Math.random()*100);//Alución a las i'es
		numerojsnake = (int)(Math.random()*100);//alución a las j's
								
		if(numeroisnake>0 && numeroisnake<34){
									
			if(numerojsnake>0 && numerojsnake<69){
								
				if(tableroJuego[numeroisnake][numerojsnake].equals(" ")){
									
					tableroJuego[numeroisnake][numerojsnake] = "O";
									
				} else {
					
					establecePosicionSnake();
					
				}
										
			} else {
				
				establecePosicionSnake();
				
			}
									
		} else {
			
			establecePosicionSnake();
			
		}
		
	}//Finaliza metodo establecePosicionSnake
	
	public void avanzaArriba(){
		
		valoranteriorisnake = numeroisnake;
		valoranteriorjsnake = numerojsnake;
		
		if((tableroJuego[numeroisnake-1][numerojsnake]).equals("%")){//EN CASO SEA %
			
			numeroisnake = numeroisnake - 1;//SUBIENDO UNA UNIDAD EN TABLERO
			puntos =puntos+10;//SUMANDO 10 PUNTOS
			
		} else if((tableroJuego[numeroisnake-1][numerojsnake]).equals("$")){//EN CASO SEA $
			
			numeroisnake = numeroisnake - 1;//SUBIENDO UNA UNIDAD EN TABLERO
			puntos =puntos-10;//RESTANDO 10 PUNTOS
			
		} else if(((tableroJuego[numeroisnake-1][numerojsnake]).equals("#")) && (numeroisnake!=1)){//EN CASO SEA #
			
			numeroisnake = numeroisnake - 1;//SUBIENDO UNA UNIDAD EN TABLERO
			
		} else if((tableroJuego[numeroisnake-1][numerojsnake]).equals(" ")){
			
			numeroisnake = numeroisnake - 1;//SUBIENDO UNA UNIDAD EN TABLERO
			
		}
		
		estableceNuevaPosSnake();
		
	}//Finaliza metodo avanzaArriba
	
	public void avanzaAbajo(){
		
		valoranteriorisnake = numeroisnake;
		valoranteriorjsnake = numerojsnake;
		
		if((tableroJuego[numeroisnake+1][numerojsnake]).equals("%")){//EN CASO SEA %
			
			numeroisnake = numeroisnake + 1;//BAJANDO UNA UNIDAD EN TABLERO
			puntos =puntos+10;//SUMANDO 10 PUNTOS
			
		} else if((tableroJuego[numeroisnake+1][numerojsnake]).equals("$")){//EN CASO SEA $
			
			numeroisnake = numeroisnake + 1;//BAJANDO UNA UNIDAD EN TABLERO
			puntos =puntos-10;//RESTANDO 10 PUNTOS
			
		} else if(((tableroJuego[numeroisnake+1][numerojsnake]).equals("#")) && (numeroisnake!=33)){//EN CASO SEA #
			
			numeroisnake = numeroisnake + 1;//BAJANDO UNA UNIDAD EN TABLERO
			
		} else if((tableroJuego[numeroisnake+1][numerojsnake]).equals(" ")){
			
			numeroisnake = numeroisnake + 1;//SUBIENDO UNA UNIDAD EN TABLERO
			
		}
		
		estableceNuevaPosSnake();
		
	}//Finaliza metodo avanzaAbajo
	
	public void avanzaIzquierda(){
		
		valoranteriorisnake = numeroisnake;
		valoranteriorjsnake = numerojsnake;
		
		if((tableroJuego[numeroisnake][numerojsnake-1]).equals("%")){//EN CASO SEA %
			
			numerojsnake = numerojsnake - 1;//AVANZANDO IZQUIERDA
			puntos =puntos+10;//SUMANDO 10 PUNTOS
			
		} else if((tableroJuego[numeroisnake][numerojsnake-1]).equals("$")){//EN CASO SEA $
			
			numerojsnake = numerojsnake - 1;//AVANZANDO IZQUIERDA
			puntos =puntos-10;//RESTANDO 10 PUNTOS
			
		} else if((tableroJuego[numeroisnake][numerojsnake-1]).equals("#") && (numerojsnake!=1)){//EN CASO SEA %
			
			numerojsnake = numerojsnake - 1;//AVANZANDO IZQUIERDA
			
		} else if((tableroJuego[numeroisnake][numerojsnake-1]).equals(" ")){//EN CASO SEA $
			
			numerojsnake = numerojsnake - 1;//AVANZANDO IZQUIERDA
			
		}
		
		estableceNuevaPosSnake();
		
	}//Finaliza avanzaIzquierda
	
	public void avanzaDerecha(){
		
		valoranteriorisnake = numeroisnake;
		valoranteriorjsnake = numerojsnake;
		
		if((tableroJuego[numeroisnake][numerojsnake+1]).equals("%")){//EN CASO SEA %
			
			numerojsnake = numerojsnake + 1;//AVANZANDO IZQUIERDA
			puntos =puntos+10;//SUMANDO 10 PUNTOS
			
		} else if((tableroJuego[numeroisnake][numerojsnake+1]).equals("$")){//EN CASO SEA $
			
			numerojsnake = numerojsnake + 1;//AVANZANDO IZQUIERDA
			puntos =puntos-10;//RESTANDO 10 PUNTOS
			
		} else if((tableroJuego[numeroisnake][numerojsnake+1]).equals("#") && (numerojsnake!=68)){//EN CASO SEA %
			
			numerojsnake = numerojsnake + 1;//AVANZANDO IZQUIERDA
			
		} else if((tableroJuego[numeroisnake][numerojsnake-1]).equals(" ")){//EN CASO SEA $
			
			numerojsnake = numerojsnake + 1;//AVANZANDO IZQUIERDA
			
		}
		
		estableceNuevaPosSnake();
		
	}//Finaliza avanzaDrecha
	
	public int damePuntos(){
		
		return puntos;
		
	}
	
	public void estableceNuevaPosSnake(){
		
		System.out.println(numeroisnake + " " + numerojsnake + "hi");
		tableroJuego[valoranteriorisnake][valoranteriorjsnake] = " ";
		tableroJuego[numeroisnake][numerojsnake] = "O";
		movimientos = movimientos + 1;
		
	}
	
	public int dameMovimientos(){
		
		return movimientos;
		
	}
	
	private String nombre;
	private Date fechaNac;
	private String [][] tableroJuego;
	private int agno;
	private int mes;
	private int dia;
	private int numeroisnake;
	private int numerojsnake;
	private int puntos;
	private int movimientos;
	private int valoranteriorisnake;
	private int valoranteriorjsnake;

}
