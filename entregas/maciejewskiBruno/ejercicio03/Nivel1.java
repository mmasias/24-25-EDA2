class Nivel1 {

	public static void main(String[] args) {
		sumaObjetivo(6);

		busquedaDePalabra("dia");

		numeroFaltante();

		montaña();

		puntoDeEquilibrio();
	}

	private static void sumaObjetivo(int objetivo) {
		System.out.println("\nSuma objetivo");
		int[] array = { 0, 1, 4, 2 };

		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] + array[j] == objetivo) {
					System.out.println("índices [" + i + ", " + j + "] (" + array[i] + " + "
							+ array[j] + " = " + objetivo + ")");
				}
			}

		}
	}

	private static void busquedaDePalabra(String palabra) {
		System.out.println("\nBusqueda de palabra");
		char[] letras = { 'a', 'c', 'd', 'i', 'm', 'r', 't', 'u' };

		System.out.print("[");
		for (int i = 0; i < palabra.length(); i++) {
			if (i != 0) {
				System.out.print(",");
			}
			for (int j = 0; j < letras.length; j++) {
				if (palabra.charAt(i) == letras[j]) {
					System.out.print(j);
					break;
				}
			}
		}
		System.out.println("]");
	}

	private static void numeroFaltante() {
		System.out.println("\nNumero Faltante");
		int[] array = { 1, 2, 4, 5, 6 };
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] != (array[i] - 1)) {
				System.out.println(array[i - 1] + 1);
			}
		}
	}

	private static void montaña() {
		System.out.println("\nArray montaña");
		int[] array = { 1, 3, 5, 4, 2 };
		if (calcularMontaña(array)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	private static boolean calcularMontaña(int[] array) {
		boolean creciente = true;
		for (int i = 1; i < array.length; i++) {
			if (creciente) {
				if (array[i - 1] > array[i]) {
					creciente = false;
				}
			} else {
				if (array[i - 1] < array[i]) {
					return false;
				}
			}

		}
		return true;
	}

	private static void puntoDeEquilibrio() {
		System.out.println("\nPunto de equilibrio");
		int[] array = { 1, 2, 3, 4, 6 };
		int sumaTotal = 0;

		for (int num : array) {
			sumaTotal += num;
		}

		int sumaIzquierda = 0;
		for (int i = 0; i < array.length; i++) {
			int sumaDerecha = sumaTotal - sumaIzquierda - array[i];

			if (sumaIzquierda == sumaDerecha) {
				System.out.println(i);
			}

			sumaIzquierda += array[i];
		}

	}
}
