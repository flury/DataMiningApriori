<%@page import="com.datamining.util.Constant"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>DataMining Apriori</title>
	
	<meta http-equiv="Content-Type" content="text/html" />
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="DataMining Apriori" name="description" />
	<meta content="DataMining Apriori" name="author" />
	
	<!--begin::Fonts-->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
	
	<!--begin::Global Theme Styles(used by all pages)-->
	<link href="<c:url value="/resources/assets/dist/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
	<!--end::Global Theme Styles-->
	
	<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    
	<link href="<c:url value="/resources/assets/dist/css/navbar-top.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<decorator:body />
	<decorator:head/>
</body>
</html>