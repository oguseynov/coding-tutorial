import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe

class BasicsDescribeSpec : DescribeSpec({
    describe("Checks on Kotlin basics implementations") {
        context("functions") {
            it("sum1 and sum2 works the same") {
                val a = 1
                val b = 2
                sum1(a, b) shouldBe 3
                sum1(a, b) shouldBeLessThan 4
                sum1(0, 3) shouldBe 3
                sum1(-1, 1) shouldBe 0
                // Add greater less checks
            }
        }

        context("variables") {

            val readOnly = 11
            var reassignable = 3
//            it("val can not be reassigned") {
//                readOnly = 12
//            }

            it("can be reassigned") {
                reassignable = 6
                reassignable shouldBe 6
            }
        }

        context("strings") {
            val toge = "toge"
            val ther = "ther"
            val together = "together"

            it("concatenation works") {
                toge + ther shouldBe together
            }

            it("string interpolation works") {
                "$toge$ther" shouldBe together
            }

            it("is not empty") {
                together.isNotBlank() shouldBe true
            }
        }

        context("conditional expressions") {
            val max = 100
            val min = 0

            it("returns max") {
                maxOf(min, max) shouldBe max
            }

            it("") {
                minOf(1, 2)
            }
        }

        // Write minOff function

        context("when expression") {
            describe(1) shouldBe "One"
            describe("hello") shouldBe "Unknown"
            // Add other checks
        }

        context("collections") {
            val fruits = arrayListOf("Apple", "Orange", "Grapes", "Cherry")

            it("") {
                fruits.count() shouldBe 4
                fruits shouldContain "Apple"

                count(fruits) shouldBe 4
            }
        }
    }
})
