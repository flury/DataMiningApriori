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
	          <a class="nav-link active" aria-current="page" href="<c:url value="/uploaddataset" />">Upload</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/datamining-processing" />">Processing</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/summary" />">Result</a>
	        </li>
	      </ul>
	      <form class="d-flex" action="<c:url value="/logout-success" />" method="POST">
	        <button class="btn btn-outline-success" type="submit">Sign-out</button>
	      </form>
	    </div>
	  </div>
	</nav>
	
	<main class="container">
		<h3 class="mb-4">Upload CSV or Excel Dataset</h3>
		<form action="<c:url value="/save-commit-dataset-file.pl"/>" method="post" enctype="multipart/form-data">
			<div class="d-flex align-items-end">
				<div class="mb-3 me-3 w-100">
					<input class="form-control" type="file" name="file" id="file">
				</div>
				<div class="mb-3">
					<button type="submit" class="btn btn-primary">Upload</button>
				</div>			
			</div>
		</form>
		<c:if test="${not empty messagesSuccess}">
			<div class="alert alert-success mb-3" role="alert" style="text-align:left;"><b>${messagesSuccess}</b></div>
		</c:if>
		<c:if test="${not empty messagesError}">
			<div class="alert alert-warning mb-3" role="alert" style="text-align:left;"><b>${messagesError}</b></div>
		</c:if>
		<div class="card" style="overflow: auto; max-height: calc(100vh - 210px);">
  			<div class="card-body">
  				<h5 class="card-title fw-normal fs-5">Total Data ${totalData}</h5>
				<table class="table table-striped">
				  <thead>
				    <tr style="border-bottom: 1px solid #cfcfcf">
				      <th scope="col" class="align-middle fw-normal">No</th>
				      <th scope="col" class="align-middle fw-normal">Angkatan</th>
				      <th scope="col" class="align-middle fw-normal">Jenis Kelamin</th>
				      <th scope="col" class="align-middle fw-normal">Proses Masuk</th>
				      <th scope="col" class="align-middle fw-normal">Nama Sekolah</th>
				      <th scope="col" class="align-middle fw-normal">Kota Sekolah</th>
				      <th scope="col" class="align-middle fw-normal">Jurusan Sekolah</th>
				      <th scope="col" class="align-middle fw-normal">Prodi</th>
				      <th scope="col" class="align-middle fw-normal">Lama Studi</th>
				      <th scope="col" class="align-middle fw-normal">IPK</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${listDataset}" var="recs" varStatus="status">
					  	<tr>
					      <th scope="row" class="fw-normal">${status.index + 1}</th>
					      <td>${recs.angkatan}</td>
					      <td>${recs.jenisKelamin}</td>
					      <td>${recs.prosesMasuk}</td>
					      <td>${recs.namaSekolah}</td>
					      <td>${recs.kotaSekolah}</td>
					      <td>${recs.jurusanSekolah}</td>
					      <td>${recs.prodi}</td>
					      <td>${recs.lamaStudi}</td>
					      <td>${recs.ipk}</td>
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