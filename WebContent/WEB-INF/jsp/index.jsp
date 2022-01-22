<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="decorator" content="indexguestpage">
	<meta charset="utf-8" />
	<title>Data Mining Apriori</title>
	
	<meta http-equiv="Content-Type" content="text/html"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta name="author" content="Data Mining Apriori"/>
	
	<!--begin::Fonts-->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
	<!--end::Fonts-->
	
	<!--begin::Page Custom Styles(used by this page)-->
	<link href="<c:url value="/resources/assets/plugins/custom/fullcalendar/fullcalendar.bundle.css"/>" rel="stylesheet" type="text/css" />
	<!--end::Page Custom Styles-->
	
	<!--begin::Global Theme Styles(used by all pages)-->
	<link href="<c:url value="/resources/assets/plugins/global/plugins.bundle.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/assets/plugins/custom/prismjs/prismjs.bundle.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/assets/css/style.bundle.css"/>" rel="stylesheet" type="text/css" />
	<!--end::Global Theme Styles-->
	
	<style type="text/css">
		/* ----------- Non-Retina Screens ----------- */
		@media screen 
		  and (min-device-width: 1200px) 
		  and (max-device-width: 1600px) 
		  and (-webkit-min-device-pixel-ratio: 1) { 
			img.zoom {
				width: 100%;
				height: 15vw;
				border-radius:0px;
				object-fit:cover;
				-webkit-transition: all .3s ease-in-out;
				-moz-transition: all .3s ease-in-out;
				-o-transition: all .3s ease-in-out;
				-ms-transition: all .3s ease-in-out;
			}
		}

		/* ----------- Retina Screens ----------- */
		@media screen 
		  and (min-device-width: 1200px) 
		  and (max-device-width: 1600px) 
		  and (-webkit-min-device-pixel-ratio: 2)
		  and (min-resolution: 192dpi) { 
			img.zoom {
				width: 100%;
				height: 15vw;
				border-radius:0px;
				object-fit:cover;
				-webkit-transition: all .3s ease-in-out;
				-moz-transition: all .3s ease-in-out;
				-o-transition: all .3s ease-in-out;
				-ms-transition: all .3s ease-in-out;
			}
		}
		
		/* ----------- iPad 1, 2, Mini and Air ----------- */
		/* Portrait and Landscape */
		@media only screen 
		  and (min-device-width: 768px) 
		  and (max-device-width: 1024px) 
		  and (-webkit-min-device-pixel-ratio: 1) {
			img.zoom {
				width: 100%;
				height: 20vw;
				border-radius:0px;
				object-fit:cover;
				-webkit-transition: all .3s ease-in-out;
				-moz-transition: all .3s ease-in-out;
				-o-transition: all .3s ease-in-out;
				-ms-transition: all .3s ease-in-out;
			}
		}

		/* ----------- Galaxy S3 ----------- */
		/* Portrait and Landscape */
		@media screen 
		  and (device-width: 360px) 
		  and (device-height: 640px) 
		  and (-webkit-device-pixel-ratio: 2) {
			img.zoom {
				width: 100%;
				height: 30vw;
				border-radius:0px;
				object-fit:cover;
				-webkit-transition: all .3s ease-in-out;
				-moz-transition: all .3s ease-in-out;
				-o-transition: all .3s ease-in-out;
				-ms-transition: all .3s ease-in-out;
			}
		}
		
		/* ----------- Galaxy S4, S5 and Note 3 ----------- */
		/* Portrait and Landscape */
		@media screen 
		  and (device-width: 320px) 
		  and (device-height: 640px) 
		  and (-webkit-device-pixel-ratio: 3) {
			img.zoom {
				width: 100%;
				height: 30vw;
				border-radius:0px;
				object-fit:cover;
				-webkit-transition: all .3s ease-in-out;
				-moz-transition: all .3s ease-in-out;
				-o-transition: all .3s ease-in-out;
				-ms-transition: all .3s ease-in-out;
			}
		}

		/* ----------- iPhone 6, 6S, 7 and 8 ----------- */
		/* Portrait and Landscape */
		@media only screen 
		  and (min-device-width: 375px) 
		  and (max-device-width: 667px) 
		  and (-webkit-min-device-pixel-ratio: 2) {
			img.zoom {
				width: 100%;
				height: 30vw;
				border-radius:0px;
				object-fit:cover;
				-webkit-transition: all .3s ease-in-out;
				-moz-transition: all .3s ease-in-out;
				-o-transition: all .3s ease-in-out;
				-ms-transition: all .3s ease-in-out;
			}
		}
	</style>
	
	<link rel="shortcut icon" href="<c:url value="/resources/assets/media/logos/favicon.ico"/>" />
</head>

<body id="kt_body" class="header-fixed header-mobile-fixed subheader-enabled page-loading">
	
	<!--begin::Main-->
	<!--begin::Header Mobile-->
	<div id="kt_header_mobile" class="header-mobile header-mobile-fixed">
		<div class="d-flex align-items-center">
			<!--begin::Logo-->
			<a href="index.html" class="mr-7">
				<img alt="Logo" src="<c:url value="/resources/assets/media/logos/logo-letter.png"/>" class="max-h-30px" />
			</a>
			<!--end::Logo-->
			<!--begin::Dropdown-->
			<div class="header-switcher dropdown mr-2">
				<a href="#" class="btn btn-icon border-0" data-toggle="dropdown" data-offset="0px,1px" aria-haspopup="true" aria-expanded="false">
					<span class="svg-icon svg-icon-xl">
						<!--begin::Svg Icon | path:assets/media/svg/icons/Shopping/Box2.svg-->
						<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
							<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
								<rect x="0" y="0" width="24" height="24" />
								<path d="M4,9.67471899 L10.880262,13.6470401 C10.9543486,13.689814 11.0320333,13.7207107 11.1111111,13.740321 L11.1111111,21.4444444 L4.49070127,17.526473 C4.18655139,17.3464765 4,17.0193034 4,16.6658832 L4,9.67471899 Z M20,9.56911707 L20,16.6658832 C20,17.0193034 19.8134486,17.3464765 19.5092987,17.526473 L12.8888889,21.4444444 L12.8888889,13.6728275 C12.9050191,13.6647696 12.9210067,13.6561758 12.9368301,13.6470401 L20,9.56911707 Z" fill="#000000" />
								<path d="M4.21611835,7.74669402 C4.30015839,7.64056877 4.40623188,7.55087574 4.5299008,7.48500698 L11.5299008,3.75665466 C11.8237589,3.60013944 12.1762411,3.60013944 12.4700992,3.75665466 L19.4700992,7.48500698 C19.5654307,7.53578262 19.6503066,7.60071528 19.7226939,7.67641889 L12.0479413,12.1074394 C11.9974761,12.1365754 11.9509488,12.1699127 11.9085461,12.2067543 C11.8661433,12.1699127 11.819616,12.1365754 11.7691509,12.1074394 L4.21611835,7.74669402 Z" fill="#000000" opacity="0.3" />
							</g>
						</svg>
						<!--end::Svg Icon-->
					</span>
				</a>
				<div class="dropdown-menu p-0 m-0 dropdown-menu-md dropdown-menu-left">
					<!--begin::Navigation-->
					<ul class="navi navi-hover py-5">
						<li class="navi-item">
							<a href="<c:url value="/login"/>" class="navi-link">
								<span class="navi-icon">
									<i class="flaticon-lock"></i>
								</span>
								<span class="navi-text">Login Agent</span>
							</a>
						</li>
						<li class="navi-separator my-3"></li>
						<li class="navi-item">
							<a href="#" class="navi-link">
								<span class="navi-icon">
									<i class="flaticon2-magnifier-tool"></i>
								</span>
								<span class="navi-text">Help</span>
							</a>
						</li>
					</ul>
					<!--end::Navigation-->
				</div>
			</div>
			<!--end::Dropdown-->
		</div>
		<!--begin::Toolbar-->
		<div class="d-flex align-items-center">
			<button class="btn p-0 ml-2">
				<span class="svg-icon svg-icon-xl svg-icon-primary">
					<!--begin::Svg Icon | path:assets/media/svg/icons/Code/Compiling.svg-->
					<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
						<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
							<rect x="0" y="0" width="24" height="24" />
							<path d="M2.56066017,10.6819805 L4.68198052,8.56066017 C5.26776695,7.97487373 6.21751442,7.97487373 6.80330086,8.56066017 L8.9246212,10.6819805 C9.51040764,11.267767 9.51040764,12.2175144 8.9246212,12.8033009 L6.80330086,14.9246212 C6.21751442,15.5104076 5.26776695,15.5104076 4.68198052,14.9246212 L2.56066017,12.8033009 C1.97487373,12.2175144 1.97487373,11.267767 2.56066017,10.6819805 Z M14.5606602,10.6819805 L16.6819805,8.56066017 C17.267767,7.97487373 18.2175144,7.97487373 18.8033009,8.56066017 L20.9246212,10.6819805 C21.5104076,11.267767 21.5104076,12.2175144 20.9246212,12.8033009 L18.8033009,14.9246212 C18.2175144,15.5104076 17.267767,15.5104076 16.6819805,14.9246212 L14.5606602,12.8033009 C13.9748737,12.2175144 13.9748737,11.267767 14.5606602,10.6819805 Z" fill="#000000" opacity="0.3" />
							<path d="M8.56066017,16.6819805 L10.6819805,14.5606602 C11.267767,13.9748737 12.2175144,13.9748737 12.8033009,14.5606602 L14.9246212,16.6819805 C15.5104076,17.267767 15.5104076,18.2175144 14.9246212,18.8033009 L12.8033009,20.9246212 C12.2175144,21.5104076 11.267767,21.5104076 10.6819805,20.9246212 L8.56066017,18.8033009 C7.97487373,18.2175144 7.97487373,17.267767 8.56066017,16.6819805 Z M8.56066017,4.68198052 L10.6819805,2.56066017 C11.267767,1.97487373 12.2175144,1.97487373 12.8033009,2.56066017 L14.9246212,4.68198052 C15.5104076,5.26776695 15.5104076,6.21751442 14.9246212,6.80330086 L12.8033009,8.9246212 C12.2175144,9.51040764 11.267767,9.51040764 10.6819805,8.9246212 L8.56066017,6.80330086 C7.97487373,6.21751442 7.97487373,5.26776695 8.56066017,4.68198052 Z" fill="#000000" />
						</g>
					</svg>
					<!--end::Svg Icon-->
				</span>
				<span class="pulse-ring"></span>
			</button>
		</div>
		<!--end::Toolbar-->
	</div>
	<!--end::Header Mobile-->
	
	<div class="d-flex flex-column flex-root">
		<!--begin::Page-->
		<div class="d-flex flex-row flex-column-fluid page">
			<!--begin::Wrapper-->
			<div class="d-flex flex-column flex-row-fluid wrapper" id="kt_wrapper">
				
				<!--begin::Header-->
				<div id="kt_header" class="header flex-column header-fixed">
					<!--begin::Top-->
					<div class="header-top" style="">
						<!--begin::Container-->
						<div class="container">
							<!--begin::Left-->
							<div class="d-none d-lg-flex align-items-center mr-3">
								<!--begin::Logo-->
								<a href="index.html" class="mr-10">
									<img alt="Logo" src="<c:url value="/resources/assets/media/logos/logo-letter.png"/>" class="max-h-35px" />
								</a>
								<!--end::Logo-->
								<!--begin::Dropdown-->
								<div class="header-switcher dropdown">
									<a href="#" class="btn btn-hover-primary font-weight-bold font-size-sm dropdown-toggle px-6 border-0" data-toggle="dropdown" data-offset="0px,1px" aria-haspopup="true" aria-expanded="false">Applications</a>
									<div class="dropdown-menu p-0 m-0 dropdown-menu-md dropdown-menu-left">
										<!--begin::Navigation-->
										<ul class="navi navi-hover py-5">
											<li class="navi-item">
												<a href="<c:url value="/login"/>" class="navi-link">
													<span class="navi-icon">
														<i class="flaticon-lock"></i>
													</span>
													<span class="navi-text">Login Agent</span>
												</a>
											</li>
											<li class="navi-separator my-3"></li>
											<li class="navi-item">
												<a href="#" class="navi-link">
													<span class="navi-icon">
														<i class="flaticon2-magnifier-tool"></i>
													</span>
													<span class="navi-text">Help</span>
												</a>
											</li>
										</ul>
										<!--end::Navigation-->
									</div>
								</div>
								<!--end::Dropdown-->
							</div>
							<!--end::Left-->
							
							<!--begin::Topbar-->
							<div class="topbar">
								<!--begin::Notifications-->
								<div class="dropdown">
									<!--begin::Toggle-->
									<div class="topbar-item" data-toggle="dropdown" data-offset="10px,0px">
										<div class="btn btn-icon btn-dropdown btn-lg mr-1 pulse pulse-white">
											<span class="svg-icon svg-icon-xl svg-icon-primary">
												<!--begin::Svg Icon | path:assets/media/svg/icons/Code/Compiling.svg-->
												<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
													<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
														<rect x="0" y="0" width="24" height="24" />
														<path d="M2.56066017,10.6819805 L4.68198052,8.56066017 C5.26776695,7.97487373 6.21751442,7.97487373 6.80330086,8.56066017 L8.9246212,10.6819805 C9.51040764,11.267767 9.51040764,12.2175144 8.9246212,12.8033009 L6.80330086,14.9246212 C6.21751442,15.5104076 5.26776695,15.5104076 4.68198052,14.9246212 L2.56066017,12.8033009 C1.97487373,12.2175144 1.97487373,11.267767 2.56066017,10.6819805 Z M14.5606602,10.6819805 L16.6819805,8.56066017 C17.267767,7.97487373 18.2175144,7.97487373 18.8033009,8.56066017 L20.9246212,10.6819805 C21.5104076,11.267767 21.5104076,12.2175144 20.9246212,12.8033009 L18.8033009,14.9246212 C18.2175144,15.5104076 17.267767,15.5104076 16.6819805,14.9246212 L14.5606602,12.8033009 C13.9748737,12.2175144 13.9748737,11.267767 14.5606602,10.6819805 Z" fill="#000000" opacity="0.3" />
														<path d="M8.56066017,16.6819805 L10.6819805,14.5606602 C11.267767,13.9748737 12.2175144,13.9748737 12.8033009,14.5606602 L14.9246212,16.6819805 C15.5104076,17.267767 15.5104076,18.2175144 14.9246212,18.8033009 L12.8033009,20.9246212 C12.2175144,21.5104076 11.267767,21.5104076 10.6819805,20.9246212 L8.56066017,18.8033009 C7.97487373,18.2175144 7.97487373,17.267767 8.56066017,16.6819805 Z M8.56066017,4.68198052 L10.6819805,2.56066017 C11.267767,1.97487373 12.2175144,1.97487373 12.8033009,2.56066017 L14.9246212,4.68198052 C15.5104076,5.26776695 15.5104076,6.21751442 14.9246212,6.80330086 L12.8033009,8.9246212 C12.2175144,9.51040764 11.267767,9.51040764 10.6819805,8.9246212 L8.56066017,6.80330086 C7.97487373,6.21751442 7.97487373,5.26776695 8.56066017,4.68198052 Z" fill="#000000" />
													</g>
												</svg>
												<!--end::Svg Icon-->
											</span>
											<span class="pulse-ring"></span>
										</div>
									</div>
									<!--end::Toggle-->
								</div>
								<!--end::Notifications-->
								<!--begin::User-->
								<div class="topbar-item">
									<div class="btn btn-icon w-auto d-flex align-items-center btn-lg px-2">
										<div class="d-flex text-right pr-3">
											<span class="text-white font-weight-bolder font-size-sm d-none d-md-inline">Iconic Bintaro Property</span>
										</div>
									</div>
								</div>
								<!--end::User-->
							</div>
							<!--end::Topbar-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Top-->
				</div>
				<!--end::Header-->
				<!--begin::Content-->
				<div class="content pt-0 d-flex flex-column flex-column-fluid" id="kt_content">
					<!--begin::Entry-->
					<!--begin::Hero Search Condition-->
					<div class="d-flex flex-row-fluid bgi-size-cover bgi-position-center" style="background-image: url('<c:url value="/resources/assets/media/bg/bg-9.jpg"/>')">
						<div class="container">
							<div class="d-flex align-items-stretch text-center flex-column py-30" style="padding-bottom: 30px !important;">
								<!--begin::Heading-->
								<h1 class="text-dark font-weight-bolder mb-5">Jual Beli Property</h1>
								<!--end::Heading-->
								<!--begin::Form-->
								<form class="d-flex position-relative w-75 px-lg-40 m-auto">
									<div class="input-group">
										<!--begin::Icon-->
										<div class="input-group-prepend">
											<span class="input-group-text bg-white border-0 py-2 px-4">
												<span class="svg-icon svg-icon-primary svg-icon-2x">
													<!--begin::Svg Icon | path:C:\wamp64\www\keenthemes\themes\metronic\theme\html\demo12\dist/../src/media/svg/icons\Map\Marker1.svg-->
													<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
													<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"><rect x="0" y="0" width="24" height="24"/><path d="M5,10.5 C5,6 8,3 12.5,3 C17,3 20,6.75 20,10.5 C20,12.8325623 17.8236613,16.03566 13.470984,20.1092932 C12.9154018,20.6292577 12.0585054,20.6508331 11.4774555,20.1594925 C7.15915182,16.5078313 5,13.2880005 5,10.5 Z M12.5,12 C13.8807119,12 15,10.8807119 15,9.5 C15,8.11928813 13.8807119,7 12.5,7 C11.1192881,7 10,8.11928813 10,9.5 C10,10.8807119 11.1192881,12 12.5,12 Z" fill="#000000" fill-rule="nonzero"/></g>
													</svg>
													<!--end::Svg Icon-->
												</span>
											</span>
										</div>
										<!--end::Icon-->
										<!--begin::Input-->
										<input type="text" class="form-control h-auto border-0 py-2 px-1 font-size-h6" placeholder="Ketik atau Pilih Lokasi" />
										<!--end::Input-->
										<div class="input-group-append">
											<span class="input-group-text bg-white border-0">
												<span class="svg-icon svg-icon-xl">
													<!--begin::Svg Icon | path:assets/media/svg/icons/General/Search.svg-->
													<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
														<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
															<rect x="0" y="0" width="24" height="24" />
															<path d="M14.2928932,16.7071068 C13.9023689,16.3165825 13.9023689,15.6834175 14.2928932,15.2928932 C14.6834175,14.9023689 15.3165825,14.9023689 15.7071068,15.2928932 L19.7071068,19.2928932 C20.0976311,19.6834175 20.0976311,20.3165825 19.7071068,20.7071068 C19.3165825,21.0976311 18.6834175,21.0976311 18.2928932,20.7071068 L14.2928932,16.7071068 Z" fill="#000000" fill-rule="nonzero" opacity="0.3" />
															<path d="M11,16 C13.7614237,16 16,13.7614237 16,11 C16,8.23857625 13.7614237,6 11,6 C8.23857625,6 6,8.23857625 6,11 C6,13.7614237 8.23857625,16 11,16 Z M11,18 C7.13400675,18 4,14.8659932 4,11 C4,7.13400675 7.13400675,4 11,4 C14.8659932,4 18,7.13400675 18,11 C18,14.8659932 14.8659932,18 11,18 Z" fill="#000000" fill-rule="nonzero" />
														</g>
													</svg>
													<!--end::Svg Icon-->
												</span>
											</span>
										</div>
									</div>
								</form>
								<form class="d-flex position-relative w-75 px-lg-40 m-auto">
									<div class="input-group">
										<div class="input-group-prepend"><span class="input-group-text bg-white border-0"><i class="fa fas fa-home" aria-hidden="true"></i></span></div>
										<select class="form-control border-0" id="exampleSelects" aria-describedby="basic-addon2">
											<option>Semua Unit</option>
											<option>Rumah</option>
											<option>Ruko</option>
											<option>Apartement</option>
											<option>Kondominium</option>
											<option>Tanah</option>
											<option>Villa</option>
										</select>
									</div>
									<div class="input-group">
										<div class="input-group-prepend"><span class="input-group-text bg-white border-0"><i class="fa fas fa-bed" aria-hidden="true"></i></span></div>
										<select class="form-control border-0" id="exampleSelects" aria-describedby="basic-addon2">
											<option>Semua Kamar</option>
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5+</option>
										</select>
									</div>
								</form>
								<!--end::Form-->
							</div>
						</div>
					</div>
					<!--end::Hero Search Condition-->
					<!--begin::Section Exclusive Listing-->
					<div class="container py-10">
						<div class="card">
						<!--begin::Row-->
						<div class="row">
						  <div class="col-xl-12">
							<div class="card">
							  <div class="card-body">
								<!--begin::Heading-->
								<div class="d-flex justify-content-between align-items-center mb-7">
								  <h2 class="font-weight-bolder text-dark font-size-h3 mb-0">Exclusive Listing</h2>
								  <!-- <a href="#" class="btn btn-light-primary btn-sm font-weight-bolder">Lihat lebih banyak</a> -->
								</div>
								<!--end::Heading-->
								<!--begin::Products-->
								<div class="row" id="showExclusiveListing">
								  <!--begin::Product-1-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 " />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div
										  class="text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								  <!--begin::Product-2-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>"
											  alt="" class="mw-100" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div
										  class="text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								  <!--begin::Product-3-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>"
											  alt="" class="mw-100" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div
										  class="text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								  <!--begin::Product-4-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div
										  class="text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								</div>
								<!--end::Products-->
							  </div>
							</div>
						  </div>
						</div>
						<!--end::Row-->
						</div>
					</div>
					<!--end::Section Proyek Terkini-->
					<!--begin::Section Hot Listing-->
					<div class="container mb-10">
						<div class="card">
						<!--begin::Row-->
						<div class="row">
						  <div class="col-xl-12">
							<div class="card">
							  <div class="card-body">
								<!--begin::Heading-->
								<div class="d-flex justify-content-between align-items-center mb-7">
								  <h2 class="font-weight-bolder text-dark font-size-h3 mb-0">Hot Listing</h2>
								  <!-- <a href="#" class="btn btn-light-primary btn-sm font-weight-bolder">Lihat lebih banyak</a> -->
								</div>
								<!--end::Heading-->
								<!--begin::Products-->
								<div class="row" id="showHotListing">
								  <!--begin::Product-1-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 zoom img-fluid" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div class="text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
 								  <!--begin::Product-2-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 zoom img-fluid" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div class="text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
 								  <!--begin::Product-3-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 zoom img-fluid" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div class="text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								  <!--begin::Product-4-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 zoom img-fluid" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div class="text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								</div>
								<!--end::Products-->
							  </div>
							</div>
						  </div>
						</div>
						<!--end::Row-->
						</div>
					</div>
					<!--end::Section Hot Listing-->
					<!--begin::Section Show Unit-->
					<div class="container mb-10">
						<div class="card">
						<!--begin::Row-->
						<div class="row">
						  <div class="col-xl-12">
							<div class="card">
							  <div class="card-body">
								<!--begin::Heading-->
								<div class="d-flex justify-content-between align-items-center mb-7">
								  <h2 class="font-weight-bolder text-dark font-size-h3 mb-0">Show Unit</h2>
								  <!-- <a href="#" class="btn btn-light-primary btn-sm font-weight-bolder">Lihat lebih banyak</a> -->
								</div>
								<!--end::Heading-->
								<!--begin::Products-->
								<div class="row" id="showNormalListing">
								  <!--begin::Product-1-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 zoom img-fluid" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div class="text mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								  <!--begin::Product-2-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 zoom img-fluid" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div class="text mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
 								  <!--begin::Product-3-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 zoom img-fluid" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div class="text mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								  <!--begin::Product-4-->
								  <div class="col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3">
									<!--begin::Card-->
									<div class="card card-custom card-shadowless">
									  <div class="card-body p-0">
										<!--begin::Image-->
										<div class="overlay">
										  <div class="overlay-wrapper rounded bg-light text-center">
											<img src="<c:url value="/resources/assets/media/stock-600x400/img-67.jpg"/>" alt="" class="mw-100 zoom img-fluid" />
										  </div>
										</div>
										<!--end::Image-->
										<!--begin::Details-->
										<div class="text mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column">
										  <a href="#" class="font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></a>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										  <span class="font-size-lg"><div class="alert alert-secondary" role="alert" style="padding: 0px;">&nbsp;</div></span>
										</div>
										<!--end::Details-->
									  </div>
									</div>
									<!--end::Card-->
								  </div>
								  <!--end::Product-->
								  
								</div>
								<!--end::Products-->
							  </div>
							</div>
						  </div>
						</div>
						<!--end::Row-->
						</div>
					</div>
					<!--end::Section Show Unit-->
					<!--begin::Section-->
					<div class="container">
						<div class="row">
							<div class="col-xl-6">
								<!--begin::Engage Widget 9-->
								<div class="card card-custom card-stretch gutter-b">
									<div class="card-body d-flex p-0">
										<div class="flex-grow-1 p-20 pb-40 card-rounded flex-grow-1 bgi-no-repeat"
											style="background-color: #c9f7f5; background-position: calc(100% + 0.5rem) bottom; background-size: 70% auto; background-image: url(<c:url value="/resources/assets/media/svg/illustrations/contact.svg"/>)">
											<h2 class="text-dark-75 pb-5 font-weight-bolder">Tanya Properti</h2>
											<p class=".text-dark-75 pb-5 font-size-h5">Punya pertanyaan seputar properti? <br /> Dapatkan jawabannya dari agen properti <br />professional dan para ahli terkemuka</p>
											<a href="#" class="btn btn-danger font-weight-bold py-2 px-6">Ajukan Pertanyaan</a>
											<div class="pt-4">
												<a href="#" class="btn btn-light-danger font-weight-bold py-2 px-6">Cari Pertanyaan</a>
											</div>
										</div>
									</div>
								</div>
								<!--end::Engage Widget 9-->
							</div>
							<div class="col-xl-6">
								<!--begin::Engage Widget 10-->
								<div class="card card-custom card-stretch gutter-b">
								  <div class="card-body d-flex p-0">
								    <div class="flex-grow-1 p-20 pb-40 card-rounded flex-grow-1 bgi-no-repeat"
								      style="background-color: #8950fc; background-position: calc(100% + 0.5rem) bottom; background-size: 50% auto; background-image: url(<c:url value="/resources/assets/media/svg/humans/custom-10.svg"/>)">
								      <h2 class="text-inverse-warning pb-5 font-weight-bolder">Start Now</h2>
								      <p class="text-inverse-warning pb-5 font-size-h5">With our responsive themes and mobile
								        <br />and desktop apps, enjoy a seamless
								        <br />experience on any device so will your
								        <br />blog's common visitors
								      </p>
								      <a href="#" class="btn btn-danger font-weight-bold py-2 px-6">Join Now</a>
								    </div>
								  </div>
								</div>
								<!--end::Engage Widget 10-->
							</div>
						</div>
					</div>
					<!--end::Section-->
					<!--end::Entry-->
				</div>
				<!--end::Content-->
				<!--begin::Footer-->
				<div class="footer bg-white py-4 d-flex flex-lg-column" id="kt_footer">
					<!--begin::Container-->
					<div class="container d-flex flex-column flex-md-row align-items-center justify-content-between">
						<!--begin::Copyright-->
						<div class="text-dark order-2 order-md-1">
							<span class="text-muted font-weight-bold mr-2">2021©</span>
							<a href="http://iconicbp.com" target="_blank" class="text-dark-75 text-hover-primary">iconicbp.com</a>
						</div>
						<!--end::Copyright-->
						<!--begin::Nav-->
						<div class="nav nav-dark order-1 order-md-2">
							<a href="http://iconicbp.com" target="_blank" class="nav-link pr-3 pl-0">About</a>
							<a href="http://iconicbp.com" target="_blank" class="nav-link px-3">Team</a>
							<a href="http://iconicbp.com" target="_blank" class="nav-link pl-3 pr-0">Contact</a>
						</div>
						<!--end::Nav-->
					</div>
					<!--end::Container-->
				</div>
				<!--end::Footer-->
			</div>
			<!--end::Wrapper-->
		</div>
		<!--end::Page-->
	</div>
	<!--end::Main-->
	<!--begin::Scrolltop-->
	<div id="kt_scrolltop" class="scrolltop">
		<span class="svg-icon">
			<!--begin::Svg Icon | path:assets/media/svg/icons/Navigation/Up-2.svg-->
			<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
				<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
					<polygon points="0 0 24 0 24 24 0 24" />
					<rect fill="#000000" opacity="0.3" x="11" y="10" width="2" height="10" rx="1" />
					<path d="M6.70710678,12.7071068 C6.31658249,13.0976311 5.68341751,13.0976311 5.29289322,12.7071068 C4.90236893,12.3165825 4.90236893,11.6834175 5.29289322,11.2928932 L11.2928932,5.29289322 C11.6714722,4.91431428 12.2810586,4.90106866 12.6757246,5.26284586 L18.6757246,10.7628459 C19.0828436,11.1360383 19.1103465,11.7686056 18.7371541,12.1757246 C18.3639617,12.5828436 17.7313944,12.6103465 17.3242754,12.2371541 L12.0300757,7.38413782 L6.70710678,12.7071068 Z" fill="#000000" fill-rule="nonzero" />
				</g>
			</svg>
			<!--end::Svg Icon-->
		</span>
	</div>
	<!--end::Scrolltop-->
	<!--begin::Global Config(global config for global JS scripts)-->
	<script>var KTAppSettings = { "breakpoints": { "sm": 576, "md": 768, "lg": 992, "xl": 1200, "xxl": 1200 }, "colors": { "theme": { "base": { "white": "#ffffff", "primary": "#0BB783", "secondary": "#E5EAEE", "success": "#1BC5BD", "info": "#8950FC", "warning": "#FFA800", "danger": "#F64E60", "light": "#F3F6F9", "dark": "#212121" }, "light": { "white": "#ffffff", "primary": "#D7F9EF", "secondary": "#ECF0F3", "success": "#C9F7F5", "info": "#EEE5FF", "warning": "#FFF4DE", "danger": "#FFE2E5", "light": "#F3F6F9", "dark": "#D6D6E0" }, "inverse": { "white": "#ffffff", "primary": "#ffffff", "secondary": "#212121", "success": "#ffffff", "info": "#ffffff", "warning": "#ffffff", "danger": "#ffffff", "light": "#464E5F", "dark": "#ffffff" } }, "gray": { "gray-100": "#F3F6F9", "gray-200": "#ECF0F3", "gray-300": "#E5EAEE", "gray-400": "#D6D6E0", "gray-500": "#B5B5C3", "gray-600": "#80808F", "gray-700": "#464E5F", "gray-800": "#1B283F", "gray-900": "#212121" } }, "font-family": "Poppins" };</script>
	<!--end::Global Config-->
	
	<!--begin::Global Theme Bundle(used by all pages)-->
	<script src="<c:url value="/resources/assets/plugins/global/plugins.bundle.js"/>"></script>
	<script src="<c:url value="/resources/assets/plugins/custom/prismjs/prismjs.bundle.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/scripts.bundle.js"/>"></script>
	<!--end::Global Theme Bundle-->
	
	<script src="<c:url value="/resources/assets/plugins/custom/fullcalendar/fullcalendar.bundle.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/pages/widgets.js"/>"></script>
	<script src="<c:url value="/resources/scripts/widget.js"/>"></script>
	
	<script type="text/javascript">
		jQuery(document).ready(function() {
			showNormalListing();
			showHotListing();
			showExclusiveListing();
			
			setInterval(showNormalListing, 20000);
			setInterval(showHotListing, 20000);
			setInterval(showExclusiveListing, 20000);
		});
		function showExclusiveListing() {
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/showExclusiveListing",
				data: {},
				success: function(data) {
					var table = document.getElementById("showExclusiveListing");
					var tabledata = "";
					$.each(data.data, function(key, value) {
						tabledata += "<div class='col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3'>";
							tabledata += "<div class='card card-custom card-shadowless'>";
								tabledata += "<div class='card-body p-0'>";
								/* begin-image*/
								tabledata += "<div class='overlay'>";
									tabledata += "<div class='overlay-wrapper rounded bg-light text-center'>";
										tabledata += "<img src='${pageContext.request.contextPath}/resources/templates/"+value.fileName+"' alt='Photo Property' class='mw-100 zoom img-fluid' />";
									tabledata += "</div>";
								tabledata += "</div>";
								/* end-image*/
								/* begin-details */
								tabledata += "<div class='text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column'>";
									tabledata += "<a href='#' class='font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1'>" + value.propertyName + "</a>";
									//tabledata += "<span class='font-size-lg'>Rp." + intToString(value.offerPrice, 1) + "</span>";
									tabledata += "<span class='font-size-lg'>" + capitalizeFirstLetter(value.provinsiName) + ", " + capitalizeFirstLetter(value.cityName) + "</span>";
								tabledata += "</div>";
								/* end-details */
								tabledata += "</div>";
							tabledata += "</div>";
						tabledata += "</div>";
					});
					// show empty data card
					if (data.data.length < 4) {
						var maxLoop = 4-(data.data.length);
						for (i=1; i<=maxLoop; i++) {
							tabledata = dataCard(tabledata,'${pageContext.request.contextPath}');
						}
					}
					table.innerHTML = tabledata; 
				}
			});
		}
		function showHotListing() {
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/showHotListing",
				data: {},
				success: function(data) {
					var table = document.getElementById("showHotListing");
					var tabledata = "";
					$.each(data.data, function(key, value) {
						tabledata += "<div class='col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3'>";
							tabledata += "<div class='card card-custom card-shadowless'>";
								tabledata += "<div class='card-body p-0'>";
								/* begin-image*/
								tabledata += "<div class='overlay'>";
									tabledata += "<div class='overlay-wrapper rounded bg-light text-center'>";
										tabledata += "<img src='${pageContext.request.contextPath}/resources/templates/"+value.fileName+"' alt='Photo Property' class='mw-100 zoom img-fluid' />";
									tabledata += "</div>";
								tabledata += "</div>";
								/* end-image*/
								/* begin-details */
								tabledata += "<div class='text-center mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column'>";
									tabledata += "<a href='#' class='font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1'>" + value.propertyName + "</a>";
									//tabledata += "<span class='font-size-lg'>Rp." + intToString(value.offerPrice, 1) + "</span>";
									//tabledata += "<span class='font-size-lg'>" + capitalizeFirstLetter(value.provinsiName) + ", " + capitalizeFirstLetter(value.cityName) + "</span>";
								tabledata += "</div>";
								/* end-details */
								tabledata += "</div>";
							tabledata += "</div>";
						tabledata += "</div>";
					});
					// show empty data card
					if (data.data.length < 4) {
						var maxLoop = 4-(data.data.length);
						for (i=1; i<=maxLoop; i++) {
							tabledata = dataCard(tabledata,'${pageContext.request.contextPath}');
						}
					}
					table.innerHTML = tabledata; 
				}
			});
		}
		function showNormalListing() {
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/showNormalListing",
				data: {},
				success: function(data) {
					var table = document.getElementById("showNormalListing");
					var tabledata = "";
					$.each(data.data, function(key, value) {
						tabledata += "<div class='col-6 col-sm-6 col-md-3 col-xxl-3 col-lg-3'>";
							tabledata += "<div class='card card-custom card-shadowless'>";
								tabledata += "<div class='card-body p-0'>";
								/* begin-image*/
								tabledata += "<div class='overlay'>";
									tabledata += "<div class='overlay-wrapper rounded bg-light text-center'>";
										tabledata += "<img src='${pageContext.request.contextPath}/resources/templates/"+value.fileName+"' alt='Photo Property' class='mw-100 zoom img-fluid' />";
									tabledata += "</div>";
									tabledata += "<div class='overlay-layer'>";
										tabledata += "<a href='${pageContext.request.contextPath}/details' class='btn font-weight-bolder btn-sm btn-primary mr-2'>View</a>";
									tabledata += "</div>";
								tabledata += "</div>";
								/* end-image*/
								/* begin-details */
								tabledata += "<div class='text mt-5 mb-md-0 mb-lg-5 mb-md-0 mb-lg-5 mb-lg-0 mb-5 d-flex flex-column'>";
									tabledata += "<a href='#' class='font-size-h5 font-weight-bolder text-dark-75 text-hover-primary mb-1'>" + value.propertyName + "</a>";
									tabledata += "<span class='font-size-lg'>Rp." + intToString(value.offerPrice, 1) + "</span>";
									tabledata += "<span class='font-size-lg'>" + capitalizeFirstLetter(value.cityName) + ", " + capitalizeFirstLetter(value.provinsiName) + "</span>";
								tabledata += "</div>";
								/* end-details */
								tabledata += "</div>";
							tabledata += "</div>";
						tabledata += "</div>";
					});
					// show empty data card
					if (data.data.length < 4) {
						var maxLoop = 4-(data.data.length);
						for (i=1; i<=maxLoop; i++) {
							tabledata = dataCard(tabledata,'${pageContext.request.contextPath}');
						}
					}
					table.innerHTML = tabledata; 
				}
			});
		}
	</script>
</body>
</html>