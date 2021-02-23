package ua.training.service;

import ua.training.dao.DaoFactory;
import ua.training.dao.TourDAO;
import ua.training.dao.UserDAO;
import ua.training.model.Tour;
import ua.training.model.User;

import java.util.List;
import java.util.Optional;

public class TourService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<Tour> findById(int id){
        Optional<Tour> result;
        try(TourDAO dao = daoFactory.createTourDAO()){
            result = dao.findById(id);
        }

        return result;
    }

    public List<Tour> findAll() {
        try(TourDAO dao = daoFactory.createTourDAO()){
            return dao.findAll();
        }
    }

    public void addTour(Tour tour) {
        try(TourDAO dao = daoFactory.createTourDAO()){
            dao.add(tour);
        }
    }
}
