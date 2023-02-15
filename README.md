<h1 align="center"> 360Ground </h1>

# Contents

- [Given problem](https://github.com/gama1221/ground360#Given)
- [My Solution](https://github.com/gama1221/ground360#Solution)
  - [Diagram](https://github.com/gama1221/ground360#Diagram)
  - [Building helper class](https://github.com/gama1221/ground360#Building)
  - [Buildings helper class](https://github.com/gama1221/ground360#Buildings)
  - [DeliveryRouter class](https://github.com/gama1221/ground360#DeliveryRouter)
  - [Ground360Application Main class](https://github.com/gama1221/ground360#Ground360Application)
- [Author (Made in...)](https://github.com/gama1221/ground360#Author)

<p align="center">
  <img width="460" height="300" src="images/360Logo.svg">
</p>

# Given
<h2 align="center">
  Code Challange
</h2>

### Implement a route planning algorithm for a delivery company.
A delivery company has to deliver packages to several buildings in a city. Given the set of buildings and the distance between every pair of buildings, the problem is to find the shortest possible route that visits every building exactly once and returns to the starting building.

Implement a function that takes a list of buildings and a starting building and returns the shortest possible route to travel from the starting building to all the other buildings, visiting all the buildings exactly once and returning to the starting building.
```python
Given Definition(Function) using python
def delivery_route_optimization(buildings: List[Building], start: Building) -> List[Building]:
```

```java
Mine implementation using java 
public static delivery_route_optimization(List<Building> buildings, Building start]{
  // Write or include the logic here
}
```

where:<br/>
* <b>buildings</b> is a list of buildings with the name and distance attributes.<br/>
* <b>start</b> is the starting building.<br/>

The function should return a list of buildings representing the optimized delivery route, starting and ending with the start building.

<b>Note:</b> Assume that the distance between any two buildings is given and it is symmetrical (i.e., if there is a path from building A to building B with a distance of d, then there is a path from building B to building A with a distance of d).

<h3> Submission Instructions </h3>

1. <b>Code:</b> you can write your solution in a preferred programming language and provide the full code.
2. <b>Comments:</b> The code should be well-commented and should explain the thought process and logic behind the solution.
3. <b>Test Cases:</b> provide test cases that demonstrate the correctness of their solution, including edge cases.
4. <b>Time & Space Complexity Analysis:</b> provide an analysis of the time and space complexity of their solution.
5. <b>Document:</b> Provide a document explaining the solution, how you approached the problem, and how you tested it.
6. <b>Submission:</b> You can upload the code to a code hosting platform (e.g., GitHub, GitLab, Bitbucket) and share the link.

<h3>
  Plagiarism
</h3>

It is important to note that plagiarism will not be tolerated. All submitted solutions must be original and written by you, who applied for the vacancy and submitted the solution. Any evidence of plagiarism will be thoroughly investigated and may result in disqualification from the assessment process.
# Solution
Breaking the problem into connected pieces as follows
  1. Buildings class
  2. Building class
  3. Delivery Route Optimization class
  4. Sample examples with sample inputs
  5. Test classes
# Diagram
<p align="center">
  <img src="images/buildings.JPG" />
</p>

# Building
```springboot
package com.shortestroute.ground360;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Building {
    /**
     * Building properties
     * Setter and Getter methods
     * Used to access private fields by other classes
     */
    private String name;
    private LinkedList<Building> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;// considers as infinity value except to the starting building
    private Map<Building, Integer> adjacentBuilding = new HashMap<>();

    /**
     * A constructor for creating Building object
     * @param name - the param used to create Building object via name parameter
     */
    public Building(String name){
        this.name = name;
    }
    /**
     * Attach and map the building with distance
     */
    public void addDestination(Building destination, int distance){
        adjacentBuilding.put(destination, distance);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LinkedList<Building> getShortestPath() {
        return shortestPath;
    }
    public void setShortestPath(LinkedList<Building> shortestPath) {
        this.shortestPath = shortestPath;
    }
    public Integer getDistance() {
        return distance;
    }
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    public Map<Building, Integer> getAdjacentBuilding() {
        return adjacentBuilding;
    }
    public void setAdjacentBuilding(Map<Building, Integer> adjacentBuilding) {
        this.adjacentBuilding = adjacentBuilding;
    }
}
```
# Author
* **Github** <[Getinet Amare](https://github.com/gama1221)>
* **Email** <[Getinet Amare](mailto:getinetamare@gmail.com)>
* **WhatsApp** <[Getinet Amare](https://wa.me/+251991732949)>
* **LinkedIn** <[Getinet Amare](https://www.linkedin.com/in/getinet-mekonnen/)>
* **Telegram** <[Getinet Amare](https://t.me/gama2112)>
