<%-- 
    Document   : UnoForm
    Created on : 13/05/2022, 01:34:33 AM
    Author     : gerdoc
--%>
<form action="DosList.jsp">
    <div class="row mt-4 grey">
        <div class="col">
            <div class="mb-3 mt-3">
                <label for="campo1">Campo 1:</label>
                <input type="number" class="form-control" id="campo1" placeholder="Escribe un número" name="campo1">
            </div>
        </div>
        <div class="col">
            <div class="mb-3 mt-3">
                <label for="campo1">Campo 3:</label>
                <input type="text" class="form-control" id="campo2" placeholder="Escribe una cadena" name="campo2">
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
