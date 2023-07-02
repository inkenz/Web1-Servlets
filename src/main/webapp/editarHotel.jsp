<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Hotel" %>
    
<%
	List<Hotel> lista = (List<Hotel>) request.getAttribute("hoteis");
%>

<%
    		if(session.getAttribute("admin")==null || lista == null){
    			response.sendRedirect("login.jsp");
    		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
            <form action="EditarHotel" method="POST" accept-charset="UTF-8">
                <fieldset >
                    <legend><fmt:message key="editar_hotel"/></legend>
                    <select name="hotel">
                    	<%for(int i = 0; i<lista.size(); i++){ %>
                    		<option value=<%=lista.get(i).getCNPJ() %>>
                    			<%=lista.get(i).getNome()%>
                    		</option>
                    	<%} %>
                    </select> <br/>
                    <fmt:message key="password"/> <input type="password" name="senha"/><br/>
                    <fmt:message key="name_hotel"/><input type="text" name="nome"/><br/>
                    <fmt:message key="city"/><input type="text" name="cidade"/><br/>
                    
                    
                    <input type="submit" value="<fmt:message key="confirmar"/>" name="EDITAR"/>
                    <input type="submit" value="<fmt:message key="apagar"/>" name="APAGAR"/>
                </fieldset>
            </form>
        </fmt:bundle>
</body>
</html>
