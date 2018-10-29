package com.printer;

import java.util.ArrayList;

public class FakePurchaseOrder extends PurchaseOrder{
    private final String fakeDescription;


    public FakePurchaseOrder(String s) {
        super(new ArrayList<>());
        this.fakeDescription = s;
    }


    @Override
    public String description(){
        return fakeDescription;
    }


}
