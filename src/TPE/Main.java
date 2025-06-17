package TPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Maquina> maquinas = new ArrayList<>();
        int piezasTotales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/TPE/config.txt"))) {
            String linea = br.readLine();
            if (linea != null) {
                piezasTotales = Integer.parseInt(linea.trim());
            }

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int piezas = Integer.parseInt(partes[1].trim());
                    maquinas.add(new Maquina(nombre, piezas));
                }
            }

        } 
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
