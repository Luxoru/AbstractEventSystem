package me.luxoru.eventsystem;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This event bus allows subscribers to register callbacks for handling events of specific types.
 *
 * @see EventBus
 * @author Luxoru
 */
public class SyncEventBus implements EventBus {

    /**
     * A map that stores event types mapped to sets of event callbacks.
     */
    protected final Map<Class<? extends Event>, Set<EventCallback<? extends Event>>> callbacks = new ConcurrentHashMap<>();

    /**
     * Subscribe a callback to receive events of a specified type.
     *
     * @param <T>       The type of event to subscribe to.
     * @param eventType The class representing the type of event to subscribe to.
     * @param callback  The callback to be invoked when an event of the specified type is dispatched.
     */
    @Override
    public <T extends Event> void subscribe(Class<T> eventType, EventCallback<T> callback) {
        callbacks.computeIfAbsent(eventType, key -> ConcurrentHashMap.newKeySet()).add(callback);
    }

    /**
     * Unsubscribe a callback from receiving events of a specified type.
     *
     * @param <T>       The type of event to unsubscribe from.
     * @param eventType The class representing the type of event to unsubscribe from.
     * @param callback  The callback to be removed from the list of event subscribers.
     */
    @Override
    public <T extends Event> void unsubscribe(Class<T> eventType, EventCallback<T> callback) {
        callbacks.computeIfPresent(eventType, (key, eventCallbacks) -> {
            eventCallbacks.remove(callback);
            if (eventCallbacks.isEmpty()) {
                return null;
            }
            return eventCallbacks;
        });
    }

    /**
     * Dispatch an event to all subscribers that are registered to handle events of its type.
     *
     * @param <T>   The type of event to dispatch.
     * @param event The event to be dispatched to subscribers.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Event> void dispatch(T event) {
        Set<EventCallback<? extends Event>> eventCallbacks = callbacks.computeIfAbsent(event.getClass(), key -> ConcurrentHashMap.newKeySet());
        for (EventCallback<? extends Event> callback : eventCallbacks) {
            ((EventCallback<T>) callback).handle(event);
        }
    }

    /**
     * Get an immutable copy of the map containing event types mapped to sets of event callbacks.
     *
     * @return An immutable copy of the map of event callbacks.
     */
    public Map<Class<? extends Event>, Set<EventCallback<? extends Event>>> getCallbacks() {
        return Map.copyOf(callbacks);
    }
}
