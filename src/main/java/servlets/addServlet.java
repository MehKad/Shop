package servlets;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import models.Cart;

public class addServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      String itemName = request.getParameter("item_name");
      double itemPrice = Double.parseDouble(request.getParameter("item_price"));

      HttpSession session = request.getSession(true);
      List<Cart> cartList = (List<Cart>) session.getAttribute("cart");

      if (cartList == null) {
         cartList = new ArrayList<>();
         session.setAttribute("cart", cartList);
      }

      Cart cart = new Cart(itemName, itemPrice);
      cartList.add(cart);

      response.sendRedirect("./cart");
   }
}