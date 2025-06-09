/*
Esperado: 3
-----------
5
1 2 3 4 5
4

Esperado: -1 (No está)
----------------------
5
1 2 3 4 5
9

Esperado: 0
------------
5
1 2 3 4 5
1

Esperado: 0
-----------
1
1
1

Esperado: -1
------------
1
1
15

Esperado: 4 (último)
--------------------
5
1 2 3 4 5
5

Link al ejercicio: https://www.hackerrank.com/contests/lpdwarka2016/challenges/binary-search-basic/
Dada una cantidad de elementos, un array ORDENADO de elementos y un valor a buscar, devolver su índice (0-based) 
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] line1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(line1[0]);

            String[] line2 = br.readLine().trim().split(" ");
            List<Integer> valores = new ArrayList<Integer>();

            for (int i = 0; i < line2.length; i++) {
                valores.add(Integer.parseInt(line2[i]));
            }
            line1 = br.readLine().trim().split(" ");
            br.close();
            int valorBuscado = Integer.parseInt(line1[0]);
            System.out.println(busquedaBinariaR(valorBuscado, 0, valores.size()-1, valores));
            
        } catch(IOException ex) {
            System.err.println();
        }

    }

    /*
     * Implementación recursiva
     */
    private static Integer busquedaBinariaR(int valorBuscado, int x, int y, List<Integer> valores) 
    {
        if (x > y) return -1; // Si ya me pasé, es porque no está

        int mitad = (x+y)/2;

        if(valores.get(mitad) == valorBuscado)
            return mitad;
        if(valorBuscado > valores.get(mitad)){
            return busquedaBinariaR(valorBuscado, mitad + 1, y, valores);
        }
        if(valorBuscado < valores.get(mitad)) {
            return busquedaBinariaR(valorBuscado, x, mitad - 1, valores);
        }
        return -1;
    }

}