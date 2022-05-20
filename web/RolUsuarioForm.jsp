<%-- 
    Document   : UnoForm
    Created on : 13/05/2022, 01:34:33 AM
    Author     : gerdoc
--%>
<%@page import="org.gerdoc.helper.UsuarioHelper"%>
<%@page import="org.gerdoc.dao.Usuario"%>
<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.helper.RolHelper"%>
<form action="RolUsuarioList.jsp">
    <div class="row mt-4 grey">
        <div class="col">
            <div class="mb-3 mt-3">
                <label for="rol">Rol:</label>
                <select class="form-select form-select-sm mb-3" aria-label=".form-select-lg example" id="rol" placeholder="Escribe un rol" name="rol">
                    <option selected>Selecciona un rol</option>
                    <%
                        List<Rol>rolList = new RolHelper( ).getList( );
                        if( rolList != null && rolList.size() > 0 )
                        {
                           for( Rol rol : rolList )
                           {                               
                    %>
                                <option value="<%=rol.getRol()%>"><%=rol.getRol()%></option>
                    <%
                           }
                        }
                    %>
                  </select>
            </div>
        </div>
        <div class="col">
            <div class="mb-3 mt-3">
                <label for="usuario">Usuario:</label>
                <select class="form-select form-select-sm mb-3" aria-label=".form-select-lg example" id="usuario" placeholder="Escribe un usuario" name="usuario">
                    <option selected>Selecciona un usuario</option>
                    <%
                        List<Usuario>usuarioList = new UsuarioHelper( ).getList( );
                        if( usuarioList != null && usuarioList.size() > 0 )
                        {
                           for( Usuario usuario : usuarioList )
                           {
                    %>
                                <option value="<%=usuario.getUsuario()%>"><%=usuario.getUsuario() +"-"+ usuario.getCorreo() %></option>
                    <%
                           }
                        }
                    %>
                  </select>
            </div>
        </div>
    </div>
    <div class="row mt-4 grey">
        <input type="hidden" id="action" name="action" value="send" />
        <div class=""input-group mb-3">
            <button type="submit" class="btn btn-primary">Enviar</button>
            <button type="reset" class="btn btn-primary">Borrar</button>
        </div>
    </div>
</form>
<br/>
<div class="row mt-6">
    <a href="?">
        <button type="button" class="btn btn-outline-primary" >Regresar</button>
    </a>
</div>
