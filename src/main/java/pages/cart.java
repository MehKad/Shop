package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import models.Cart;

public class cart extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      HttpSession session = request.getSession(false);
      String username = (String) session.getAttribute("username");

      String cartSessionAttributeName = "cart_" + username;

      List<Cart> carts = (List<Cart>) session.getAttribute(cartSessionAttributeName);

      out.println("<html><head><title>Cart page</title></head><body>");
      out.println("<h1>Cart page for " + username + "</h1><br>");
      out.println("<h2>Your cart:</h2>");
      out.println("<table border='1'>");
      out.println("<tr><th>Name</th><th>Price</th></tr>");
      if (carts != null) {
         for (Cart item : carts) {
            out.println("<tr>");
            out.println("<td>" + item.getName() + "</td>");
            out.println("<td>" + item.getPrice() + "</td>");
            out.println("</tr>");
         }
      } else {
         out.println("<tr><td colspan='2'>Your cart is empty</td></tr>");
      }
      out.println("</table>");
      out.println("<a href=\"./home\">Continue shopping</a>");
      out.println("</body></html>");
   }
}
