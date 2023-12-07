package hello.core.order;

public interface OrderService {
    Order createOrder(Long numberId, String itemName, int itemPrice);
}
