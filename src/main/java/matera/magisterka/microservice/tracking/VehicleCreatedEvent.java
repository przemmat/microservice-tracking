package matera.magisterka.microservice.tracking;
import java.io.Serializable;

public record VehicleCreatedEvent(Long vehicleId, String vin, String plateNumber) implements Serializable {}