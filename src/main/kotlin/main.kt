fun main() {


    println(commission("MasterCart", 2000, 1000 ))
    println(commission("MasterCart", 2000, 74_000))
    println(commission("Mir", 10000))
    println(commission("VK Play", 150, 40001))
    println(commission("VK Play", 15001, 32))


}

fun commission(name: String = "VK Play", transferAmount: Int, transferAmountMonth: Int = 0): Int {
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
        "MasterCart", "Maestro", "Visa", "Mir" -> if (transferAmountMonth < 600_000 && transferAmount < 150_000) {
            return true
        }
        "VK Play" -> if (transferAmountMonth < 40_000 && transferAmount < 15_000) {
            return true
        }
    }
    return false
}

fun commissionAmount(name: String, transferAmount: Int, transferAmountMonth: Int): Int {
    when (name) {
        "MasterCart", "Maestro" -> return if (transferAmount + transferAmountMonth in 300..75_000) {
            0
        } else ((transferAmount * 0.6 / 100) + 20).toInt()

        "Visa", "Mir" -> return if (35 < (transferAmount / 100 * 0.75)) {
            (transferAmount / 100 * 0.75).toInt()
        } else 35
    }
    return 0
}