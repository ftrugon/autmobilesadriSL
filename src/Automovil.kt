import kotlin.reflect.KMutableProperty

class Automovil(val esHibrido:Boolean,
                marca: String,
                modelo: String,
                capacidadcombustible:Float,
                val tipo :String,
                combustibleactual: Float,
                kilometrosactuales: Float
):Vehiculo(marca,modelo,capacidadcombustible,
    combustibleactual, kilometrosactuales
){
    init {
        require(tipo.isNotEmpty()){"Tipo no puede estar vacio"}
    }

    companion object{
        var condicionBritanica:Boolean = false
    }

    override fun toString(): String {
        return "${super.toString().dropLast(1).replace("Vehiculo","Coche")}, tipo = $tipo)"
    }

    override fun obtenerKm_por_L(): Float {
        return if (esHibrido) KM_por_L + 5 else KM_por_L
    }


    fun cambiarCondicionBritanica(nuevacondicio:Boolean){
        condicionBritanica = nuevacondicio
    }

    fun realizarderrape():Float{
        return if (combustibleactual >=  (7.5/10)){
            if (esHibrido){
                val litrosarestar = 7.5/15
                combustibleactual -= litrosarestar.toFloat()
                combustibleactual
            }else{
                val litrosarestar = 7.5 / 10
                combustibleactual -= litrosarestar.toFloat()
                combustibleactual
            }
        }else {
            println("No hay combustible como para derrapar")
            combustibleactual
        }
    }

}
