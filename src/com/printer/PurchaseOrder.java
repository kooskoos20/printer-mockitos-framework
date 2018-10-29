package com.printer;

import java.util.List;

public class PurchaseOrder {

    List<Product> products;

    public PurchaseOrder(List<Product> products){
        this.products = products;
    }

    public String description(){
        String description = "";
        for (Product product : products) {
            description += "Name: " + product.getName() + " Price: " + product.getPrice();
        }
        return description;
    }


}
