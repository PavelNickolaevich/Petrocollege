package main.kotlin.classes.task_4

import main.kotlin.classes.task_3.Point
import kotlin.math.sqrt

class Triangle(val a: Point, val b: Point, val c: Point) {

    // Шаг 1: Вычисление середины каждой стороны треугольника
    private  val ab = a.x * 0.5 + b.x * 0.5
    private val ac = a.x * 0.5 + c.x * 0.5
    private val bc = b.x * 0.5 + c.x * 0.5
    private val abm = a.y * 0.5 + b.y * 0.5
    private val acm = a.y * 0.5 + c.y * 0.5
    private val bcm = b.y * 0.5 + c.y * 0.5

    // Шаг 2: Нахождение координат точек пересечения серединных перпендикуляров с противоположными сторонами
    private val am = (ab * abm - ac * acm) / (b.x - c.x)
    private val bm = (ac * acm - ab * abm) / (c.x - a.x)
    private val cm = (ab * abm - bc * bcm) / (a.x - b.x)

    // Шаг 3: Нахождение координат центра окружности
    private val centerX = (am + bm + cm) / 3
    private val centerY = (abm + acm + bcm) / 3

    val circumcenter = Point(centerX, centerY)

    private val s = 0.5 * ((a.x * b.y - a.y * b.x) + (b.x * c.y - b.y * c.x) + (c.x * a.y - c.y * a.x))
    val radius = sqrt(s)

}