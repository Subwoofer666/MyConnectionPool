import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class ConnectionPool {

    private static HikariDataSource hikariDataSource;

    static {
        try {
            hikariDataSource = new HikariDataSource();
            hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?allowPublicKeyRetrieval=true&useSSL=false&verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            hikariDataSource.setUsername("root");
            hikariDataSource.setPassword("123123");
            hikariDataSource.setMinimumIdle(5);  //Min conn
            hikariDataSource.setMaximumPoolSize(10); // Max Conn
            hikariDataSource.setLoginTimeout(10); //Waiting time in seconds
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return hikariDataSource;
    }
}