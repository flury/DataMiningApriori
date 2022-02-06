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
		<div class="d-flex justify-content-between align-items-start">
			<h3 class="mb-4">Summary Data Apriori Algoritm</h3>
			<a href="<c:url value="/summary" />" class="btn btn-outline-secondary">Back</a>
		</div>
		<div class="alert alert-success" role="alert">
			<div class="mb-3">Candidate Definition:</div>
			<div class="d-flex justify-content-between">
				<div>
					<div>1 &nbsp;&nbsp;: Angkatan 13</div>
					<div>2 &nbsp;&nbsp;: Angkatan 14</div>
					<div>3 &nbsp;&nbsp;: Angkatan 15</div>
					<div>4 &nbsp;&nbsp;: Angkatan 16</div>
					<div>5 &nbsp;&nbsp;: Pria</div>
					<div>6 &nbsp;&nbsp;: Wanita</div>
				</div>
				<div>
					<div>7 &nbsp;&nbsp;&nbsp;: Beasiswa</div>
					<div>8 &nbsp;&nbsp;&nbsp;: Nilai Rapor Kurang Dari 7.00</div>
					<div>9 &nbsp;&nbsp;&nbsp;: Nilai Rapor >= 7.00</div>
					<div>10 &nbsp;: SMA</div>
					<div>11 &nbsp;: SMK</div>
					<div>12 &nbsp;: Jakarta</div>
				</div>
				<div>
					<div>13 &nbsp;&nbsp;: Tangerang</div>
					<div>14 &nbsp;&nbsp;: Luar Kota</div>
					<div>15 &nbsp;&nbsp;: Teknik Informatika</div>
					<div>16 &nbsp;&nbsp;: Non Teknik Informatika</div>
					<div>17 &nbsp;&nbsp;: Cumlaude (Lebih Dari 3.5)</div>
					<div>18 &nbsp;&nbsp;: Memuaskan (Kurang Dari = 3.5)</div>
				</div>
				<div>
					<div>19 &nbsp;&nbsp;: Cepat (Kurang Dari = 4)</div>
					<div>20 &nbsp;&nbsp;: Standar (Lebih Dari 4)</div>
					<div>21 &nbsp;&nbsp;: TI</div>
					<div>22 &nbsp;&nbsp;: SI</div>
				</div>
			</div>
		</div>
		<div class="mb-3 mt-3"></div>
		 <h3 class="mb-4">Support:</h3>
		<div class="card" style="overflow: auto; max-height: calc(100vh - 155px);">
			<div class="card-body">
				<h5 class="card-title fw-normal fs-5">Total Data ${totalData}</h5>
				<table class="table table-striped">
				  <thead>
				    <tr style="border-bottom: 1px solid #cfcfcf">
				      <th scope="col" class="align-middle fw-normal">No</th>
				      <th scope="col" class="align-middle fw-normal">Itemset</th>
				      <th scope="col" class="align-middle fw-normal">Candidate</th>
				      <th scope="col" class="align-middle fw-normal">Support</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${listDataset}" var="recs" varStatus="status">
					  	<tr>
					      <th scope="row" class="fw-normal">${status.index + 1}</th>
					      <td>${recs.itemsetNumber}</td>
					      <td>${recs.candidate}</td>
					      <td>${recs.support*100}%</td>
						</tr>
				  	</c:forEach>
				  </tbody>
				</table>
		 	</div>
		 </div>
		 <div class="mb-3 mt-3"></div>
		 <h3 class="mb-4">Confidence:</h3>
		 <div class="card" style="overflow: auto; max-height: calc(100vh - 155px);">
			<div class="card-body">
				<h5 class="card-title fw-normal fs-5">Total Data ${totalDataConfidence}</h5>
				<table class="table table-striped">
				  <thead>
				    <tr style="border-bottom: 1px solid #cfcfcf">
				      <th scope="col" class="align-middle fw-normal">No</th>
				      <th scope="col" class="align-middle fw-normal">Candidate (A)</th>
				      <th scope="col" class="align-middle fw-normal">Support (A1)</th>
				      <th scope="col" class="align-middle fw-normal">Candidate (B)</th>
				      <th scope="col" class="align-middle fw-normal">Support (B1)</th>
				      <th scope="col" class="align-middle fw-normal">Confidence (A1 / B1)</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${listDataConfidence}" var="recs" varStatus="status">
					  	<tr>
					      <th scope="row" class="fw-normal">${status.index + 1}</th>
					      <td>${recs.candidateA}</td>
					      <td><fmt:formatNumber type="percent" maxIntegerDigits="3" maxFractionDigits="2" value="${recs.supportA}" /></td>
					      <td>${recs.candidateB}</td>
					      <td><fmt:formatNumber type="percent" maxIntegerDigits="3" maxFractionDigits="2" value="${recs.supportB}" /></td>
					      <td><fmt:formatNumber type="percent" maxIntegerDigits="3" maxFractionDigits="2" value="${recs.confidence}" /></td>
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