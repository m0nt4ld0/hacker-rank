import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> valores = new ArrayList<>();
        // Lee primera linea (n y m)
        long n = Long.parseLong(br.readLine().trim());
        // Lee segunda linea (lista de valores)
        valores = Stream.of(br.readLine().trim().split(" "))
            .map(Long::parseLong)
            .collect(Collectors.toList());
        Result.maximumSum(valores, n);
        br.close();
    }
}
