fun main() {

    println(commission("MasterCart", 145000))
    println(commission("Mir", 10000))
    println(commission("VkPlay", 15500))

}

fun commission(name: String, transferAmount: Int): Int {
    when (name) {
        "MasterCart" -> if (maximumTransferPer(name, transferAmount)) {
            return commissionAmount(name, transferAmount)
        }

        "VkPlay" -> if (maximumTransferPer(name, transferAmount)) {
            return transferAmount
        }

        "Mir" -> if (maximumTransferPer(name, transferAmount)) {
            return commissionAmount(name, transferAmount)
        }
    }
    return -1
}

var transferAmountMonth = 0

fun maximumTransferPer(name: String, transferAmount: Int): Boolean {
    transferAmountMonth += transferAmount
    when (name) {

        "MasterCart" -> if (transferAmountMonth < 600_000 || transferAmount < 150_000) {
            return true
        }

        "VkPlay" -> if (transferAmountMonth < 40_000 || transferAmount < 15_000) {
            return true
        }

        "Mir" -> if (transferAmountMonth < 600_000 || transferAmount < 150_000) {
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
                transferAmount - (((transferAmount * 0.6 / 100) + 20).toInt())
            }
        }

        "Mir" -> if (35 < ((transferAmount * 100 / 0.75) - transferAmount)) {
            return transferAmount - 35
        } else transferAmount - (transferAmount * 100 / 0.75)
    }
    return transferAmount
}
