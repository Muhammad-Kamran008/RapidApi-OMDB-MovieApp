package com.example.rpaidapi_omdb.Model;

import java.io.Serializable;

public class Role implements Serializable {
    private String character="";
    private String characterId="";

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }
}
