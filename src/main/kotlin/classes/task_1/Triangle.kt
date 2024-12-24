package main.kotlin.classes.task_1

import kotlin.math.abs

class Triangle (a: Point, b: Point, c: Point) {

    private val sideABLengthSquared = abs(a.x - b.x) * abs(a.x - b.x) + abs(a.y - b.y) * abs(a.y - b.y)
    private val sideBCLengthSquared = abs(b.x - c.x) * abs(b.x - c.x) + abs(b.y - c.y) * abs(b.y - c.y)
    private val sideCALengthSquared = abs(c.x - a.x) * abs(c.x - a.x) + abs(c.y - a.y) * abs(c.y - a.y)

    fun isPointInside(p: Point): Boolean {
        val ab = p - a
        val bc = p - b
        val ca = p - c

        val sumSideLengthSquares = sideABLengthSquared + sideBCLengthSquared + sideCALengthSquared
        val innerProductsSum = Point.dotProduct(ab, bc) + Point.dotProduct(bc, ca) + Point.dotProduct(ca, ab)

        return innerProductsSum <= sumSideLengthSquares
    }

}