package ua.training.dao.impl;

import ua.training.dao.TourDAO;
import ua.training.dao.mapper.TourMapper;
import ua.training.model.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCTourDao implements TourDAO {

    public static final String FIND_ALL_TOURS = "select * from tour";
    public static final String FIND_BY_ID = "select * from tour where id=?";
    public static final String ADD_TOUR = "insert into tour( name ,description,price,tour_type,people_amount,stars,is_hot,img) values (?, ?, ?, ?, ?, ?, ?, ?)";

    private Connection connection;

    public JDBCTourDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Tour tour) {
        try(PreparedStatement ps = connection.prepareStatement(ADD_TOUR)){
            ps.setString(1, tour.getName());
            ps.setString(2, tour.getDescription());
            ps.setInt(3, tour.getPrice());
            ps.setString(4, tour.getTourType().name());
            ps.setInt(5,tour.getPeopleAmount());
            ps.setInt(6, tour.getStars());
            ps.setBoolean(7, tour.isHot());
            ps.setString(8, tour.getImg());
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Tour> findById(int id) {
        Optional<Tour> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)){
            ResultSet rs;
            ps.setInt(1, id);
            rs = ps.executeQuery();
            TourMapper tourMapper = new TourMapper();
            if(rs.next()){
                result = Optional.of(tourMapper.extractFromResultSet(rs));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public List<Tour> findAll() {
        List<Tour> tours = new ArrayList<>();

        try(Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(FIND_ALL_TOURS);
            TourMapper mapper = new TourMapper();
            while(rs.next()){
                Tour tour = mapper.extractFromResultSet(rs);
                tours.add(tour);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("Some technical problems with Server, please try later");
        }
        return tours;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
