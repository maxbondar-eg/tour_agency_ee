package ua.training.command;

import ua.training.model.Tour;
import ua.training.service.TourService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class TourPageCommand implements Command{
    TourService tourService = new TourService();

    @Override
    public String execute(HttpServletRequest request) {
        if(request.getMethod().equals("GET")){
            int tourId = Integer.parseInt(request.getParameter("tourId"));
            Optional<Tour> tour = tourService.findById(tourId);
            System.out.println("In method");
            if(tour.isPresent()){
                request.setAttribute("tour", tour.get());
            }else{
                throw new RuntimeException("Tour Not Exist");
            }
            return "/tourpage.jsp";
        }
        return "/tourpage.jsp";
    }
}
