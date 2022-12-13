fun main() {

    fun part1(input: String): Int? {
        val chars = input.toList()
        for(char in 3 until chars.size){
            if(chars.subList(char - 3, char + 1).toSet().size == 4){
                return char + 1
            }
        }
        return null
    }

    fun part2(input: String): Int? {
        val chars = input.toList()
        for(char in 13 until chars.size){
            if(chars.subList(char - 13, char + 1).toSet().size == 14){
                return char + 1
            }
        }
        return null
    }

    val input = readInput("Input06")
    input.forEach { println(part1(it)) }
    input.forEach { println(part2(it)) }
}