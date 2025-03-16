import java.util.Objects;

public class Clase {
    public String [] shuntinYard(String[] expresionInFija) {

        //Array o string o lista

        String[] pila = new String[10];
        int sizePila = 0;
        String[] salida = new String[10];
        int sizeSalida = 0;
        Boolean b = false;

        for (int i = 0; i < expresionInFija.length; i++) {
            char o = expresionInFija[i].charAt(0);
            if (isNumeric(expresionInFija[i])) {
                salida[sizeSalida] = expresionInFija[i];
                sizeSalida++;
            }
            if (isOperator(o)) {
                if(!isEmpty(pila)) {
                    char p = pila[sizePila-1].charAt(0);
                    while (!isEmpty(pila) && isOperator(p)&& priority(pila[sizePila-1],expresionInFija[i])) { //falta preferencias de noseque
                        salida[sizeSalida] = pila[sizePila-1];
                        pila[sizePila-1]=null;
                        sizePila--;
                        sizeSalida++;
                    }
                }
                pila[sizePila] = expresionInFija[i];
                sizePila++;
            }
            if (o == '(') {
                pila[sizePila] = expresionInFija[i];
                sizePila++;

            }
            if (o == ')') {
                while (!pila[sizePila-1].equals("(")) {
                    salida[sizeSalida] = pila[sizePila-1];
                    pila[sizePila-1]=null;
                    sizePila--;
                    sizeSalida++;
                }
                pila[sizePila-1]=null;
                sizePila--;
            }
        }

        while (!isEmpty(pila)){
            salida[sizeSalida] = pila[sizePila-1];
            pila[sizePila-1]=null;
            sizePila--;
            sizeSalida++;
        }



        return salida;
    }


    public boolean isNumeric(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isEmpty(String[] str){
        if(str[0]==null ||str[0].isEmpty()){
            return true;
        }
        return false;

    }

    public boolean isOperator(char o) {

        if (o == '%' || o=='/' || o=='*' || o=='+' || o=='-') {
            return true;
        } else {
            return false;
        }
    }

    public boolean priority(String c1,String c2 ){

        if(Objects.equals(c1, "*") || Objects.equals(c1, "/") && isOperator(c2.charAt(0))){
            return true;
        }

        return false;


    }




}
