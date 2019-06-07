package slotmachine

class SlotMachine {
    val slots = new Array[Symbol](3)
    // Init the symbols
    var symbols = new Array[Symbol](3)
    symbols(0) = new Symbol("*", 1, Console.YELLOW)
    symbols(1) = new Symbol("+", 2, Console.BLUE)
    symbols(2) = new Symbol("7", 3, Console.RED)

    var win = 0

    /**
    *   Start a slotmachine party
    */
    def start = {
        spin
        checkWin
        printResult
    }

    /**
    *   Spin it
    */
    def spin = {
        setSymbol(0)
        setSymbol(1)
        setSymbol(2)
    }

    // Check if we got a win situation here
    def checkWin = {
        if(slots(0).visual == slots(1).visual && slots(1).visual == slots(2).visual) {
            win = slots(0).win
        } else {
            win = 0
        }
    }

    /**
    *   Check if the player has won
    */
    def hasWon = win > 0

    /**
    *   Print the result of the slot machine
    */
    def printResult = {
        println("-" * 13)

        print("| ")
        print(slots(0).color + slots(0).visual)
        Thread.sleep(1000)
        print(Console.WHITE + " | ")
        print(slots(1).color + slots(1).visual)
        Thread.sleep(1000)
        print(Console.WHITE + " | ")
        print(slots(2).color + slots(2).visual)
        println(Console.WHITE + " |")

        println("-" * 13)
        Thread.sleep(1000)
    }

    /**
    *   Set a random slot icon at slot position index
    */
    def setSymbol(index:Int) = {
        val rand = new scala.util.Random
        slots(index) = symbols(rand.nextInt(3))
    }
}