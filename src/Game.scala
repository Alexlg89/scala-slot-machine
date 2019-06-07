package slotmachine

class Game {

    def start = {
        // Costs per spin
        var bet = 1
        // Continue y/n
        var continue = "y"
        // New player with 20 coins
        val player = new Player(20)
        // Do it!
        val slotMachine = new SlotMachine
        
        // Game loop
        while(continue == "y" && player.hasCoins) {
            // Draw header and stats
            printHeader
            printPlayerCoins

            // Read the player bet
            readPlayerBet

            // Player pays for the game
            player.lostCoins(bet)
            println("> You pay: " + bet)
            println("")
            Thread.sleep(1000)

            // Start a slotmachine party
            slotMachine.start

            // Print win/loss
            println("")
            if(slotMachine.hasWon) {
                val win = slotMachine.win * bet
                player.wonCoins(win)
                println(Console.GREEN + "> YOU WON " + win + " <")
            } else {
                println(Console.RED + "> YOU LOST <")
            }
            println(Console.WHITE + "")
            Thread.sleep(1000)

            // Check if player can play again
            if(player.hasCoins) {
                println("-" * 20)
                printPlayerCoins
                // Print wanna play again?
                println("Again? y/n")
                continue = scala.io.StdIn.readLine()
            } else {
                println("Looser! You have no coins to play again.")
            }
            
        }

        /**
        *   Print the header
        */
        def printHeader = {
            println(Console.WHITE + "")
            println("")
            println("")
            println("")
            println("-" * 20)
            println("   SLOT MACHINE   ")
            println("-" * 20)
            Thread.sleep(1000)
        }

        /**
        *   Draw the player coins
        */
        def printPlayerCoins = {
            println("")
            println("You have: " + player.coins)
            println("")
            Thread.sleep(1000)
        }

        def readPlayerBet: Unit = {
            println("")
            println("Place your bet:")
            bet = scala.io.StdIn.readInt()

            if(bet > player.coins) {
                println("")
                println("You don't have enough coins, fool!")
                println("")
                readPlayerBet
            }
        }
    }
}