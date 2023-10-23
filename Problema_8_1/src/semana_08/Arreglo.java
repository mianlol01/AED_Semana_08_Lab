package semana_08;

import java.util.Random;

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

	public void adicionar(int numero) {
		if (indice == n.length)
			ampliarArreglo();
		n[indice] = numero;
		indice++;
	}

	// Operaciones p�blicas complementarias
	public void eliminarNumerosPares() {
		for (int i = 0; i < indice; i++) {
			if (n[i] % 2 == 0) {
				eliminar(i);
				i--;
			}
		}
	}

	public void eliminarNumerosImpares() {
		for (int i = 0; i < indice; i++) {
			if (n[i] % 2 != 0) {
				eliminar(i);
				i--;
			}
		}
	}

	public void eliminarNumerosRepetidos() {
		for (int i = 0; i < indice; i++) {
			for (int j = i + 1; j < indice; j++) {
				if (n[i] == n[j]) {
					eliminar(j);
					j--;
				}
			}
		}
	}

	public int posPrimerNumeroPar() {
		for (int i = 0; i < indice; i++) {
			if (n[i] % 2 == 0 && n[i] != 0) {
				return i;
			}
		}
		return -1;
	}

	public void primerNumeroParAlFinal() {
		if (posPrimerNumeroPar() != -1) {
			intercambiar(posPrimerNumeroPar(), indice - 1);
		}
	}

	public void barajarNumeros() {
		Random random = new Random();
		for (int i = indice - 1; i > 0; i--) {
			int j = random.nextInt(indice);
			// Intercambia array[i] con array[j]
			int temp = n[i];
			n[i] = n[j];
			n[j] = temp;
		}
	}

	// Operaciones privadas
	private void ampliarArreglo() {
		int[] aux = n;
		n = new int[indice + 10];
		for (int i = 0; i < indice; i++)
			n[i] = aux[i];
	}

	private void eliminar(int pos) {
		for (int i = pos; i < indice - 1; i++) {
			n[i] = n[i + 1];
		}
		indice--;
	}

	private void intercambiar(int pos01, int pos02) {
		int aux;
		aux = n[pos01];
		n[pos01] = n[pos02];
		n[pos02] = aux;
	}
}
