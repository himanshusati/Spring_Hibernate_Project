<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart Product Listing</title>
</head>
<body>
<div class="row">
					<c:if test="${!empty products}">
					<c:forEach items="${products}" var="product">
					
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
            
            
            <form:form id="cartCheckout" modelAttribute="product" method="post" action="cartCheckout.html">
            <div class="ratings">
            			<input type="hidden" name="cartValue" value="${carCost}" />
            		 	<span class="glyphicon glyphicon-star">Total cart cost is :${carCost} </span>
                        <input type="submit" name="Checkout" value="Checkout"> 
             </div>
             </form:form>

</body>
</html>