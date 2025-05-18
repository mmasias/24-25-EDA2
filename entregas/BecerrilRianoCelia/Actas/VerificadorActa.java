package Actas;
class VerificadorActas {
    public static boolean verificarActa(Acta acta) {
        return acta != null && acta.verificarIntegridad();
    }
}