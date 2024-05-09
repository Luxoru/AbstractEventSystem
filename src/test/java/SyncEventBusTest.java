import event.CustomEvent;
import me.luxoru.eventsystem.SyncEventBus;
import org.junit.Test;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class SyncEventBusTest {

    @Test
    public void eventBusTest() {
        SyncEventBus syncEventBus = new SyncEventBus();

        syncEventBus.subscribe(CustomEvent.class, (event) ->{

            System.out.println("Custom event called, with UUID "+event.getUuid());

        });

        CompletableFuture<SyncEventBus> future = CompletableFuture.supplyAsync(()->{
            for(int i =0;i<50;i++){
                syncEventBus.dispatch(new CustomEvent(Instant.now(), UUID.randomUUID()));
            }
            return syncEventBus;
        });

        future.thenAccept((eventBus) ->{
            int size = eventBus.getCallbacks().size();
            System.out.println(size);
        });

        future.join();



    }





}
