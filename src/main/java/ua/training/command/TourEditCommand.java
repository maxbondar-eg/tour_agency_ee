package ua.training.command;

import ua.training.model.Tour;
import ua.training.model.TourType;
import ua.training.service.TourService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class TourEditCommand implements Command{
    TourService tourService = new TourService();
    @Override
    public String execute(HttpServletRequest request) {
        if(request.getMethod().equals("GET")){
            request.setAttribute("tourTypes", TourType.values());
            int tourId = Integer.parseInt(request.getParameter("tourId"));
            Optional<Tour> tour = tourService.findById(tourId);
            if(tour.isPresent()){
                request.setAttribute("tour", tour.get());
            }else{
                throw new RuntimeException("Tour Not Exist");
            }
            return "/editTour.jsp";

        }
        int tourId = Integer.parseInt(request.getParameter("tourId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        TourType tourType = TourType.valueOf(request.getParameter("tourType"));
        int peopleAmount = Integer.parseInt(request.getParameter("peopleAmount"));;
        int stars = Integer.parseInt(request.getParameter("stars"));;
        boolean isHot = Boolean.parseBoolean(request.getParameter("isHot"));
        String img = request.getParameter("img");;

        if(hasEditErrors(request)){
            return "/addTour.jsp";
        }
        Tour tour = new Tour();
        tour.setId(tourId);
        tour.setName(name);
        tour.setDescription(description);
        tour.setPrice(price);
        tour.setTourType(tourType);
        tour.setPeopleAmount(peopleAmount);
        tour.setStars(stars);
        tour.setHot(isHot);
        tour.setImg(img);
        tourService.editTour(tour);
        return "redirect:/tourcontrol";
    }

    private boolean hasEditErrors(HttpServletRequest req){
        return (req.getParameter("name") == null || req.getParameter("name").equals("") ||
                req.getParameter("description") == null || req.getParameter("description").equals("") ||
                req.getParameter("price") == null || req.getParameter("price").equals("") ||
                req.getParameter("tourType") == null || req.getParameter("tourType").equals("") ||
                req.getParameter("peopleAmount") == null || req.getParameter("peopleAmount").equals("") ||
                req.getParameter("stars") == null || req.getParameter("stars").equals("") ||
                req.getParameter("img") == null || req.getParameter("img").equals(""));
    }
}
