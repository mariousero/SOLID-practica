# Principios SOLID
## Ejercicio de práctica

### Introducción

Tras implementar la función .getSize() en la clase Directory, se ha procedido a revisar que el código cumple con los principios SOLID. A consecuencia de dicha revisión se han encontrado y arreglado distintos errores que incumplían algunos de los principios SOLID.

### Descripción de los cambios realizados

**- Principio de Segregación de Interfaces:**

El código original incumplía con el principio de segregación de interfaces, dado que se usaba la interfaz "FileSystemItem" como interfaz para las clases "Directory", "File" y "FileSystemItemBase". Esta interfaz contiene ciertos métodos que no son necesarios para algunas de estas clases que la implementan, lo cual esta causando que salten excepciones que se podrían evitar.

Para solucionar este problema, he creado dos nuevas interfaces ("DirectoryInterface" y "FileInterface"), las cuales incluirán los métodos relacionados con los directorios y los archivos independientemente unos de otros. La interfaz "FileSystemItem" sigue presente, pero he eliminado los métodos que causaban el error previo y he mantenido aquellos que son utiles para cualquier archivo.

La implementación de estos cambios en el programa se lleva a cabo implementando las interfaces necesarias en los distintos tipos de archivos, diferenciando en clases como "FileSystemBuilder" y "FileSystemPrinter" entre objetos de tipo "Directory" y "File" o "FileSystemItemBase".

**- Principio de Inversión de Dependencias:**
    
El principio de inversión de dependencias lo hemos conseguido aplicar usando interfaces para definir las dependencias ded las clases. En concreto para las clases de los archivos ("File", "Directory", "FileSystemItemBase"). De esta manera consigo aislar el código de alto nivel de las implementaciones de bajo nivel.

**- Principio de Responsabilidad Única:**
    
El principio de responsabilidad única se incumple en la clase "File", dado que esta clase en el código original incluye dos métodos para convertir archivos MP3 a wav y viceversa. Estos métodos no están relacionados directamente con la responsabilidad de la clase "File".

Para solucionar el problema y conseguir que se cumpla el principio de responsabilidad única, he movido dichos métodos a la clase "FileManager" y los he borrado de la clase "File". Ahora el método recibe un objeto "File" el cual es usado para la conversión. En el programa dado no se usa ninguno de estos métodos, pero una vez aplicados los cambios descritos, solo se necesitaria llamar al método de la clase "FileManager" dando como parámetro el objeto "File" que se desea convertir.

**- Principio de Abierto/Cerrado:**
    
Este principio puede ser que se incumpla en la clase "FileManager", dado que en su método "calculateSize" anida un par de ifs. En caso de que se quisieran añadir al programa más tipos de archivos cuya forma de calcular el tamaño fuese diferente, este método sería complicado de modificar para añadir una nueva funcionalidad.

El problema es solucionado al añadir el método "getSize()" a cada tipo de archivo que usa el programa, por el momento "Directory" y "File", dejando sin uso el método "calculateSize" y permitiendo que en caso de querer añadir otro tipo de archivo sea posible.

### Observaciones
- En la clase "FileManager" deja de ser necesario el método "calculateSize", puesto que se ha implementado un método "getSize()" en la clase "Directory". Una vez aplicado este cambio, este método deja de ser útil, ya que su única función era la de obtener el tamaño del archivo y mostrarlo desde el método "print" de la clase "FileSystemPrinter" y ahora ese método puede llamar simplemente al método "getSize()" puesto que está implementado tanto en objetos de tipo "File" como "Directory".
- La inversión de dependencias aún estaría por implementar a nivel práctico en ciertos puntos del programa. Es decir ya se han aislado las implementaciones de bajo nivel pero aún no se ha aplicado a ciertas funcionalidades del código.