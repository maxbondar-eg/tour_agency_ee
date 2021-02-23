package ua.training.dao.mapper;

import ua.training.model.Tour;
import ua.training.model.TourType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourMapper implements ObjectMapper<Tour>{
    @Override
    public Tour extractFromResultSet(ResultSet rs) throws SQLException {

        Tour tour = new Tour();

        tour.setId(rs.getInt("id"));
        tour.setName(rs.getString("name"));
        tour.setDescription(rs.getString("description"));
        tour.setPrice(rs.getInt("price"));
        tour.setTourType(TourType.valueOf(rs.getString("tour_type")));
        tour.setPeopleAmount(rs.getInt("people_amount"));
        tour.setStars(rs.getInt("stars"));
        tour.setHot(rs.getBoolean("is_hot"));
        tour.setImg(rs.getString("img"));

        return tour;
    }
}
