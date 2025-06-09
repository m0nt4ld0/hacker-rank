import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
    
    public static void main(String[] args) {
        ArrayList<BigInteger> val = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n, val));
    }

    /* Implementación de Fibonacci con MEMOIZACION, practicando Programación Dinámica.
     * El array "val" es un array que almacena los valores de la secuencia de Fibonacci 
     * que ya hice anteriormente, para evitar cálculos innecesarios y mejorar la eficiencia.
     *   0  +   1  =  1
     * f[0] + f[1] = f[2]
     *   1  +   1  =  2
     * f[1] + f[2] = f[3]
     * Si ya calculé f[1] y f[2], busco ahorrarme de calcular f[3] de nuevo. Guardo en un array
     * todos esos resultados parciales, y los reutilizo. Entonces devuelvo el valor que ya guardé
     */
    public static BigInteger fibonacci(int lim, ArrayList<BigInteger> val) 
    {
        if(val.isEmpty())
        {
            val.add(BigInteger.ZERO);
            val.add(BigInteger.ONE);
        }
        for(int i = val.size(); i <= lim; i++) {
            val.add(val.get(i-1).add(val.get(i-2)));   
        }
        
        return val.get(lim);
    }

}