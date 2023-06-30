<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<!-- Isso é usado para fazer a internacionalização -> <fmt:bundle basename="message"> -->

    <head>
        <title>
            <fmt:message key="Promoções loucas" />
        </title>
    </head>

    <body>
        <h1 style="text-align: center;"> Promoções loucas</h1>
        <a href="Hotel">CRUD Hotéis</a>
        <br>
        <a href="Site">CRUD Sites de Reservas</a>
        <br><br>
        <a href="?">Listar todos os hotéis</a>
        <br>
        <a href="?">Listar todos os hotéis por cidade</a>
        <br><br>
        <a href="?">Criar promoções de hotel</a>
        <br>
        <a href="?">Listar promoções de um hotel</a>
        <br>
        <a href="?">Listar promoções de um site de reserva</a>
    </body>
<!--</fmt:bundle>-->

</html>
