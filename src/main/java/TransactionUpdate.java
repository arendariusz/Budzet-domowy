import java.math.BigDecimal;
import java.util.Scanner;

public class TransactionUpdate {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ID transakcji którą chcesz zaktualizować");
        int id = scanner.nextInt();
        scanner.nextLine();

        String type = TransactionUtility.getTypeAndValidate(scanner);

        System.out.println("Opis transakcji: ");
        String description = scanner.nextLine();

        System.out.println("Podaj kwotę transakcji");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Podaj datę transakcji (np. 2022-02-22");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(id, type, description, amount, date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.update(transaction);

    }
}
