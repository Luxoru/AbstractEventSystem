package me.luxoru.eventsystem;

import java.io.Serializable;
import java.time.Instant;


import java.io.Serializable;
import java.time.Instant;

/**
 * The Event interface represents an event that can occur within an application.
 * Events can carry information such as a timestamp and additional payload data.
 *
 * <p>Implementations of the Event interface can be serializable to support
 * transmission and persistence of events.</p>
 *
 * @see Serializable
 * @author Luxoru
 *
 */
public interface Event extends Serializable {

    /**
     * Get the timestamp indicating when the event occurred.
     *
     * @return The timestamp of the event.
     */
    Instant getTimeStamp();

    /**
     * Serialize the event into a byte array.
     *
     * <p>This method is responsible for converting the event object into a byte array
     * representation, which can be used for transmission or persistence purposes.</p>
     *
     * @return A byte array representing the serialized form of the event, or {@code null}
     *         if serialization is not supported.
     */
    default byte[] serialise() {
        return null;
    }

    /**
     * Deserialize the event from a byte array.
     *
     * <p>This method is responsible for reconstructing the event object from its byte
     * array representation. It should be implemented to reverse the serialization process
     * performed by the {@code serialise} method.</p>
     *
     * @return The deserialized event object, or {@code null} if deserialization is not supported.
     */
    default Object deserialise() {
        return null;
    }
}

