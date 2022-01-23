<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Summary</title>
	
	<meta http-equiv="Content-Type" content="text/html"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta name="author" content="Data Mining Apriori"/>
	
	<link href="<c:url value="/resources/assets/dist/css/custom.css"/>" rel="stylesheet" type="text/css" />
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
	          <a class="nav-link" aria-current="page" href="<c:url value="/uploaddataset" />">Upload</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/datamining-processing" />">Processing</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="<c:url value="/summary" />">Result</a>
	        </li>
	      </ul>
	      <form class="d-flex" action="<c:url value="/logout-success" />" method="POST">
	        <button class="btn btn-outline-success" type="submit">Sign-out</button>
	      </form>
	    </div>
	  </div>
	</nav>
	
	<main class="container">
		<h3 class="mb-4">Summary Data Apriori Algoritm</h3>
		<div class="card" style="overflow: auto; max-height: calc(100vh - 155px);">
			<div class="card-body">
				<h5 class="card-title fw-normal fs-5">Total Data ${totalData}</h5>
				<table class="table table-striped">
				  <thead>
				    <tr style="border-bottom: 1px solid #cfcfcf">
				      <th scope="col" class="align-middle fw-normal">No</th>
				      <th scope="col" class="align-middle fw-normal">Date</th>
				      <th scope="col" class="align-middle fw-normal">Record</th>
				      <th scope="col" class="align-middle fw-normal">Support</th>
				      <th scope="col" class="align-middle fw-normal">Confidence</th>
				      <th style="width: 100px" scope="col" class="align-middle fw-normal">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${listDataset}" var="recs" varStatus="status">
					  	<tr>
					      <th scope="row" class="fw-normal">${status.index + 1}</th>
					      <td>${recs.executeDate}</td>
					      <td>${recs.paramTotalRecord}</td>
					      <td>${recs.paramMinSupport}</td>
					      <td>${recs.paramMinConfidence}</td>
					      <td><a href="<c:url value="/summary-details/${recs.frequentDataId}" />" class="btn btn-sm btn-outline-secondary">View</a></td>
						</tr>
				  	</c:forEach>
				  </tbody>
				</table>
		 	</div>
		 </div>
	</main>

    <script src="<c:url value="/resources/assets/dist/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>