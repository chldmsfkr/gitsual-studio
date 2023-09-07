<%@page import="com.peisia.domain.GuestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	글 읽기
	<hr>
	글번호:${read.bno}
	<hr>
	글내용:${read.btext}

	<!-- [ ] 글삭제로 이동. 글번호를 넘겨야함. -->
	<a href="/spring/guest/del?bno=${read.bno}">글 삭제</a>

	<!-- [ ] 글 수정으로 이동. 글번호를 넘겨야함. -->
	<a href="/spring/guest/modify?bno=${read.bno}">글 수정</a>

	<!-- [ ] 글 리스트로 이동. -->
	<a href="/spring/guest/getList">글 리스트</a>

</body>
</html>