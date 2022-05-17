<%-- 
    Document   : UsuarioTable
    Created on : 13/05/2022, 01:13:16 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.dao.Usuario"%>
<%@page import="org.gerdoc.helper.UsuarioHelper"%>
<%@page import="java.util.List"%>
<div class="row">
    <a href="?action=nuevo">
        <button type="button" class="btn btn-outline-primary" >Nuevo</button>
    </a>
    <br/><br/>
</div>
<%
    List<Usuario>usuarioList = null;
    usuarioList = new UsuarioHelper( ).getList( );
    if( usuarioList == null || usuarioList.size() == 0 )
    {
%>
        <div class="row mt-4">
            <p>Lista usuario sin datos</p>
        </div>
<%            
        return;
    }
%>
        <div class="row">
            <table class="table">
                <thead class="table-primary">
                    <tr>
                        <th>Usuario</th>
                        <th>Password</th>
                        <th>Correo</th>
                    </tr>
                </thead>
<%
    for( Usuario usuario : usuarioList)
    {
%>
                <tbody>
                    <tr>
                        <td>
                            <%=usuario.getUsuario()%>
                        </td>
                        <td>
                            <%=usuario.getPassword()%>
                        </td>
                        <td>
                            <%=usuario.getCorreo()%>
                        </td>
                    </tr>
                </tbody>
<%
    }
%>
            </table>
        </div>