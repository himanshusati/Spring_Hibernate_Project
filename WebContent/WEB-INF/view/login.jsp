<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<body>

<c:url var="loginUser" value="loginUser.html"/>

 <div class="container">
<form:form class="form-signin" id="loginUser" modelAttribute="userLogin" method="post" action="${loginUser}">

 <h2 class="form-signin-heading" style="color: red;">${text}</h2>	
 <h2 class="form-signin-heading">Please sign in</h2>

<form:input  path="userName" class="form-control" />

<form:password path="password" class="form-control" />

 
         <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        
       <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>


</form:form>
</div>

</body>
</html>


