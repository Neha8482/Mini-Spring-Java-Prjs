<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel List</title>
</head>
<body>

<table border="2" width="70%" cellpadding="2">
	<thead>
	<th>NAME</th>
	<th>CITY</th>
	<th>COST FOR 2</th>
	<th>BOOK</th>
	</thead>
	
	<tbody>
	<c:forEach var="hotel" items="${hotelList}">
	<tr>
		<td>${hotel.hotelName}</td>
		<td>${hotel.address.city}</td>
		<td>${hotel.room_cost_perDay}</td>
		<td><a href="bookHotel/${hotel.hotelId}">Book</a> </td>	</tr>
	</c:forEach>
	</tbody>
	
</table>


<a href="lowToHigh/${id}">Price Low to High</a>
</br>
<a href="highToLow/${id}">Price High to Low</a>
<form action="http://localhost:8080/SpringFinalProject/searchHotels/${id}" method="post">
  Search By City : <input type="text" name="city">
         <br/>
        <input type="submit" value="Search">
</form>

<form action="http://localhost:8080/SpringFinalProject/userBookingDetails/${id}" method="post">
	<input type="hidden" name="email" value="${email}">
	<input type="submit" value="My Bookings">
</form>
<a href="UserProfile/${id}">Update Profile</a>
</body>
</html>