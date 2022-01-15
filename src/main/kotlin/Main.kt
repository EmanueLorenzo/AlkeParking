import java.util.*

//Una función onSuccess que se ejecutará cuando se complete el
//check-out y que reciba como parámetro un Int que corresponderá al
//monto que se debe pagar.

fun onSuccess(fees: Int) = "Your fee is $$fees. Come back soon."

//Una función onError que se ejecutará en caso de un error en el
//check-out.
fun onError() = "Sorry, the check-out failed"

fun main() {
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle("BB222BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val miniBUS = Vehicle("CC333CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle("DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val parking = Parking(mutableSetOf(), car)

    val vehiclesToAdd = listOf(
        car, moto, miniBUS, bus,
        Vehicle("EE555EE", VehicleType.CAR, Calendar.getInstance()),
        Vehicle("FF666FF", VehicleType.MOTORCYCLE, Calendar.getInstance()),
        Vehicle("GG777GG", VehicleType.MINIBUS, Calendar.getInstance(), "DICOUNT_CARD_003"),
        Vehicle("HH888HH", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("II999II", VehicleType.CAR, Calendar.getInstance()),
        Vehicle("JJ000JJ", VehicleType.MOTORCYCLE, Calendar.getInstance()),
        Vehicle("KK111KK", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("LL222LL", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("MM333MM", VehicleType.CAR, Calendar.getInstance()),
        Vehicle("NN444NN", VehicleType.CAR, Calendar.getInstance()),
        Vehicle("OO555OO", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("PP666PP", VehicleType.MOTORCYCLE, Calendar.getInstance()),
        Vehicle("QQ777QQ", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("RR888RR", VehicleType.MINIBUS, Calendar.getInstance()),
        Vehicle("SS999SS", VehicleType.CAR, Calendar.getInstance()),
        Vehicle("TT000TT", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("UU111UU", VehicleType.BUS, Calendar.getInstance()),
        Vehicle("VV222VV", VehicleType.BUS, Calendar.getInstance()),
    )
    //La estructura de datos Map (Mapa) utiliza una clave para acceder a un valor.
    // El subíndice puede ser cualquier tipo de clase, lo mismo que su valor
    vehiclesToAdd.map {
        parking.addVehicle(it).also(::println)
    }

    //el método add de Set
    //retorna un boolean true en caso de que el elemento se haya ingresado
    //correctamente y un false en caso de que este ya se encuentra en la colección):

    //vehículo 1 (car) con tarjeta de descuento - éxito
    parking.checkOutVehicle(car.plate, ::onSuccess, ::onError).also(::println)

    //vehículo 2 (moto) - éxito
    parking.checkOutVehicle("BB222BB", ::onSuccess, ::onError).also(::println)

    //vehículo 3 (minibus) - error
    parking.checkOutVehicle("CC33", ::onSuccess, ::onError).also(::println)

    //vehículo 4 (bus) con tarjeta de descuento - éxito
    parking.checkOutVehicle(bus.plate, ::onSuccess, ::onError).also(::println)

    //Obtiene la información del parking
    parking.getParkingCheckOutInfo().also(::println)

    //La administración podrá solicitar en cualquier momento la lista de las
    //patentes de los vehículos que se encuentran en el estacionamiento.
    //Imprime la lista de vehículos
    val listVehicle = parking.listVehicles()
    println(listVehicle)
}

