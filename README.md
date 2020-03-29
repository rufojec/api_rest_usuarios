# global-logic-jcarmona
Api-restfull de creación de usuarios

Descripción: Api RestFull encargada de generar usuarios.
<br><br>
Tecnologias: 
- Java Versión 8
- Spring boot 4
- Hibernate
- H2 Data Base
- Lombok
- Spock Unit Test / Gradle
- JWT Token
.
<h2>Descripción de la API<h2>
  <p>La api restfull cuenta con endpoint que ejecutan las llamadas necesarias para listar, crear y actualizar usuarios mediante llamadas json. Existen 4 handlers dentro del controlador que trabajan con los usuarios. Ademas se expone un controlador JwtAuthenticationController encargado de generar un token JWT utilizando un user y password configurado en el proyecto</p>
  
<table style="width:100%">
  <tr>
    <th>Nombre de api</th>
    <th>Metodo HTTP</th>
    <th>Path</th>
    <th>Código de respuesta</th>
    <th>Descripción</th>
  </tr>
  <tr>
    <td>POST user</td>
    <td>POST</td>
    <td>/api/v1/user</td>
    <td>200</td>
    <td>Creación de un nuevo usuario</td>
  </tr>
  <tr>
    <td>PUT user</td>
    <td>PUT</td>
    <td>/users/{id}</td>
    <td>200</td>
    <td>Actualización de un usuario mediante ID</td>
  </tr>
  <tr>
    <td>GET user</td>
    <td>GET</td>
    <td>/user/{id}</td>
    <td>200</td>
    <td>Obtiene el usuario mediante su ID</td>
  </tr>
  <tr>
    <td>GET user</td>
    <td>GET</td>
    <td>/users</td>
    <td>200</td>
    <td>Obtiene todos los usuarios de la base de datos</td>
  </tr>
   <tr>
    <td>POST token jwt</td>
    <td>POST</td>
    <td>/authenticate</td>
    <td>200</td>
    <td>Obtiene un token aleatorio para autenticar cada request</td>
  </tr>
</table>
<br>
<h2>Instrucciones</h2><br><p>se da por echo que tiene un ambiente spring boot configurado con eclipse o eclipse sts y los componentes gradle necesarios.</p>
<ul>
  <li>Descargar proyecto</li>
  <li>Importar gradle proyect</li>
  <li>Seleccionar Project root directory</li>
  <li>Construir proyecto gradle mediante comando</li>
  <li>Iniciar proyecto mediante gradle boot, o botón derecho sobre la clase UsersApplication--run as--Java Application</li>
  <li>El proyecto levantara en el puerto 8080</li>
</ul>

<br><br>
<h2>Consumo de api</h2>
<p>Para probar los endpoint se sugiere utilizar algun cliente rest, en este caso con postman es suficiente. Antes de poder consumir los servicios es necesario generar un token. Se adjunta documentación de api rest:
  https://documenter.getpostman.com/view/9342178/SW14TbsU
</p>
