package pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<html><head><title>Login</title></head><body>");
      out.println("<h1>Login</h1><br>");
      out.println("<p>(Le nom et le mot de passe > 3 caractères !!!)</p>");
      out.println("<form action=\"loginServlet\" method=\"post\">");
      out.println("<label for=\"nom\">nom</label>");
      out.println("<input type=\"text\" name=\"nom\">");
      out.println("<label for=\"password\">password</label>");
      out.println("<input type=\"password\" name=\"password\">");
      out.println("<input type=\"submit\" value=\"Sidentifier\">");
      out.println("</form>");
      out.println("<a href=\"./register\">Register</a>");
      out.println("</body></html>");
   }
}
