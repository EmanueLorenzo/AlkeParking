data class Parking(val vehicles: MutableSet<Vehicle>) {
    //estacionamiento del programa
    val max = 20
    fun addVehicle(vehicle: Vehicle) : Boolean =
        if (vehicles.size < max) {
            //Revisa la documentación de Kotlin para identificar qué función de Set puede
            //ser útil para obtener la cantidad de vehículos en el estacionamiento.
            //Size es la función de set
            vehicles.add(vehicle)
            println("Welcome to AlkeParking!")
            true
        } else {
            println("Sorry, the check-in failed")
            false
        }


}