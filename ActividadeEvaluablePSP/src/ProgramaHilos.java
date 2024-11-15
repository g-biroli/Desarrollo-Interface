
public class ProgramaHilos {

	public static void main(String[] args) {
		// Gestionar el processo - creando las variables para iniciar abajo
		
		Thread par1 = new Thread(new HiloPar());
		Thread par2 = new Thread(new HiloPar());
		Thread impar1 = new Thread(new HiloImpar());
		Thread impar2 = new Thread(new HiloImpar());
		
		//Iniciando los hilos
		par1.start();
		par2.start();
		impar1.start();
		impar2.start();
		
	}

}
