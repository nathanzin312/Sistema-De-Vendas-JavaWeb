
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : editarProdutos
    Created on : 01/02/2022, 15:23:46
    Author     : ricardo
--%>

<!DOCTYPE html>
<html>
  <head>
    <title>Editar</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="CSS/cadastro.css" rel="stylesheet">
  </head>
  <body>
    <div class="quadrado">
    <form method="POST" action="AdicionarUsuario" >
       <div class="itens">
          <h2>Editar Usuario</h2>
          <div class="usuario">
            <label>Usuario: </label><input type="text" placeholder="${usuario.nome}"  name="usuario"/> 
             <br>
             <br>
          </div>
          <div class="senha">
            <label>Senha: </label><input type="password" placeholder="${usuario.senha}" name="senha"/>
            <br>
          </div >
          <div class="idade">
            <label>Idade: </label><input type="number" step="any" placeholder="${usuario.idade}" name="idade"/>
           <br>
            <input type="hidden" name="id" value="${usuario.id}" />
          </div>
          <div class="posicaobotao">
            <input type="submit" name="logar" class="botao" value="ALTERAR" />
          </div>
     </div>
    </form>
     <div class="textinho">
            <small>Voltar <a href="./home.jsp">logar</a></small>
    </div>
   </div>
  </body>
</html>
