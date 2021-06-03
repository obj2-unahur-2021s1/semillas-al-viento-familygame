package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class PlantaTest : DescribeSpec ({

    describe("Una planta") {

        val plantaDeMenta = Menta(2015, 2.5F)
        val plantaDeSoja = Soja(2016, 0.5F, true)

        it("Es fuerte"){
            plantaDeMenta.esFuerte().shouldBeFalse()
            plantaDeSoja.esFuerte().shouldBeTrue()
        }

        it("Da semillas"){
            plantaDeMenta.daSemillas().shouldBeTrue()
            plantaDeSoja.daSemillas().shouldBeFalse()
        }
    }

})