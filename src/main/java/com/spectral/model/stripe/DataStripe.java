package com.spectral.model.stripe;

public class DataStripe {
    private ObjectStripe object;

    public ObjectStripe getObject() {
        return object;
    }

    public void setObject(ObjectStripe object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "DataStripe{" +
                "object=" + object +
                '}';
    }
}
