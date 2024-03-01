package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import config.DBConfig;
import models.Item;

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
            String userSql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement userStatement = conn.prepareStatement(userSql)) {
               userStatement.setString(1, username);
               userStatement.setString(2, password);
               try (ResultSet userResultSet = userStatement.executeQuery()) {
                  if (userResultSet.next()) {
                     System.out.println("User logged in successfully");

                     HttpSession session = request.getSession();
                     session.setAttribute("username", username);

                     List<Item> items = new ArrayList<>();
                     String itemSql = "SELECT * FROM items";
                     try (PreparedStatement itemStatement = conn.prepareStatement(itemSql)) {
                        try (ResultSet itemResultSet = itemStatement.executeQuery()) {
                           while (itemResultSet.next()) {
                              Item item = new Item();
                              item.setName(itemResultSet.getString("name"));
                              item.setDescription(itemResultSet.getString("description"));
                              item.setPrice(itemResultSet.getDouble("price"));
                              items.add(item);
                           }
                        }
                     }

                     session.setAttribute("items", items);

                     response.sendRedirect("./home");
                  } else {
                     System.out.println("Invalid username or password");
                     response.sendRedirect("./");
                  }
               }
            }
         }
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }
}
