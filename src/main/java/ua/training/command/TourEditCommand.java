package ua.training.command;

import javax.servlet.http.HttpServletRequest;

public class TourEditCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        return "editTour.jsp";
    }
}
