import java.util.*

data class Vehicle(
    val plate: String,
    //No se puede cambiar de tipo de vehículo en el momento
    //Por eso se define como val que es inmutable
    val type: VehicleType,
    val checkInTime: Calendar,
    val discountCard: String? = null
    //La tarjeta de descuentos es opcional, es decir que un vehículo puede no
    //tener una tarjeta y su valor será null. ¿Cómo indicamos que un tipo de
    //datos puede adquirir esta característica en Kotlin?
    //Se indica con elvis operator
) {
    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / 60000

    //1 min = 60000 milliseconds
    //Calendar.getInstance para que se almacene la fecha de ingreso
    //debemos pasar las fechas a milisegundos y a partir
    //de ahí calcular la cantidad de minutos transcurridos.
    //parkedTime que deberá indicar el total de minutos.

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {

            //un vehículo será único e identificado por la patente

            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }
}
