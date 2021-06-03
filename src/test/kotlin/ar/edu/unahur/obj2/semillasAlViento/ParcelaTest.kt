package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ParcelaTest : DescribeSpec({
    describe("Una Parcela"){

        val parcela = Parcela(20, 30, 3)

        it("Tiene una superficie"){
            parcela.superficie().shouldBe(600)
        }

        it("Cantidad maxima de plantas"){
            parcela.cantidadMaximaPlantas().shouldBe(230)
        }
        it("Permite plantar"){
            val unaPlanta = Menta(2011, 0.7F)
            parcela.cantidadPlantas.shouldBe(0)
            parcela.plantar(unaPlanta)
            parcela.cantidadPlantas.shouldBe(1)
        }

    }
})