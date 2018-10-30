import java.util.*;

import static java.lang.System.out;

public class HellOldWorld {

    private static List<String> compareToStreamMethod(List<String> arrayReceived) {

        List<String> stringNumberDumbList = new ArrayList<>();

        for (String stringNumber : arrayReceived) {

            out.println("Elemento Original: " + stringNumber);

            if (stringNumber.length() > 3 && !stringNumberDumbList.contains(stringNumber.toUpperCase())) {
                stringNumberDumbList.add(stringNumber.toUpperCase());
            }
        }

        List<String> stringNumberDumbListResponse = stringNumberDumbList.subList(1,4);

        Collections.sort(stringNumberDumbListResponse, new Comparator<String>(){
            public int compare(String t1, String t2){
                return Integer.valueOf(t2.length()).compareTo(t1.length());
            }
        });

        return stringNumberDumbListResponse;

    }

    public static void main(String[] args) {

        List<String> stringNumberDumbListResponse =
                compareToStreamMethod(Arrays.asList("um", "dois", "três", "três", "quatro", "cinco", "seis", "sete"));

        out.println("\nResultado da operação normal: "
                .concat(String.join(", ", stringNumberDumbListResponse)));

    }
}
