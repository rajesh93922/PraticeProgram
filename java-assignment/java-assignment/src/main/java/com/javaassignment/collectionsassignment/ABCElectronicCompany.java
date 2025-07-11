package com.javaassignment.collectionsassignment;

import com.javaassignment.collectionsassignment.model.SalesTracker;

import java.util.List;
import java.util.Scanner;

public class ABCElectronicCompany {

    private static Scanner sc = new Scanner(System.in);

    static SalesTracker salesTracker = new SalesTracker();

    public static void main(String[] args) {

            System.out.println("Enter number of records to be added..");
            int numberOfRecords = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < numberOfRecords; i++){
                int c = i+1;
            System.out.println(c+". Enter the records (Customer Name:Product)");
            String setOfRecords = sc.nextLine();

            salesTracker.addSalesRecord(setOfRecords);
            }

            System.out.println("Enter the Product to be searched");
            String searchProduct = sc.nextLine();
            int numberOfCustomersByProduct = salesTracker.findNumberOfCustomersByProduct(searchProduct);
            System.out.println("The number of customers who purchased "+ searchProduct+" is "+numberOfCustomersByProduct);

            System.out.println("Enter the Product to identify the Customer Names");
            String productName = sc.nextLine();

            List<String> customersByProduct = salesTracker.getCustomersByProduct(productName);
            System.out.println("Customer names who purchased "+productName+" are" + customersByProduct);

            System.out.println("Enter the Customer name to find the Product purchased");
            String customerName = sc.nextLine();
            String productByCustomer = salesTracker.getProductByCustomer(customerName);
            System.out.println("Product purchased by "+customerName+" is "+productByCustomer);
        }
}
