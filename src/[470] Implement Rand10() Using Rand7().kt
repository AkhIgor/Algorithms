import kotlin.random.Random

fun main() {
    Randomizer().rand10()
}

class Randomizer {

    fun rand7(): Int{
        return Random.nextInt(7)
    }

    fun rand10(): Int {
        while(true) {
            // Генерация случайного числа от 1 до 49
            val randomValue = (rand7()-1)*7 + rand7()

            // Оставляем только числа от 1 до 40
            if(randomValue <= 40) {
                return randomValue % 10 + 1
            }
        }
    }
}