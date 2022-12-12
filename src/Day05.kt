fun main() {

    fun String.locateCrate(index: Int): Char? {
        val crateIndex = 1 + (4 * index)
        return if (crateIndex > this.length) null else {
            val crate = this[crateIndex]
            if (crate.isWhitespace()) null else crate
        }
    }

    fun parseCrates(input: List<String>): List<ArrayDeque<Char>>{
        val stacks = input[input.size - 1].split("   ").map { ArrayDeque<Char>() }
        for (i in input.size - 2 downTo 0) {
            for (j in stacks.indices) {
                input[i].locateCrate(j)?.let { crate -> stacks[j].addLast(crate) }
            }
        }
        return stacks
    }

    data class Instructions(val move: Int, val from: Int, val to: Int)

    fun parseInstructions(input: List<String>): List<Instructions> {
        val instructions = mutableListOf<Instructions>()
        input.forEach { line ->
            val (m, f, t) = line.split("move ", " from ", " to ").mapNotNull { it.toIntOrNull() }
            instructions.add(Instructions(m, f, t))
        }
        return instructions
    }

    fun part1(input: List<String>): List<ArrayDeque<Char>> {
        val stacks = parseCrates(input.subList(0,9))
        println(stacks)
        val instructions = parseInstructions(input.subList(10, input.size))
        for (instructs in instructions){
            for(i in 1..instructs.move){
                val crate = stacks[instructs.from - 1].removeLast()
                stacks[instructs.to -1].addLast(crate)
            }
        }
        return stacks
    }

    fun part2(input: List<String>): List<ArrayDeque<Char>> {
        val stacks = parseCrates(input.subList(0,9))
        val instructions = parseInstructions(input.subList(10, input.size))
        for (instructs in instructions){
            val tempOrder: ArrayDeque<Char> = ArrayDeque()
            for(i in 1..instructs.move){
                val crate = stacks[instructs.from - 1].removeLast()
                tempOrder.addLast(crate)
            }
            for(j in tempOrder.indices){
                val crate = tempOrder.removeLast()
                stacks[instructs.to-1].addLast(crate)
            }
        }
        return stacks
    }

    val input = readInput("Input05")
    println(part1(input))
    println(part2(input))
}