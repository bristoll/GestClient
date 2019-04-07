# GestClient

En el fichero <b>source</b> se pueden encontrar los codigos, o se puede descargar la carpeta completa para poder importar directamente el proyecto en eclipse, teniendo solo que crear las tablas en la base de datos y modificar la url del servidor.

El proyecto se estructura en 3 paquetes principales. Dos de ellos asociados a las tablas de la base de datos, cliente y factura(<s>por implementar</s>).Y por separado un paquete que solo contiene la clase de conexion a la base de datos. El código está bastante comentado, especialmente en el paquete cliente ( ya que el paquete factura es una copia con diferentes atributos correspondientes a los que posea factura en la base de datos).

La estructura de los paquetes se explica relativamente bien en los comentarios del código.

Esto no pretende ser un programa funcional, solamente es un ejercicio didactico para ver la aplicación de un esquema <b>MVC</b>(https://es.wikipedia.org/wiki/Modelo%E2%80%93vista%E2%80%93controlador) y el uso de <b>DAO</b>(https://es.wikipedia.org/wiki/Objeto_de_acceso_a_datos) para el manejo de los datos.
