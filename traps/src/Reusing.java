import java.util.stream.IntStream;

public class Reusing {

	public static void main(String[] args) {

		IntStream stream = IntStream.of(1, 2);

		stream.forEach(System.out::println);

		stream.forEach(System.out::println);

	}
}
