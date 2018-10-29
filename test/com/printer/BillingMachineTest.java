package com.printer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;


public class BillingMachineTest {

    @Test
    public void shouldPassThePurchaseOrderDescriotionToThePrinter(){

        Printer printer = Mockito.mock(Printer.class);
        BillingMachine billingMachine=new BillingMachine(printer);
        Product product = new Product("test",20);
        List<Product> listOfProducts  = new ArrayList<>();
        listOfProducts.add(product);
        PurchaseOrder po = new PurchaseOrder(listOfProducts);
        billingMachine.process(po);
        
        verify(printer, times(1)).print("Name: test Price: 20");
    }





    @Test
    public void shouldTruncateValueTo100BeforePassingItToPrinter(){
        Printer printer = Mockito.mock(Printer.class);
        BillingMachine billingMachine=new BillingMachine(printer);
        PurchaseOrder po = Mockito.mock(PurchaseOrder.class);
        when(po.description()).thenReturn("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678902432432432432423412524545781509179857012875980710257821705987912057870197509175");
        billingMachine.process(po);
        verify(printer).print("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
    }
}

