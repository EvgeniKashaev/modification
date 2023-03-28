fun main() {

    println(commission("MasterCart", 2000, 1000, "*"))
    println(commission("Mir", 10000))
    println(commission("VK Play", 15, 41424))

}

fun commission(name: String = "VK Play", transferAmount: Int, transferAmountMonth: Int = 0, action: String = "#"): Int {
    when (name) {
        "MasterCart", "Maestro", "Visa", "Mir" -> if (maximumTransferPer(name, transferAmount, transferAmountMonth)) {
            return commissionAmount(name, transferAmount, transferAmountMonth, action)
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

fun commissionAmount(name: String, transferAmount: Int, transferAmountMonth: Int, action: String): Int {
    when (name) {
        "MasterCart", "Maestro" -> if (action(action)) {
            when (transferAmountMonth) {
                in 300..75_000 -> return 0
            }
        } else return ((transferAmount * 0.6 / 100) + 20).toInt()

        "Visa", "Mir" -> return if (35 < (transferAmount / 100 * 0.75)) {
            (transferAmount / 100 * 0.75).toInt()
        } else 35
    }
    return 0
}

fun action(name: String, action: String = "#"): Boolean {
    when (name) {
        "MasterCart", "Maestro" -> if (action === "*") {
            return true
        }
    }
    return false
}