package src.calculadora;

import java.util.ArrayList;

public class Calculadora {
    private ArrayList<Double> numeros;
    private double resultado;

    
    public Calculadora(double valorInicial) {
        numeros = new ArrayList<>();
        if (valorInicial != 0) {
            ingresarNumero(valorInicial);
        }
    }

    
    public Calculadora(double[] valores) {
        numeros = new ArrayList<>();
        for (double valor : valores) {
            ingresarNumero(valor);
        }
    }

    
    public Calculadora() {
        this.numeros = new ArrayList<>();
    }

   
    public void ingresarNumero(double numero) {
        numeros.add(numero);
    }

   
    public void sumar() {
        if (numeros.size() >= 2) {
            resultado = numeros.get(numeros.size() - 1) + numeros.get(numeros.size() - 2);
            numeros.add(resultado);
            
            numeros.remove(numeros.size() - 3); 
            numeros.remove(numeros.size() - 3); 
        }
    }

    
    public void restar() {
        if (numeros.size() >= 2) {
            resultado = numeros.get(numeros.size() - 2) - numeros.get(numeros.size() - 1);
            numeros.add(resultado);
            numeros.remove(numeros.size() - 3);
            numeros.remove(numeros.size() - 3);
        }
    }

    
    public void multiplicar() {
        if (numeros.size() >= 2) {
            resultado = numeros.get(numeros.size() - 1) * numeros.get(numeros.size() - 2);
            numeros.add(resultado);
            numeros.remove(numeros.size() - 3);
            numeros.remove(numeros.size() - 3);
        }
    }

    
    public void dividir() {
        if (numeros.size() >= 2) {
            if (numeros.get(numeros.size() - 1) != 0) {
                resultado = numeros.get(numeros.size() - 2) / numeros.get(numeros.size() - 1);
                numeros.add(resultado);
                numeros.remove(numeros.size() - 3);
                numeros.remove(numeros.size() - 3);
            } else {
                System.out.println("Error: División por cero");
            }
        }
    }

    
    public void calcularSumatoria() {
        resultado = 0;
        for (double numero : numeros) {
            resultado += numero;
        }
        numeros.add(resultado);
    }

    
    public void calcularMedia() {
        if (!numeros.isEmpty()) {
            calcularSumatoria();
            resultado /= numeros.size();
            numeros.add(resultado);
        }
    }

    
    public void calcularPorcentaje() {
        if (numeros.size() >= 2) {
            resultado = (numeros.get(0) * numeros.get(1)) / 100;
            numeros.add(resultado);
        }
    }

    
    public void calcularFactorial() {
        int num = (int) numeros.get(0).doubleValue();
        if (num < 0) {
            System.out.println("Error: El factorial no está definido para números negativos");
            return;
        }
        resultado = 1;
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        numeros.add(resultado);
    }

    
    public void calcularMaximo() {
        if (!numeros.isEmpty()) {
            resultado = numeros.get(0);
            for (double numero : numeros) {
                if (numero > resultado) {
                    resultado = numero;
                }
            }
            numeros.add(resultado);
        }
    }

    
    public void calcularMinimo() {
        if (!numeros.isEmpty()) {
            resultado = numeros.get(0);
            for (double numero : numeros) {
                if (numero < resultado) {
                    resultado = numero;
                }
            }
            numeros.add(resultado);
        }
    }

    
    public void duplicarNumero() {
        if (!numeros.isEmpty()) {
            resultado = numeros.get(numeros.size() - 1) * 2;
            numeros.add(resultado);
        }
    }

    
    public void intercambiar() {
        if (numeros.size() >= 2) {
            double temp = numeros.get(numeros.size() - 1);
            numeros.set(numeros.size() - 1, numeros.get(numeros.size() - 2));
            numeros.set(numeros.size() - 2, temp);
        }
    }

    
    public void calcularPotencia() {
        if (numeros.size() >= 2) {
            resultado = Math.pow(numeros.get(numeros.size() - 2), numeros.get(numeros.size() - 1));
            numeros.add(resultado);
            numeros.remove(numeros.size() - 3);
            numeros.remove(numeros.size() - 3);
        }
    }

    
    public void calcularPotencia(double exponente) {
        if (!numeros.isEmpty()) {
            resultado = Math.pow(numeros.get(numeros.size() - 1), exponente);
            numeros.add(resultado);
        }
    }

    
    public void ingresarPI() {
        ingresarNumero(Math.PI);
    }

    
    public String mostrarTodo() {
        return "Números: " + numeros.toString() + ", Resultado: " + resultado;
    }
}