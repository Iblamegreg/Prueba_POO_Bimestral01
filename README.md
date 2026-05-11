# Prueba_POO_Bimestral01

# Sistema de Entregas con Drones Autónomos - PRUEBA BI

Este repositorio contiene la resolución de la Evaluación del Primer Bimestre de la asignatura de Programación Orientada a Objetos. El proyecto consiste en un sistema logístico inteligente que gestiona entregas mediante drones utilizando el lenguaje Java.

## Descripción del Proyecto

La solución implementa una estructura de clases para diferentes tipos de drones (Liviano, Carga y Emergencia), cada uno con sus propias reglas de negocio, capacidades y métodos de cálculo de costos. Se han aplicado los pilares fundamentales de la Programación Orientada a Objetos.

## Conceptos POO Aplicados

- **Clase Abstracta (`Dron`):** Define la estructura base y los métodos que toda clase hija debe implementar.
- **Herencia:** Las clases `DronLiviano`, `DronCarga` y `DronEmergencia` extienden de la clase padre.
- **Encapsulamiento:** Atributos protegidos y privados con acceso mediante métodos `getters` y `setters` con validación lógica.
- **Polimorfismo:** Uso de referencias de la clase padre para manejar distintos tipos de objetos y ejecutar métodos sobrescritos (`@Override`).
- **Validaciones:** Control de límites de peso y horas de vuelo específicos por cada tipo de dron.

## Video de Reflexión

Enlace:

[**https://youtu.be/ZIu-huLhFZw?si=jg8XqSruFrguRmoS**] 

## Autor

**Gregory Alejandro Araujo Ayala** Estudiante de Software - Escuela de Formación de Tecnólogos (ESFOT)  
Escuela Politécnica Nacional
