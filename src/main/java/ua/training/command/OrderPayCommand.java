package ua.training.command;

import ua.training.service.TourOrderService;

import javax.servlet.http.HttpServletRequest;

public class OrderPayCommand implements Command{
    TourOrderService orderService = new TourOrderService();

    @Override
    public String execute(HttpServletRequest request) {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        orderService.updateOrder(orderId, "pay");
        return "redirect:/orders";
    }
}
