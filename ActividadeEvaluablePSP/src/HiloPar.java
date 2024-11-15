
public class HiloPar implements Runnable {

	@Override
	public void run() {
		// Metodo con logica del numero Par
		int numeroPar = 0;
		System.out.println("Numeros Pares: ");
		//El mismo bucle del numero Impar
		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
			numeroPar += i;
		}
		System.out.println("Suma de los numeros pares: " + numeroPar);
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}
