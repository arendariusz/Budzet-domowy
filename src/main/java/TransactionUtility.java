import java.util.Scanner;

public class TransactionUtility {

    Scanner scanner = new Scanner(System.in);

    public static String getTypeAndValidate(Scanner scanner) {
        final String income = "PRZYCHÓD";
        final String outcome = "WYDATEK";
        String type;
        do {
            System.out.println("Podaj typ transakcji (Przychód/Wydatek)");
            type = scanner.nextLine().toUpperCase();
        } while (! (type.equals(income) || type.equals(outcome)));
        return type;
    }
}
