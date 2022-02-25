<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Balanço</title>
            <link href="CSS/style.css" rel="stylesheet">
  </head>
  <body>
    <div class="quadrado">
         <form action="Pesquisar" method="POST" class="formulario">
           <div class="itens">
               <h2>Pesquisar </h2>
              <div class="usuario">
                <label>Usuario: </label><input type="text" placeholder="Usuario"  name="usuario" >
              </div>
              <br>
              <div class="senha">
                <label>Senha: </label><input type="password" placeholder="*******" name="senha">
                <br>
              </div >
              <div class="posicaobotao">
                <input type="submit" name="logar" class="botao" value="PESQUISAR">
              </div> 
           </div>
        </form>
    </div>
  </body>
</html>