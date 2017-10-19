package com.example.jmcaldera.daggertest.domain.model;

public class Character {

    private String id;
    private String name;
    private int photo;
//    private int cover;
    private String description;
    private Abilities abilities;

    public Character(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.photo = builder.photo;
//        this.cover = builder.cover;
        this.description = builder.description;
        this.abilities = builder.abilities;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

//    public int getCover() {
//        return cover;
//    }

    public String getDescription() {
        return description;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public static class Builder {
        private String id;
        private String name;
        private int photo;
//        private int cover;
        private String description;
        private Abilities abilities;

        private Builder () {

        }

        public static Builder create() {
            return new Builder();
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhoto(int photo) {
            this.photo = photo;
            return this;
        }

//        public Builder setCover(int cover) {
//            this.cover = cover;
//            return this;
//        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAbilities(Abilities abilities) {
            this.abilities = abilities;
            return this;
        }

        public Character build() {
            return new Character(this);
        }
    }
}
