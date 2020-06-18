package com.personal.web.spring.web.spring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    String id;
    String name;
    int cost;
    boolean availability;

    public Item(@JsonProperty("id") String id,
                @JsonProperty("name") String name,
                @JsonProperty("cost") int cost,
                @JsonProperty("availability") boolean availability) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public boolean isAvailabilite() {
        return availability;
    }

}
