# clientes

Para ejecutar localmente hay dos opciones:

I.- Desde un eclipse:
1.- Run As a la clase "ClientesApiApplication.java"
2.- La aplicacion se levanta en el puerto 8080 por defecto
3.- Ingresar a la ruta para probar los métodos con swagger:
 http://localhost:8080/swagger-ui.html 
 
4.- Ingresar a la ruta para ver la informacion general del api:
http://localhost:8080/v2/api-docs 


II.- Ejecutando el jar:
1.- Ejecutar comando: mvn eclipse:eclipse
1.- Ejecutar comando: clean install 
1.- Ejecutar el jar ubicado en  target/clientes-0.0.1-SNAPSHOT.jar con el comando: java -jar clientes-0.0.1-SNAPSHOT.jar
2.- La aplicacion se levanta en el puerto 8085
3.- Ingresar a la ruta para probar los métodos con swagger:
 http://localhost:8080/swagger-ui.html 
 
4.- Ingresar a la ruta para ver la informacion general del api:
http://localhost:8080/v2/api-docs 



Para probar en un servidor público:
I.- Ingresar a la siguiente ruta pública swagger:

http://ec2-54-175-136-34.compute-1.amazonaws.com:8080/swagger-ui.html


