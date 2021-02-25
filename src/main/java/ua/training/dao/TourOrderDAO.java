package ua.training.dao;

import ua.training.dto.TourOrderDTO;
import ua.training.model.TourOrder;

import java.util.List;

public interface TourOrderDAO  extends GenericDAO<TourOrder>{
    List<TourOrderDTO> findAllByUserId(int id);

    List<TourOrderDTO> findRegistered();

    void cancel(int id);

    void pay(int id);
}
