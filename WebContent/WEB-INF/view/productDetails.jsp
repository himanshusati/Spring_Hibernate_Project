<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products Listing</title>
</head>
<body>
<div class="row">
					<c:if test="${!empty product}">
					<c:forEach items="${product}" var="product">
					
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="<c:out value="${product.prodimgURL}"></c:out>" alt="">
                            <div class="caption">
                                <h4 class="pull-right"><c:out value="${product.prodPrice}"></c:out></h4>
                                <h4><a href="#"><c:out value="${product.prodName}"></c:out></a>
                                </h4>
                                <p><c:out value="${product.prodDesc}"></c:out></p>
                                  <p><c:out value="${product.prodBrand}"></c:out></p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">15 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    </c:if>
           </div>


<%-- <center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Products Listing</div>
<br><br>
<c:if test="${!empty product}">
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: teal;color: white;text-align: center;" height="40px">
<td>Product Id</td>
<td>Product Name</td>
<td>Product Brand</td>
<td>Product Price</td>
<td>Product Description</td>
<td>Product Image</td>
</tr>
<c:forEach items="${product}" var="product">

<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<form:form action="addCart.html" modelAttribute="productdetails" method="post">
<td><input type="checkbox" name="selectedItems" id="a_${product.id}" value="<c:out value="${product.id}"/>" /></td>
<td><c:out value="${product.prodName}"></c:out></td>
<td><c:out value="${product.prodBrand}"></c:out></td>
<td><c:out value="${product.prodPrice}"></c:out></td>
<td><c:out value="${product.prodDesc}"></c:out></td>
<td><c:out value="${product.prodimgURL}"></c:out></td>

<td><input type="submit" value="Add to Cart" name="submit"/></td>
</form:form>

</tr>
</c:forEach>
</table>
</c:if>
<br>
<a href="AddProduct.html" >Click Here to add More Product</a>
</center --%>>
</body>
</html>