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
<h1>Formulario buscar libro</h1>
<form action="getLibro" method="get">
    <input type="text" name="id" placeholder="Id del Libro">
    <button type="submit">Enviar</button>
</form>
<br>
<h1>Formulario agregar libro</h1>
<form action="addLibro" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="autor" placeholder="autor">
    <input type="text" name="categoria" placeholder="categoria">
    <button type="submit">Enviar</button>
</form>
</body>
</html>