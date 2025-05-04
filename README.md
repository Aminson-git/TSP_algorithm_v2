## 🧭 **Simulated Annealing for Travelling Salesperson Problem (TSP)**
This Java project demonstrates how to solve the Travelling Salesperson Problem (TSP) using the Simulated Annealing algorithm. TSP is a well-known NP-hard problem where the goal is to find the shortest possible route that visits each city exactly once and returns to the origin city.

## 🔍 **Problem Overview** 
-**Cities**: Randomly generated with distances between 0 and 100.

-**Objective**: Minimize the total travel cost.

-**Technique**: Heuristic search via simulated annealing and Random Mutation Hill climbing.

-**Bonus**: Includes a call to Final_soln for comparison with a different optimization method.

## 🧊 **How Simulated Annealing Works**
-->Start with an initial random tour.

-->Generate a neighboring tour by swapping two cities.

-->Accept new tour if it's better, or with a probability based on temperature if worse.

-->Gradually decrease the temperature (cooling schedule).

-->Repeat until the temperature reaches a threshold.

