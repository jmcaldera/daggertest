package com.example.jmcaldera.daggertest.data.model;

/**
 * Created by jmcaldera on 06/10/2017.
 */

public class CharacterEntity {

    private String id;
    private String name;
    private int photo;
    //    private int cover;
    private String description;
    private AbilitiesEntity abilities;

    public CharacterEntity(Builder builder) {
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

    public AbilitiesEntity getAbilities() {
        return abilities;
    }

    public static class Builder {
        private String id;
        private String name;
        private int photo;
        //        private int cover;
        private String description;
        private AbilitiesEntity abilities;

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

        public Builder setAbilities(AbilitiesEntity abilities) {
            this.abilities = abilities;
            return this;
        }

        public CharacterEntity build() {
            return new CharacterEntity(this);
        }
    }
}
