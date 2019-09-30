package com.codingblocks.Recursion;

import java.util.ArrayList;

public class MazePath {

    public static void main(String[] args) {

        System.out.println(mazePath(0,0,3));

        ArrayList<String> result = new ArrayList<>();

        mazePath2(0,0,3,"",result);
        System.out.println(result);

    }

    public static ArrayList<String> mazePath(int row,int col,int size){

        if(row==size-1 && col==size-1){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        if(row>size-1|| col>size-1){
            ArrayList<String> temp = new ArrayList<>();
            return temp;
        }


        ArrayList<String> myRes = new ArrayList<>();

        ArrayList<String> recResV = mazePath(row+1,col,size);
        for (int i=0;i<recResV.size();i++){
            String value = "V"+recResV.get(i);
            myRes.add(value);
        }

        ArrayList<String> recResH = mazePath(row,col+1,size);
        for (int i = 0; i <recResH.size() ; i++) {
            String value = "H" + recResH.get(i);
            myRes.add(value);
        }

        return myRes;
    }

    public static void mazePath2(int row,int col,int size,String processed,ArrayList<String> str){

        if(row==size-1 && col==size-1){
            str.add(processed);
            return;
        }

        if(row==size||col==size){
            return;
        }

        mazePath2(row+1,col,size,processed+"V",str);
        mazePath2(row,col+1,size,processed+"H",str);


    }
}
