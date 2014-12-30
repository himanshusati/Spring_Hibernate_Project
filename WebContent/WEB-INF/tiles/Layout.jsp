<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-theme.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-social.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/font-awesome-4.1.0/css/font-awesome.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/font-awesome-4.1.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-theme.min.css">
 <link href="<%=request.getContextPath()%>/shop-homepage/css/shop-homepage.css" rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/signin.css">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:insertAttribute name="title" ignore="true" />
</title>
 <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <script src="<%=request.getContextPath()%>/js/jquery-2.1.0.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files 
            as needed -->
      <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
      
</head>
<body>
	<div class="span9">
	<tiles:insertAttribute name="header" />
	</div>
	
	<div class="span9">
	<tiles:insertAttribute name="menu" />
	</div>
	<div class="span9">
	<tiles:insertAttribute name="body" />
	</div>
	<div class="footer">
	<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>