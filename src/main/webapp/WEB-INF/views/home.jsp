<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="x.css" >
<link href="${pageContext.request.contextPath}/resources/x.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container y">
<form:form action="${pageContext.request.contextPath}/books/add" modelAttribute="book" method="post">

<div class="form-group" >
<label class="control-label">ID:</label>
<form:input path="id" class="form-control"/>
</div>

<div class="form-group" >
<label class="control-label">TITLE:</label>
<form:input path="title" class="form-control"/>
</div>

<button type="submit"  name="add" class="btn btn-primary" >Add</button>
<button type="submit"  name="update" class="btn btn-primary x" >Update</button>

</form:form>

<table class="table table-striped y">
<thead class="bg-info">
<tr>
<th>ID</th>
<th>Title</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${books}" var="b">
<tr>
<td>${b.id}</td>
<td>${b.title}</td>
<td>
<a href="${pageContext.request.contextPath}/books/${b.id}" class="btn btn-primary">Edit</a>
<a href="${pageContext.request.contextPath}/books/delete/${b.id}"  class="btn btn-primary">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</body>
</html>