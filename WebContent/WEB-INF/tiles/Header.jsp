<%@page import="com.himanshu.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
<style>
        
        footer {
            color: #666;
            background: #222;
            padding: 17px 0 18px 0;
            border-top: 1px solid #000;
        }
        footer a {
            color: #999;
        }
        footer a:hover {
            color: #efefef;
        }
        .wrapper {
            min-height: 100%;
            height: auto !important;
            height: 100%;
            margin: 0 auto -63px;
        }
        .push {
            height: 63px;
        }
        /* not required for sticky footer; just pushes hero down a bit */
        .wrapper > .container {
            padding-top: 60px;
        }
    </style>

<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
</head>
<body>

<div class="bs-example">

    <nav role="navigation" class="navbar navbar-inverse">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="HomePage.html" class="navbar-brand">E-ZONE</a>
        </div>
        <!-- Collection of nav links and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="productList.html">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
            
             <c:url var="searchProduct" value="searchProduct.html"/>
				<form role="search" class="navbar-form navbar-left" id="searchProduct" method="post" action="${searchProduct}" >
				<div class="form-group">
				 <input type="text" placeholder="Search" class="form-control" name="searchText">
				</div>
				</form>
            
            <ul class="nav navbar-nav navbar-right">
               <%
				User obj=(User)session.getAttribute("userdetails");
				if(obj!=null)
				{%>
				<li><a href="AddProduct.html" >Add new Product</a></li>
				
				<li><a href="logout.html">Logout</a></li>
				
				
				<li><a href="AddAddress.html">Add Address</a></li>
				
				<%
				}
				else {
				%>
				
				<li><a href="register.html" >Register</a></li>
				
				<li><a href="login.html" >Login</a></li>
				<%} %>
               
               
                
            </ul>
        </div>
    </nav>
</div>

</body>
</html>