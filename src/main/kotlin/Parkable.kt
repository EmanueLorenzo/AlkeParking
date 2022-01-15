import kotlin.math.roundToInt

//Tener una patente.
//Debe ser de un tipo de vehículo permitido en el estacionamiento.
//Se debe registrar la fecha de ingreso.
//El vehículo podrá poseer una tarjeta de descuentos para el pago de la
//tarifa. Calcular el tiempo total que permaneció en el estacionamiento.

open class Parkable(open var vehicle: Vehicle, open var vehicles: MutableSet<Vehicle>) {
    //Inicializamos las variables
    // En el set los vehículos no pueden ser iguales
    var countVehicle = 0
    var countMoney = 0

    //fun checkOutVehicle Remueve el vehículo del estacionamiento
    fun checkOutVehicle(plate: String, onSuccess: (Int) -> String, onError: () -> String): String {
        val foundVehicleList = vehicles.map { it }.filter { it.plate == plate }
        return if (foundVehicleList.isNotEmpty()) {
            val foundVehicle = foundVehicleList[0]
            val fees = calculateFee(foundVehicle.type, foundVehicle.parkedTime, foundVehicle.discountCard != null)
            vehicles.remove(foundVehicle)
            countVehicle++
            countMoney += fees
            onSuccess(fees)
        } else onError()
    }

    //Las dos primeras horas de estacionamiento tendrán un costo fijo
    //determinado por el tipo de vehículo (auto: $20, moto: $15, mini bus:
    //$25, bus: $30).
    //Luego de las 2 primeras horas se cobrarán $5 por cada 15 minutos o
    //fracción independiente del tipo de vehículo.

    private fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {
        if (parkedTime > 120) {
            //una tarjeta de
            //descuentos, la cual reduce la tarifa total de estacionamiento un 15%.
            //Los valores de las tarifas no deben incluir centavos; en caso de
            //tenerlos deben descartarse.

            val blocksTime = (parkedTime - 120.0) / 15
            val roundedBlocks = blocksTime.roundToInt().run {

                //Se dividen esos  minutos en grupos de 15 y da  bloques. Como la
                //fracción también se incluye se redondea a  bloques.

                if (blocksTime > this) (this + 1) else this
            }
            val totalFees = when (type) {
                VehicleType.CAR -> (roundedBlocks * 5) + VehicleType.CAR.fare
                VehicleType.MOTORCYCLE -> (roundedBlocks * 5) + VehicleType.MOTORCYCLE.fare
                VehicleType.MINIBUS -> (roundedBlocks * 5) + VehicleType.MINIBUS.fare
                VehicleType.BUS -> (roundedBlocks * 5) + VehicleType.BUS.fare
            }

            //Luego de obtener el total de la tarifa, aplica el descuento si corresponde
            //y retorna el valor actualizado (Los centavos no deberán contarse en el
            //cobro de la tarifa).

            return if (hasDiscountCard) (totalFees * 0.85).roundToInt() else totalFees

        }
        val totalFees = when (type) {
            VehicleType.CAR -> VehicleType.CAR.fare
            VehicleType.MOTORCYCLE -> VehicleType.MOTORCYCLE.fare
            VehicleType.MINIBUS -> VehicleType.MINIBUS.fare
            VehicleType.BUS -> VehicleType.BUS.fare
        }
        return if (hasDiscountCard) (totalFees * 0.85).roundToInt() else totalFees
    }
}