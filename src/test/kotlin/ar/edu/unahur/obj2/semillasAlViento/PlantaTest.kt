package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class PlantaTest : DescribeSpec ({

    describe("Una planta") {

        val plantaDeMenta = Menta(2015, 2.5F)

        /**
         * Debemos modificar este objeto ya que se creó la clase SojaTransgenica y
         * la clase soja ya no recibe el parametro "esTransgenica"
         */
        val plantaDeSoja = Soja(2016, 0.5F)

        val plantaSojaTransgenica = SojaTransgenica(2002, 1F)

        it("Es fuerte"){
            plantaDeMenta.esFuerte().shouldBeFalse()
            /**
             * plantaDeSoja ya no es fuerte porque el objeto no tiene mas el parámetro
             * "esTrangenica" por lo tanto es Soja normal y las horas de sol no se duplican.
             */
            plantaDeSoja.esFuerte().shouldBeFalse()
            plantaSojaTransgenica.esFuerte().shouldBeTrue()
        }

        it("Da semillas"){
            plantaDeMenta.daSemillas().shouldBeTrue()
            plantaDeSoja.daSemillas().shouldBeFalse()
            plantaSojaTransgenica.daSemillas().shouldBeFalse()
        }
    }

})