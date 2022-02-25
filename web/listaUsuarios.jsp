<%-- 
    Document   : listaUsuarios
    Created on : 01/02/2022, 14:56:38
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Historico</title>
    <link href="./CSS/listaUsuarios.css" rel="stylesheet">
 </head>
 <body>
     <div class="quadrado">
          <h3>Produtos Cadastrados</h3>
          <div class="corpo">
            <div class="topo">
              <div>Balanço</div>
            </div>
            <div class="cabecalho">
             <div>Produto</div>
             <div>Quantidade</div>
             <div>Preço.Uni</div>
             <div>Valor total</div>
             <div>Data</div>
              <div>editar</div>
             <div>excluir</div>
            </div>
            <div class="tabela">
              <div>${produto.nome}</div>
              <div></div>
              <div>exemplo</div>
              <div>exemplo</div> 
              <div>exemplo</div> 
              <div> <a href="">editar</a></div>
              <div><a href="">excluir</a></div>
            </div>      
        </div>
 </body>
</html>