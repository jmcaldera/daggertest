package com.example.jmcaldera.daggertest.domain.model;

/**
 * Created by jmcaldera on 03/10/2017.
 */

public class Abilities {

    private int accelerate;
    private int steer;
    private int brake;
    private int reverse;
    private int lookBehind;
    private int drift;

    public Abilities(Builder builder) {
        this.accelerate = builder.accelerate;
        this.steer = builder.steer;
        this.brake = builder.brake;
        this.reverse = builder.reverse;
        this.lookBehind = builder.lookBehind;
        this.drift = builder.drift;
    }

    public int getAccelerate() {
        return accelerate;
    }

    public int getSteer() {
        return steer;
    }

    public int getBrake() {
        return brake;
    }

    public int getReverse() {
        return reverse;
    }

    public int getLookBehind() {
        return lookBehind;
    }

    public int getDrift() {
        return drift;
    }

    public static class Builder {

        private int accelerate;
        private int steer;
        private int brake;
        private int reverse;
        private int lookBehind;
        private int drift;

        private Builder() {

        }

        public static Builder create() {
            return new Builder();
        }

        public Builder setAccelerate(int accelerate) {
            this.accelerate = accelerate;
            return this;
        }

        public Builder setSteer(int steer) {
            this.steer = steer;
            return this;
        }

        public Builder setBrake(int brake) {
            this.brake = brake;
            return this;
        }

        public Builder setReverse(int reverse) {
            this.reverse = reverse;
            return this;
        }

        public Builder setLookBehind(int lookBehind) {
            this.lookBehind = lookBehind;
            return this;
        }

        public Builder setDrift(int drift) {
            this.drift = drift;
            return this;
        }

        public Abilities build() {
            return new Abilities(this);
        }
    }
}
