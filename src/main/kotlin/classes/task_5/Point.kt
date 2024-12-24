package main.kotlin.classes.task_5

data class Point(val x: Int, val y: Int) {
    override fun toString(): String {
        return "($x, $y)"
    }
}