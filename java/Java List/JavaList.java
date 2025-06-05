import java.util.ArrayList;
import java.util.Scanner;

public class JavaList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> valores = new ArrayList<>();
        
        Integer n = (Integer.parseInt(input.nextLine()));
        String[] numeros = input.nextLine().split(" ");
        for(int i=0; i<n; i++) {
            valores.add(Integer.parseInt(numeros[i]));
        }

        Integer q = (Integer.parseInt(input.nextLine()));
        for(int i=0; i<q; i++) {
            String operacion = input.nextLine();
            if(operacion.equals("Insert")) {
                String[] aux = input.nextLine().split(" ");
                valores.add(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
            }
            else if(operacion.equals("Delete")) {
                valores.remove(Integer.parseInt(input.nextLine()));
            }
        }

        input.close();

        System.out.println(
            valores.stream()
                .map(String::valueOf)
                .reduce((a, b) -> a + " " + b)
                .orElse("")
        );
       
    }
}