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

public class check extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      HttpSession session = request.getSession(false);

      if (session != null) {
         String username = (String) session.getAttribute("username");

         String cartSessionAttributeName = "cart_" + username;

         @SuppressWarnings("unchecked")
         List<Cart> carts = (List<Cart>) session.getAttribute(cartSessionAttributeName);

         double totalPrice = 0.0;
         out.println("<html><head><title>Cart Summary</title></head><body>");
         out.println("<h1>Cart Summary for: " + username + "</h1><br>");
         if (carts != null && !carts.isEmpty()) {
            out.println("<table border='1'>");
            out.println("<tr><th>Item</th><th>Price</th></tr>");
            for (Cart item : carts) {
               out.println("<tr>");
               out.println("<td>" + item.getName() + "</td>");
               out.println("<td>" + item.getPrice() + "</td>");
               out.println("</tr>");
               totalPrice += item.getPrice();
            }
            out.println("</table>");
            out.println("<h5>Total Price: " + totalPrice + "$</h5>");
         } else {
            out.println("<h3>Your cart is empty.</h3>");
         }
         out.println("</body></html>");
      } else {
         response.sendRedirect("./");
      }

   }
}
