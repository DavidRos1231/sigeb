<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="getLibros">getLibro</a>
<form action="getLibro" method="get">
    <input type="text" name="id">
    <button type="submit">Enviar</button>
</form>
</body>
</html>