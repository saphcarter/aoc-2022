fun main() {

    fun part1(input: List<String>): Int {
        var counter = 0
        input.forEach {
            val (firstFrom, firstTo, secondFrom, secondTo) = it.split('-', ',').map(String::toInt)
            if((firstFrom <= secondFrom && firstTo >= secondTo) || (firstFrom >= secondFrom && firstTo <= secondTo)){
                counter++
            }
        }
        return counter
    }

    fun part2(input: List<String>): Long {
        return input.sumOf {
            val (firstFrom, firstTo, secondFrom, secondTo) = it.split('-', ',').map(String::toInt)
            val pair = firstFrom..firstTo to secondFrom..secondTo
            if (pair.first.toSet().intersect(pair.second.toSet()).isNotEmpty()) 1L else 0L
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = listOf("2-4,6-8","2-3,4-5","5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8")
    val test1 = part1(testInput)
    check(test1 == 2)
    println("Test 1 passed")

    /*val test2 = part2(testInput)
    check(test2 == 4)
    println("Test 2 passed")*/

    val input = readInput("Input04")
    //println(part1(input))
    println(part2(input))
}
