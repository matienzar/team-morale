package org.focus.teammorale.data;


import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MongoEntity(collection = "TeamEmotion")
public class TeamEmotion {

    @Id
    @NotNull
    public ObjectId id;

    public String observation;

    @NotNull
    public Emotion emotion;

    @NotNull
    public LocalDateTime registered;

    public ObjectId getId() {
        return id;
    }

    public String getObservation() {
        return observation;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }
}

