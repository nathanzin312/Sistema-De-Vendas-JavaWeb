
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Comprar Produtos </title>
    </head>
    <body>
   

        <form method="POST" action="Pesquisar">
            <tr>
                    <td>
                        <select id="goio" name="goio">
                            <c:forEach  var="prod" items="${oi}">
                            <option value=${prod.id}>${prod.nome}</option>
                            </c:forEach>
                        </select>
                    </td> 
                    <td><input type="date" name="data_inicio" ></td>
                    <td><input type="date" name="data_final" ></td>
                    <td><input type="submit" value="Enviar"/></td>
                </tr>

              
        </form>

    </ta
    <br>
    <br>    

</body>
</html>