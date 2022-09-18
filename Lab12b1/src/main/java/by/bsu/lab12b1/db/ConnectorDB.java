package by.bsu.lab12b1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectorDB {

    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        try {
            Class.forName(resource.getString("db.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        properties.put("user", resource.getString("db.user"));
        properties.put("password", resource.getString("db.password"));
        properties.put("allowPublicKeyRetrieval", resource.getString("db.allowPublicKeyRetrieval"));
        properties.put("useSSL", resource.getString("db.useSSL"));
        properties.put("useUnicode", resource.getString("db.useUnicode"));
        properties.put("characterEncoding", resource.getString("db.encoding"));
        properties.put("autoReconnect", resource.getString("db.autoReconnect"));
        String url = resource.getString("db.url");
        return DriverManager.getConnection(url, properties);
    }
}
