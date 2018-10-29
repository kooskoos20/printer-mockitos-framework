package com.printer;

public class BillingMachine {

    Printer printer;
    public BillingMachine(Printer printer){
        this.printer = printer;
    }

    public void process(PurchaseOrder purchaseOrder){
        String description = purchaseOrder.description();
        if(description.length() > 100) description = description.substring(0,100);
        printer.print(description);
    }
}
