# Viagogo-Code
Completed Version - Viagogo Coding Challenge

This program accepts a user location as a pair of co-ordinates, and returns a list of the five closest events, along with the cheapest ticket price for each event.

This program is written in Java. 


Instructions to run: (using command prompt / terminal)
- e.g to compile - [javac Event.java]

1. compile Event.java file 
2. compile Coordinates.java file
3. compile Viagogo.java file		//contains main method 

- e.g to run compiled file - [java Viagogo]

4. Run Viagogo.java file 
5. Follow instructions on the screen



Assumptions:
1. Random price has a maximum price of $1000
2. Event details that are stored will only be EventID and price
3. Each event will have only 1 ticket type
4. Number of tickets are not assigned to events
4. Ticket returned is always the cheapest ticket
5. Random number of events will be generated - possibility of having an event at every coordinate
6. Error will not be thrown when user input a coordinate which has more than 2 values


How might you change your program if you needed to support multiple events at the
same location?
- Have a list that hold Event objects in that position
OR
- Create a new class which holds all the events. Each event will be pointed to a position in the 2D array (represented as the coordinate)   


How would you change your program if you were working with a much larger world
size?
- Have a more efficient method for sorting event distances
 
