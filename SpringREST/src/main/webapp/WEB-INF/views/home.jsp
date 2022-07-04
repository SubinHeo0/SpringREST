<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert('jQuery Call~');
		
		$('#checkBtn').click(function(){
			
			$.ajax({
				//url:'/controller/test1',
				url:'${pageContext.request.contextPath}/test3',
				type:"GET",
				success:function(data){
					alert('SUCCESS!!');
					
					//$('body').append("전달 값 : "+data+"<br>");
					$('body').append("전달 값 : "+data[0].name+"<br>");
					$('body').append("전달 값 : "+data[0].tel+"<br>");
					$('body').append("전달 값 : "+data[0].age+"<br>");
				}
			});
			
		});
		
	});

</script>


</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<input type="button" value="BTN" id="checkBtn">
</body>
</html>
