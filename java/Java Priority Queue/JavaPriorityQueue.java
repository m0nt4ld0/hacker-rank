/* https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=true
 * Sample Input 0

12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
Sample Output 0

Dan
Ashley
Shafaet
Maria
 */
import java.util.*;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa)
    {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getCgpa() {
        return this.cgpa;
    }

    @Override
    public int compareTo(Student otro) {
        return Double.compare(otro.cgpa, this.cgpa)!=0 ? Double.compare(otro.cgpa, this.cgpa) 
            : (!this.name.equals(otro.name)) ? this.name.compareTo(otro.name) 
            : Integer.compare(otro.id, this.id);
    }
}

public class JavaPriorityQueue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer n = (Integer.parseInt(input.nextLine()));

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            String line = input.nextLine();
            String[] tokens = line.split(" ");

            if(tokens[0].equals("ENTER")) {
                pq.add(new Student(
                    Integer.parseInt(tokens[3]), 
                    tokens[1], 
                    Double.parseDouble(tokens[2])));
            } else if(tokens[0].equals("SERVED")) {
                pq.poll(); // Sale el de mas puntaje
            }
        }
        input.close();

        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            List<Student> remaining = new ArrayList<>();
            while (!pq.isEmpty()) {
                remaining.add(pq.poll());
            }
            for (Student s : remaining) {
                System.out.println(s.getName());
            }
        }
    }
}