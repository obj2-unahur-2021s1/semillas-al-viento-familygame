package ar.edu.unahur.obj2.semillasAlViento

class Parcela(private val ancho: Int, private val largo: Int, private val horasSolPorDia: Int) {

  val plantas = mutableListOf<Planta>()

  fun superficie() = ancho * largo

  fun cantidadMaximaPlantas() =
    if (ancho > largo) ancho * largo / 5 else ancho * largo / 3 + largo

  fun plantar(planta: Planta) {
    when {
        plantas.size == this.cantidadMaximaPlantas() -> {
          throw Exception("Ya no hay lugar en esta parcela")
        }
        horasSolPorDia > planta.horasDeSolQueTolera() + 2 -> {
          throw Exception("No se puede plantar esto acá, se va a quemar")
        }
        else -> {
          plantas.add(planta)
        }
    }
  }

  fun tieneComplicaciones(parcela: Parcela) =
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }
}


class Agricultora(val parcelas: List<Parcela>) {

  fun parcelasSemilleras() =
    parcelas.filter {
      parcela -> parcela.plantas.all {
        planta -> planta.daSemillas()
      }
    }

  fun plantarEstrategicamente(planta: Planta) {
    val laElegida = parcelas.maxByOrNull { it.cantidadMaximaPlantas() - it.plantas.size }
    laElegida?.plantar(planta)
  }

}
