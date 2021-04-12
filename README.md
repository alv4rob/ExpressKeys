# Express Keys
<p align="center">
<img src="imagenes/logo.png" alt="Logo" width="600" height="600">

# Descripción de la web 🌐
ExpressKeys consiste en una web de compra de "keys" de videojuegos para las diferentes plataformas online del mercado. En ella el cliente puede buscar los diferentes títulos disponibles utilizando diferentes herramientas como por ejemplo un sistema de filtrado por categorías, por precio, por plataforma online, etc... para posteriormente comprarlo y recibir su código para canjearlo.


# Entidades 🗯
 * Clientes: Usuarios del sistema que compran las keys en la página web.
 * Administradores: Usuario o usuarios que se encargan de añadir o eliminar productos del catalogo de la tienda.
 * Producto: Son las keys de los videojuegos que se muestran en la tienda y el usuario puede comprar.
 * Carrito de la compra: Los usuarios pueden añadir una o varias keys a una cesta de la compra antes de adquirirlas.
 * Valoraciones: Tras comprar una key un usuario puede dejar una puntuacion a la compra o revisar la valoración de otros productos,

# Parte pública 🔓
* Busqueda de videojuegos
* Filtrar catálogo
* Comprar keys
* Logearse/Registrarse 

# Parte privada 🔐
* Añadir/Eliminar productos del catalogo
* Dar de baja/alta a usuarios
* Consultar información de usuarios.

# Servicio interno 🖥
El servicio interno enviará un correo electrónico al usuario tras la compra de una key con los detalles de su pedido.

# Integrantes 👥 

* Sergio García Rosell [s.garciaro.2017@alumnos.urjc.es] https://github.com/SergioGr8
* Álvaro Barrio Luquero [a.barrio.2017@alumnos.urjc.es] https://github.com/alv4rob
* Nerfi Salim Perello [n.salim.2017@alumnos.urjc.es] https://github.com/nerf7

# Capturas de pantalla 
* Página principal: Como página principal, se muestra tanto el catálogo completo de productos junto a los filtros de búsqueda, además de los enlaces de registro e inicio de sesión.
<p align="center">
<img src="imagenes/PaginaPrincipal.png">
  
* Registro: La página de registro de usuarios incluye los campos para introducir un nombre de usuario, una contraseña y un correo electrónico, los campos que conforman a un usuario.
<p align="center">
<img src="imagenes/Registro.png">

* Usuario registrado: Pantalla de aviso de que un nuevo usuario ha sido registrado. Lleva de vuelta a la Página principal.
<p align="center">
<img src="imagenes/UsuarioRegistrado.png">
  
* Inicio de sesión: Se trata de la pantalla que recibe los datos de login de un usuario para que pueda iniciar sesión.
<p align="center">
<img src="imagenes/InicioDeSesion.png">

* Página principal (logged): Página principal una vez se ha iniciado sesión correctamente. Es como la pantalla Página principal, pero permite acceder a la Página del carrito y a la Página de usuario. Para administradores, permite acceder a la pantalla Admin.
<p align="center">
<img src="imagenes/PaginaPrincipalLogged.png">

* Login error: Pantalla de aviso de que el usuario y contraseña introducidos no pertenecen a ningún usuario registrado. Permite volver a la pantlla de Inicio de sesión.
<p align="center">
<img src="imagenes/LoginError.png">

* Admin: Pantalla exclusiva para administradores que permite mostrar la pantalla de Lista de usuarios, Nuevo producto o volver a la Página principal (logged).
<p align="center">
<img src="imagenes/Admin.png">

* Perfil: Pantalla que muestra los datos del usuario en la sesión.
<p align="center">
<img src="imagenes/Perfil.png">
  
* Lista de usuarios: Como opción para los administradores, contiene la lista de los usuarios registrados actualmente y sus roles. Permite acceder a la página de cada usuario o volver a la Página principal (logged).
<p align="center">
<img src="imagenes/ListaDeUsuarios.png">
  
* Página de usuario: Página exclusiva de administradores que muestra los datos de un usuario y da la opción de eliminarlo de la base de datos.
<p align="center">
<img src="imagenes/PaginaDeUsuario.png">
  
* Usuario eliminado: Pantalla de aviso de que un usuario ha sido eliminado. Lleva de vuelta a la Lista de usuarios.
<p align="center">
<img src="imagenes/ClienteEliminado.png">
  
* Nuevo producto: Se trata de la página de inserción de usuarios al catálogo. Incluye los campos para introducir una lista de keys, un título, un precio, una plataforma y una categoría, los campos que conforman un producto.
<p align="center">
<img src="imagenes/NuevoProducto.png">
  
* Producto guardado: Pantalla de aviso de que un nuevo producto ha sido guardado en la base de datos. Lleva de vuelta a la Página principal.
<p align="center">
<img src="imagenes/ProductoGuardado.png">
  
* Página de producto: Muestra la información de un producto y da la opción de añadirlo al carrito, dejar una valoración o volver a la página principal. Como opción para los administradores, está la posibilidad de eliminar el producto de la base de datos y poder ver las keys que quedan del producto.
<p align="center">
<img src="imagenes/PaginaDeProducto.png">
  
* Añadido al carrito: Pantalla de aviso de que un producto ha sido añadido al carrito. Lleva de vuelta a la Página principal.
<p align="center">
<img src="imagenes/AñadidoAlCarrito.png">
  
* No ñadido al carrito: Pantalla de aviso de que un producto no ha sido añadido al carrito. Lleva de vuelta a la Página principal.
<p align="center">
<img src="imagenes/NoAñadidoAlCarrito.png">

* Producto eliminado: Pantalla de aviso de que un producto ha sido eliminado de la base de datos. Lleva de vuelta a la Página principal.
<p align="center">
<img src="imagenes/ProductoEliminado.png">
  
* Introducción de valoración: Pantalla en la que añadir el nombre y contenido de una valoración para un producto.
<p align="center">
<img src="imagenes/IntroduccionDeValoración.png"> 

* Valoración enviada: Pantalla de aviso de que una valoración ha sido registrada. Lleva de vuelta a la Página de producto.
<p align="center">
<img src="imagenes/ValoraciónEnviada.png">
  
* Página del carrito: Pantalla que contiene los productos que se encuentran en el carrito en un momento dado junto a la suma total a pagar. Permite volver a la Página principal o acceder a comprar.
<p align="center">
<img src="imagenes/PaginaDelCarrito.png">
  
* Compra finalizada: Pantalla de aviso de que la compra ha sido completada. Se adjunta un recibo con los productos comprados y su key. Lleva de vuelta a la Página principal.
<p align="center">
<img src="imagenes/CompraFinalizada.png">

* Error compra: Pantalla de aviso de que ocurrió un error al procesar la compra. El carrito se mantendrá como estaba. Lleva de vuelta a la Página principal (logged).
<p align="center">
<img src="imagenes/CompraFinalizada.png">

# Diagrama de navegación

Una vez vista cada una de las pantallas, a continuación se adjunta el diagrama de navegación de las mismas:
<p align="center">
<img src="imagenes/DiagramaDeNavegacion.jpg">
  
# Diagrama Entidad Relación
<p align="center">
<img src="imagenes/DiagramaEntidadRelacion2.PNG">

# Diagrama UML
Adjuntamos una imagen con el diagrama UML (actualizado):
<p align="center">
<img src="imagenes/DiagramaUML.png">

# Diagrama de Clases y templates
Adjuntamos aquí el diagrama de clases y templates:
<p align="center">
<img src="imagenes/DiagramaDeClasesTemplates.jpg">
