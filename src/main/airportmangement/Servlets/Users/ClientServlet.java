package src.main.airportmangement.Servlets.Users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import src.main.airportmangement.Services.Authentification.ClientAuthentificationService;

import java.io.IOException;

@WebServlet(name = "ClientServlet", value = "/client")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userStatus =  (String)request.getSession().getAttribute("userStatus");

        if(userStatus == null || userStatus == null) {
            request.getRequestDispatcher("Authentification/ClientRegister.jsp");
        }else {
            request.getRequestDispatcher("Authentification/ClientLogin.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String cin = request.getParameter("cin");
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ClientAuthentificationService clientAuthentificationService = new ClientAuthentificationService();
        boolean isUserSignedUp = clientAuthentificationService.signUp(firstName,lastName,email,password,phoneNumber,cin);

        if(isUserSignedUp){
            request.getSession().setAttribute("userStatus","client");
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("/client");
        }



    }
}