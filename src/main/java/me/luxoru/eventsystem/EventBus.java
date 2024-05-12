package me.luxoru.eventsystem;


/**
 * An EventBus is a mechanism for publishing and subscribing to events within an application.
 * Events can be of various types, and subscribers can register callbacks to handle specific types of events.
 *
 * @see EventCallback
 * @see Event
 * @author Luxoru
 */

public interface EventBus<T> {

    /**
     * Subscribe a callback to receive events of a specified type.
     *

     * @param eventType The class representing the type of event to subscribe to.
     * @param callback  The callback to be invoked when an event of the specified type is dispatched.
     */
    default <U extends T> void subscribe(Class<U> eventType, EventCallback callback){};

    /**
     * Unsubscribe a callback from receiving events of a specified type.
     *

     * @param eventType The class representing the type of event to unsubscribe from.
     * @param callback  The callback to be removed from the list of event subscribers.
     */
    default <U extends T> void unsubscribe(Class<U> eventType, EventCallback callback){};

    /**
     * Dispatch an event to all subscribers that are registered to handle events of its type.
     *

     * @param event The event to be dispatched to subscribers.
     */
    default <U extends T> void dispatch(U event){};
}

