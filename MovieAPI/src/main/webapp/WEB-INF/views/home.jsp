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
		<div class="container" id="div_searchResult">
			<!-- 영화 검색 결과가 출력 될 영역 -->
			<div class="row h-100 bg-info">
				<div class="col my-5">
					<h1 class="text-center">영화를 검색해주세요</h1>
				</div>
			</div>
		</div>
		<!-- ./container -->
	</main>

	<footer class="text-muted bg-dark fixed-bottom position-relative">
		<div class="container pt-3 mt-3">
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

<!-- 검색 결과 출력을 도와주는 스크립트 -->
<script type="text/javascript">
	var getOnlyDecimal = function(_number) {
	  var result;
	  result = _number % 1;
	  result  = Number(result .toFixed(1));
	  return result;
	};
	
	var makeStarHTML = function(movie) {
		var starScore = movie.userRating * 0.5;		// 평점을 별점으로 환산한 값
		var starFill = Math.floor(starScore);
		var starHalf = getOnlyDecimal(starScore) >= 0.5 ? 1 : 0; 
		var starEmpty = 5 - (starFill + starHalf);
		
		var str = "";
		for(var num = 0; num < starFill; num++) {
			str +=  "<svg class='bi bi-star-fill' width='1em' height='1em' viewBox='0 0 16 16' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>";
			str +=  "<path d='M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z'/>";
			str +=	 "</svg>";
		}
		
		for(var num = 0; num < starHalf; num++) {
			str +=  "<svg class='bi bi-star-half' width='1em' height='1em' viewBox='0 0 16 16' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>";
			str +=  "<path fill-rule='evenodd' d='M5.354 5.119L7.538.792A.516.516 0 018 .5c.183 0 .366.097.465.292l2.184 4.327 4.898.696A.537.537 0 0116 6.32a.55.55 0 01-.17.445l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256a.519.519 0 01-.146.05c-.341.06-.668-.254-.6-.642l.83-4.73L.173 6.765a.55.55 0 01-.171-.403.59.59 0 01.084-.302.513.513 0 01.37-.245l4.898-.696zM8 12.027c.08 0 .16.018.232.056l3.686 1.894-.694-3.957a.564.564 0 01.163-.505l2.906-2.77-4.052-.576a.525.525 0 01-.393-.288L8.002 2.223 8 2.226v9.8z' clip-rule='evenodd'/>";
			str +=	 "</svg>";
		}
		
		for(var num = 0; num < starEmpty; num++) {
			str += "<svg class='bi bi-star' width='1em' height='1em' viewBox='0 0 16 16' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>";
			str +=  "<path fill-rule='evenodd' d='M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.523-3.356c.329-.314.158-.888-.283-.95l-4.898-.696L8.465.792a.513.513 0 00-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767l-3.686 1.894.694-3.957a.565.565 0 00-.163-.505L1.71 6.745l4.052-.576a.525.525 0 00.393-.288l1.847-3.658 1.846 3.658a.525.525 0 00.393.288l4.052.575-2.906 2.77a.564.564 0 00-.163.506l.694 3.957-3.686-1.894a.503.503 0 00-.461 0z' clip-rule='evenodd'/>";
			str += "</svg>";
		}
		
		return str;
	};
	
	var makeImgHTML = function(movie) {
		var result = "";
		
		if(movie.image == "") {
			result += "<div class='d-flex justify-content-center'><svg class='bi bi-exclamation-triangle' width='1em' height='1em' viewBox='0 0 16 16' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>";
			result += "<path fill-rule='evenodd' d='M7.938 2.016a.146.146 0 00-.054.057L1.027 13.74a.176.176 0 00-.002.183c.016.03.037.05.054.06.015.01.034.017.066.017h13.713a.12.12 0 00.066-.017.163.163 0 00.055-.06.176.176 0 00-.003-.183L8.12 2.073a.146.146 0 00-.054-.057A.13.13 0 008.002 2a.13.13 0 00-.064.016zm1.044-.45a1.13 1.13 0 00-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566z' clip-rule='evenodd'/>";
			result += "<path d='M7.002 12a1 1 0 112 0 1 1 0 01-2 0zM7.1 5.995a.905.905 0 111.8 0l-.35 3.507a.552.552 0 01-1.1 0L7.1 5.995z'/>";
			result += "</div></svg>";
			result += "<p class='text-center'>이미지가<br>없습니다</p>";
			
			console.log(result);
		} else {
			result += "<a href='" + movie.link +  "' target='_blank'>";
			result += "<img class='img-thumbnail align-middle border border-dark' src='" + movie.image + "'></a>";			
		}
		
		return result;
	};
</script>


	<!-- 검색 동작 처리 스크립트 -->
	<script type="text/javascript">
	
		$(document).ready(function() {
				var itemNum_forRow = 3;
			// 검색 Form 검사
			$("#searchButton").on("click", function(event) {
				var val = $("input[name='query']").val();
				
				if(!val) {
					alert("검색어를 입력해주세요");
				} else {
					alert("검색어 (" + val + ") 요청 성공");
					
					$.getJSON("/movie/search/" + val, 
							function(items, textStatus, req) {
								
								console.log(items);
						
								var rowNum;
								var str ="";
								
								if(items.length <= 3) {
									rowNum = 1;
								} else if (items.length <= 6) {
									rowNum = 2;
								} else {
									rowNum = 3;
								}	
								
								for(var row = 0; row < rowNum; row++) {
									str += "<div class='row m-1 p-1'>"
									
									// items에서 영화 item을 가져올 인덱스
									var idxStart = itemNum_forRow * row;
									var idxEnd = idxStart + itemNum_forRow;
									
									for(var idx = idxStart; idx < idxEnd; idx++) {
										var movie = items[idx];
									
										str += "<div class='col-md-4 py-2 border bg-light rounded'>";
										
										if(movie != null) { 
											str += 		"<div class='row alin-items-center h-100'>";
											str += 			"<div class='col-5 m-auto'>";
											str += 				makeImgHTML(movie);
											str +=			 "</div>";
											str += 			"<div class='col-7 m-auto'>";
											str += 				"<p class='text-center font-weight-bold'>" + movie.title + "</p>";
											str += 				"<p class='text-center'>";
											str +=				makeStarHTML(movie);
											str += 			"</div>";
											str += 		"</div>";
											
										}
											str += "</div>";
									}
									
									str += "</div>"
								}
								
								$("#div_searchResult").html(str);
					});
				};
			});
		});
	</script>
</body>
</html>