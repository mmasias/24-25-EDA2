class PatronesColor {
    char gris = '@';
    char cyanBajaInt = ':';
    char magentaBajaInt = ';';
    char cyanAltaInt = '=';
    char magentaAltaInt = '&';
    char blancoMediaInt = '$';
    
    void mostrarPatrones() {
        System.out.println("Patrones de color disponibles: " + gris + " " + cyanBajaInt + " " + magentaBajaInt + " " + cyanAltaInt + " " + magentaAltaInt + " " + blancoMediaInt);
    }
}