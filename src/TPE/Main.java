package TPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Maquina> maquinas = new ArrayList<>();
        int piezasTotales = 0;

        //en el try busca un archivo en la ruta que se especifica
        try (BufferedReader br = new BufferedReader(new FileReader("src/TPE/config.txt"))) {
            String linea = br.readLine();
            if (linea != null) {
                piezasTotales = Integer.parseInt(linea.trim()); // toma de la primera linea del archivo txt, que es la cantidad de piezas
            }

            // Lee cada linea del archivo hasta el final
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim(); // obtiene el nombre de la maquina
                    int piezas = Integer.parseInt(partes[1].trim());  // obtiene el numero de la maquina que esta en string y convierte en entero
                    maquinas.add(new Maquina(nombre, piezas));
                }
            }

        } // en el caso de que no encuentre un archivo en la ruta que se le asigno, va a dar un mensaje de error
        catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }
		
        Backtracking pb = new Backtracking(maquinas, piezasTotales);
        Greedy pg = new Greedy(maquinas, piezasTotales);
    
        pb.resolver();
        pg.resolver();
	}

}
