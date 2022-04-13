package servlets;
import domain.Customer;
import exceptions.LoginException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        String url = "/index.html";
        String option = request.getParameter("option");
        System.out.println("option = " + option);
        
        if (option.equals("login")) {
            Customer.initialize();
            try {
                String userID = request.getParameter("userID");
                String password = request.getParameter("password");
                Customer customer = Customer.login(userID, password);
                System.out.println("Customer: " + customer.getName());
                session.setAttribute("customer", customer);
                url = "/customerMain.jsp";
            }
            
            catch(LoginException e) {
                System.out.println("Login Exception");
                session.setAttribute("message", e.getMessage());
                url = "/login.jsp";
            }
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}