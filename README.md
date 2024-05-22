This repository provides a solution to determine the optimal route for a delivery executive to take when there are multiple orders from different consumers. The solution is based on the following assumptions:

1. All restaurant names are unique; each name corresponds to only one restaurant.
2. All consumer names are unique; each name corresponds to only one consumer.
3. All orders are placed simultaneously, and each order comes from a different restaurant.


**Overview**

The provided code calculates the most efficient path for a delivery executive to follow in order to deliver multiple orders. The process involves:

1. **Creating a List of Orders:** Each order contains details of the associated consumer and restaurant.
2. **Generating All Possible Paths:** The code generates all potential routes that the delivery executive can take to complete the deliveries.
3. **Calculating Delivery Times:** For each potential path, the code calculates the total time required for the executive to deliver all orders using the Haversine formula to compute distances.
4. **Finding the Optimal Path:** The code identifies the path that requires the least time and suggests this route to the delivery executive.

**Implementation Details**
**Order Class:** Contains consumer and restaurant details.
**Path Generation:** Generates all permutations of restaurant-consumer pairs to cover all possible routes.
**Time Calculation:** Uses the Haversine formula to calculate distances between locations and computes total delivery time for each path.
**Optimization:** Identifies the path with the shortest delivery time and outputs it.

This approach ensures that the delivery executive can complete all deliveries in the most time-efficient manner possible.


**Test result:**

Given sample with random latitudes and longitudes

<img width="450" alt="Screenshot 2024-05-22 at 3 37 12 AM" src="https://github.com/praveen-lpk/BestRouteProblem/assets/59311248/db1f909d-f7d7-42c2-a737-d41e2cdbe6ea">



If there are 3 orders from 3 consumers in 3 different restaurants(with random latitudes and longitudes)


<img width="586" alt="Screenshot 2024-05-22 at 3 38 05 AM" src="https://github.com/praveen-lpk/BestRouteProblem/assets/59311248/331761e3-fd8e-479a-972d-49f1e3cf9b5a">
