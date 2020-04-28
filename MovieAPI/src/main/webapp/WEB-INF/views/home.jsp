<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport"
	content="width=device-width, 
	initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>영화 정보</title>
</head>
<body>

	<header>

		<!-- 네비게이션 바 -->
		<div class="navbar navbar-dark bg-dark box-shadow sticky-top">

			<div class="container d-flex justify-content-between">

				<a href="/" class="navbar-brand d-flex align-items-center"> <strong
					class="mr-3">영화 검색 </strong> <svg id="i-search"
						xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" width="32"
						height="32" fill="none" stroke="currentcolor"
						stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
				    <circle cx="14" cy="14" r="12" />
				    <path d="M23 23 L30 30" />
				</svg>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="colapse"
					data-target="#navbarHeader" aria-controls="navbarHeader"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

			</div>

		</div>


	</header>

	<main role="main">
		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">영화 검색하기</h1>

				<div class="row mt-4">
					<div class="col-12 col-sm pr-sm-0">
						<input name="query" class="form-control form-control-lg"
							type="text" placeholder="영화 제목을 입력하세요">
					</div>

					<div class="col-12 col-sm-auto pl-sm-0">
						<button id="searchButton" class="btn btn-primary btn-sm">
							<svg id="i-search" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 32 32" width="32" height="32" fill="none"
								stroke="currentcolor" stroke-linecap="round"
								stroke-linejoin="round" stroke-width="2">
									    <circle cx="14" cy="14" r="12" />
									    <path d="M23 23 L30 30" />
										</svg>
						</button>
					</div>
				</div>

			</div>
		</section>

		<!-- 결과 출력 영역 -->
		<div class="container">

			<div class="row">
				<div class="col-md-6">
					<div class="card">
						<img class="card-img-top img-thumbnail"
							src="https://ssl.pstatic.net/imgmovie/mdi/mit110/0475/D7568-00.jpg">
						<div class="card-body">
							<h4 class="card-title">
								<c:out value="${movie.getFormmatedName() }" />
							</h4>
							<p class="card-text">
								<c:out value="${movie.userRating }" />
							</p>
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="card">
						<img class="card-img-top img-thumbnail"
							src="https://ssl.pstatic.net/imgmovie/mdi/mit110/0475/D7568-00.jpg">
						<div class="card-body">
							<h4 class="card-title">
								<c:out value="${movie.getFormmatedName() }" />
							</h4>
							<p class="card-text">
								<c:out value="${movie.userRating }" />
							</p>
						</div>
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="card">
						<img class="card-img-top img-thumbnail"
							src="https://ssl.pstatic.net/imgmovie/mdi/mit110/0475/D7568-00.jpg">
						<div class="card-body">
							<h4 class="card-title">
								<c:out value="${movie.getFormmatedName() }" />
							</h4>
							<p class="card-text">
								<c:out value="${movie.userRating }" />
							</p>
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="card">
						<img class="card-img-top img-thumbnail"
							src="https://ssl.pstatic.net/imgmovie/mdi/mit110/0475/D7568-00.jpg">
						<div class="card-body">
							<h4 class="card-title">
								<c:out value="${movie.getFormmatedName() }" />
							</h4>
							<p class="card-text">
								<c:out value="${movie.userRating }" />
							</p>
						</div>
					</div>
				</div>
				<!-- ./row -->
			</div>
			<!-- ./container -->
		</div>
	</main>

	<footer class="text-muted bg-dark">
		<div class="container pt-3">
			<p class="float-right">
				<a class="text-light" href="#">Back to top</a>
			</p>
			<p class="text-secondary">네이버 영화 API를 이용한 영화 검색 사이트</p>
		</div>

		<div class="footer-copyright text-center pb-3">
			<p class="text-info">
				<span class="text-secondary">&copy; 제 작 : </span>Jong Young Choi
			</p>
			<p class="text-info">
				<span class="text-secondary">@ E-Mail : </span>whddud102@naver.com
			</p>
			<p class="text-info">
				<span class="text-secondary">@ Source : </span><a
					href="https://github.com/whddud102/MovieAPI_Project">github.com/whddud102/MovieAPI_Project</a>
			</p>
		</div>
		<!-- Copyright -->
	</footer>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"
		integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<!-- 검색 동작 처리 스크립트 -->
	<script type="text/javascript">
		$(document).ready(function() {
			
			// 검색 Form 검사
			
			$("#searchButton").on("click", function(event) {
				var val = $("input[name='query']").val();

				if(!val) {
					alert("검색어를 입력해주세요");
				} else {
					alert("검색어 (" + val + ") 요청 성공");
					$.getJSON("/movie/search/" + val, 
						function(data, textStatus, req) {
							console.log(data);
					});
					
				}
			});
			
		})
	
	</script>
</body>
</html>