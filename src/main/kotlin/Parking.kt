data class Parking(override var vehicles: MutableSet<Vehicle>, override var vehicle: Vehicle) :
    Parkable(vehicle, vehicles) {
    //Estacionamiento del programa
    private val spot = 20
    //cupo máximo de 20 vehículos.
    //una función addVehicle en Parking que recibirá el vehículo
    //a ingresar y retornará Boolean indicando si se pudo ingresar el vehículo
    //correctamente o no:

    fun addVehicle(vehicle: Vehicle): String {
        return when (spot - vehicles.size) {

            //Revisa la documentación de Kotlin para identificar qué función de Set puede
            //ser útil para obtener la cantidad de vehículos en el estacionamiento.
            //Size es la función de set
            //Agrega una validación que verifique si aún hay cupos disponibles; en
            //caso de que no haya cupo retornar el parámetro false.
            //En caso de que el vehículo se haya podido ingresar correctamente
            //retornará el valor true

            in 1..spot -> {
                vehicles.add(vehicle)
                "Welcome to AlkeParking!"
            }
            //Si supera la cantidad de autos el estacionamiento da error
            else -> "Sorry, the check-in failed"
        }
    }


    fun getParkingCheckOutInfo(): String {

        //Por solicitud de la administración de AlkeParking, debe tenerse un registro
        //del total de vehículos que se retiran del estacionamiento, junto con el total
        //de las ganancias recibidas
        // Agrega una propiedad de tipo Pair
        //acumular tanto la cantidad de vehículos retirados como las ganancias
        //recibidas y actualiza su valor cada que se retira un vehículo.

        val parkingCheckOutInfo: Pair<Int, Int> = Pair(countVehicle, countMoney)
        return "${parkingCheckOutInfo.first} vehicles have checked out and have earnings of $${parkingCheckOutInfo.second}."
    }

    //Agrega una función listVehicles en Parking que liste las patentes de los
    //vehículos.
    fun listVehicles(): List<String> {
        return vehicles.map { it.plate }
    }
}