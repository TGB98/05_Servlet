const goToList = documnet.querySelector("#goToList"); // 목록으로 버튼.

// 목록으로 버튼이 클릭된 경우
goToList.addEventListener("click", () => {
	// "/" (메인 페이지) 요청 (Get 방식)
	location.href = "/";
});