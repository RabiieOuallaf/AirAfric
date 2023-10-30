package src.main.airportmangement.Servlets.Users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import src.main.airportmangement.Services.Authentification.ClientAuthentificationService;

import java.io.IOException;

@WebServlet(name = "ClientServlet", urlPatterns = {"/client" , "/client/register", "/client/login"})
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("Authentification/ClientLogin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI().split("/")[2];
        System.out.println("action" + action);
        if(action.equals("login")){
            String cin = request.getParameter("cin");
            String password = request.getParameter("password");
            ClientAuthentificationService clientAuthentificationService = new ClientAuthentificationService();
            boolean isUserSignedIn = clientAuthentificationService.signIn(cin,password);
            if(isUserSignedIn){
                response.sendRedirect("/main.jsp");
            }
        }else if(action.equals("register")){
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String cin = request.getParameter("cin");
            String phoneNumber = request.getParameter("phone");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            ClientAuthentificationService clientAuthentificationService = new ClientAuthentificationService();
            boolean isUserSignedUp = clientAuthentificationService.signUp(firstName,lastName,email,password,phoneNumber,cin);
            if(isUserSignedUp){
                response.sendRedirect("/main.jsp");
            }


        }else {
            response.sendRedirect("/client");
        }



    }
}