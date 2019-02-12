import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.numerics.shouldBeLessThan
import io.kotlintest.matchers.numerics.shouldNotBeGreaterThanOrEqual
import io.kotlintest.matchers.numerics.shouldNotBeLessThan
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FeatureSpec

class BasicsFeatureSpec : FeatureSpec({
    feature("functions") {
        scenario("sum1 and sum2 works the same") {
            val a = 1
            val b = 2
            sum1(a, b) shouldBe 3
            sum1(a, b) shouldBeLessThan 4
            sum1(0, 3) shouldBe 3
            sum1(-1, 1) shouldBe 0
            sum1 (10,15) shouldNotBeLessThan 9
            sum1 (3,7) shouldNotBe 11
            sum1 ( 10,11) shouldNotBeGreaterThanOrEqual 22
            // Add greater less checks
        }
    }

    feature("variables") {

        val readOnly = 11
        var reassignable = 3
//            scenario("val can not be reassigned") {
//                readOnly = 12
//            }

        scenario("can be reassigned") {
            reassignable = 6
            reassignable shouldBe 6
        }
    }

    feature("strings") {
        val toge = "toge"
        val ther = "ther"
        val together = "together"

        scenario("concatenation works") {
            toge + ther shouldBe together
        }

        scenario("string interpolation works") {
            "$toge$ther" shouldBe together
        }

        scenario("is not empty") {
            together.isNotBlank() shouldBe true
        }
    }

    feature("conditional expressions") {
        val max = 100
        val min = 0

        scenario("returns max") {
            maxOf(min, max) shouldBe max
        }

        scenario("") {
            minOf(1, 2)
        }
    }

    // Write minOff function

    feature("when expression") {
        //describe(1) shouldBe "One"
        //describe("hello") shouldBe "Unknown"
        // Add other checks
    }

    feature("collections") {
        val fruits = arrayListOf("Apple", "Orange", "Grapes", "Cherry")

        scenario("") {
            fruits.count() shouldBe 4
            fruits shouldContain "Apple"

            //count(fruits) shouldBe 4
        }
    }
})

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun minOf(a:Int, b: Int, c: Int) {

    fun minOf(list: List<Int> ) : Int{
        var min: Int = list[0]
        for (i in list){
            if (i<min) min=i
        }
        return min
    }

fun minOf(a: Double, b: Double): Any {
    if (a < b) return a
    return Unit
}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun count(list: ArrayList<String>): Int {
    var counter = 0
    for (i in list) {
        counter += 1
    }
    return counter
}
    fun main(args: Array<String>) {

        var fruits = listOf("Apple", "Orange", "Grapes", "kiwi")
        for (n in fruits) {
            print(n)
            var fruits: Map<String, Int> = mapOf("Apple" to 57, "Orange" to 27, "Grapes" to 32, "kiwi" to 20)

            println(fruits["Apple"])   // 57
            for (fruit in fruits) println("${fruit.key} - ${fruit.value}")
        }

        println(fruits)
    }
}

