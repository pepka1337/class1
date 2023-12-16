import kotlin.math.abs

data class Point(val x: Double, val y: Double)

class Triangle(val p1: Point, val p2: Point, val p3: Point) {
    fun containsPoint(point: Point): Boolean {
        val areaOrig = triangleArea(p1, p2, p3)
        val area1 = triangleArea(point, p2, p3)
        val area2 = triangleArea(p1, point, p3)
        val area3 = triangleArea(p1, p2, point)
        return (area1 + area2 + area3) == areaOrig
    }

    private fun triangleArea(p1: Point, p2: Point, p3: Point): Double {
        return abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0)
    }
}

fun main() {
    println("Введите координаты вершины A треугольника (x, y):")
    val x1 = readLine()?.toDouble() ?: 0.0
    val y1 = readLine()?.toDouble() ?: 0.0

    println("Введите координаты вершины B треугольника (x, y):")
    val x2 = readLine()?.toDouble() ?: 0.0
    val y2 = readLine()?.toDouble() ?: 0.0

    println("Введите координаты вершины C треугольника (x, y):")
    val x3 = readLine()?.toDouble() ?: 0.0
    val y3 = readLine()?.toDouble() ?: 0.0

    val triangle = Triangle(Point(x1, y1), Point(x2, y2), Point(x3, y3))

    println("Введите координаты точки (x, y):")
    val pointX = readLine()?.toDouble() ?: 0.0
    val pointY = readLine()?.toDouble() ?: 0.0
    val point = Point(pointX, pointY)

    val inside = triangle.containsPoint(point)
    if (inside) {
        println("Точка находится внутри треугольника")
    } else {
        println("Точка находится вне треугольника")
    }
}
