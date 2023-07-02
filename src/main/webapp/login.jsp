<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
            <form action="Login" method="POST" accept-charset="UTF-8">
                <fieldset >
                    <legend><fmt:message key="login"/></legend>
                    <fmt:message key="user"/><input type="text" name="usuario" /><br/>
                    <fmt:message key="password"/><input type="password" name="senha" /><br/>
                    <input type="submit" value="<fmt:message key="submit_login"/>" />
                </fieldset>
            </form>
        </fmt:bundle>


    </body>
</html>
