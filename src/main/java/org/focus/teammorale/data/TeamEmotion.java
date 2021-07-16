package org.focus.teammorale.data;


import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@MongoEntity(collection="TeamEmotion")
public class TeamEmotion {

    public ObjectId id;
    public String observation;
    public Emotion emotion;
    @ManyToOne
    public Team team;
    public LocalDateTime registered;
}
