
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        for(int i = 1; i <= 100; i++)
        {
            String result = (esDivisibleTres(String.valueOf(i)) ? "Fizz" : "") + (esDivisibleCinco(String.valueOf(i)) ? "Buzz" : "");
            System.out.println(!result.isEmpty() ? result : i);
        }
    }

    /* Elijo hacerlo asi porque si uso modulo ya tendria O(1) y como solo necesito
     * dividir por 3 y 5, hago un metodo dedicado a cada uno.
     */
    public static boolean esDivisibleCinco(String valor)
    {
        return ((valor.charAt(valor.length()-1) == '0') || (valor.charAt(valor.length()-1) == '5') ? true : false);
    }

    /* Si la suma de los digitos de un numero es divisible por 3, el numero tambien. La consigna dice que ingresan valores de 0
     * a 100, asi que descompongo en unidad, decena y centena, evitando bucles todo lo posible.
     */
    public static boolean esDivisibleTres(String valor)
    {
        int acum=0;
        if(valor.length() >= 1) 
            acum += (int)(valor.charAt(0) - '0');
        if(valor.length() >= 2) 
            acum += (int)(valor.charAt(1) - '0');
        if(valor.length() == 3) 
            acum += (int)(valor.charAt(2) - '0');
        return (acum % 3 == 0);
    }
}