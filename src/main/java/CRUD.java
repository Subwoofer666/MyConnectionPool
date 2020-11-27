import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
    public static void main(String[] args) throws SQLException {

    }

    public static void createUser(String name, int age, String tour) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("insert users (name,age,tour) values ('" + name + "," + age + "'," + tour + ")");
        }
    }
    public static void createTour(String name, String country, String hotel) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("insert tours (name,country,hotel) values ('" + name + "," + country + "'," + hotel +")");
        }
    }

    public static void getAllUsers() throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()){
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getString(3) + " ");
                System.out.print(resultSet.getString(4));
                System.out.println();
            }
        }
    }
    public static void getAllTours() throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from tours");
            while (resultSet.next()){
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getString(3 ) + " ");
                System.out.print(resultSet.getString(4));
                System.out.println();
            }
        }
    }

    public static void getUser(int id) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users where id = " + id);
            while (resultSet.next()) {
                System.out.print(resultSet.getString(2) + " ");
                System.out.println(resultSet.getString(3) + " ");
                System.out.println(resultSet.getString(4));
            }
        }
    }
    public static void getTour(int id) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from tour where id = " + id);
            while (resultSet.next()) {
                System.out.print(resultSet.getString(2) + " ");
                System.out.println(resultSet.getString(3) + " ");
                System.out.println(resultSet.getString(4));
            }
        }
    }

    public static void updateUser(int id, String newName, int newAge, String newTour) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("replace users values (" + id + ", '" + newName + ", " + newAge + "', " + newTour + ")");
        }
    }
    public static void updateTour(int id, String newName, String newCountry, String newHotel) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("replace tour values (" + id + ", '" + newName + ", " + newCountry + "', " + newHotel + ")");
        }
    }

    public static void deleteUser(String name) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("delete from users where name = '" + name + "'");
        }
    }
    public static void deleteTour(String name) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("delete from tours where name = '" + name + "'");
        }
    }
}


