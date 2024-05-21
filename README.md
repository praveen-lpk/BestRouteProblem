The code provides the optimal route which delivery executive can chose if there are n orders from n consumers.
**Below are the assumptions:**
1. All the restaurant names are unique. There is only one restaurant with certain name.
2. All consumer names are unique. There is only one consumer with certain name.
3. All the orders came at the same time and each order is from different restaurant.



Below is the high level explaination of the code
1. We'll create list of orders which has consumer and restaurant details.
2. We'll generate all possible paths the executive can take.
3. We'll calculate the time taken by executive to deliver all the orders in particular path. We'll use harvesine formula to calculate distance.
4. We'll find the shortest time consuming path and share with the executive.

**Test result:**

Given sample with random latitudes and longitudes

<img width="450" alt="Screenshot 2024-05-22 at 3 37 12 AM" src="https://github.com/praveen-lpk/BestRouteProblem/assets/59311248/db1f909d-f7d7-42c2-a737-d41e2cdbe6ea">



If there are 3 orders from 3 consumers in 3 different restaurants(with random latitudes and longitudes)

<img width="537" alt="Screenshot 2024-05-22 at 3 36 37 AM" src="https://github.com/praveen-lpk/BestRouteProblem/assets/59311248/c0d9634e-0ecf-4090-a9c9-8c2ab9f33ecf">

