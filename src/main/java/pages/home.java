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
         Item item = new Item(itemInfo[0], itemInfo[1], Double.parseDouble(itemInfo[2]));
         items.add(item);
      }
      if (username == null || items == null) {
         response.sendRedirect("./");
      } else {
         out.println("<html><head><title>Home page</title></head><body>");
         out.println("<h1>Home page</h1><br>");
         out.println("<p>Welcome " + username + "</p>");
         out.println("<h2>Items:</h2>");
         out.println("<table border='1'>");
         out.println("<tr><th>Name</th><th>Description</th><th>Price</th><th>Action</th></tr>");
         for (Item item : items) {
            out.println("<tr>");
            out.println("<td>" + item.getName() + "</td>");
            out.println("<td>" + item.getDescription() + "</td>");
            out.println("<td>" + item.getPrice() + "</td>");
            out.println("<td><form action='addtocart' method='post'>");
            out.println("<input type='hidden' name='item_name' value='" + item.getName() + "'/>");
            out.println("<input type='hidden' name='item_price' value='" + item.getPrice() + "'/>");
            out.println("<input type='submit' value='Add to Cart'/>");
            out.println("</form></td>");
            out.println("</tr>");
         }
         out.println("</table>");
         out.println("<a href=\"./\">Exit</a>");
         out.println("</body></html>");
      }
   }

}
