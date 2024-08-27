//Universidad de Cundinamarca
//Linea de Profundizacion III
//Nicolas Guzman Montaña

import kotlin.system.exitProcess
import kotlin.random.Random

// Clase de cabina telefónica
class CabinaTelefonica {
    private var numeroLlamadas: Int = 0
    private var duracionTotal: Int = 0
    private var costoTotal: Int = 0

    // Función para registrar una llamada en la cabina
    fun registrarLlamada(tipoLlamada: Int) {
        val duracion = Random.nextInt(1, 61) // Genera un número aleatorio entre 1 y 60 minutos
        val costoPorMinuto = when (tipoLlamada) {
            1 -> 50        // Llamada Local
            2 -> 350       // Llamada Larga Distancia
            3 -> 150       // Llamada a Celular
            else -> throw IllegalArgumentException("Tipo de llamada no válido")
        }
        numeroLlamadas++
        duracionTotal += duracion
        costoTotal += duracion * costoPorMinuto
        println("Duración de la llamada: $duracion minutos")
    }

    // Función para mostrar la información detallada de la cabina
    fun mostrarInfo() {
        println("Número de llamadas: $numeroLlamadas")
        println("Duración total de llamadas: $duracionTotal minutos")
        println("Costo total de llamadas: $$costoTotal pesos")
    }

    // Función para reiniciar la cabina, restableciendo todos los valores a cero
    fun reiniciar() {
        numeroLlamadas = 0
        duracionTotal = 0
        costoTotal = 0
    }

    // Función para obtener la duración total de las llamadas
    fun obtenerDuracionTotal() = duracionTotal

    // Función para obtener el costo total de las llamadas
    fun obtenerCostoTotal() = costoTotal
}

// Clase principal que maneja las operaciones de la aplicación
class Main {
    private val cabinas = mutableListOf<CabinaTelefonica>()

    // Inicialización de la clase, comenzando con una cabina y llamando al menú
    init {
        cabinas.add(CabinaTelefonica())  // Iniciar con una cabina
        menu()
    }

    // Función para solicitar un número válido al usuario
    private fun solicitarNumero(mensaje: String): Int {
        while (true) {
            print(mensaje)
            val input = readLine()
            val numero = input?.toIntOrNull()
            if (numero != null && numero > 0) {
                return numero
            } else {
                println("Por favor, ingrese un número válido.")
            }
        }
    }

    // Función que despliega el menú principal y maneja la selección del usuario
    private fun menu() {
        while (true) {
            println("\nSeleccione una opción:")
            println("1. Registrar llamada")
            println("2. Mostrar información de una cabina")
            println("3. Mostrar consolidado total")
            println("4. Reiniciar una cabina")
            println("5. Agregar más cabinas")
            println("6. Salir")
            print("Opción: ")

            when (solicitarNumero("Ingrese una opción: ")) {
                1 -> registrarLlamada()
                2 -> mostrarInfoCabina()
                3 -> mostrarConsolidadoTotal()
                4 -> reiniciarCabina()
                5 -> agregarCabinas()
                6 -> {
                    println("Saliendo...")
                    exitProcess(0)
                }
                else -> println("Opción no válida.")
            }
        }
    }

    // Función para registrar una llamada en una cabina específica
    private fun registrarLlamada() {
        val cabinaNumero = solicitarNumero("Ingrese el número de cabina (1 a ${cabinas.size}): ")
        if (cabinaNumero in 1..cabinas.size) {
            val tipoLlamada = solicitarNumero("Ingrese el tipo de llamada (1: Local, 2: Larga Distancia, 3: Celular): ")
            if (tipoLlamada in 1..3) {
                cabinas[cabinaNumero - 1].registrarLlamada(tipoLlamada)
                println("Llamada registrada exitosamente.")
            } else {
                println("Tipo de llamada no válido.")
            }
        } else {
            println("Número de cabina no válido.")
        }
    }

    // Función para mostrar la información de una cabina específica
    private fun mostrarInfoCabina() {
        val cabinaNumero = solicitarNumero("Ingrese el número de cabina (1 a ${cabinas.size}): ")
        if (cabinaNumero in 1..cabinas.size) {
            cabinas[cabinaNumero - 1].mostrarInfo()
        } else {
            println("Número de cabina no válido.")
        }
    }

    // Función para mostrar un consolidado total de todas las cabinas
    private fun mostrarConsolidadoTotal() {
        var costoTotal = 0
        var duracionTotal = 0
        var totalLlamadas = 0

        for (cabina in cabinas) {
            costoTotal += cabina.obtenerCostoTotal()
            duracionTotal += cabina.obtenerDuracionTotal()
            totalLlamadas += cabina.obtenerDuracionTotal() // Número de llamadas es igual a la duración total.
        }

        val costoPromedioPorMinuto = if (duracionTotal > 0) costoTotal / duracionTotal else 0

        println("Consolidado Total:")
        println("Número total de llamadas: $totalLlamadas")
        println("Duración total de llamadas: $duracionTotal minutos")
        println("Costo total de llamadas: $$costoTotal pesos")
        println("Costo promedio por minuto: $$costoPromedioPorMinuto pesos")
    }

    // Función para reiniciar una cabina específica
    private fun reiniciarCabina() {
        val cabinaNumero = solicitarNumero("Ingrese el número de cabina (1 a ${cabinas.size}): ")
        if (cabinaNumero in 1..cabinas.size) {
            cabinas[cabinaNumero - 1].reiniciar()
            println("Cabina reiniciada exitosamente.")
        } else {
            println("Número de cabina no válido.")
        }
    }

    // Función para agregar más cabinas al sistema
    private fun agregarCabinas() {
        val cantidad = solicitarNumero("Ingrese la cantidad de cabinas que desea agregar: ")
        for (i in 1..cantidad) {
            cabinas.add(CabinaTelefonica())
        }
        println("$cantidad cabina(s) agregada(s) exitosamente.")
    }
}

