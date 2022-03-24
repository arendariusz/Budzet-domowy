
import java.math.BigDecimal;
import java.sql.*;

public class TransactionDao {

    public void showTransactions(String transactionType) {
        Connection connection = connect();

        String sql = "SELECT * FROM transaction WHERE type = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transactionType);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                String date = resultSet.getString("date");

                System.out.println("ID transakcji: " + id + ". Typ: " + type + "- opis: " + description +
                        ". Kwota " + amount + "zł. Data: " + date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement;

        String sql = "INSERT INTO transaction(type, description, amount, date) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setBigDecimal(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd zapisu do bazy : " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void update(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement;
        String sql = "UPDATE transaction SET type = ? , description = ?, amount = ?, date = ? WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setBigDecimal(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.setInt(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd zapisu do bazy : " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void deleteById(int id) {
        Connection connection = connect();

        PreparedStatement preparedStatement;
        String sql = "DELETE FROM transaction WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nie udało się usunąć transakcji : " + e.getMessage());
        }
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/transactions?serverTimezone=UTC&characterEncoding=utf8";
        try {
            return DriverManager.getConnection(url, "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
