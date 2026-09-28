package matera.magisterka.microservice.tracking;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FleetEventListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "tracking.fleet.events", durable = "true"),
            exchange = @Exchange(value = "fleet.exchange", type = "topic"),
            key = "fleet.vehicle.*"
    ))
    public void handleVehicleCreated(VehicleCreatedEvent event) {
        // Asynchroniczne przetworzenie powiadomienia w innym mikroserwisie
        System.out.println("Otrzymano zdarzenie z Fleet Service dla pojazdu: " + event.vin());
    }
}