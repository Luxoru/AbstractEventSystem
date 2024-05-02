package me.luxoru.eventsystem;


/**
 * An EventBus is a mechanism for publishing and subscribing to events within an application.
 * Events can be of various types, and subscribers can register callbacks to handle specific types of events.
 *
 * @see EventCallback
 * @see Event
 * @author Luxoru
 */

public interface EventBus {

    /**
     * Subscribe a callback to receive events of a specified type.
     *
     * @param <T>       The type of event to subscribe to.
     * @param eventType The class representing the type of event to subscribe to.
     * @param callback  The callback to be invoked when an event of the specified type is dispatched.
     */
    <T extends Event> void subscribe(Class<T> eventType, EventCallback<T> callback);

    /**
     * Unsubscribe a callback from receiving events of a specified type.
     *
     * @param <T>       The type of event to unsubscribe from.
     * @param eventType The class representing the type of event to unsubscribe from.
     * @param callback  The callback to be removed from the list of event subscribers.
     */
    <T extends Event> void unsubscribe(Class<T> eventType, EventCallback<T> callback);

    /**
     * Dispatch an event to all subscribers that are registered to handle events of its type.
     *
     * @param <T>   The type of event to dispatch.
     * @param event The event to be dispatched to subscribers.
     */
    <T extends Event> void dispatch(T event);
}

