package ua.training.dao.impl;

import ua.training.dao.TourOrderDAO;
import ua.training.dto.TourOrderDTO;
import ua.training.model.OrderStatus;
import ua.training.model.TourOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCTourOrderDao implements TourOrderDAO {

    public static final String ADD_ORDER = "insert into tour_order( user_id ,tour_id,tickets_quantity,status) values (?, ?, ?, ?)";
    public static final String FIND_ORDERS_BY_USER= "select tour_order.id, account.login as user_login,tour.name as tour_name, tickets_quantity, status from tour_order left join account on tour_order.user_id = account.id left join tour on tour_order.tour_id=tour.id where user_id=?";
    public static final String FIND_REGISTERED_ORDERS= "select tour_order.id, account.login as user_login,tour.name as tour_name, tickets_quantity, status from tour_order left join account on tour_order.user_id = account.id left join tour on tour_order.tour_id=tour.id where status='REGISTERED'";
    public static final String CHANGE_ORDER_STATUS = "update tour_order set status=? where id=?";


    private Connection connection;

    public JDBCTourOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(TourOrder order) {
        try(PreparedStatement ps = connection.prepareStatement(ADD_ORDER)){
            ps.setInt(1, order.getCustomer().getId());
            ps.setInt(2,order.getTour().getId());
            ps.setInt(3, order.getTicketsQuantity());
            ps.setString(4, order.getStatus().name());
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<TourOrder> findById(int id) {
        return null;
    }

    @Override
    public List<TourOrder> findAll() {
        return null;
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

    @Override
    public void edit(TourOrder entity) {

    }

    @Override
    public List<TourOrderDTO> findAllByUserId(int id) {
        List<TourOrderDTO> userOrders = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(FIND_ORDERS_BY_USER)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TourOrderDTO order = new TourOrderDTO();
                order.setId(rs.getInt("id"));
                order.setCustomerLogin(rs.getString("user_login"));
                order.setTourName(rs.getString("tour_name"));
                order.setTicketsQuantity(rs.getInt("tickets_quantity"));
                order.setStatus(OrderStatus.valueOf(rs.getString("status")));
                userOrders.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Some troubles with server");
        }
        return userOrders;
    }

    @Override
    public List<TourOrderDTO> findRegistered() {
        List<TourOrderDTO> orders = new ArrayList<>();
        try(Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(FIND_REGISTERED_ORDERS);
            while (rs.next()){
                TourOrderDTO order = new TourOrderDTO();
                order.setId(rs.getInt("id"));
                order.setCustomerLogin(rs.getString("user_login"));
                order.setTourName(rs.getString("tour_name"));
                order.setTicketsQuantity(rs.getInt("tickets_quantity"));
                order.setStatus(OrderStatus.valueOf(rs.getString("status")));
                orders.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Some troubles with server");
        }
        return orders;
    }

    @Override
    public void cancel(int id) {
        try(PreparedStatement ps = connection.prepareStatement(CHANGE_ORDER_STATUS)){
            ps.setString(1, OrderStatus.CANCELED.name());
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void pay(int id) {
        try(PreparedStatement ps = connection.prepareStatement(CHANGE_ORDER_STATUS)){
            ps.setString(1, OrderStatus.PAID.name());
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
