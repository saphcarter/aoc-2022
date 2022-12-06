import java.util.EnumSet.range

fun main() {
    fun priority(alpha: Char): Int{
        return if (alpha.isLowerCase()) {
            alpha.code - 96
        } else alpha.code - 38;
    }

    fun part1(input: List<String>): Int {
        var priority = 0
        input.forEach {
            val inputList = it.toList()
            val size = inputList.size
            val comp1 = inputList.subList(0,(size/2))
            val comp2 = inputList.subList(size/2,size)
            val intersect = comp1 intersect comp2
            //println("comp1: $comp1, comp2:$comp2, intersect: $intersect")
            intersect.forEach { char: Char ->
                val prior = priority(char)
                //println("char: $char, priority: $prior")
                priority += prior
            }
        }
        return priority
    }

    fun part2(input: List<String>): Int {
        var priority = 0
        for(i in 0 .. input.size step 3){
            val elf1, elf2, elf 3 = 
        }
        return priority
    }

    // test if implementation meets criteria from the description, like:
    val testInput = listOf("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw")
    val answer = part1(testInput)
    check(answer == 157)
    println("Test passed")

    val input = readInput("Input03")
    println(part1(input))
    println(part2(input))
}