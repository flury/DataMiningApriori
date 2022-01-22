<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="decorator" content="error404page">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	
	<title>ICONIC Online | 404 Page Not Found</title>
	
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="<c:url value="/resources/plugins/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/plugins/bootstrap/css/bootstrap-responsive.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/style-metro.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/style-responsive.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/themes/light.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/plugins/uniform/css/uniform.default.css"/>" rel="stylesheet">
	
	<link href="<c:url value="/resources/css/pages/error.css"/>" rel="stylesheet">
</head>
<body class="page-404-3">
	<div class="container error-404">
		<h1>404</h1>
		<h2>Oupps, page not found.</h2>
		<p>
			Actually, the page you are looking for does not exist. 
		</p>
		<p>
			<a href="<c:url value="/index"/>">Return home</a>
		</p>
	</div>
</body>
</html>