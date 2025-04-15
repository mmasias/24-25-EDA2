package SYArboles;

import java.util.Scanner;

class ShutingYard {
    public static void main(String[] args) {
        String input = intro();
        System.out.println("Operación en infijo: " + input);

        BinaryTree tree1 = new BinaryTree();
        tree1.organize(input);
        tree1.printPostorder(tree1.root);
    }

     @SuppressWarnings("resource")
    static String intro() {
        System.out.println("Escribe la operacion a transformar: ");
        return new Scanner(System.in).nextLine();
    }
    
}
