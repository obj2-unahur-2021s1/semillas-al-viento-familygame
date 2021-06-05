package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe

class AgricultoraTest : DescribeSpec ({
    describe("Una agricultora"){

        val parcela = Parcela(10, 8, 5)
        /**
         * Debemos modificar este objeto ya que se creó la clase SojaTransgenica y
         * la clase soja ya no recibe el parametro "esTransgenica"
         */
        val plantaDeSoja = Soja(2018, 1F)
        val agricultora = Agricultora(parcelas = mutableListOf())

        it("Puede comprar parcela"){
            agricultora.comprarParcela(parcela)
            agricultora.ahorrosEnPesos.shouldBe(15000)
        }

        it("Tiene una parcela semillera"){
            agricultora.parcelasSemilleras().shouldBeEmpty()
        }

        it("Puede plantar estrategicamente"){
            agricultora.comprarParcela(parcela)
            agricultora.plantarEstrategicamente(plantaDeSoja)
            agricultora.parcelas[0].cantidadPlantas.shouldBe(0)
            agricultora.parcelas[0].plantas.size.shouldBe(1)
        }
    }
})