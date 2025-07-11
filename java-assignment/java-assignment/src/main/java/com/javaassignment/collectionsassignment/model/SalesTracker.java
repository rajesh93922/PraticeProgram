package com.javaassignment.collectionsassignment.model;

import ch.qos.logback.core.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesTracker {

    private Map<String, String> salesSet;

    public SalesTracker(){
        this.salesSet = new HashMap<>();
    }

    public Map<String, String> getSalesSet() {
        return salesSet;
    }

    public void setSalesSet(Map<String, String> salesSet) {
        this.salesSet = salesSet;
    }

    public void addSalesRecord(String setOfRecords) {
        if (!StringUtil.isNullOrEmpty(setOfRecords)){
        String[] recordSplit = setOfRecords.split(":");
        this.salesSet.put(recordSplit[0], recordSplit[1]);
        }
    }

    public int findNumberOfCustomersByProduct(String product){
        int c = 0;
        for (Map.Entry<String, String> salesSetEntry : salesSet.entrySet()) {
            if (salesSetEntry.getValue().equalsIgnoreCase(product)){
                c++;
            }
        }
        if (c != 0){
            return c;
        }
        return -1;
    }

    public List<String> getCustomersByProduct(String product){
        List<String> customerList = new ArrayList<>();

        for (Map.Entry<String, String> salesSetEntry : salesSet.entrySet()) {
            if (salesSetEntry.getValue().equalsIgnoreCase(product)){
                customerList.add(salesSetEntry.getKey());
            }
        }
        return customerList;
    }

    public String getProductByCustomer(String customerName){

        if (salesSet.containsKey(customerName)){
          return salesSet.get(customerName);
        }

        return "None";
    }
}
