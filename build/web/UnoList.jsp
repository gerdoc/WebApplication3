<%-- 
    Document   : UnoList
    Created on : 12/05/2022, 01:56:02 PM
    Author     : Alumno
--%>

<%@page import="org.gerdoc.helper.UnoHelper"%>
<%@page import="org.gerdoc.dao.Uno"%> 
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.service.MySqlConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <title>Uno List</title>
    </head>
    
        <div class="container-fluid p-5 bg-primary text-white text-center">
            Lista Uno
        </div>
        <div class="container mt-4"> 
            <%
                if( request == null )
                {
                    return;
                }
                String action = request.getParameter( "action" );
                if( action == null )
                {
                    action = "";
                }
                switch( action )
                {
                    case "nuevo":
                    case "editar":
            %>
                        <jsp:include page="UnoForm.jsp" />
            <%
                        break;
                    case "send":
                        if( new UnoHelper( ).addUno(request) )
                        {
                            response.sendRedirect("UnoList.jsp");
                        }
                        break;
                    case "delete":
                        if( new UnoHelper( ).deleteUno(request) )
                        {
                            response.sendRedirect("UnoList.jsp");
                        }
                        break;
                    case "actualizar":
                        if( new UnoHelper( ).updateUno(request) )
                        {
                            response.sendRedirect("UnoList.jsp");
                        }
                        break;
                    default:
            %>
                        <jsp:include page="UnoTable.jsp" />
            <%
                }
            %>
        </div>
</html>
