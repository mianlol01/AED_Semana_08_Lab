package semana_08;

public class Arreglo {

	// Atributos privados
	private int[] n;
	private int indice;

	// Constructor
	public Arreglo() {
		n = new int[10];
		indice = 0;
	}

	// Operaciones p�blicas b�sicas
	public int tamanio() {
		return indice;
	}

	public int obtener(int i) {
		return n[i];
	}

	public void adicionarYreubicar(int numero) {
		if (indice == n.length)
			ampliarArreglo();
		if (numero % 2 == 0) {
			for (int i = indice; i > 0; i--) {
				n[i] = n[i - 1];
			}
			n[0] = numero;
		} else {
			n[indice] = numero;
		}
		indice++;
	}

	// Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = n;
		n = new int[indice + 10];
		for (int i = 0; i < indice; i++)
			n[i] = aux[i];
	}

	public void adicionar(int numero) {
		if (indice == n.length)
			ampliarArreglo();
		n[indice] = numero;
		indice++;
	}

}
