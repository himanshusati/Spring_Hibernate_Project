<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px"></div>
<br><br>
<c:url var="addProduct" value="saveProduct.html"/>
<form:form id="addProduct" modelAttribute="product" method="post" action="${addProduct}">
<table width="400px" height="150px">
<tr>
<td><form:label path="prodName">Product Name</form:label></td>
<td><form:input  path="prodName"/></td>
</tr>
<tr>
<td><form:label path="prodPrice">Product Price</form:label></td>
<td><form:input  path="prodPrice"/></td>
</tr>

<tr>
<td><form:label path="prodBrand">Product Brand</form:label></td>
<td><form:select path="prodBrand" items="${model.brand}"></form:select></td>
</tr>

<tr>
<td><form:label path="prodDesc">Product Descrption</form:label></td>
<td><form:input  path="prodDesc"/></td>
</tr>

<tr>
<td><label>Product Image URL</label></td>
<td><input type="file" name="prodImage"></td>
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