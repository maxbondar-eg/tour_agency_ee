package ua.training;

import ua.training.command.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put("/controller", new MainPageCommand());
        commands.put("logout", new LogOutCommand());
        commands.put("login", new LoginCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("tourpage", new TourPageCommand());
        commands.put("tourcontrol", new TourControlCommand());
        commands.put("tourcontrol/add", new TourAddCommand());
        commands.put("tourcontrol/edit", new TourEditCommand());
        commands.put("tourcontrol/delete", new TourDeleteCommand());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/controller/" , "");
        System.out.println(path);
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        String page = command.execute(request);
        if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", "/controller"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
