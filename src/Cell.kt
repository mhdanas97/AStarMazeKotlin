class Cell(val x: Int, val y: Int, val cost: Int, private val parent: Cell?) {
    constructor(x: Int, y: Int) : this(x, y, 0, null)

    override fun toString(): String = "x =  $x  y = $y  cost = $cost"

    fun printPath() {
        if (this.parent != null)
            this.parent.printPath()
        println(this)
    }
}