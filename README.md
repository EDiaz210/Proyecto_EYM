
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
 **BOTON VOLVER**:
 
El botón "Volver" tiene un "ActionListener" que se inicia cuando se hace clic en él.
Crear nueva ventana: cree una nueva instancia de "JFrame". Nueva configuración de ventana:
El contenido de la ventana se establece en la barra de menú principal. La imagen se establece como icono de ventana. El nombre de la ventana está configurado en "Entrar". Configure el programa para que se cierre cuando se cierre la ventana. El tamaño de la ventana gráfica es de 600 x 300 píxeles. Se abre una ventana. Cerrar la ventana actual: Cerrar la ventana que contiene el botón "Atrás".
Dependencias:
Java Swing es una herramienta para crear y gestionar interfaces gráficas de usuario. La utilidad java.awt.Toolkit se utiliza para cargar imágenes de iconos.

-
![image](https://github.com/user-attachments/assets/a2abef8d-6595-42ea-9f84-f1fac5efeb21)



-

