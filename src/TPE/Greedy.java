package TPE;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy {
	/*
	 * - Los candidatos son [(M1, 7), (M2, 3), (M3, 4), (M4, 1)].
	 * - La estrategia para seleccionar candidatos es fijarse si la cantidad de piezas producidad por la maquina actual es menor a las piezas totales necesarias, las piezas
	 *	 totales necesarias se van restando a medida que sumamos maquinas a la solucion.
	 * - Si la cantidad de piezas producidad por la maquina actual es mayor al total necesario, simplemente se le elimina de la lista de candidatos para revisar la siquiente maquina.
	 * - Hay que tener en consideracion que el arreglo de candidatos esta ordenado de manera descendiente.
	 * */ 
	
	
	
	
	private ArrayList<Maquina> maquinas; // candidatos
	private ArrayList<Maquina> maquinaOptima; // solucion
	private int piezas; // piezas totales necesarias
	private int estadosGenerados = 0;
	
	public Greedy(ArrayList<Maquina> maquinas, int piezas) {
		this.maquinas = maquinas;
		this.piezas = piezas;
		this.maquinaOptima = new ArrayList<Maquina>();
	}
	
	public void resolver() {
		System.out.println("Greedy");
		greedy();
		System.out.println("Solucion obtenida: " + maquinaOptima);
		System.out.println("Cantidad de piezas producidas: " + this.sumarMaquina(maquinaOptima) + ", " + "Cantidad de puestas en funcionamiento: " + maquinaOptima.size());
		System.out.println("Estados generados: " + estadosGenerados);
	}
	
	private void greedy() {
		//trabajamos sobre una copia del arreglo maquinas
		ArrayList<Maquina> arrMaquinas = new ArrayList<Maquina>(maquinas);
		//ordenamos las maquinas
		Collections.sort(arrMaquinas);
		int i = 0;
		while(i < arrMaquinas.size() && piezas > 0) {
			this.estadosGenerados++;
			if (arrMaquinas.get(i).getPieza() <= this.piezas) {
				maquinaOptima.add(arrMaquinas.get(i));
				piezas -= arrMaquinas.get(i).getPieza();
			} else {
				//solo avanzamos en arrMaquinas si las piezas producidas por una maquina
				//no entran en la solucion
				i ++;
			}
		}
		if (piezas > 0) {
			System.out.println("No se obtuvo una solucion optima");
			this.maquinaOptima.clear(); //eliminamos la solucion parcial o incompleta para devolver un arreglo vacio

		}
	}
	private int sumarMaquina(ArrayList<Maquina> arr){
		int sum = 0;
		for(Maquina m: arr) {
			sum += m.getPieza();
		}
		return sum;
	}
}