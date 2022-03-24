import java.math.BigDecimal;
import java.util.Scanner;

public class TransactionSave {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String type = TransactionUtility.getTypeAndValidate(scanner);

        System.out.println("Opis transakcji: ");
        String description = scanner.nextLine();

        System.out.println("Podaj kwotę transakcji");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Podaj datę transakcji (np. 2022-02-22)");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(type, description, amount, date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.save(transaction);

    }
}
