/* PROBLEMA --> https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true
 * In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).
 * Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:
 * Deque deque = new LinkedList<>();
 * or
 * Deque deque = new ArrayDeque<>();
 * You can find more details about Deque here.
 * In this problem, you are given N integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size M.
 * Note: Time limit is 3 second for this problem.
 * Input Format
 * The first line of input contains two integers N and M: representing the total number of integers and the size of the subarray, respectively. 
 * The next line contains N space separated integers.
 * 
 * n valores
 * m tamaño subconjunto
 * 
 * si ingreso n=6 m=3
 * 5 3 5 2 3 2
 * ¿cuantos valores unicos tiene?

 *   5 3 5 | 2
 *   3 5 2 | 3
 *   5 2 3 | 3
 *   2 3 2 | 2

 *   Salida esperada: 3 (maxima cantidad de items diferentes)

 *   n=6 m=2
 *   6 2
 *   5 3 5 2 3 2

 *   5 3 | 2 
 *   3 5 | 2 
 *   5 2 | 2 
 *   2 3 | 2 
 *   3 2 | 2 

 *   Salida esperada: 2
 *   Otro lote de prueba más
 *   7 4
 *   5 3 5 2 3 2 5
 *   -->3

*/
/* Esta solucion naive me fallaría por TLE
* 
*  public static void main(String[] args) {
*    int max = -1;
*    List<Integer> deque = new ArrayList<>();
*    // Input del usuario
*    Scanner in = new Scanner(System.in);
*    int n = in.nextInt();
*    int m = in.nextInt();
*    for (int i = 0; i < n; i++) {
*        deque.add(in.nextInt());
*    }
*    // Desplazo la ventana un lugar a la derecha
*    for (int i = 0; i <= n - m; i++) {
*        Set<Integer> aux = new HashSet<>();
*        for (int j = i; j < i + m; j++) {
*            aux.add(deque.get(j));
*        }
*        if (aux.size() > max) {
*            max = aux.size();
*        }
*    }
*    System.out.println(max);
*  }
* 
*/
// Uso la técnica de Sliding Windows, para reducir la complejidad de cuadratica a lineal
// Voy a recorrer una sola vez, desplazandome hacia la derecha, moviendo la ventana
// Sin recalcular todo, solamente saco el primer elemento e incorporo el que viene
// El tamaño de la ventana esta dado por m y la iteracion por i
// Aprovecho las estructuras de datos de Java. Set guarda valores sin repetición y Deque 
// es una cola que me va a dejar quitar tanto del ppio como del final
import java.util.*;

public class Dequeue {
    
    public static void main(String[] args) {
        
        int max = -1;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer> valores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            valores.add(in.nextInt());
        }

        Deque<Integer> ventana = new ArrayDeque<>();
        Set<Integer> unicos = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int aux=valores.get(i);
            unicos.add(aux);
            ventana.addLast(aux);

            if (ventana.size() > m) {
                int eliminado = ventana.removeFirst();

                if(!ventana.contains(eliminado))
                    unicos.remove(eliminado);
                
            } 

            if(ventana.size() == m){
                max = Math.max(max, unicos.size());
            }
        }

        System.out.println(max);
    }
}
