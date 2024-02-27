package config;

public class DBConfig {
   private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shop";
   private static final String DB_USER = "root";
   private static final String DB_PASSWORD = "";

   private static DBConfig instance;

   private DBConfig() {
   }

   public static synchronized DBConfig getInstance() {
      if (instance == null) {
         instance = new DBConfig();
      }
      return instance;
   }

   public String getJdbcUrl() {
      return JDBC_URL;
   }

   public String getDbUser() {
      return DB_USER;
   }

   public String getDbPassword() {
      return DB_PASSWORD;
   }
}
