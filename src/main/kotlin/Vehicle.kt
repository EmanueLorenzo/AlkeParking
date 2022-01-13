data class Vehicle(val plate: String, val type: VehicleType, val discountCard: String?) {
    //La tarjeta de descuentos es opcional, es decir que un vehículo puede no
    //tener una tarjeta y su valor será null. ¿Cómo indicamos que un tipo de
    //datos puede adquirir esta característica en Kotlin?
    //Se indica con elvis operator, String?
   // checkInTime debe ir en ParkingSpace

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }
    //Vehicle irán almacenando los vehículos que están estacionados
    // En el set los vehículos no pueden ser iguales
    override fun hashCode(): Int = this.plate.hashCode()
}
