package com.spectral.model.stripe;

public class JSONStripe {
    private String id;
    private DataStripe data;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataStripe getData() {
        return data;
    }

    public void setData(DataStripe data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JSONStripe{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", type='" + type + '\'' +
                '}';
    }
}
