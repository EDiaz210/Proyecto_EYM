**ADMINISTRADOR**
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
**Desarrollador**
-
-
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
 **BOTON VOLVER**:
 
El botón "Volver" tiene un "ActionListener" que se inicia cuando se hace clic en él.
Crear nueva ventana: cree una nueva instancia de "JFrame". Nueva configuración de ventana:
El contenido de la ventana se establece en la barra de menú principal. La imagen se establece como icono de ventana. El nombre de la ventana está configurado en "Entrar". Configure el programa para que se cierre cuando se cierre la ventana. El tamaño de la ventana gráfica es de 600 x 300 píxeles. Se abre una ventana. Cerrar la ventana actual: Cerrar la ventana que contiene el botón "Atrás".

Dependencias:
Java Swing es una herramienta para crear y gestionar interfaces gráficas de usuario. La utilidad java.awt.Toolkit se utiliza para cargar imágenes de iconos.

-
![image](https://github.com/user-attachments/assets/a2abef8d-6595-42ea-9f84-f1fac5efeb21)



-

