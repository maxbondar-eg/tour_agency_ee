package ua.training.command;

import ua.training.service.TourOrderService;

import javax.servlet.http.HttpServletRequest;

public class OrderCancelCommand implements Command{
    TourOrderService orderService = new TourOrderService();

    @Override
    public String execute(HttpServletRequest request) {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        orderService.updateOrder(orderId, "cancel");
        return "redirect:/orders";
    }
}
