<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Upload Dataset</title>
	
	<meta http-equiv="Content-Type" content="text/html"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta name="author" content="Data Mining Apriori"/>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="<c:url value="/dashboard.pl" />">Data Mining Apriori</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarCollapse">
	      <ul class="navbar-nav me-auto mb-2 mb-md-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="<c:url value="/uploaddataset" />">Upload</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/datamining-processing" />">Processing</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Result</a>
	        </li>
	      </ul>
	      <form class="d-flex" action="<c:url value="/logout-success" />" method="POST">
	        <button class="btn btn-outline-success" type="submit">Sign-out</button>
	      </form>
	    </div>
	  </div>
	</nav>
	
	<main class="container">
		<h3>Upload CSV or Excel Dataset</h3>
		<form action="<c:url value="/save-commit-dataset-file.pl"/>" method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="formFile" class="form-label"></label>
				<input class="form-control" type="file" name="file" id="file">
			</div>
			<div class="mb-3">
				<button type="submit" class="btn btn-primary">Upload</button>
			</div>
		</form>
		<c:if test="${not empty messagesSuccess}">
			<div class="alert alert-success" role="alert" style="text-align:left;"><b>${messagesSuccess}</b></div>
		</c:if>
		<c:if test="${not empty messagesError}">
			<div class="alert alert-warning" role="alert" style="text-align:left;"><b>${messagesError}</b></div>
		</c:if>
	</main>

    <script src="<c:url value="/resources/assets/dist/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>