package org.focus.teammorale.data;

import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.OneToMany;
import java.util.List;

@MongoEntity(collection="Team")
public class Team {
    public ObjectId id;
    public String teamName;
    public String purpose;
    public int membership = 1;

    @OneToMany
    public List<TeamEmotion> teamEmotions;
}
