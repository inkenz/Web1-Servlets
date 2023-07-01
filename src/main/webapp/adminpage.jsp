<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
		<%
    		if(session.getAttribute("admin")==null){
    			response.sendRedirect("login.jsp");
    		}
    	%>
		<fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
            <form action="AdminServlet" method="POST">
                <fieldset >
                    <input type="submit" value="<fmt:message key="cadastro_hotel"/>" name="BT1"/>
                    <input type="submit" value="<fmt:message key="cadastro_site"/>" name="BT2"/>
                </fieldset>
            </form>
        </fmt:bundle>
</body>
</html>