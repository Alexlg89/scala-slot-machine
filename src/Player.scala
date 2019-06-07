package slotmachine

class Player (_coins: Int) {

    var coins = _coins

    /**
    *   Check if player has coins
    */
    def hasCoins = coins > 0

    /**
    *   Apply win
    */
    def wonCoins(won:Int = 1) = {
        if(won > 0) coins += won
    }

    /**
    *   Apply loss
    */
    def lostCoins(lost:Int = 1) = {
        if(lost > 0) coins -= lost
    }
}