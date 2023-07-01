<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar novo hotel</title>
</head>
<body>
	<h1>Cadastrar novo hotel</h1>
	<form name="frmHotel" action="">
		<table>
			<tr>
				<td><input type="text" name="email" placeholder="Email"></td>
			</tr>
			<tr>
				<td><input type="password" name="senha" placeholder="Email"></td>
			</tr>
			<tr>
				<td><input type="text" name="cnpj" placeholder="Email"></td>
			</tr>
		</table>
	</form>
</body>
</html>