package TPE;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
	
	/* 
	* <<Breve explicación de la estrategia de resolución. Por ejemplo:  
	*  
	*  - Cómo se genera el árbol de exploración.
	*  el arbol que se va generando es por recursion y la condicione es verificar si el total obtenido es igual a la cantiidad de piezas
	*  y si la maquina optima esta vacia o si el tamanio del arreglo actual es mayor al tamanio del arreglo optimo, se lo agrega al arreglo optimo
	*  si no es asi verifica que el total sea menor a las piezas. Si es asi, recorre el arreglo de maquina y por cada elementoa, lo agregar al arreglo actual
	*  y se hace la recursion con el arreglo actual y al total se le suma la cantidad de piezas que tiene el elemento de maquina.  
	*  
	*  Cuáles son los estados finales y estados solución
	*  para el ejemplo de [(M1, 7), (M2, 3), (M3, 4), (M4, 1)] con una cantidad de 12 piezas 
	*  una posible solucion para el estado final es [M1,7, M3,4, M4,1]
	*  
	*  Posibles podas.
	*  
    * - Si la cantidad total de piezas producidas ya es mayor que la requerida, 
    *   la rama se descarta implícitamente, ya que no entra al caso de recursión.
    *
    * - Si la solución parcial actual ya usa igual o más máquinas que la mejor solución encontrada, 
    *   se descarta esa rama, ya que no puede mejorar el resultado óptimo.
	*    
	*/
	
	private ArrayList<Maquina> maquinas;
	private ArrayList<Maquina> maquinaOptima;
	private int piezas;
	private int estadosGenerados = 0;
	
	public Backtracking(ArrayList<Maquina> maquinas, int piezas) {
		this.maquinas = maquinas;
		this.piezas = piezas;
		this.maquinaOptima = new ArrayList<Maquina>();
	}
	
	public void resolver() {
		backtracking(new ArrayList<>(), 0);
		System.out.println("Backtracking");
		System.out.println("Solucion obtenida: " + maquinaOptima);
		System.out.println("Cantidad de piezas producidas: " + this.sumarMaquina(maquinaOptima) + ", " + "Cantidad de puestas en funcionamiento: " + maquinaOptima.size());
		System.out.println("Estados generados: " + estadosGenerados);
	}
	
	public void backtracking(List<Maquina> actual, int total) {
		estadosGenerados++;
		if(total == piezas) {
			
			if(maquinaOptima.isEmpty() || actual.size() < maquinaOptima.size()) {
				maquinaOptima = new ArrayList<Maquina>(actual);
			}
		}
		
		// Poda por cantidad de máquinas:
		// Si la solución parcial actual ya usa la misma o más cantidad de máquinas que la mejor solución conocida,
		// no vale la pena continuar explorando este camino porque no puede mejorar el resultado.
		if(!maquinaOptima.isEmpty() && actual.size() >= maquinaOptima.size())
			return;
		
		if (total < piezas) {
		    for (Maquina maquina : maquinas) {
		        actual.add(maquina);
		        backtracking(actual, total + maquina.getPieza());
		        actual.remove(actual.size() - 1);
		    }
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