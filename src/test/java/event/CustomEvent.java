package event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.luxoru.eventsystem.Event;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class CustomEvent implements Event {

    private final Instant timestamp;
    private final UUID uuid;

    @Override
    public Instant getTimeStamp() {
        return timestamp;
    }
}
