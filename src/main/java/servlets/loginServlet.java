package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import config.DBConfig;

public class loginServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      String username = request.getParameter("nom");
      String password = request.getParameter("password");

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         try (Connection conn = DriverManager.getConnection(DBConfig.getInstance().getJdbcUrl(),
               DBConfig.getInstance().getDbUser(),
               DBConfig.getInstance().getDbPassword())) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
               statement.setString(1, username);
               statement.setString(2, password);
               try (ResultSet resultSet = statement.executeQuery()) {
                  if (resultSet.next()) {
                     System.out.println("User logged in successfully");
                     response.sendRedirect("./home");
                  } else {
                     System.out.println("Invalid username or password");
                  }
               }
            }
         }
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }
}
