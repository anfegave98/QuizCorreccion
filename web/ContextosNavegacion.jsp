

<%@page import="model.ContextoNavegacionn"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Contexto Navegacion</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body background="fondo.jpg">
        <h1>Inserte el Contexto Navegacion</h1>
        <form action="ContextoNavegacion" method="POST">
            Link:
            <input type="text" name="Link"/>
            Id Modelo Navegacion:
            <input type="text" name="id_modelo"/>
            <br>
            <br>  
            <input type="submit" class="btn btn-info" name="enviar"/>
            <a class="btn btn-info" href="UnidadAbstractaInformacion" role="button">Crear Unidad Abstracta</a>
            <a class="btn btn-info" href="index.jsp" role="button">Inicio</a>
        </form>

        <h1>Contextos Navegacion</h1>
        <div class="container">
            <div class="row">  
                <div class="col-sm-12">
                    <table class="table table-hover table-condensed table-bordered">
                        <tr>
                            <td>Id</td>
                            <td>Link</td>
                            <td>Id Modelo</td>
                     
                        </tr>
                        <% if (request.getAttribute("listaContextos") != null) {
                                ArrayList<ContextoNavegacionn> list = (ArrayList<ContextoNavegacionn>) request.getAttribute("listaContextos");
                                if (list != null)
                                    for (ContextoNavegacionn con : list) {


                        %>
                        <tr>
                            <td><%=con.getId_contexto()%></td>
                            <td><%=con.getLink()%></td>
                            <td><%=con.getId_modeloNaveg()%></td>
                         
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

