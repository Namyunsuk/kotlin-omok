package omok.model

data class Position(val row: Int, val col: Int) {
    init {
        validPosition(row, col)
    }

    companion object {
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 14
        private val positionRange = MIN_RANGE..MAX_RANGE

        private fun invalidPositionMessage(
            row: Int,
            col: Int,
        ): String {
            val rowValue = 'A' + row
            return "유효하지 않은 위치입니다. 현재 입력 값: $rowValue${col + 1}\n"
        }

        fun of(
            rowValue: Char,
            col: Int,
        ): Position {
            val row = rowValue - 'A'
            validPosition(row, col - 1)
            return Position(row, col - 1)
        }

        private fun validPosition(
            row: Int,
            col: Int,
        ) {
            require(row in positionRange && col in positionRange) { invalidPositionMessage(row, col) }
        }
    }
}
