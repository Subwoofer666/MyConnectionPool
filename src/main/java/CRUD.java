import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
    public static void main(String[] args) throws SQLException {

    }

    public static void create(String name, int age) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("insert users (name,age) values ('" + name + "'," + age + ")");
        }
    }

    public static void getAll() throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()){
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getString(3));
                System.out.println();
            }
        }
    }

    public static void get(int id) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users where id = " + id);
            while (resultSet.next()) {
                System.out.print(resultSet.getString(2) + " ");
                System.out.println(resultSet.getString(3));
            }
        }
    }

    public static void update(int id, String newName, int newAge) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("replace users values (" + id + ", '" + newName + "', " + newAge + ")");
        }
    }

    public static void delete(String name) throws SQLException {
        try (Connection conn = ConnectionPool.getDataSource().getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("delete from users where name = '" + name + "'");
        }
    }

}
