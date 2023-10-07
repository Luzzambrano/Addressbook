# Actividad 4.

1. Escribe una clase llamada AddressBook, que representará la agenda telefónica.
2. La clase AddressBook deberá tener un atributo de tipo HashMap que almacene los contactos, HashMap será un Map<String, String>, el primer atributo String utilizará el número telefónico como llave.
3. En la clase AddressBook se implementarán los métodos para la lectura y escritura de los contactos en un archivo de texto.
    a. load: cargará los contactos del archivo.
    b. save: guardará los cambios en el archivo.
4. Se implementarán tres métodos para modificar la información de los contactos.
    a. list: mostrar los contactos de la agenda.
    b. create: crear un nuevo contacto.
    c. delete: borrar un contacto.
5. Los tres métodos anteriores deberán estar conectados a un menú interactivo que proporcionará al usuario de la aplicación una interfaz para realizar las tres acciones anteriores:

   a. list: iterar el HashMap de AddressBook y mostrar los contactos con el siguiente formato:

        ```
        Contactos:
        {Número} : {Nombre}
        {Número} : {Nombre}
        {Número} : {Nombre}
        {Número} : {Nombre}
        ....
        ```
   b. create: solicitar el nombre y número de contacto a guardar.

   c. delete: solicitar el número telefónico a eliminar.
