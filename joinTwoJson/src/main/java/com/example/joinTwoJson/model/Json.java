package com.example.joinTwoJson.model;


public class Json {
    private String productUuid;
    private String productName;
    private int amount;


    public Json() {
    }

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Json(String productUuid, String productName, int amount) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.amount = amount;
    }
}
