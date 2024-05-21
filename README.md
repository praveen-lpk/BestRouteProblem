The code provides the optimal route which delivery executive can chose if there are n orders from n consumers.
Below are the assumptions:
1. All the restaurant names are unique. There is only one restaurant with certain name.
2. All consumer names are unique. There is only one consumer with certain name.
3. All the orders came at the same time and each order is from different restaurant.



Below is the high level explaination of the code
1. We'll create list of orders which has consumer and restaurant details.
2. We'll generate all possible paths the executive can take.
3. We'll calculate the time taken by executive to deliver all the orders in particular path. We'll use harvesine formula to calculate distance.
4. We'll find the shortest time consuming path and share with the executive.
