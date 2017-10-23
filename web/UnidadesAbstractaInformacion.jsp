

<%@page import="model.UnidadAbstractaInformacionn"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>UnidadAbstractaInformacion </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body background="fondo.jpg">
        <h1>Inserte la Unidad Abstracta Informacion</h1>
        <form action="UnidadAbstractaInformacion" method="POST">
            Id Context:
            <input type="text" name="id_contexto"/>
            Id Tabla:
            <input type="text" name="id_tabla"/>
            <br>
            <br>
            <input type="submit" class="btn btn-info" name="enviar"/>
            <a class="btn btn-info" href="Punto4" role="button">Consulta Punto 4</a>
            <a class="btn btn-info" href="index.jsp" role="button">Inicio</a>
            
        </form>

        <h1>Unidad Abstracta Informacion</h1>
        <div class="container">
            <div class="row">  
                <div class="col-sm-12">
                    <table class="table table-hover table-condensed table-bordered">
                        <tr>
                            <td>Id</td>
                            <td>Id Contexto</td>
                            <td>Id Tabla</td>

                        </tr>
                        <% if (request.getAttribute("listaUnidades") != null) {
                                ArrayList<UnidadAbstractaInformacionn> list = (ArrayList<UnidadAbstractaInformacionn>) request.getAttribute("listaUnidades");
                                if (list != null)
                                    for (UnidadAbstractaInformacionn und : list) {


                        %>
                        <tr>
                            <td><%=und.getId_unidadabs()%></td>
                            <td><%=und.getId_contexto()%></td>
                            <td><%=und.getId_tabla()%></td>
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
