package SYArboles;

class BinaryTree {
    
    Node root;

    BinaryTree() {
        root = null;
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    public void organize(String input) {
        String[] tokens = input.split("");

        for (int index = 0; index < tokens.length; index++) {
            String token = tokens[index];
            

        }
    }
}