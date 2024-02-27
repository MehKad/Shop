package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import config.DBConfig;

public class registerServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      String username = request.getParameter("nom");
      String password = request.getParameter("password");

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         try (Connection conn = DriverManager.getConnection(DBConfig.getInstance().getJdbcUrl(),
               DBConfig.getInstance().getDbUser(),
               DBConfig.getInstance().getDbPassword())) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
               statement.setString(1, username);
               statement.setString(2, password);
               statement.executeUpdate();
            }
         }
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }

      System.out.println("User registered successfully! Username: " + username + ", Password: " + password);
   }
}
