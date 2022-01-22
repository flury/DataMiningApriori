<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	 
	<meta charset="utf-8" />
	<meta name="decorator" content="logindasboard">
	<title>Login | Data Mining Apriori</title>
	<meta name="description" content="Login Property Online" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	
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
    
	<link href="<c:url value="/resources/assets/dist/css/signin.css"/>" rel="stylesheet" type="text/css" />
</head>
<body class="form-signin">
	<main class="form-signin">
	  <form action="<c:url value="/j_spring_security_check" />" method="POST">
	    <img class="mb-4" src="<c:url value="/resources/assets/brand/bootstrap-logo.svg"/>" alt="" width="72" height="57">
	    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
	
	    <div class="form-floating">
	      <input type="text" class="form-control" id="floatingInput" placeholder="Username" name="username" autocomplete="off">
	      <label for="floatingInput">Username</label>
	    </div>
	    <div class="form-floating">
	      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" autocomplete="off">
	      <label for="floatingPassword">Password</label>
	    </div>
	    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
	    <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
	  </form>
	</main>
	
</body>
</html>