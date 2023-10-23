package semana_08;

import java.util.Arrays;

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

	public void adicionarDistintoYordenar(int numero) {
		if (indice == n.length) {
			ampliarArreglo();
		}
		if (!existeNumero(numero)) {
			n[indice] = numero;
			indice++;
			Arrays.sort(n, 0, indice);
		}
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

	private boolean existeNumero(int numero) {
		for (int i = 0; i < indice; i++) {
			if (n[i] == numero) {
				return true;
			}
		}
		return false;
	}

}