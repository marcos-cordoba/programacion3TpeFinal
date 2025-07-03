package TPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ConfigLoader {
	private String ruta;
	
	public ConfigLoader(String ruta) {
		this.ruta = ruta;
	}
	
	public ConfigData cargar() throws Exception{
		ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
		int piezasTotales = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
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

        }
		
		return new ConfigData(maquinas, piezasTotales);
	}
	
	public static class ConfigData {
		public ArrayList<Maquina> maquinas;
		public int piezasTotales;
		
		public ConfigData(ArrayList<Maquina> maquinas, int piezasTotales) {
			this.maquinas = maquinas;
			this.piezasTotales = piezasTotales;
		}
	}
}
