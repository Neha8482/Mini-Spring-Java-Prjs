<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
            <thead>
                <tr>
                    <th>RequestID</th>
                    <th>ExecutiveID</th>
                    <th>Request_Type</th>
                    <th>Request_Status</th>
                    <th>Description</th>
                    <th>Request_Date</th>
                    <th>Resolve_Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="request" items="${ree}" >
                <tr>
                    <td>${request.requestid}</td>
                    <td>${request.executiveid}</td>
                    <td>${request.request_type}</td>
                    <td>${request.request_status}</td>
                    <td>${request.description}</td>
                    <td>${request.request_date}</td>
                    <td>${request.resolve_date}</td>
                </tr>
                </c:forEach>   
            </tbody>
</table>

</body>
</html>