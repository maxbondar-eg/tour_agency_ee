package ua.training.command;

import ua.training.service.TourService;

import javax.servlet.http.HttpServletRequest;

public class TourDeleteCommand implements Command{
    TourService tourService = new TourService();

    @Override
    public String execute(HttpServletRequest request) {
        int tourId = Integer.parseInt(request.getParameter("tourId"));
        tourService.deleteTour(tourId);
        return "redirect:/tourcontrol";
    }
}
