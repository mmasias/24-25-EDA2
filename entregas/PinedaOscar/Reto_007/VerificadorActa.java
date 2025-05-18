package entregas.PinedaOscar.Reto_007;

class VerificadorActas {
    public static boolean verificarActa(Acta acta) {
        return acta != null && acta.verificarIntegridad();
    }
}
