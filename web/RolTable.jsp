<%-- 
    Document   : RolTable
    Created on : 13/05/2022, 01:13:16 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.dao.Rol"%>
<%@page import="org.gerdoc.helper.RolHelper"%>
<%@page import="java.util.List"%>
<div class="row">
    <a href="?action=nuevo">
        <button type="button" class="btn btn-outline-primary" >Nuevo</button>
    </a>
    <br/><br/>
</div>
<%
    List<Rol>rolList = null;
    rolList = new RolHelper( ).getList( );
    if( rolList == null || rolList.size() == 0 )
    {
%>
        <div class="row mt-4">
            <p>Lista rol sin datos</p>
        </div>
<%            
        return;
    }
%>
        <div class="row">
            <table class="table">
                <thead class="table-primary">
                    <tr>
                        <th>Rol</th>
                        <th>Descripción</th>
                    </tr>
                </thead>
<%
    for( Rol rol : rolList)
    {
%>
                <tbody>
                    <tr>
                        <td>
                            <%=rol.getRol()%>
                        </td>
                        <td>
                            <%=rol.getDescripcion()%>
                        </td>
                    </tr>
                </tbody>
<%
    }
%>
            </table>
        </div>