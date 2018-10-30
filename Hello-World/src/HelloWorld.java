import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

public class HelloWorld {

    public static void main(String[] args) {

        Stream<String> stringNumbers = Stream.of("um", "dois", "três", "três", "quatro", "cinco", "seis", "sete")
                .parallel()
                .peek(e-> out.println("Elemento Original: " + e))
                .filter(e -> e.length() > 3)
                .distinct()
                .map(String::toUpperCase)
                .skip(1L)
                .limit(3L)
                .sorted(Comparator.comparing(String::length).reversed());

        out.println("\nResultado da operação: "
                .concat(stringNumbers.collect(Collectors.joining(", "))));
    }
}
