<a name="br1"></a> 

**CMPE 343 Spring 2023**

**Programming Homework 3**

**PROGRAMMING TASK**

**Question 1(25 points):**

In Esenboğa airport, there is a parking facility which is in the form of a graph having *N* nodes and *M* edges. The graph does not have self-loops or multiple edges. Each node represents a parking slot and has a capacity of vehicles it can hold. Each edge has a weight of *w*, which indicates that it will cost *w* units to go from node *u* to node *v*. All parking slots have a parking fee *F* per vehicle, which is same for all slots. 

There are *K* identical vehicles entering the parking facility, each vehicle enumerated with a distinct number from *1* to *K*. The vehicles enter in their natural order, that is, vehicle number *1* enters, then vehicle number *2*, then *3* and so on till vehicle number *K*. For each vehicle, you have to print the minimum total cost that is incurred on the vehicle owner. Here, total cost includes **cost of the path taken to reach the parking slot and parking fee of the slot**. It is guaranteed that you can reach any slot from any other slot. **All vehicles entering the parking facility enter from the parking slot 1.**

In the input, the first line contains 3 space separated integers, *N, M* and *F*. *N* denotes the number of nodes, *M* denotes the number of edges and *F* denotes the parking fee. The second line consists of *N* space separated integers denoting the seating capacity of each parking slot. Following *M* lines contain three space separated integers each: *u, v* and *w,* denoting we can reach from node *u* to node *v* incurring a cost of *w* units. The last line of input contains an integer *K* denoting the number of vehicles enter the parking facility.

In the first line it is given that we have 5 parking slots, 4 connections between the parking slots and 10 as parking fee which is the base fee for each car enters the parking facility. In the second line, we have 5 parking slots with their capacity which are 1, 2, 1, 1, and 2. In the next 4 lines, the distance between these parking slots is given and the number of vehicles will be entering the parking facility is 5. You need to give the total cost each car enters the facility.

**Sample Input:**

> 5 4 20

> 1 2 1 1 2

> 1 2 2

> 4 5 1

> 3 4 2

> 1 3 1

> 5

In the output, print K space separated integers denoting answer for each vehicle. ith integer in the space separated integers denotes answer for ith vehicle number. If it is not possible to enter a parking slot print −1 for that vehicle. The output for the about inputs as follows. Please check your program with this input as well as the others that you will create. Please note that we may use other inputs when grading your assignments.

**Sample Output:**

> 20 21 22 22 23


**Question 2(25 points):**

There are *N* bus stations and *M* buses provide service in Ankara Kızılay. Each bus *s* has a schedule consisting of *t* stations. At the beginning, each bus at their first station and each minute it travels to the next station. When it reaches the end, it goes back to the beginning and starts again. At the beginning, you are at station 1. If at any moment you and a bus are at the same station, you can get on it and travel with it. You can get off the bus at any station. The same station can appear multiple times in the itinerary of the bus, but not adjacent to each other (in particular the last station is adjacent to the first one). You are interested in finding the minimum amount of time you need to reach to each station, or state that it is impossible.

You can only travel in one bus at a time, but you can use multiple buses to reach your destination. Do not forget that you can only travel by bus. There can be multiple buses at the same station at the same time. Getting on and off a bus is instantaneous.

In the input, the first line contains *2* space separated integers, *N*, *M*. *N* denotes the number of stations, *M* denotes the number of buses respectively. Each of the next *M* lines contain an integer *t* followed by *t* integers which demonstrate the schedule of each bus.

In the given sample input, it is given that we have 8 stations, and 4 buses work between them in the first line. The next lines give the schedule of each bus with the number of stations it visits and which stations it visits. For example, the second bus has 3 stations 6, 1 and 2. Buses visit the stations according to the given order, so the second bus is in the 6<sup>th</sup> station at the beginning, then it goes to the 1<sup>st</sup> station and then 2<sup>nd</sup> station and returns to the 6<sup>th</sup> station. And, traveling between each station takes 1 minute, so it takes 2 minute for the second bus to go from 6<sup>th</sup> station to 2<sup>nd</sup> station.

**Sample Input:**

> 8 4

> 2 5 4

> 3 6 1 2

> 4 4 2 1 3

> 2 7 8

In the output, print *N-1* space separated integers denoting the minimum amount of time needed to reach each station except the 1<sup>st</sup> station because you are at the first station at the beginning. If any of the stations is not reachable with the given schedule of the buses, you need to print *-1* for that station. You need to print the output in numerical order which means you need to give the amount of time for 2<sup>nd</sup> station first, then 3<sup>rd</sup>, then 4<sup>th</sup> and goes on. 

The output for the above inputs is as follows. Please check your program with this input as well as the others that you will create. Please note that we may use other inputs when grading your assignments.

**Sample Output:**

> 2 3 4 6 3 -1 -1
