package com.emp.java8;

import java.util.Arrays;

public class ArraysPrograms {
    public static void main(String[] args) {
        int[] originalArray = {1,2,3,4}; /// 3

        int insertValue = 37;
        int position = 1;
        arrayInsertOperOnIndex(originalArray, insertValue, position);

        int[] deleteArray = {1,2,3,4}; /// 3
        int deleteIndex = 2;
        arrayDeleteOperOnIndex(deleteArray , deleteIndex);

        //Input: {20, 30, 40}, insert 10
        //Output: {10, 20, 30, 40}
        int[] insertRandom = {20, 30, 40};
        int ramdomValue = 10 ;
        insertValueRandom(insertRandom , ramdomValue);
    }

    private static void insertValueRandom(int[] oringnalValue, int ramdomValue) {
        int[] addSpace = new int[oringnalValue.length + 1];

        int count =0 ;
        while (count < oringnalValue.length ){
            addSpace[count] = oringnalValue[count];
            count ++;
        }
        addSpace[count] = ramdomValue;
        //System.out.println(Arrays.toString(addSpace));







    }

    private static void arrayDeleteOperOnIndex(int[] deleteArray, int deleteIndex) {
        int[] removeElement = new int[deleteArray.length - 1];

        for (int i = 0; i < deleteIndex; i++) {
            removeElement[i] = deleteArray[i];
        }
        for (int j = deleteIndex + 1; j < deleteArray.length; j++) {
            removeElement[j - 1] = deleteArray[j];
           // System.out.println(Arrays.toString(removeElement));

        }

    }

    private static void arrayInsertOperOnIndex(int[] originalArray, int insertValue, int position) {

        int[] extraSpace = new int[originalArray.length + 1];

        for (int i = 0; i < position; i++) {
            extraSpace[i] = originalArray[i];
            //System.out.println(Arrays.toString(extraSpace));
        }
        extraSpace[position] = insertValue;
        // System.out.println(Arrays.toString(extraSpace));

        for (int j = position; j < originalArray.length; j++) {
            extraSpace[j + 1] = originalArray[j];
          //  System.out.println(Arrays.toString(extraSpace));
        }

    }
}
