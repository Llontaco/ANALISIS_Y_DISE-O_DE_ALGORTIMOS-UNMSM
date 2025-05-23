package Ackermann;
import java.util.Stack;
import java.util.Scanner;
public class Ackermann {
    public static int ackermannIterativo(int m, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(m);

        while (!stack.isEmpty()) {
            m = stack.pop();
            if (m == 0) {
                n = n + 1;
            } else if (n == 0) {
                stack.push(m - 1);
                n = 1;
            } else {
                stack.push(m - 1);
                stack.push(m);
                n = n - 1;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de m: ");
        int m = scanner.nextInt();

        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();

        if (m < 0 || n < 0) {
            System.out.println("Los valores deben ser enteros no negativos.");
        } else {
            int resultado = ackermannIterativo(m, n);
            System.out.println("Ackermann(" + m + ", " + n + ") = " + resultado);
        }

        scanner.close();
    }
}
