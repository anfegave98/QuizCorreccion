<%-- 
    Document   : Entidad
    Created on : 16/10/2017, 04:01:13 PM
    Author     : User
--%>

<%@page import="model.Esquema"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
  <title>Esquema</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
    <body background="fondo.jpg">
        <h1>Inserte el Esquema</h1>
        <form action="Esquemas" method="POST">
            Nombre del esquema:
            <input type="text" name="nombre"/>
            <br>
            <br>
         
            <input type="submit" class="btn btn-info" name="Enviar"/>
            <a class="btn btn-info" href="Tabla.jsp" role="button">Crear Tabla</a>
            <a class="btn btn-info" href="index.jsp" role="button">Inicio</a>
        </form>
        <h1>Esquemas</h1>
        <div class="container">
        <div class="row">  
            <div class="col-sm-12">
                <table class="table table-hover table-condensed table-bordered">
                    <tr>
                        <td>Id</td>
                        <td>Nombre</td>
                        <td>Acciones</td>
                    </tr>
                    
                    <% 
                        
                        if (request.getAttribute("listaEsquemas") != null) {
                        ArrayList<Esquema> list = (ArrayList<Esquema>) request.getAttribute("listaEsquemas");
                        if(list!= null)
                            for (Esquema esquema : list) {


                        %>

                         <tr>
                            <td><%=esquema.getId_esquema()%></td>
                            <td><%=esquema.getNombre_esquema()%></td>
                            <td>

                                <button onclick="window.location.href='EditarEsquemas?id=<%=esquema.getId_esquema()%>'" class="btn btn-warning">Editar</button>
                                <button onclick="window.location.href='BorrarEsquemas?id=<%=esquema.getId_esquema()%>'" class="btn btn-danger">Borrar</button>
                            </td>
                        </tr>

                        <% } 
                        }
                        %>
                </table>
            </div>
        </div>
            </div>
    </body>
</html>
