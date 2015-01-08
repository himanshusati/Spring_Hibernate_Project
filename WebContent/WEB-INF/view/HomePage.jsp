<%@page import="com.himanshu.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script type="text/javascript">
function reply_click(clicked_id)
{
	 var name = clicked_id;  
	 debugger
	  window.location.href="openProduct.html?name="+name;
}
</script>
</head>
<body onload="$('#my-modal').modal('show');">
context value  :- <%=request.getContextPath()%>
	<div id="my-modal" class="modal fade" style="margin-top: 20%;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"></div>
				<div class="modal-body">
					<img alt="test image"
						src="<%=request.getContextPath()%>/bootstrap/css/images.jpg">
					<br> Welcome to E-ZONE....... click next to continue.
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">NEXT</button>
				</div>
			</div>
		</div>
	</div>
	
	 <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">E-ZONE</p>
                <div class="list-group">
                    <a href="#" class="list-group-item">Computers</a>
                    <a href="#" class="list-group-item">Mobiles</a>
                    <a href="#" class="list-group-item">Camera</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="<%=request.getContextPath()%>/images/App1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="<%=request.getContextPath()%>/images/App2.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="<%=request.getContextPath()%>/images/App3.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

            </div>

        </div>
        <div class="row">
					<c:if test="${!empty product}">
					<c:forEach items="${product}" var="product">
					
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div id="${product.id}" class="thumbnail" onclick="reply_click(this.id)" style="cursor: pointer;">
                            <img src="<%=request.getContextPath()%>/images/${product.prodName}.jpg" alt="">
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
		
    </div>
</body>
</html>