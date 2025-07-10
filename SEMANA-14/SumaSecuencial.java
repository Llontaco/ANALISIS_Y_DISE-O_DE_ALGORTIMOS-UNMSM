public class SumaSecuencial {
    public static long sumar(int[] numeros) {
        long suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }
}
