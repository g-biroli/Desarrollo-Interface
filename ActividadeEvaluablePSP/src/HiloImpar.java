
public class HiloImpar implements Runnable {
		//Implements la clase que permite usar hilo
	
	@Override
	public void run() {
		// metodo para imprimir numero Impar
		int numeroImpar = 0;
		
		System.out.println("Numeros Impares: ");
		//bucle para imprimir numeros pares y calcular la suma
		for (int i = 1; i <= 10; i +=2) {
			System.out.println(i);
			numeroImpar += i;
		}
		System.out.println("La suma de los números impares: " + numeroImpar);
	}

}
