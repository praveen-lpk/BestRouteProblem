package lucidity;

public class Order {
    private Consumer consumer;
    private Restaurant restaurant;

    public Order(Consumer consumer, Restaurant restaurant) {
        this.consumer = consumer;
        this.restaurant = restaurant;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
