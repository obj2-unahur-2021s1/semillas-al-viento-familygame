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
        val plantaDeSoja2 = Soja(2019, 1F)
        parcela.plantar(plantaDeSoja2)
        val parcelas: List<Parcela> = listOf(parcela)
        val agricultora = Agricultora(parcelas)

        /**
         * Se elimino test ya que una parcela no puede ser comprada ni vendida
         */
        /**
         * Se corrigio test ya que una parcela no puede ser comprada ni vendida
         */
        it("Puede plantar estrategicamente"){
            agricultora.parcelas[0].plantas.size.shouldBe(1)
            agricultora.plantarEstrategicamente(plantaDeSoja)
            agricultora.parcelas[0].plantas.size.shouldBe(2)
        }

        it("Tiene una parcela semillera"){
            agricultora.parcelasSemilleras().shouldBeEmpty()
        }


    }
})