var getOnlyDecimal = function(_number) {
	var result;
	result = _number % 1;
	result = Number(result.toFixed(1));
	return result;
};

var makeStarHTML = function(movie) {
	var starScore = movie.userRating * 0.5; // 평점을 별점으로 환산한 값
	var starFill = Math.floor(starScore);
	var starHalf = getOnlyDecimal(starScore) >= 0.5 ? 1 : 0;
	var starEmpty = 5 - (starFill + starHalf);

	var str = "";
	for (var num = 0; num < starFill; num++) {
		str += "<svg class='bi bi-star-fill' width='1em' height='1em' viewBox='0 0 16 16' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>";
		str += "<path d='M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.283.95l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z'/>";
		str += "</svg>";
	}

	for (var num = 0; num < starHalf; num++) {
		str += "<svg class='bi bi-star-half' width='1em' height='1em' viewBox='0 0 16 16' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>";
		str += "<path fill-rule='evenodd' d='M5.354 5.119L7.538.792A.516.516 0 018 .5c.183 0 .366.097.465.292l2.184 4.327 4.898.696A.537.537 0 0116 6.32a.55.55 0 01-.17.445l-3.523 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256a.519.519 0 01-.146.05c-.341.06-.668-.254-.6-.642l.83-4.73L.173 6.765a.55.55 0 01-.171-.403.59.59 0 01.084-.302.513.513 0 01.37-.245l4.898-.696zM8 12.027c.08 0 .16.018.232.056l3.686 1.894-.694-3.957a.564.564 0 01.163-.505l2.906-2.77-4.052-.576a.525.525 0 01-.393-.288L8.002 2.223 8 2.226v9.8z' clip-rule='evenodd'/>";
		str += "</svg>";
	}

	for (var num = 0; num < starEmpty; num++) {
		str += "<svg class='bi bi-star' width='1em' height='1em' viewBox='0 0 16 16' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>";
		str += "<path fill-rule='evenodd' d='M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.523-3.356c.329-.314.158-.888-.283-.95l-4.898-.696L8.465.792a.513.513 0 00-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767l-3.686 1.894.694-3.957a.565.565 0 00-.163-.505L1.71 6.745l4.052-.576a.525.525 0 00.393-.288l1.847-3.658 1.846 3.658a.525.525 0 00.393.288l4.052.575-2.906 2.77a.564.564 0 00-.163.506l.694 3.957-3.686-1.894a.503.503 0 00-.461 0z' clip-rule='evenodd'/>";
		str += "</svg>";
	}

	return str;
};

var makeImgHTML = function(movie) {
	var result = "";

	if (movie.image == "") {
		result += "<div class='d-flex justify-content-center'><svg class='bi bi-exclamation-triangle' width='1em' height='1em' viewBox='0 0 16 16' fill='currentColor' xmlns='http://www.w3.org/2000/svg'>";
		result += "<path fill-rule='evenodd' d='M7.938 2.016a.146.146 0 00-.054.057L1.027 13.74a.176.176 0 00-.002.183c.016.03.037.05.054.06.015.01.034.017.066.017h13.713a.12.12 0 00.066-.017.163.163 0 00.055-.06.176.176 0 00-.003-.183L8.12 2.073a.146.146 0 00-.054-.057A.13.13 0 008.002 2a.13.13 0 00-.064.016zm1.044-.45a1.13 1.13 0 00-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566z' clip-rule='evenodd'/>";
		result += "<path d='M7.002 12a1 1 0 112 0 1 1 0 01-2 0zM7.1 5.995a.905.905 0 111.8 0l-.35 3.507a.552.552 0 01-1.1 0L7.1 5.995z'/>";
		result += "</div></svg>";
		result += "<p class='text-center'>이미지가<br>없습니다</p>";

	} else {
		result += "<a href='" + movie.link + "' target='_blank'>";
		result += "<img class='img-thumbnail align-middle border border-dark' src='"
				+ movie.image + "'></a>";
	}

	return result;
};

var makeMovieItemHTML = function(movie) {
	var str = "";

	str += "<div class='row alin-items-center h-100'>";
	str += "<div class='col-5 m-auto'>";
	str += makeImgHTML(movie);
	str += "</div>";
	str += "<div class='col-7 m-auto'>";
	str += "<p class='text-center font-weight-bold'><a href='" + movie.link
			+ "' target='_blank'>" + movie.title + "</a></p>";
	str += "<p class='text-center'><strong>(" + movie.pubDate + ")</strong></p>";
	str += "<p class='text-center'>";
	str += makeStarHTML(movie);
	str += "</div>";
	str += "</div>";

	return str;
}

var calculateRow = function(numItems) {
	var numRow;

	if (numItems <= 3) {
		numRow = 1;
	} else if (numItems <= 6) {
		numRow = 2;
	} else {
		numRow = 3;
	}

	return numRow;
}

var makeResultHTML = function(numRow, items) {
	var itemNum_forRow = 3; // 한 줄에 출력할 영화 개수
	var str = "";

	for (var row = 0; row < numRow; row++) {
		str += "<div class='row my-2'>"

		// items에서 영화 item을 가져올 인덱스
		var idxStart = itemNum_forRow * row;
		var idxEnd = idxStart + itemNum_forRow;

		for (var idx = idxStart; idx < idxEnd; idx++) {
			var movie = items[idx];

			str += "<div class='col-md-4 py-2 border bg-light rounded'>";

			if (movie != null) {
				str += makeMovieItemHTML(movie);
			}
			str += "</div>";
		}

		str += "</div>"
	}

	return str;
}

var makePageNav = function(pageDTO) {

	var resultStr = "";
	var prevPageVal = parseInt(pageDTO.startPage) - 1;
	var nextPageVal = parseInt(pageDTO.endPage) + 1;
	
	// 이전 버튼을 누를 수 있을 경우
	if (pageDTO.prev) {
		resultStr += "<li class='page-item'>";
	} else {
		resultStr += "<li class='page-item disabled'>";
	}
	
	resultStr += "<a class='page-link' href='" + prevPageVal + "' aria-label='Previous'>&laquo;</a></li>";

	for (var num = pageDTO.startPage; num <= pageDTO.endPage; num++) {
		resultStr += "<li class='page-item'><a class='page-link' href='" + num + "'>"
				+ num + "</a></li>";
	}

	// 다음 버튼을 누를 수 있을 경우sss
	if (pageDTO.next) {
		resultStr += "<li class='page-item'>";
	} else {
		resultStr += "<li class='page-item disabled'>";
	}
	
	resultStr += "<a class='page-link' href='" + nextPageVal + "' aria-label='Next'>&raquo;</a></li>";

	return resultStr;
}

var showList = function(pageDTO) {
	var api_ResponseVO = pageDTO.api_ResponseVO;
	var items = api_ResponseVO.items;
	var numRow = calculateRow(items.length);
	var resultStr = makeResultHTML(numRow, items);
	var paginationStr = makePageNav(pageDTO);
	
	console.log(api_ResponseVO);
	
	$("#div_searchResult").html(resultStr);
	$("#paginationList").html(paginationStr);
}
