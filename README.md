# Railway Reservation System

A Java GUI application for Train Booking and Management.
The main objectives of the project is to allow the passenger to view, book and cancel their train reservations. The project aims to improve the existing systems of booking trains by trying to implement user freedom of booking by allowing the user or passenger to choose their own seats.


## Tools and Libraries
* Java Swing
* JDBC
* XAMPP Server
* mySQL

## System Architecture
<kbd>
 <img src="Attachments/System-Arch.png?raw=true" width="600" height="700">
</kbd>

## Database Design
<kbd>
 <img src="Attachments/ER-DIAG.png?raw=true" width="600" height="500">
</kbd>

## Coach Selection Algorithm
 This System allows seat selection, but to balance the weight distribution of the train, this "Coach Selection Algorithm" comes into picture.
 This Algorithm is based on 'Divide and Conquer' , where the algorithm is designed to pick the right coach so that the mass is evenly distributed.
*	Initially, the coaches are picked at random, in which the customer is able to select the seat/s of their choice, checking the availability of the same.
*	Once that is done, the next user would be prompted to a different coach based on the algorithm which would be chosen according to the existing weights on each coach. 
*	A special case of the same (with six coaches) is represented below where the initially picked coach is 1 (i.e the random function return coach 1 as its output)
*	Once the first passenger has finished selecting their seats, the second passenger is then allowed to book onto a different coach(in this case, the sixth), where they can select their seats.
*	Based on their selection, the coach selection algorithm moves back to the left side where once again the divide an conquer effect comes into play, allowing the third coach to be chosen. 
*	This algorithm continues off in this manner until all seats are completely filled. 
</br>
<kbd>
 <img src="Attachments/Algo 1.png?raw=true" width="700" height="300">
</kbd>
</br>
<kbd>
 <img src="Attachments/Algo 2.png?raw=true" width="700" height="300">
</kbd>
</br>
<kbd>
 <img src="Attachments/Algo 3.png?raw=true" width="700" height="300">
</kbd>


## Screenshots

### Login Page
Login Page for Customers and Admins. New users can also signup. 
</br>
<kbd>
 <img src="Attachments/1.png?raw=true" width="800" height="600">
</kbd>

### Admin Page 
Admins(IRCTC Employees) have the functionality to Add/Edit Train Details and Ticket Validation using PNR
</br>
<kbd>
 <img src="Attachments/2.png?raw=true" width="500" height="400">
</kbd>


### Add/Edit Train Details
Admin can Add/Edit Train Details.
</br>
<kbd>
 <img src="Attachments/addTrain.png?raw=true" width="900" height="400">
</kbd>

### Customer Page
Customers can Book the Tickets and View/Cancel their Bookings.
</br>
<kbd>
 <img src="Attachments/4.png?raw=true" width="500" height="400">
</kbd>

### Reservation Page
Customers can book their Tickers by selecting seats of their choice.
</br>
<kbd>
 <img src="Attachments/REser.png?raw=true" width="600" height="550">
</kbd>

### View/Cancel Reservation
Customers can view and cancel their bookings.
</br>
<kbd>
 <img src="Attachments/view reser.png?raw=true" width="900" height="400">
</kbd>
