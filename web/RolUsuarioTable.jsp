<%-- 
    Document   : RolUsuarioTable
    Created on : 13/05/2022, 01:13:16 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.dao.RolUsuario"%>
<%@page import="org.gerdoc.helper.RolUsuarioHelper"%>
<%@page import="java.util.List"%>
<div class="row">
    <a href="?action=nuevo">
        <button type="button" class="btn btn-outline-primary" >Nuevo</button>
    </a>
    <br/><br/>
</div>
<%
    List<RolUsuario>rolUsuarioList = null;
    rolUsuarioList = new RolUsuarioHelper( ).getList( );
    if( rolUsuarioList == null || rolUsuarioList.size() == 0 )
    {
%>
        <div class="row mt-4">
            <p>Lista rolUsuario sin datos</p>
        </div>
<%            
        return;
    }
%>
        <div class="row">
            <table class="table">
                <thead class="table-primary">
                    <tr>
                        <th>Id</th>
                        <th>Usuario</th>
                        <th>Passsword</th>
                        <th>Correo</th>
                        <th>Rol</th>
                        <th>Descripción</th>
                    </tr>
                </thead>
<%
    for( RolUsuario rolUsuario : rolUsuarioList)
    {
%>
                <tbody>
                    <tr>
                        <td>
                            <%=rolUsuario.getId()%>
                        </td>
                        <td>
                            <%=rolUsuario.getUsuario().getUsuario()%>
                        </td>
                        <td>
                            <%=rolUsuario.getUsuario().getPassword()%>
                        </td>
                        <td>
                            <%=rolUsuario.getUsuario().getCorreo()%>
                        </td>
                        <td>
                            <%=rolUsuario.getRol().getRol()%>
                        </td>
                        <td>
                            <%=rolUsuario.getRol().getDescripcion()%>
                        </td>
                    </tr>
                </tbody>
<%
    }
%>
            </table>
        </div>