# Equipo1-RetoSura

Solución equipo 1 al reto sura.

La noticia tiene los siguientes datos: título, descripción, URL, fuente, fecha, imagen, categoría, lenguaje y autor. En este caso, nuestra API tiene 4 diferentes endpoints para pedir la información:

El primer endpoint, donde podemos solicitar todas las noticias que hay en la base de datos, utilizando el método HTTP Get.

El segundo endpoint, donde podemos solicitar una noticia en específico de la base de datos por medio de la ID, utilizando el método HTTP Get.

El tercer endpoint, donde podemos generar las noticias según los parámetros que especificamos en el formulario/body que enviamos desde el cliente, que en este caso son: categoría, lenguaje y número de noticias. 
Con ellos podemos generar una cantidad de noticias y guardarlas en la base de datos, utilizando el método HTTP Post.

El cuarto endpoint, donde podemos eliminar una noticia según el parámetro ID que enviamos desde el cliente, utilizando el método HTTP Delete.

__________________________________________________________________________________




(entities-new) En el código, tenemos la capa donde se encuentran las Entidades, en este caso la de noticias.
Aquí es donde guardamos los datos como: título, descripción, URL, fuente, fecha, imagen, categoría, lenguaje y autor. 
Esta entidad es la que representará el esquema que hay en la base de datos.
(repository) Luego, tenemos la capa de repositorio que es la encargada de conectarse y llamar directamente a la base de datos según la necesitemos.
También tenemos la capa de servicios donde, en conjunto con la capa de repositorio, podemos obtener, crear, modificar y eliminar datos de la base de datos, y también controlar excepciones en caso de algún error. 
Esta capa será llamada cuando sea solicitada desde la capa del controlador.
Y en la última capa, la capa del controlador, que trabaja en conjunto con la capa de servicios, es la encargada de controlar todas las peticiones que se reciben del exterior del API. 
Según el resultado que se obtiene de la capa de servicios, se envía una respuesta.


En el archivo application.properties pones: 

spring.data.mongodb.uri: (aqui va la uri de la base de datos)
api.key.news: (aqui va el api key que tengas)

