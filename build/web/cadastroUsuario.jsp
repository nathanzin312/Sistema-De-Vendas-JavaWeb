<!DOCTYPE>
<html>
  <head>
    <title>Cadastro</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="CSS/cadastro.css" rel="stylesheet">
  </head>
  <body>
    <div class="quadrado">
    <form method="POST" action="AdicionarUsuario" >
       <div class="itens">
          <h2>Cadastro</h2>
          <div class="usuario">
            <label>Usuario: </label><input type="text" placeholder="Usuario"  name="usuario"/> 
             <br>
             <br>
          </div>
          <div class="senha">
            <label>Senha: </label><input type="password" placeholder="Digite Sua Senha" name="senha"/>
            <br>
          </div >
          <div class="idade">
            <label>Idade: </label><input type="number" step="any" placeholder="Sua Idade" name="idade"/>
           <br>
          </div>
          <div class="posicaobotao">
            <input type="submit" name="logar" class="botao" value="CADASTRAR" />
          </div>
     </div>
    </form>
        <c:out value="${variavelRequestMsgErro}" />
     <div class="textinho">
            <small>Ja é registrado? <a href="./index.html">logar</a></small>
            
    </div>
   </div>
  </body>
</html>
