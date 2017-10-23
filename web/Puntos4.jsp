

<%@page import="model.Tabla"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Punto4</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body background="fondo.jpg">
        <h1>Consulta</h1>
        <form action="Punto4" method="GET">
            Id Tablas a Listar:
            <input type="text" name="idunidad"/>
            <br>
            <br>  
            <input type="submit" class="btn btn-info" name="enviar"/>
            <a class="btn btn-info" href="index.jsp" role="button">Inicio</a>
        </form>

        <h1>Lista de tablas</h1>
        <div class="container">
            <div class="row">  
                <div class="col-sm-12">
                    <table class="table table-hover table-condensed table-bordered">
                        <tr>
                            <td>Id Tabla</td>
                            <td>Nombre Tabla</td>
                            <td>Nombre Columna</td>
             

                        </tr>
                        <% if (request.getAttribute("listaPunto4") != null) {
                                ArrayList<Tabla> list = (ArrayList<Tabla>) request.getAttribute("listaPunto4");
                                if (list != null)
                                    for (Tabla tabla : list) {


                        %>
                        <tr>
                            <td><%=tabla.getId_tabla()%></td>
                            <td><%=tabla.getNombre_tabla()%></td>
                            <td><%=tabla.getNombre_columna()%></td>
                          
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
