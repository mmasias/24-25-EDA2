public class Ascensor {

	public static void main(String[] args) {
		int ascensor = 0;
		ascensor = moverAscensor(ascensor, 5);
		ascensor = moverAscensor(ascensor, 3);
		ascensor = moverAscensor(ascensor, 10);
		ascensor = moverAscensor(ascensor, 0);
	}

	public static int moverAscensor(int ascensor, int objetivo) {
		System.out.println("Planta actual: " + ascensor);
		if (ascensor == objetivo) {
			System.out.println("Se ha llegado a su destino");
			return ascensor;
		}
		if (ascensor > objetivo) {
			return moverAscensor(--ascensor, objetivo);
		} else {
			return moverAscensor(++ascensor, objetivo);
		}

	}
}
