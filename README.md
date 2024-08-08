**Objetivo Principal**
-
El propósito principal de estos códigos es crear una interfaz gráfica de usuario (GUI) basada en Java que permita la gestión de usuarios y tareas en una aplicación de desarrollo de software que utiliza una base de datos MongoDB. Los códigos proporcionados incluyen funcionalidades importantes para varios tipos de usuarios (administradores y desarrolladores), incluida la eliminación de tareas, la actualización de detalles de tareas y el inicio de sesión. El sistema tiene como objetivo proporcionar una plataforma efectiva para administrar las tareas de un proyecto, asegurando la integridad y seguridad de los datos mediante la autenticación de usuarios y la manipulación adecuada de los registros en la base de datos.

-
**LOGIN**
-
![image](https://github.com/user-attachments/assets/ed8286db-9fa9-4abd-a2d9-ec04e5a6ed63)
![image](https://github.com/user-attachments/assets/43e0797c-793a-4293-b23f-29b141da4f79)
![image](https://github.com/user-attachments/assets/fdb42ba4-6bd7-474b-a05c-65e6ce38f7f1)
![image](https://github.com/user-attachments/assets/f44e14f1-95fb-4f7d-a878-bdc8cadaca1c)
La estrategia de selección para el selector de administrador es la siguiente:

La insignia de usuario se actualiza para mostrar que está en modo administrador. Para administrar la autenticación de administrador, agregue un detector de acciones al botón de inicio de sesión. Desarrollador destacado:

Su etiqueta de usuario se actualizará para mostrar que está en modo desarrollador. Para administrar la autenticación del desarrollador, agregue un detector de acciones al botón de inicio de sesión. Iniciar sesión con lógica de botones
Validación de campos vacíos:

Si los campos de correo electrónico o de contraste están vacíos, se muestra un mensaje de error. Conexión a MongoDB:

Conexión establecida con MongoDB local en el puerto 27017. Se puede acceder a la base de datos de LxxuzOXCORP y a las colecciones correspondientes. Encuentre y verifique las credenciales:
Los documentos de la colección se revisan para garantizar que el correo electrónico y la contraseña ingresados ​​coincidan con los ya guardados. Para mayor seguridad, utilice hashes SHA-256 para comparar contraseñas. Redirigir al menú apropiado:

Si el certificado es válido, se abre y se cierra la ventana del menú correspondiente (MENUP para administradores, menuD para desarrolladores). Si las credenciales no son válidas, se muestra un mensaje de error en la pestaña Credenciales. Generar hashes de contraseña
El método GenerateHash acepta una cadena de entrada y le asigna un valor hash SHA-256 en formato hexadecimal. Convierta una matriz de bytes en una cadena hexadecimal utilizando el método bytesToHex.

-

**ADMINISTRADOR**
**TAREAS**
**FORM BUSCAR Y SU CLASE**

-
![image](https://github.com/user-attachments/assets/89f398eb-37bf-4d66-aa61-4b3d9af96247)
![image](https://github.com/user-attachments/assets/08997762-3be4-42d5-9de5-d14ff085bba4)
![image](https://github.com/user-attachments/assets/acf38e07-9724-4c3a-b9ac-189b1694a376)
-
Confirmar la búsqueda de la tarea por el usuario:

El proceso primero verifica si el usuario ha ingresado un código de tarea. Si no hay espacio en el campo de texto Tcode, se muestra un mensaje solicitando al usuario que ingrese el código de tarea. La conexión a la base de datos es la siguiente:

El método MongoClients.create se utiliza para conectarse a la base de datos MongoDB LyxuzOXCORP. La recopilación de tareas y la recopilación de datos asociados con la tarea se recuperan de la base de datos. collection.find() se utiliza para recuperar todos los archivos de la colección de tareas. Compatibilidad de misión:

Este método recorre en iteración todos los archivos que recupera y agrega los datos al objeto Tareas. Verifique que el task_id del documento coincida con el código ingresado por el usuario.
Mostrar información sobre el proyecto:

Si se encuentra una tarea coincidente, se utilizan los elementos de la interfaz de usuario apropiados (por ejemplo, nombre, progresoB, identificación, desarrollador, desc, fecha_A, fecha_V, duración) para mostrar la información de la tarea. Mostrar imágenes con mayor prioridad:

Este método está diseñado para recuperar y mostrar el orden de prioridad de las tareas. Si se encuentra la imagen, se escalará y se mostrará en el elemento prioridadB. Si no se encuentra la imagen, se muestra un mensaje de imagen no encontrada. Comunicación de resultados:

Se enviará un mensaje al usuario para determinar si se ha encontrado la tarea.

-
**FORM INSERTAR Y SU CLASE**
-
![image](https://github.com/user-attachments/assets/775f8378-298d-4934-8d59-014763c73c89)
![image](https://github.com/user-attachments/assets/81cd90ba-1f3b-4f40-b9d6-f6e821b2047e)
![image](https://github.com/user-attachments/assets/760a0e0e-2412-4aa8-b993-e92fd6b04c31)
![image](https://github.com/user-attachments/assets/7eacbb12-b237-4f27-bc5b-815664d2a9e9)
-
En el comienzo del código se inicializa los spinner:
1. Spinner1: Su valor puede estar entre 1 y 12, y el valor inicial es 1.
2. Spinner2: establezca un valor entre 1 y 60 con un valor inicial de 1. 

El botón "SelectImage" le permite abrir un "JFileChooser" para seleccionar una imagen. Se filtrar archivos con extensiones jpeg y png y permite conviertir la imagen seleccionada en un objeto binario. Mostrandola en la pestaña de prioridad.

Tambien se puede agregar nuevos datos como:
El botón "InsertarB" confirma que todos los campos de texto están completos  y que se conecte a la base de datos MongoDB. Se recibe una colección de "Tareas". Donde se puede incluir datos del usuario en el objeto "Tarea" y  verificar si hay una tarea con el mismo ID o un desarrollador asignado a una tarea diferente. Si la verificación tiene éxito, el nuevo archivo se coloca en la colección de tareas. Caso contrario procede a mostrar un mensaje que indica que los datos se cargaron correctamente, la tarea se completó o el desarrollador está ocupado.

-
**FORM ElIMINAR Y SU CLASE**
-
![image](https://github.com/user-attachments/assets/fa4c9736-9b8a-4f15-a2f1-2888fbbd1731)
![image](https://github.com/user-attachments/assets/3b25dbf9-d260-4fb6-96f2-bbf70018da2e)
![image](https://github.com/user-attachments/assets/74930db2-88ee-4bb8-8b62-0f5039ffa28d)
-
La lógica del botón EliminarB para verificar si hay un campo vacío es la siguiente:

Si el campo Eliminar búsqueda está vacío, se mostrará un mensaje de error solicitando el código de tarea. Conexión a MongoDB:

Conéctese a la base de datos MongoDB en esta máquina en el puerto 27017. Se puede acceder a colecciones de tareas y bases de datos LyxuzOXCORP. Buscando archivos:

Busca en la colección de tareas archivos que coincidan con el ID de tarea ingresado por el usuario. Mostrar información sobre el proyecto:

Si se encuentra, la información del archivo se mostrará en el elemento GUI correspondiente.

Si el archivo contiene una imagen en formato binario, se convierte en una imagen y se muestra con prioridad E. Aceptar eliminación:

Aparece un cuadro de diálogo para confirmar la tarea de eliminación. Si el usuario lo aprueba, el archivo se elimina de la colección y se muestran los resultados de la operación. Manejar excepciones
Para garantizar que la conexión a MongoDB se cierre automáticamente, el código utiliza un bloque de "reintentar con recursos". Cualquier excepción de tiempo de ejecución se genera como una excepción de tiempo de ejecución.

-
**EQUIPOS**
-
Los forms de equipos cumplen las mimas funcinalidades que las de las de tareas simplemente no se va visualizar lo que es la barra de porcetaje, el nombre de la data base cambia y el de la coleccion,ylas interfaces de cada uno son diferentes porque recordemos que en equipos vamos a componer de desarrolladores entonces solo vamos a dijitar los nombres en insertar y conformar equipos, por otro lado tambien hay un insertar, eliminar y buscar para lo que son equipos de desarrollo.
-
![image](https://github.com/user-attachments/assets/5aaa8ec3-61b8-463c-9853-91c37a23d595)
![image](https://github.com/user-attachments/assets/e571a1b0-f0fc-4933-b57a-e4a7e666f3a9)
![image](https://github.com/user-attachments/assets/c4cc44e2-43e5-4adb-8114-975fb1a0f91d)


-
**Desarrollador**
**FORM ACTUALIZAR Y SU CLASE**
-
![image](https://github.com/user-attachments/assets/c0888c30-4b64-4001-8037-867a00cdf142)
![image](https://github.com/user-attachments/assets/49f9439a-1414-44ca-b2ef-f0ba8c11828c)
![image](https://github.com/user-attachments/assets/58e6e425-2778-4260-8023-267b96842e20)
-
La lógica del botón updateB está conectada a MongoDB:

Conéctese a la base de datos MongoDB en esta máquina en el puerto 27017. Se puede acceder a colecciones de tareas y bases de datos LyxuzOXCORP. Buscando archivos:

Busca en la colección de tareas archivos que coincidan con el ID de tarea ingresado por el usuario. Mostrar información sobre el proyecto:

Si se encuentra, la información del archivo se mostrará en el elemento GUI correspondiente. Si el archivo contiene una imagen en formato binario, se convertirá en una imagen y se mostrará con prioridad A. Explorar espacio libre:
Si los campos OffM, OffM y AdvanceM están vacíos, se mostrará un mensaje de error solicitándole que complete todos los campos. Actualizar archivo:

Si no hay ningún campo vacío, se crea una nueva instancia de la clase Tareas y se establece con el valor ingresado. Se crea un documento de actualización que incluye el valor de descripción actualizado, el equipo responsable y el progreso. Los archivos de la colección se actualizan y se muestran los resultados de la operación.

-
**FORM INSERTAR Y SU CLASE**
-
En este caso el form insertar con su clase cumple la misma funcionalidad que el insertar del administador ya que los dos usuarios puede crear nuevas tareas.
-
![image](https://github.com/user-attachments/assets/b3114d9a-c519-4968-99e6-efdbd0bcc2e4)

-
 **BOTON VOLVER**:
 
El botón "Volver" tiene un "ActionListener" que se inicia cuando se hace clic en él.
Crear nueva ventana: cree una nueva instancia de "JFrame". Nueva configuración de ventana:
El contenido de la ventana se establece en la barra de menú principal. La imagen se establece como icono de ventana. El nombre de la ventana está configurado en "Entrar". Configure el programa para que se cierre cuando se cierre la ventana. El tamaño de la ventana gráfica es de 600 x 300 píxeles. Se abre una ventana. Cerrar la ventana actual: Cerrar la ventana que contiene el botón "Atrás".

En el proyecto podemos encontrar diferentes botones "volver" ya que estos seran utilizados para retornar a la pestaña que deseamos, siempre y cuando en el setContentPane se ponga el panel publico que desamos visualizar.

Dependencias:
Java Swing es una herramienta para crear y gestionar interfaces gráficas de usuario. La utilidad java.awt.Toolkit se utiliza para cargar imágenes de iconos.

-
![image](https://github.com/user-attachments/assets/a2abef8d-6595-42ea-9f84-f1fac5efeb21)
-
**Conclusiones**
-
La aplicación utiliza un sistema de autenticación para distinguir entre desarrolladores y administradores. Esta diferencia se gestiona mediante JComboBox, que permite a los usuarios elegir sus roles, y la aplicación cambia su comportamiento según el tipo de usuario al acceder a diferentes colecciones de MongoDB. 

La aplicación utiliza MongoDB como sistema de almacenamiento para gestionar tareas y credenciales de usuario. Maneja de manera eficiente operaciones básicas como conectarse a una base de datos y realizar consultas, actualizar y eliminar archivos. Compara las credenciales ingresadas con los datos almacenados en MongoDB para autenticar al usuario.

Utilice hash SHA-256 para proteger las contraseñas. Este método mejora la seguridad al almacenar la contraseña como un valor hash en lugar de texto sin formato. Sin embargo, vale la pena señalar que es posible implementar otras técnicas (como salt) y utilizar algoritmos más potentes (como bcrypt) para aumentar la seguridad.

-
**Recomendaciones**
-
Para evitar posibles errores durante las conexiones y consultas en MongoDB, se debe implementar un manejo de excepciones más estricto, como MongoException, incluso si IOException se maneja en el código del programa. Esto mejorará la experiencia del usuario y ayudará a proporcionar mensajes de error más precisos. 

Se debe mejorar la validación de los perfiles de usuario. Compruebe, por ejemplo. Formatos de correo electrónico y contraseña. Esto puede ayudar a prevenir errores y proteger la integridad de los datos de la base de datos.

Considere agregar un sistema de control de acceso más granular a su aplicación. Esto puede incluir permisos específicos de roles que brindan a los desarrolladores y administradores acceso solo a la funcionalidad y los datos que necesitan, mejorando la seguridad y el control del usuario.

-
**LINK DEL VIDEO**
-
https://youtu.be/thAoRaPqCJA
-

