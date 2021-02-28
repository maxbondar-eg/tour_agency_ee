package ua.training.command;

import ua.training.model.Tour;
import ua.training.service.TourService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MainPageCommand  implements Command{
    TourService tourService = new TourService();

    @Override
    public String execute(HttpServletRequest request) {
        List<Tour> tours = tourService.findAll();
        request.setAttribute("tours", tours);
        return "/index.jsp";
    }
}
