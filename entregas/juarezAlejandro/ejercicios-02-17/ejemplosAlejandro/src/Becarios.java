/*class Becario extends Esclavo {
    @Override
    public void trabajar() {
        System.out.println("Haciendo trabajo gratis con ilusión de ser feliz");
    }
}*/

/* class Becario extends Esclavo {
    @Override
    public void trabajar() {
        System.out.println("Haciendo trabajo gratis con ilusión de ser feliz");
    }

    public void pedirContrato() {
        System.out.println("Por favor, ¿me pueden pagar?");
    }
} */

/* class Becario extends Esclavo {
    @Override
    public void trabajar() {
        System.out.println("Haciendo trabajo gratis con ilusión de ser feliz");
    }
} */

/* class Becario extends Esclavo {
    @Override
    public void quejarse() {
        System.out.println("¡Necesito un sueldo!");
    }
} */

class Becario extends Esclavo implements MalPagado {
    @Override
    public String pedirAumento() {
        return "Jefe, ¿me puede pagar algo?";
    }
}