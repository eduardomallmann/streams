import java.util.stream.IntStream;

public class UnOrdered {

	public static void main(String[] args) {

		IntStream.iterate(0, i -> i + 1)
//				.skip(5)
				.limit(10) // LIMIT
				.skip(5)   // OFFSET
				.forEach(System.out::println);

	}

}
