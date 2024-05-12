package me.luxoru.eventsystem;

/**
 * Represents a callback function for handling events of a specific type.
 *
 * <p>Implementations should define the logic for handling events of the specified type.</p>
 *
 * @param <T> The type of event to handle.
 * @see Event
 * @author Luxoru
 */
public interface EventCallback {

    /**
     * Handle the given event.
     *
     * <p>Invoked when an event of the specified type is dispatched to the callback.</p>
     *
     * @param event The event to be handled.
     */
    <T>void handle(T event);

}

