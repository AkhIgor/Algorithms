import java.util.LinkedList
import kotlin.random.Random

fun main() {
    RandomizedSet().apply {
        insert(1)
        remove(2)
        insert(2)
        getRandom()
        remove(1)
        insert(2)
        getRandom()
    }
}

class RandomizedSet {
    // Хранение значений
    private val list = ArrayList<Int>()

    // Отображение значения -> индекс в списке
    private val map = HashMap<Int, Int>()

    /** Initialize your data structure here. */
    init {}

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    fun insert(value: Int): Boolean {
        if (map.containsKey(value)) return false

        // Добавляем значение в конец списка
        list.add(value)

        // Сохраняем индекс нового элемента в мапе
        map[value] = list.size - 1

        return true
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    fun remove(value: Int): Boolean {
        if (!map.containsKey(value)) return false

        // Получаем индекс удаляемого элемента
        val index = map[value]!!

        // Если список пуст или индекс выходит за пределы, ничего не делаем
        if (list.isEmpty() || index >= list.size) return false

        // Обмениваем последний элемент со значением, которое хотим удалить
        val lastElement = list.last()
        list[index] = lastElement

        // Обновляем индекс последнего элемента в мапе
        map[lastElement] = index

        // Удаляем последний элемент из списка
        list.removeAt(list.size - 1)

        // Убираем запись из мапы
        map.remove(value)

        return true
    }

    /**
     * Get a random element from the set.
     */
    fun getRandom(): Int {
        // Генерируем случайный индекс от 0 до size-1
        val randomIndex = Random.nextInt(list.size)

        // Возвращаем случайный элемент
        return list[randomIndex]
    }
}

// MINE
//class RandomizedSet() {
//
//    private val array = ArrayList<MutableList<Int>?>(10)
//    private val values = LinkedList<Int>()
//
//    fun insert(`val`: Int): Boolean {
//        val div = if(array.isEmpty()) 1 else array.size
//        val key = `val`.hashCode() % div
//        return array.getOrNull(key)?.let { currentList ->
//            if (currentList.contains(`val`)) {
//                false
//            } else {
//                currentList.add(`val`)
//                values.add(`val`)
//                true
//            }
//        } ?: run {
//            array.add(key, mutableListOf(`val`))
//            values.add(`val`)
//            true
//        }
//    }
//
//    fun remove(`val`: Int): Boolean {
//        val div = if(array.isEmpty()) 1 else array.size
//        val key = `val`.hashCode() % div
//        return array.getOrNull(key)?.let {
//            val result = it.remove(`val`)
//            values.remove(`val`)
//            result
//        }?: false
//    }
//
//    fun getRandom(): Int {
//        val bound = values.size-1
//        if (bound > 0) {
//            val randomKey = Random.nextInt(bound)
//            return values[randomKey]
//        } else {
//            return values[0]
//        }
//    }
//}