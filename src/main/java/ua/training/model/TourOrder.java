package ua.training.model;

public class TourOrder {

    private Integer id;
    private User customer;
    private Tour tour;
    private int ticketsQuantity;
    private OrderStatus status;

    public TourOrder() {
    }

    public TourOrder(Integer id, User customer, Tour tour, int ticketsQuantity, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.tour = tour;
        this.ticketsQuantity = ticketsQuantity;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
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
