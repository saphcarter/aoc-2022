fun main() {
    fun priorityCalc(alpha: Char): Int{
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
                //println("char: $char, priority: $prior")
                priority += priorityCalc(char)
            }
        }
        return priority
    }

    fun part2(input: List<String>): Int {
        var priority = 0
        for(i in 0 .. input.size step 3){
            if(i < input.size-2){
                val halfIntersect = input[i].toSet() intersect input[i + 1].toSet()
                val fullIntersect = halfIntersect intersect input[i + 2].toSet()
                priority += priorityCalc(fullIntersect.first())
            }
        }
        return priority
    }

    // test if implementation meets criteria from the description, like:
    val testInput = listOf("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw")
    val test1 = part1(testInput)
    check(test1 == 157)
    println("Test 1 passed")

    val test2 = part2(testInput)
    check(test2 == 70)
    println("Test 2 passed")

    val input = readInput("Input03")
    //println(part1(input))
    println(part2(input))
}