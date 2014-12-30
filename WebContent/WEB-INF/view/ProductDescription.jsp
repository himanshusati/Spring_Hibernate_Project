<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Product Description</h4>


 <form:form id="addCart" modelAttribute="product" method="post" action="addCart.html">
 
  <input type="hidden" name="selectedItems" value="${item.id}" />
 <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="<c:out value="${item.prodimgURL}"></c:out>" alt="">
                            <div class="caption">
                                <h4 class="pull-right"><c:out value="${item.prodPrice}"></c:out></h4>
                                <h4><a href="#"><c:out value="${item.prodName}"></c:out></a>
                                </h4>
                                <p><c:out value="${item.prodDesc}"></c:out></p>
                                  <p><c:out value="${item.prodBrand}"></c:out></p>
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
                        <div class="ratings">
                        <input type="submit" name="Add" value="Add to Cart"> 
                        </div>
                    </div>
</form:form>

</body>
</html>