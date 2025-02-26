package entregas.celayaIker;

public class MedianaOptimizado {
    public static void insertarOrdenado(int[] nums, int n, int nuevo) {
        int pos = encontrarPosicion(nums, n, nuevo);
        
        for (int i = n; i > pos; i--) {
            nums[i] = nums[i - 1];
        }
        nums[pos] = nuevo;
    }

    public static int encontrarPosicion(int[] nums, int n, int nuevo) {
        int izquierda = 0, derecha = n - 1;
        while (izquierda <= derecha) {
            int mid = izquierda + (derecha - izquierda) / 2;
            if (nums[mid] == nuevo) {
                return mid; 
            } else if (nums[mid] < nuevo) {
                izquierda = mid + 1;
            } else {
                derecha = mid - 1;
            }
        }
        return izquierda; 
    }

    public static double calcularMediana(int[] nums, int n) {
        if (n % 2 == 1) {
            return nums[n / 2]; 
        } else {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0; 
        }
    }

    public static void main(String[] args) {
        int[] flujo = {1, 3, 2, 4, 5};
        int[] nums = new int[flujo.length]; 
        int n = 0;

        System.out.print("Medianas en stream: ");
        for (int num : flujo) {
            insertarOrdenado(nums, n, num); 
            n++;
            System.out.print(calcularMediana(nums, n) + " ");
        }
    }
}
