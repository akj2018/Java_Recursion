package com.codingblocks.Recursion;

import java.util.ArrayList;

public class MazePathDiag {

    public static void main(String[] args) {

        System.out.println(printMazePath(0,0,2));
        printMazePathDiag("",0,0,2);
        System.out.println(countMazePathDiag(0,0,2));

    }

    public static ArrayList<String> printMazePath(int row,int col,int target){

        if(row==target-1 && col==target-1) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        if(row==target || col==target) {
            ArrayList<String> temp = new ArrayList<>();
            return temp;
        }

        ArrayList<String> myRec = new ArrayList<>();

        ArrayList<String> recResH = printMazePath(row,col+1,target);
        for (String rss: recResH) {
            myRec.add(rss+"H");
        }

        ArrayList<String> recResV = printMazePath(row+1,col,target);
        for (String rss: recResV) {
            myRec.add(rss+"V");
        }

        ArrayList<String> recResD = printMazePath(row+1,col+1,target);
        for (String rss: recResD) {
            myRec.add(rss+"D");
        }


        return  myRec;
    }

    public static void printMazePathDiag(String processed,int row,int col,int size){

        if(row==size-1 && col==size-1){
            System.out.println(processed);
            return;
        }

        if(row==size || col==size){
            return;
        }

        printMazePathDiag(processed+"H",row,col+1,size);
        printMazePathDiag(processed+"V", row+1, col, size);
        printMazePathDiag(processed+"D", row+1, col+1, size);

    }

    public static int countMazePathDiag(int row,int col,int size){

        if(row==size-1 && col==size-1){
            return 1;
        }

        if(row>=size ||col>=size){
            return 0;
        }

        int ch=countMazePathDiag(row, col+1, size);
        int cv=countMazePathDiag(row+1,col,size);
        int cd =countMazePathDiag(row+1,col+1,size);

        return ch+cv+cd;


    }
}
