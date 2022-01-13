import java.util.* //¿Dónde deben agregarse las propiedades, en Parkable,
    // Vehicle o en ambos


private val MINUTES_IN_MILLISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle, val checkInTime: Calendar = Calendar.getInstance() ) {

    val parkedTime: Long get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS

}