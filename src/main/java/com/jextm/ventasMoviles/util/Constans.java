package com.jextm.ventasMoviles.util;

public class Constans {
	
	public  static final String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};   
	
	
	public static int getDiaByText(String tdia){
		switch (tdia) {
		case "Domingo":
			return 0;
		case "Lunes":
			return 1;
		case "Martes":
			return 2;
		case "Miercoles":
			return 3;
		case "Jueves":
			return 4;
		case "Viernes":
			return 5;
		case "Sabado":
			return 6;
		default:
			return 0;
		}
	}
	
}
