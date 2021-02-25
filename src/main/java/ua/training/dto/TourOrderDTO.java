package ua.training.dto;

import ua.training.model.OrderStatus;

public class TourOrderDTO {
    private int id;
    private String customerLogin;
    private String tourName;
    private int ticketsQuantity;
    private OrderStatus status;

    public TourOrderDTO() {
    }

    public TourOrderDTO(int id, String customerLogin, String tourName, int ticketsQuantity, OrderStatus status) {
        this.id = id;
        this.customerLogin = customerLogin;
        this.tourName = tourName;
        this.ticketsQuantity = ticketsQuantity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public int getTicketsQuantity() {
        return ticketsQuantity;
    }

    public void setTicketsQuantity(int ticketsQuantity) {
        this.ticketsQuantity = ticketsQuantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
