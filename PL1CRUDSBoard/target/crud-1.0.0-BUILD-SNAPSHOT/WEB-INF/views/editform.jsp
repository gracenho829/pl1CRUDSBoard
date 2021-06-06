<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.spring.crud.BoardDAO, com.spring.crud.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>


<h1>Edit Form</h1>
<form action="../editok" method="post">
<!--  send form to editpost.jsp with method post -->
<input type="hidden" name="seq" value="${u.seq}"/>
<!-- this input is hidden from viewers and is something only developers can see
it has the value of the sequence of u. -->
<table>
<tr><td>Category:</td><td><input type = "text" name = "category" value = "${u.category }"/></td></tr>
<tr><td>Title:</td><td><input type="text" name="title" value="${u.title }"/></td></tr>
<tr><td>Writer:</td><td><input type="text" name="writer" value="${u.writer}" /></td></tr>
<tr><td>Content:</td><td><textarea cols="50" rows="5" name="content">${ u.content}</textarea></td></tr>
<!--  this form has the values of the original Title, Writer, and content that 
was saved in the text input 칸. -->
<!--  this table cell has the input type button of submit with Edit Post as the title -->
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
<!--  cancel goes back on the action. 는 히스토리에서 전 단계로 이동해준 -->
</table>
</form>

</body>
</html>