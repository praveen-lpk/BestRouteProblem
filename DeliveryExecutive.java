package lucidity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DeliveryExecutive implements Executive {
    private static final Double AVG_SPEED = 20.0;
    private static final Integer HOUR_TO_MINUTES = 60;
    private final String name;
    private final GeoLocation currentLocation;

    public DeliveryExecutive(String name, GeoLocation currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }


    public GeoLocation getCurrentLocation() {
        return currentLocation;
    }


    public List<String> calculateOptimizedPath(List<Order> orders) {
        List<List<String>> paths = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        Set<String> visitedRestaurants = new HashSet<>();
        Set<String> visitedConsumers = new HashSet<>();
        Map<String, Restaurant> restaurants = new HashMap<>();
        Map<String, Consumer> consumers = new HashMap<>();
        for (Order order : orders) {
            restaurants.put(order.getRestaurant().getName(), order.getRestaurant());
            consumers.put(order.getConsumer().getName(), order.getConsumer());
        }

        generatePaths(orders, visitedConsumers, visitedRestaurants, currentPath, paths);
        double shortestTime = Double.MAX_VALUE;
        List<String> shortestPath = new ArrayList<>();


        for (List<String> path : paths) {
            double totalTime = calculateTime(path, restaurants, consumers);
            if (totalTime < shortestTime) {
                shortestTime = totalTime;
                shortestPath = new ArrayList<>(path);
            }
//            System.out.println(path + "=" + totalTime);
        }

        return shortestPath;
    }


    private void generatePaths(List<Order> orders, Set<String> visitedConsumers,
                               Set<String> visitedRestaurants,
                               List<String> currentPath, List<List<String>> paths) {
        if (currentPath.size() == (2 * orders.size())) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }
        for (Order order : orders) {
            String restaurantName = order.getRestaurant().getName();
            String consumerName = order.getConsumer().getName();
            if (!visitedRestaurants.contains(restaurantName)) {
                currentPath.add(restaurantName);
                visitedRestaurants.add(restaurantName);
                generatePaths(orders, visitedConsumers, visitedRestaurants, currentPath, paths);
                visitedRestaurants.remove(restaurantName);
                currentPath.remove(restaurantName);
            }
            if (visitedRestaurants.contains(restaurantName) &&
                    !visitedConsumers.contains(consumerName)) {
                currentPath.add(consumerName);
                visitedConsumers.add(consumerName);
                generatePaths(orders, visitedConsumers, visitedRestaurants, currentPath, paths);
                visitedConsumers.remove(consumerName);
                currentPath.remove(consumerName);
            }
        }
    }


    private double calculateTime(List<String> path,
                                 Map<String, Restaurant> restaurants,
                                 Map<String, Consumer> consumers) {
        double totalTime = 0;
        GeoLocation currentLocation = getCurrentLocation();

        for (String name : path) {
            if (restaurants.containsKey(name)) {
                Restaurant restaurant = restaurants.get(name);
                double distanceToRestaurant = currentLocation.distanceTo(restaurant.getLocation());
                double travelTimeToRestaurant = (distanceToRestaurant / AVG_SPEED) * HOUR_TO_MINUTES;
                double remainingPreparationTime = Math.max(0, restaurant.getPreparationTime() - (totalTime + travelTimeToRestaurant));
                totalTime += travelTimeToRestaurant + remainingPreparationTime;
                currentLocation = restaurant.getLocation();
            } else {
                Consumer consumer = consumers.get(name);
                double distanceToConsumer = currentLocation.distanceTo(consumer.getLocation());
                double travelTimeToConsumer = (distanceToConsumer / AVG_SPEED) * HOUR_TO_MINUTES;
                totalTime += travelTimeToConsumer;
                currentLocation = consumer.getLocation();
            }
        }
        return totalTime;
    }

}
