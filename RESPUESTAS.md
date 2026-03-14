# Este es el documento donde indicaremos las respuestas del ejercicio propuesto:

## Ejercicio 1)
- **1.1:** Si quiero añadir el ataque Meteoro debo modificar todo el código, cosa que violaria los principios SOLID.
- **1.2:** Tendriamos que modificar mtodo el rato esta parte de código 
- **1.3** Patrón Fabric

## Ejercicio 2)
- **2.1** Se viola el principio OCP (Las clases deben estar abiertas a extendión pero cerradas a modificación
- **2.2** Strategy Pattern

## Ejercicio 3)
- **3.1** Un constructor con muchos parametros puede dar muchos problemas tales como que si hay algunos opcionales eso se llena de nulls y que sea más dificultoso para entender.
- **3.2**Con el Patron Builder
- **3.3** El Patron Builder

## Ejercicio 4) 
- **4.1** Que cada clase tendría su propio mapa, por lo tanto no compartirían batallas
- **4.2** Tenemos que proporcionar un punto de acceso global a dicha instancia
- **4.3** El patron Singleton

## Ejercicio 5) 
- **5.1** El controller se acopla a formatos externos y duplica la lógica implementada por el proveedor
- **5.2** Usando mapeadores especificos para contruir objetos de dominio
- **5.3** Adapter

## Ejercicio 6) 
- **6.1** si se añadde 5 suscriptores más, se tendria que modificar _applyDamage()_ y meter más lineas
- **6.2** Para descoplar hacemos que el servicio publique un evento y otros objetos que estan suscritos lo escuchen
- **6.3** Patron Observer
