<%-- 
    Document   : UnoTable
    Created on : 13/05/2022, 01:13:16 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.helper.UnoHelper"%>
<%@page import="java.util.List"%>
<%@page import="org.gerdoc.dao.Uno"%>

<div class="row">
    <a href="?action=nuevo">
        <button type="button" class="btn btn-outline-primary" >Nuevo</button>
    </a>
    <br/><br/>
</div>
<%
    List<Uno>unoList = null;
    unoList = new UnoHelper( ).getList( );
    if( unoList == null || unoList.size() == 0 )
    {
%>
        <div class="row mt-4">
            <p>Lista uno sin datos</p>
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
                        <th>CAMPO 3</th>
                        <th>CAMPO 4</th>
                    </tr>
                </thead>
<%
    for( Uno uno : unoList)
    {
%>
                <tbody>
                    <tr>
                        <td>
                            <%=uno.getId()%>
                        </td>
                        <td>
                            <%=uno.getCampo1()%>
                        </td>
                        <td>
                            <%=uno.getCampo2()%>
                        </td>
                        <td>
                            <%=uno.getCampo3()%>
                        </td>
                        <td>
                            <%=uno.getCampo4()%>
                        </td>
                    </tr>
                </tbody>
<%
    }
%>
            </table>
        </div>