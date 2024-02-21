class Motocicleta(marca: String,
                  modelo: String,
                  capacidadcombustible:Float,
                  val cilindrada :Int,
                  combustibleactual: Float,
                  kilometrosactuales: Float
):Vehiculo(marca,modelo,capacidadcombustible, combustibleactual, kilometrosactuales){

    init {
        require(cilindrada in 125..1000){"La cilindrada no puede ser mayor a 1000 y menor a 125"}
    }


    override fun obtenerKm_por_L(): Float {
        return 19 + (cilindrada.toFloat() / 1000)
    }

    fun realizarcaballito():Float{
        return if (combustibleactual > 0.25){
            combustibleactual -= 0.25F
            combustibleactual
        }else{
            println("No queda combustible como para hacer un caballito")
            combustibleactual
        }
    }

    override fun toString(): String {
        return "${super.toString().dropLast(1).replace("Vehiculo","Moto")}, cilindrada = $cilindrada)"
    }

}