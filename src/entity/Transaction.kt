package entity

import report.Report
import java.time.LocalDate
import java.util.*

data class Transaction(
    val id: UUID = UUID.randomUUID(),
    val amount: Double,
    val transactionsType:Report,
    val  category:Categories,
    val date: LocalDate,
) {
    fun validAmount(): Boolean {
        val result = amount > 0
        println(
            when (result) {
                true -> "Checking amount: $amount → Valid"
                false -> "Checking amount: $amount → Invalid"
            }
        )
        return result
    }

    override fun toString(): String {
        return "               /| _ ╱|、  \n" +
                "             ( •̀ㅅ •́  )\n" +
                "           ＿ノ ヽ ノ＼＿ \n" +
                "         /　`/ ⌒Ｙ⌒ Ｙ　 \\\n" +
                "        ( 　(三ヽ人　 /　 　|\n" +
                "        |　ﾉ⌒＼ ￣￣ヽ　 ノ\n" +
                "        ヽ＿＿＿＞､＿＿／\n" +
                "           ｜( 王 ﾉ〈 \n"
    }
    fun validDate(): Boolean {
        val result = !date.isAfter(LocalDate.now())
        println(
            when (result) {
                true -> "Checking date: $date → Valid"
                false -> "Checking date: $date → Invalid"
            }
        )
        return result
    }
}