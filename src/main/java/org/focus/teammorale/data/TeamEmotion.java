package org.focus.teammorale.data;


import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.time.LocalDateTime;

@MongoEntity(collection = "TeamEmotion")
public class TeamEmotion {

    @Id
    public ObjectId id;
    public String observation;
    public Emotion emotion;
    public LocalDateTime registered;
}
