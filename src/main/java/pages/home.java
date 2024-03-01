package pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class home extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String username = request.getParameter("username");

      if (username == null) {
         response.sendRedirect("./");
      } else {
         out.println("<html><head><title>Home page</title></head><body>");
         out.println("<h1>Home page</h1><br>");
         out.println("<p>Welcome " + username + "</p>");
         out.println("<a href=\"./\">Exit</a>");
         out.println("</body></html>");
      }
   }
}
