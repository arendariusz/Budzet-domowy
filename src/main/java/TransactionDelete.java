import java.util.Scanner;

public class TransactionDelete {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz usunąć");
        int id = scanner.nextInt();

        TransactionDao bookDao = new TransactionDao();
        bookDao.deleteById(id);
        System.out.println("Usunięto!");
    }
}
