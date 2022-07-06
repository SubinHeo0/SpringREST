<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>content.jsp</h1>
	
	<input type="button" value="내용 수정하기" id="modBtn">
	<input type="button" value="내용 삭제하기" id="delBtn">
	
	<h2>컨트롤러</h2>
	
	글번호 : ${vo.bno } <br>
	제목 : ${vo.title } <br>
	내용 : ${vo.content } <br>
	이름 : ${vo.writer } <br>
	조회수 : ${vo.viewcnt } <br>
	날짜 : ${vo.regdate } <br>
	
	<h2>REST 컨트롤러</h2>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			alert("REST 호출");
			
			$.ajax({
				url : "/controller/boards/${vo.bno}",
				type : "GET",
				success : function(data){
					alert("글 조회 성공");
					console.log(data);
					
					$('body').append("글 번호 : "+data.bno+"<br>");
					$('body').append("글 제목 : "+data.title+"<br>");
					$('body').append("글 내용 : "+data.content+"<br>");
					$('body').append("글 이름 : "+data.writer+"<br>");
					$('body').append("글 날짜 : "+data.regdate+"<br>");
					$('body').append("글 조회수 : "+data.viewcnt+"<br>");
				}
			});	// ajax
			
			// 수정버튼
			$('#modBtn').click(function(){
				alert('수정버튼 클릭');
				// 정보 수정 (제목, 내용, 글쓴이)
				
// 				alert("${vo.title}"+"${vo.bno}");
				
				var modVO = {
					'title' : "${vo.title}"+"-${vo.bno}",
					'content' : "${vo.content}@@@@@",
					'writer' : "${vo.writer}님"
				};
				
// 				alert(modVO);
// 				console.log(modVO);

				// ajax 사용 정보 수정
				$.ajax({
					//url : "/controller/boards/461",
					url : "/controller/boards/${vo.bno}",
					type : "PUT",
					contentType : "application/json",
					data : JSON.stringify(modVO),
					success : function(data){
						if(data == "modOK"){
							alert("수정 동작 완료");
							location.reload();
						} else {
							alert("수정 동작 실패");
							location.reload();
						}
					}
				});
				
			});	// modBtn
			
			
			// 삭제 버튼
			$('#delBtn').click(function(){
				alert('삭제버튼 클릭');
				
				$.ajax({
					url : "/controller/boards/${vo.bno}",
					type : "DELETE",
					success : function(data){
						alert(" 삭제 동작 완료 ");
						if(data == "delOK"){
							location.href="/controller/all";
						}
					},
					erorr : function(){
						alert(" 삭제 동작 실패 ");
					}
				});
				
			});	// delBtn
			
		});
	</script>
	
</body>
</html>