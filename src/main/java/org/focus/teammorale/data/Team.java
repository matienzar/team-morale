package org.focus.teammorale.data;

import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@MongoEntity(collection="Team")
public class Team {

    @Id
    public ObjectId id;

    @NotNull
    public String teamName;

    @NotNull
    public String purpose;
    public int membership = 1;

    @OneToMany(mappedBy = "team")
    public Set<TeamEmotion> teamEmotions;
}
