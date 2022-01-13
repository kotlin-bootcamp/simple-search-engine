package search

fun main() {
    SearchApplication().run()
}

enum class ProgramStatus {
    CONTINUE, EXIT
}

class SearchApplication {
    private val searchEngine: SearchEngine

    init {
        println("Enter the number of people:")
        val lineCount = readLine()!!.toInt()
        println("Enter all people:")
        val dataSet = MutableList(lineCount) { readLine()!! }

        searchEngine = SearchEngine(dataSet)
    }

    fun run() {
        do {
            val menuNum = printMenuAndRead()
        } while (executeMenu(menuNum) != ProgramStatus.EXIT)
    }

    private fun printMenuAndRead(): Int {
        println(
            "=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit"
        )

        return readLine()!!.toInt()
    }

    private fun executeMenu(menuNum: Int): ProgramStatus {
        return when (menuNum) {
            1 -> menu1()
            2 -> menu2()
            0 -> menu0()
            else -> incorrectMenu()
        }
    }

    private fun menu0(): ProgramStatus {
        println("Bye!")
        return ProgramStatus.EXIT
    }

    private fun menu1(): ProgramStatus {
        searchEngine.findPerson()
        return ProgramStatus.CONTINUE
    }

    private fun menu2(): ProgramStatus {
        searchEngine.printAllPeople()
        return ProgramStatus.CONTINUE
    }

    private fun incorrectMenu(): ProgramStatus {
        println("Incorrect option! Try again.")
        return ProgramStatus.CONTINUE
    }

    class SearchEngine(dataSet: MutableList<String>) {
        private val dataSet = dataSet
        fun findPerson() {
            println("Enter a name or email to search all suitable people.")
            val query = readLine()!!
            searchLine(dataSet, query).forEach { println(it) }
        }

        fun printAllPeople() {
            println("=== List of people ===")
            dataSet.forEach { println(it) }
        }

        private fun searchLine(dataSet: MutableList<String>, query: String): List<String> {
            val result = mutableListOf<String>()
            for (data in dataSet) {
                if (data.lowercase().contains(query.lowercase()))
                    result.add(data)
            }

            return result.toList()
        }
    }
}

