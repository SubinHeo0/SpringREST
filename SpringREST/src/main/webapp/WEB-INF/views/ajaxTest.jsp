<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	
		
		$('#sendBtn').click(function(){
// 			alert('버튼 클릭');
			// 정보를 REST컨트롤러로 전달
			
			// 전달정보(객체)
			var member = {
				'name' : $('#txt').val(),
				'tel' : '010-1234-1234',
				'age' : 20
			};
			
// 			alert(member);
			console.log(member);
			
			// 위 객체를 REST 컨트롤러를 통해서 처리(ajax)
			$.ajax({
				type:"POST",
				url : "${pageContext.request.contextPath}/info",
				//data : {'name':200,'tel':'010-1234-1234'}
				data : JSON.stringify(member),
				contentType: "application/json",
				success : function(data){
					alert("성공");
				}
				
				
			});	// ajax끝
		
		});	// 버튼클릭 끝
	
	});	
	

</script>

</head>
<body>
	<h1>ajaxTest.jsp</h1>
	<input type="text" id="txt">
	
	<input type="button" value="send" id="sendBtn">
</body>
</html>