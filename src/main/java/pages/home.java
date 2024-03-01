package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.Item;

public class home extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String username = request.getParameter("username");
      String itemsString = (String) request.getParameter("items");

      List<Item> items = new ArrayList<>();
      String[] itemTokens = itemsString.split(";");
      for (String token : itemTokens) {
         String[] itemInfo = token.split(":");
         Item item = new Item(itemInfo[0], itemInfo[1], Integer.parseInt(itemInfo[2]), Double.parseDouble(itemInfo[3]));
         items.add(item);
      }
      if (username == null || items == null) {
         response.sendRedirect("./");
      } else {
         out.println("<html><head><title>Home page</title></head><body>");
         out.println("<h1>Home page</h1><br>");
         out.println("<p>Welcome " + username + "</p>");
         out.println("<h2>Items:</h2>");
         out.println("<ul>");
         for (Item item : items) {
            out.println("<li>Name: " + item.getName() + ", Description: " + item.getDescription() + ", Stock: "
                  + item.getStock() + ", Price: " + item.getPrice() + "</li>");
         }
         out.println("</ul>");
         out.println("<a href=\"./\">Exit</a>");
         out.println("</body></html>");
      }
   }

}
