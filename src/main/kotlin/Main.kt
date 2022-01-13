fun main(args: Array<String>) {
    val car = Vehicle("ABC123", VehicleType.CAR, "DISCOUNT_CARD_001")
    val moto = Vehicle("ABD125", VehicleType.MOTORCYCLE, "DISCOUNT_CARD_002")
    val minibus = Vehicle("DSAD1231", VehicleType.MINIBUS, "DISCOUNT_CARD_003")
    val bus = Vehicle("DSAD1234", VehicleType.BUS, "DISCOUNT_CARD_004")
    val parking = Parking(mutableSetOf(car, moto, minibus, bus))

    val car2 = Vehicle("ABC123", VehicleType.CAR, "DISCOUNT_CARD_0005")


    println(parking.vehicles.contains(car2))
    println(parking.vehicles.contains(moto))
    println(parking.vehicles.contains(minibus))
    println(parking.vehicles.contains(bus))

    val car2Inserted = parking.vehicles.add(car2)
    val car2IsRemoved = parking.vehicles.remove(moto)
    println(car2Inserted)
    println(car2IsRemoved)

}

