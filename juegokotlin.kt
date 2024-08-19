import java.util.Scanner

const val WALL = '#'
const val PATH = ' '
const val PLAYER = 'P'
const val EXIT = 'E'

val maze = arrayOf(
    charArrayOf(WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL),
    charArrayOf(WALL, PATH, PATH, WALL, PATH, PATH, PATH, WALL),
    charArrayOf(WALL, PATH, WALL, WALL, WALL, PATH, WALL, WALL),
    charArrayOf(WALL, PATH, PATH, PATH, WALL, PATH, EXIT, WALL),
    charArrayOf(WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL),
    charArrayOf(WALL, WALL, WALL, PATH, PATH, PATH, PATH, WALL),
    charArrayOf(WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL)
)

var playerPos = intArrayOf(1, 1) // posición inicial del jugador

fun printMaze() {
    for (i in maze.indices) {
        for (j in maze[i].indices) {
            if (i == playerPos[0] && j == playerPos[1]) {
                print(PLAYER)
            } else {
                print(maze[i][j])
            }
        }
        println()
    }
}

fun movePlayer(direction: String) {
    val newPos = playerPos.clone()

    when (direction) {
        "w" -> newPos[0]-- // arriba
        "s" -> newPos[0]++ // abajo
        "a" -> newPos[1]-- // izquierda
        "d" -> newPos[1]++ // derecha
        else -> {
            println("Movimiento no válido. Usa 'w', 'a', 's', 'd'.")
            return
        }
    }

    if (maze[newPos[0]][newPos[1]] != WALL) {
        playerPos = newPos
    } else {
        println("¡Chocaste con una pared!")
    }

    if (maze[playerPos[0]][playerPos[1]] == EXIT) {
        println("¡Felicidades! Has encontrado la salida.")
        System.exit(0)
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    println("Bienvenido al juego de Laberinto.")
    println("Usa 'w' para arriba, 's' para abajo, 'a' para izquierda, 'd' para derecha.")
    println("Intenta encontrar la salida (E).")

    while (true) {
        printMaze()
        print("Tu movimiento: ")
        val input = scanner.nextLine()
        movePlayer(input)
    }
}
