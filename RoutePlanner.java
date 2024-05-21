package lucidity;

import java.util.ArrayList;
import java.util.List;

public class RoutePlanner {

    /**
     * This method can be used to test optimised path logic, In the real word, these data will come from API
     *
     * @param args
     */
    public static void main(String[] args) {
        GeoLocation amanLocation = new GeoLocation(12.9345, 77.6221);

        // Create consumers
        Consumer consumer1 = new Consumer("C1", new GeoLocation(12.9371, 79.6229));
        Consumer consumer2 = new Consumer("C2", new GeoLocation(12.9355, 77.6216));

        // Create restaurants
        Restaurant restaurant1 = new Restaurant("R1", new GeoLocation(12.9355, 77.6214), 20);
        Restaurant restaurant2 = new Restaurant("R2", new GeoLocation(12.9355, 77.6215), 21);

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(consumer1, restaurant1));
        orders.add(new Order(consumer2, restaurant2));

        // Create delivery executive
        DeliveryExecutive aman = new DeliveryExecutive("aman", amanLocation);


        List<String> optimizedPath = aman.calculateOptimizedPath(orders);
        System.out.println("Optimized path for delivery: " + optimizedPath);
    }
}
