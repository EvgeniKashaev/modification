fun main() {

    println(commission("MasterCart", 14000, 75_001))
    println(commission("Mir", 1000))
    println(commission("VK Play", 15500))

}
fun commission(name: String = "VK Play", transferAmount: Int, transferAmountMonth:Int = 0): Int {

    when (name) {
        "MasterCart", "Maestro", "Visa", "Mir" -> if (maximumTransferPer(name, transferAmount, transferAmountMonth)) {
            return commissionAmount(name, transferAmount, transferAmountMonth)
        }

        "VK Play" -> if (maximumTransferPer(name, transferAmount, transferAmountMonth)) {
            return 0
        }
    }
    return -1
}
fun maximumTransferPer(name: String, transferAmount: Int, transferAmountMonth: Int): Boolean {

    when (name) {

        "MasterCart", "Maestro", "Visa", "Mir" -> if (transferAmountMonth < 600_000 || transferAmount < 150_000) {
            return true
        }

        "VK Play" -> if (transferAmountMonth < 40_000 || transferAmount < 15_000) {
            return true
        }
    }
    return false
}

fun commissionAmount(name: String, transferAmount: Int, transferAmountMonth: Int): Int {
    when (name) {
        "MasterCart", "Maestro" -> return when (transferAmountMonth) {
            in 300..75_000 -> {
                0
            }

            else -> {
                ((transferAmount * 0.6 / 100) + 20).toInt()
            }
        }

        "Visa", "Mir" -> if (35 < ((transferAmount * 100 / 0.75) - transferAmount)) {

            return 35
        } else (transferAmount * 100 / 0.75).toInt()

    }
    return transferAmount
}
