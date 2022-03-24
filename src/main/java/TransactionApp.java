import java.util.Scanner;

public class TransactionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionDao transactionDao = new TransactionDao();

        while (true) {

            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Dodawanie");
            System.out.println("2. Aktualizacja");
            System.out.println("3. Usuwanie");
            System.out.println("4. Wyświetl wszystkie przychody");
            System.out.println("5. Wyświetl wszystkie wydatki");
            System.out.println("0. Zakończ");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    TransactionSave.main(new String[0]);
                    break;
                case "2":
                    TransactionUpdate.main(new String[0]);
                    break;
                case "3":
                    TransactionDelete.main(new String[0]);
                    break;
                case "4":
                    String transactionType = "PRZYCHÓD";
                    transactionDao.showTransactions(transactionType);
                    break;
                case "5":
                    transactionType = "WYDATEK";
                    transactionDao.showTransactions(transactionType);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Błędny wybór!");
            }
        }
    }
}
