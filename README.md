# Aplicación de Cabina Telefónicas

Este proyecto es una aplicación de consola escrita en Kotlin para controlar los gastos telefónicos de una empresa. La empresa cuenta con cabinas telefónicas a través de las cuales se pueden realizar llamadas locales, de larga distancia y a celulares.

## Funcionalidades

1. **Registrar llamada:** Permite registrar una llamada especificando el tipo de llamada y la cabina utilizada.
2. **Mostrar información de una cabina:** Muestra la información detallada de una cabina, incluyendo el número de llamadas realizadas, la duración total de las llamadas y el costo total.
3. **Mostrar consolidado total:** Muestra un resumen de todas las cabinas, incluyendo el número total de llamadas, la duración total y el costo total.
4. **Reiniciar cabina:** Restablece los valores de una cabina específica a cero.
5. **Agregar más cabinas:** Permite agregar nuevas cabinas al sistema.
6. **Salir:** Cierra la aplicación.

## Uso

Al iniciar la aplicación, el sistema comienza con una cabina telefónica preconfigurada. Puedes agregar más cabinas utilizando el menú. Para registrar llamadas, simplemente selecciona la cabina deseada y el tipo de llamada.

### Tipos de Llamadas

- **Llamada Local:** $50 pesos por minuto.
- **Llamada Larga Distancia:** $350 pesos por minuto.
- **Llamada a Celular:** $150 pesos por minuto.

### Menú de Opciones

El menú de la aplicación ofrece las siguientes opciones:

1. **Registrar llamada:** Te permite registrar una llamada seleccionando una cabina y especificando el tipo de llamada. La duración de la llamada se genera aleatoriamente entre 1 y 60 minutos.
2. **Mostrar información de una cabina:** Muestra el número de llamadas, duración total y costo total de las llamadas de una cabina específica.
3. **Mostrar consolidado total:** Muestra un resumen de todas las cabinas con información consolidada.
4. **Reiniciar cabina:** Reinicia los valores de una cabina específica a cero.
5. **Agregar más cabinas:** Agrega una o más cabinas al sistema.
6. **Salir:** Finaliza la ejecución de la aplicación.

## Requisitos

- Kotlin 1.5.0 o superior
- Un entorno de desarrollo compatible con Kotlin (por ejemplo, IntelliJ IDEA)

## Ejecución

1. Clona el repositorio en tu máquina local.
2. Abre el proyecto en tu IDE.
3. Ejecuta la función `main()` en la clase `Main`.

## Notas

- **Excepciones:** El programa maneja la entrada incorrecta solicitando al usuario que ingrese valores válidos. Si se ingresa un tipo de llamada incorrecto, se lanza una excepción.
- **Aleatoriedad:** La duración de las llamadas se genera de manera aleatoria para simular escenarios reales de duración variable.
- **Expansión:** El sistema puede expandirse agregando más cabinas según sea necesario.

## Autor

**Nicolás Guzmán Montaña**  
Estudiante de la Universidad de Cundinamarca - Línea de Profundización III
