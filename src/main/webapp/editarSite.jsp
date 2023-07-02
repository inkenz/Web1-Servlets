<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Site" %>
    
<%
	List<Site> lista = (List<Site>) request.getAttribute("sites");

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
            <form action="EditarSite" method="POST">
                <fieldset >
                    <legend><fmt:message key="editar_hotel"/></legend>
                    <select name="site">
                    	<%for(int i = 0; i<lista.size(); i++){ %>
                    		<option value=<%=lista.get(i).getURL() %>>
                    			<%=lista.get(i).getNome()%>
                    		</option>
                    	<%} %>
                    </select> <br/>
                    <fmt:message key="password"/> <input type="password" name="senha"/><br/>
                    <fmt:message key="name_site"/><input type="text" name="nome"/><br/>
                    <fmt:message key="telefone"/><input type="text" name="telefone"/><br/>
                    
                    
                    <input type="submit" value="<fmt:message key="confirmar"/>" name="EDITAR"/>
                    <input type="submit" value="<fmt:message key="apagar"/>" name="APAGAR"/>
                </fieldset>
            </form>
        </fmt:bundle>
</body>
</html>