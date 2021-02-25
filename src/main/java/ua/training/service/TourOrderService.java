package ua.training.service;

import ua.training.dao.DaoFactory;
import ua.training.dao.TourOrderDAO;
import ua.training.dto.TourOrderDTO;
import ua.training.model.TourOrder;

import java.util.List;

public class TourOrderService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void add(TourOrder order) {
        try(TourOrderDAO dao = daoFactory.createTourOrderDAO()){
            dao.add(order);
        }
    }

    public List<TourOrderDTO> findAllByUserId(int id) {
        try(TourOrderDAO dao = daoFactory.createTourOrderDAO()){
            return dao.findAllByUserId(id);
        }
    }

    public List<TourOrderDTO> findRegistered() {
        try(TourOrderDAO dao = daoFactory.createTourOrderDAO()){
            return dao.findRegistered();
        }
    }

    public void updateOrder(int orderId, String command) {
        try(TourOrderDAO dao = daoFactory.createTourOrderDAO()){
            if(command.equals("cancel")){
                dao.cancel(orderId);
            }else{
                dao.pay(orderId);
            }
        }
    }
}
