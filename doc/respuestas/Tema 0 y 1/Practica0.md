
Programación II / Algoritmos y estructuras de datos I
Práctica 0: Sintaxis Java Procedural

Instrucciones generales:

    Crea un proyecto "practica0" en VSCode (con la extensión Java Extension Pack, "create Java Project" en el explorador de ficheros de VSCode), tipo Maven, sin arquetipo, con groupid "proii_aedi", artifactId "practica0", en una carpeta cualquiera con permisos de escritura (ej: "Documentos").

    A través de "Open Folder" en el explorador de ficheros de VSCode, abre la carpeta creada, que debería tener el nombre de "practica0".

    Se abrirá un VSCode para trabajar en esa carpeta. Emplear la vista "Java Projects" (puede que tarde un poco en estar disponible y/o activas todas las funciones).

    Prueba abrir y ejecutar el código Main que se encuentra en src/main/java -> proii_aedi -> Main (fichero src/main/java/proii_aedi/Main.java).

    Para cada ejercicio crearíamos un paquete y, al menos, una clase. Por ejemplo, para el ejercicio 1, crearíamos un paquete "ejercicio1" (botón "+" en src/main/java. Si no se ve al hacerlo, se recomienda probar a refrescar el proyecto con la opción Refresh en los "···" en Java Projects). Después se crearía una clase "Ejercicio1" (botón "+" en el paquete recientemente creado).

Ejercicio 1

En un paquete ejercicio1, clase Ejercicio1, entro del proyecto practica0, crea una clase con el siguiente código:

package ejercicio1; 

public class Ejercicio1 { 
    public static void main(String[] args) { 
        System.out.println("Aprendiendo Java");
    } 
}

    Ejecuta el código (empleando el icono de play visualizando el fichero). Haz cualquier modificación sencilla y vuelve a ejecutar.

    Añade al programa anterior las instrucciones necesarias para que visualice también el mensaje "Este es mi primer programa en Java". Prueba a usar bloque de textos (text blocks).

    Añade al programa una lectura por teclado de edad (entero), nombre (cadena de texto) y nota (decimal) y muestra los datos por salida estándar.

Ejercicio 2

En un paquete ejercicio2, clase Ejercicio2, ejecuta el siguiente programa que declara dos números enteros, los suma a través de un método suma y finalmente muestra el resultado.

package ejercicio2; 

public class Ejercicio2 { 

  public static void main(String[] args) { 
     var num1 = 5; 
     var num2 = 2;  
     System.out.println("Suma de " + num1 + " y " + num2 + " es: " + suma(num1, num2)); 
  } 

  public static int suma (int n1, int n2) { 
      return n1 + n2; 
  }     

} 

Añade código al programa anterior para que realice, mediante métodos, las cuatro operaciones aritméticas básicas (suma, resta, multiplicación y división) sobre los dos números enteros. Se debe controlar que el divisor no sea cero, en cuyo caso el resultado de la división deberá ser 0.
Ejercicio 3

En un paquete ejercicio3, clase Ejercicio3, escribe un programa que lea por teclado un número entero e indique por pantalla, mediante mensajes que aparecerán en líneas diferentes, las características de dicho número:

    "Número par" si el número es par y "Número impar" en caso contrario.
    "Número cero" si el número es cero y "Número distinto de cero" en caso contrario.
    "Número elevado" si el número es mayor de 100 y "Número bajo" en caso contrario.

Ejercicio 4

Escribe un programa que solicite un carácter y dos números reales al usuario.

    Si el carácter es ‘+’, el programa calculará la suma de los dos números introducidos.
    Si el carácter es ‘-‘, calculará la resta de los dos números introducidos.
    Si el carácter es ‘*’, calculará el producto de los dos números introducidos.
    Si el carácter es ‘/’, calculará el cociente de los dos números introducidos.
    El programa debe almacenar el resultado en una variable y luego mostrarlo por pantalla.
    Prueba el programa con diferentes caracteres para que realice distintas operaciones.
    ¿Qué ocurre si se introduce un carácter que no se corresponde con ninguno de los previstos? Añade el código necesario para que en ese caso aparezca el mensaje "Opción incorrecta", y se calcule como resultado Double.NaN ("not a number").
    Si se introduce un cero como segundo valor, la división provocará un error. Añade el código necesario para que en este caso, en vez de aparecer un error, aparezca el mensaje "La división no puede realizarse porque el divisor es cero" y se calcule como resultado Double.NaN ("not a number").

Ejercicio 5

Escribe un programa que calcule la suma de los N primeros números pares. Este número N se leerá del teclado y es obligatorio garantizar que N sea positivo, volviendo a pedir al usuario hasta que sea correcto.
Ejercicio 6

Escribe un programa que calcule si un número introducido por teclado es o no primo. Un número primo es un número natural mayor que 1 que tiene únicamente dos divisores distintos: él mismo y el 1.
Ejercicio 7

Amplia el programa del ejercicio 4 de manera que, tras realizar una operación, se solicite por teclado si se quiere realizar otra operación. Se podrá indicar ‘s’ o ‘n’ según si quiere seguir o no. Si se introduce la ‘s’, el programa debe volver a solicitar los datos para realizar la nueva operación. Si no, debe acabar.
Ejercicio 8

Escribe un programa que calcule la letra del DNI a partir del número. Para ello debes obtener el resto de dividir el número entre 23. La letra asociada al número vendrá dada por la siguiente tabla:
T 	R 	W 	A 	G 	M 	Y 	F 	P 	D 	X 	B 	N 	J 	Z 	S 	Q 	V 	H 	L 	C 	K 	E
0 	1 	2 	3 	4 	5 	6 	7 	8 	9 	10 	11 	12 	13 	14 	15 	16 	17 	18 	19 	20 	21 	22
Ejercicio 9

Escribe un programa que solicite por teclado 10 números enteros, los guarde en un array y que, mediante métodos, calcule el valor máximo, el mínimo y el promedio de esos 10 valores.
Ejercicio 10

Repite el programa anterior haciendo uso del paquete activity0 del proyecto AEDI-Activities. Para probar el correcto funcionamiento de la solución haz uso de la clase disponible para ello en el mismo paquete.
Ejercicio 11

Implementa un programa, usando métodos, que almacene en una matriz bidimensional las notas (números reales leídos de teclado) que tienen un número concreto de estudiantes. Tanto el número de estudiantes como el número de notas que tienen (todos los/as estudiantes tienen el mismo número de notas), se leerán también por teclado. Visualiza posteriormente las notas de esos/as estudiantes. Para ello haz uso del paquete activity0 del proyecto AEDI-Activities. Para probar el correcto funcionamiento de la solución haz uso de la clase disponible para ello en el mismo paquete.
Ejercicio 12

Implementa un programa que almacene en una matriz de 3x3 números enteros solicitados por teclado. A continuación, el programa debe solicitar por teclado un número entero y debe calcular en qué fila y en qué columna se encuentra la primera ocurrencia de ese número en la matriz. Una vez localizada esa primera ocurrencia no se debe continuar buscando por la matriz. En el caso de que en la matriz no se encuentre ese número deberá especificarlo mediante un mensaje.

