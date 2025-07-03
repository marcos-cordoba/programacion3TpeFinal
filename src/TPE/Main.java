package TPE;

public class Main {

	public static void main(String[] args) {
		
		try {
			ConfigLoader loader = new ConfigLoader("src/TPE/config.txt");
			ConfigLoader.ConfigData data = loader.cargar();
			
			Backtracking pb = new Backtracking(data.maquinas, data.piezasTotales);
	        Greedy pg = new Greedy(data.maquinas, data.piezasTotales);
	        
	        pb.resolver();
	        pg.resolver();
			
		} catch (Exception e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}

}
