<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User Address</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px"></div>
<br><br>
<c:url var="saveAddress" value="saveAddress.html"/>
<form:form id="saveAddress" modelAttribute="UserAddress" method="post" action="${saveAddress}">
<table width="400px" height="150px">
<tr>
<td><form:label path="h_no">House Number</form:label></td>
<td><form:input  path="h_no"/></td>
</tr>
<tr>
<td><form:label path="h_local">Locality</form:label></td>
<td><form:input  path="h_local"/></td>
</tr>

<tr>
<td><form:label path="h_street">Street Name</form:label></td>
<td><form:select path="h_street"></form:select></td>
</tr>

<tr>
<td><form:label path="h_city">City</form:label></td>
<td><form:input  path="h_city" items="${model.city}"/></td>
</tr>

<tr>
<td><form:label path="h_state">State</form:label></td>
<td><form:input  path="h_state" items="${model.state}"/></td>
</tr>
<tr>
<td><form:label path="h_pin">Pin Code</form:label></td>
<td><form:input  path="h_pin"/></td>
</tr>

<tr><td></td><td>
<input type="submit" value="Register" name="submit"/>
</td></tr>
</table>
</form:form>
<br>
<a href="productList.html" >Click Here to see Products List</a>
</center>
</body>
</html>