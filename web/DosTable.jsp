<%-- 
    Document   : DosTable
    Created on : 13/05/2022, 01:13:16 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.dao.Dos"%>
<%@page import="org.gerdoc.helper.DosHelper"%>
<%@page import="java.util.List"%>
<div class="row">
    <a href="?action=nuevo">
        <button type="button" class="btn btn-outline-primary" >Nuevo</button>
    </a>
    <br/><br/>
</div>
<%
    List<Dos>dosList = null;
    dosList = new DosHelper( ).getList( );
    if( dosList == null || dosList.size() == 0 )
    {
%>
        <div class="row mt-4">
            <p>Lista dos sin datos</p>
        </div>
<%            
        return;
    }
%>
        <div class="row">
            <table class="table">
                <thead class="table-primary">
                    <tr>
                        <th>ID</th>
                        <th>CAMPO 1</th>
                        <th>CAMPO 2</th>
                    </tr>
                </thead>
<%
    for( Dos dos : dosList)
    {
%>
                <tbody>
                    <tr>
                        <td>
                            <%=dos.getId()%>
                        </td>
                        <td>
                            <%=dos.getCampo1()%>
                        </td>
                        <td>
                            <%=dos.getCampo2()%>
                        </td>
                    </tr>
                </tbody>
<%
    }
%>
            </table>
        </div>