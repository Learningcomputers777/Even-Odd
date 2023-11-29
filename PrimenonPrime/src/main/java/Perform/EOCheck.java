package Perform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EOCheck
 */
@WebServlet("/EOCheck")
public class EOCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            int n = Integer.parseInt(request.getParameter("t1"));
            out.println("<center>");
            
            if (isPrime(n)) {
                out.println("<font color=blue>" + n + " is a prime number</font>");
            } else {
                out.println("<font color=green>" + n + " is not a prime number</font>");
            }

        } catch (Exception e) {
            out.println("Error:" + e.getMessage());
        } finally {
            out.println("<br><br>");
            out.println("To go to main page <a href=index.html> Click HERE</a>");
            out.print("</center>");
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
