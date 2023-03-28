fun main() {

    println(commission("MasterCart", 145000))
    println(commission("Mir", 10000))
    println(commission("VkPlay", 15500))

}

fun commission(name: String = "MasterCart", transferAmount: Int, transferAmountMonth:Int = 0): Int {
    when (name) {
        "MasterCart", "Mir" -> if (maximumTransferPer(name, transferAmount, transferAmountMonth)) {
            return commissionAmount(name, transferAmount)
        }

        "VkPlay" -> if (maximumTransferPer(name, transferAmount, transferAmountMonth)) {
            return transferAmount
        }
    }
    return -1
}
fun maximumTransferPer(name: String, transferAmount: Int, transferAmountMonth: Int): Boolean {

    when (name) {

        "MasterCart", "Mir" -> if (transferAmountMonth < 600_000 || transferAmount < 150_000) {
            return true
        }

        "VkPlay" -> if (transferAmountMonth < 40_000 || transferAmount < 15_000) {
            return true
        }
    }
    return false
}

fun commissionAmount(name: String, transferAmount: Int): Int {
    when (name) {
        "MasterCart" -> return when (transferAmount) {
            in 300..75_000 -> {
                transferAmount
            }
            else -> {
                ((transferAmount * 0.6 / 100) + 20).toInt()
            }
        }

        "Mir" -> if (35 < ((transferAmount * 100 / 0.75) - transferAmount)) {
            return 35
        } else transferAmount * 100 / 0.75
    }
    return transferAmount
}
