
# 📘 OwnGuias-Programacion 📘

Proyecto de guías y prácticas de programación usadas en la asignatura PROII.

## Descripción

Colección de enunciados, soluciones y recursos para prácticas y ejercicios en Java. Incluye ejemplos, apuntes y plantillas utilizadas por el curso.

## Estructura principal

- `doc/`
	- `enunciados/` — enunciados de prácticas y ejercicios.
	- `Prácticas/` — carpetas por práctica, por ejemplo `practica0/` contiene un proyecto Maven de ejemplo.
		- `practica0/` — `pom.xml`, `src/main/java/` con ejercicios y un `target/` compilado.
	- `respuestas/` — materiales con apuntes y soluciones por tema.
- `pdf/` — recursos, plantillas y archivos auxiliares (por ejemplo `templates/eisvogel`).

## Requisitos

- Java JDK 11+ instalado
- Maven instalado (si vas a compilar los proyectos Maven)

## Comandos útiles

Compilar la práctica 0 con Maven:

```bash
mvn -f doc/Prácticas/practica0/pom.xml clean package
```

Compilar sólo:

```bash
mvn -f doc/Prácticas/practica0/pom.xml compile
```

Ejecutar tests:

```bash
mvn -f doc/Prácticas/practica0/pom.xml test
```

Para abrir el proyecto en un IDE, importa la carpeta `doc/Prácticas/practica0` como proyecto Maven.

## Contribuciones

Si quieres añadir mejoras, abre un issue o envía un pull request con los cambios propuestos.

## Licencia

Licencia no especificada. Añade un archivo `LICENSE` si quieres aclarar los términos.

---
Actualizado en español: descripción y estructura de carpetas.
