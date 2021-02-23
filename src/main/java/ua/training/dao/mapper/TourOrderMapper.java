package ua.training.dao.mapper;

import ua.training.model.TourOrder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourOrderMapper implements ObjectMapper<TourOrder>{
    @Override
    public TourOrder extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
