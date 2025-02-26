package entregas.romeroAngel.reto002.Nivel1;

public class WordSearch {
    public static int[] searchIndexes(char[] letterArray, char[] word) {
        int[] indexes = new int[word.length];
        for (int i = 0; i < word.length; i++) {
            indexes[i] = -1; 
            for (int j = 0; j < letterArray.length; j++) {
                if (letterArray[j] == word[i]) {
                    indexes[i] = j;
                    break; 
                }
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        char[] letterArray = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        char[] word = {'d', 'i', 'a'};
        
        int[] indexes = searchIndexes(letterArray, word);
        
        System.out.print("Índices encontrados: [");
        for (int i = 0; i < indexes.length; i++) {
            System.out.print(indexes[i]);
            if (i < indexes.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}