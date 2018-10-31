import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManipulandoArquivo {

	private static final String FILE_PATH = "C:\\Users\\emallmann\\Documents\\Treinamento\\Presentation\\Stream\\code\\manipulando-arquivo\\MOCK_DATA.csv";

	public static void main(String[] args) {

		// recuperar o arquivo para dentro da Stream
		try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {

			// transformar o arquivo em CSV
			List<Order> orders = stream.skip(1).map(Order::wrapCSV).filter(order -> order.getPais().equals("Brazil"))
					.collect(Collectors.toList());

			// apresentar a order
			orders.forEach(order -> System.out.println(order.toJson()));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
