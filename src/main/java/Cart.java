import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart")
public class Cart extends HttpServlet {

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        final RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("OHLALALA PAS DE JSP");
        }
    }
}
