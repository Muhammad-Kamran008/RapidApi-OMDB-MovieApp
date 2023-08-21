package com.example.rpaidapi_omdb.Model;

import java.io.Serializable;
import java.util.List;

public class Principal implements Serializable {
    private String id="";
    private String legacyNameText="";
    private String name="";
    private int billing=1;
    private String category="";
    private List<String> characters=null;
    private List<Role> roles=null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegacyNameText() {
        return legacyNameText;
    }

    public void setLegacyNameText(String legacyNameText) {
        this.legacyNameText = legacyNameText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBilling() {
        return billing;
    }

    public void setBilling(int billing) {
        this.billing = billing;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
