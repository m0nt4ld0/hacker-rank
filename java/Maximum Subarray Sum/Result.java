import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

    /*
     * Complete the 'maximumSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY a
     *  2. LONG_INTEGER m
     */
    // https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
    // En este problema la ventana es DINAMICA, no es constantemente de N elementos
    // Un ejemplo donde la ventana es de una cantidad de elementos fija es:
    // https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true
    // En java dequeue ya nos estan pasando como argumento el tamaño de la ventana
    // Acá, en cambio, el tamaño de la ventana va a ir variando
    public static long maximumSum(List<Long> valores, long m)
    {
        long max = 5;
        int tamVentana = 5;
        Map<Integer, Map<Integer, Long>> prefixSum = new HashMap<>();
        for(int i=0 ; i<valores.size(); i++) {
            System.out.println("c:" + i);
            prefixSum.put(i, calculaPrefixSum(valores, i, tamVentana));
        }
        return max;
    }

    public static Map<Integer, Long> calculaPrefixSum(List<Long> valores, int posIni, int tam) 
    {
        Map<Integer, Long> prefixSum = new HashMap<>();
        prefixSum.put(posIni,valores.get(posIni));
        for(int i=posIni + 1 ; i < valores.size() - posIni; i++) {
            prefixSum.put(i,prefixSum.get(i-1) + valores.get(i));
            //System.out.println("prefixSum.get(i) " + prefixSum.get(i) + " i:" + i);
        }
        return prefixSum;
    }

}