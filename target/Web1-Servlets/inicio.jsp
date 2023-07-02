<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
    	<fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
        <title><fmt:message key="pagina_inicial"/></title>
		</fmt:bundle>
    </head>
    <body>
        <fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
            <form action="Inicio" method="POST" accept-charset="UTF-8">
                <fieldset >
                    <legend><fmt:message key="pagina_inicial"/></legend>
                    <input type="submit" value="<fmt:message key="login"/>" name="BT1"/><br/>
 					<input type="submit" value="<fmt:message key="lista_hotel"/>" name="BT2"/><br/>
                </fieldset>
            </form>
        </fmt:bundle>
    </body>
</html>
