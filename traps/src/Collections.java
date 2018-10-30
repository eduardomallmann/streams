import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collections {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

		List<Integer> badResult1 = new ArrayList<>();

		list.parallelStream().forEach(i -> badResult1.add(i));

		System.out.println(badResult1);

//		List<Integer> badResult2 = new ArrayList<>();
//
//		Stream<Integer> stream = list.parallelStream();
//
//		stream.peek(val -> {
//			synchronized (badResult2) {
//				if (badResult2.size() < 12) {
//					badResult2.add(val);
//				}
//			}
//		}).forEach( e -> {});
//
//		System.out.println(badResult2);

//		List<Integer> goodResult = list.stream().limit(11L).collect(Collectors.toList());
//
//		System.out.println(goodResult);

	}

}
