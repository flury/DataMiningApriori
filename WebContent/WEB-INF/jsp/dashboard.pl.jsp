<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
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
	  <div class="bg-light p-5 rounded">
	    <h1>Data Mining Apriori</h1>
	    <p class="lead">Adalah aplikasi yang dibuat untuk mencari Frequent Item/Itemset pada transaksional Database.</p>
	    <p class="lead">Menurut Santoso (2007) data mining sering juga disebut knowledge discovery in database (KDD), adalah kegiatan yang meliputi pengumpulan, pemakaian data historis untuk menemukan keteraturan, pola atau hubungan dalam set data berukuran besar. Kaluaran dari data mining ini bisa dipakai untuk mempebaiki pengambilan keputusan dimasa depan. Sehingga istilah pattern recognition sekarang jarang digunakan karena ia termasuk bagian dari data mining (Albab & Ade, 2015).</p>
	    <p class="lead">Menurut Agrawal & Srikant (1994) algoritma apriori adalah suatu algoritma dasar untuk menemukan frequent itemsets pada aturan asosiasi boolean. Ide utama pada algoritma apriori adalah:
Pertama, mencari frequent itemset (himpunan item-item yang memenuhi minimum support) dari basis data transaksi.
Kedua, menghilangkan itemset dengan frekuensi yang rendah berdasarkan level minimum support yang telah ditentukan sebelumnya.
Selanjutnya membangun aturan asosiasi dari itemset yang memenuhi nilai minimum confidence dalam basis data (Listriani et al, 2016).</p>
	    <!-- <a class="btn btn-lg btn-primary" href="../components/navbar/" role="button">View navbar docs &raquo;</a> -->
	  </div>
	</main>

    <script src="<c:url value="/resources/assets/dist/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>