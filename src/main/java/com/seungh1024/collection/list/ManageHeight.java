package com.seungh1024.collection.list;

import java.util.ArrayList;

public class ManageHeight {
    private ArrayList<ArrayList<Integer>> gradeHeights;

    public static void main(String[] args) {
        ManageHeight mh = new ManageHeight();
        mh.setData();
        for(int i = 1; i <= 5; i++){
            mh.printHeight(i);
        }

        int classNo = 1;
        while(classNo <= 5){
            mh.printAverage(classNo);
            classNo++;
        }
    }

    public void printAverage(int classNo){
        int count = 0;
        int sum = 0;
        for(int height :gradeHeights.get(classNo)){
            sum+=height;
            count++;
        }
        double average = (double)sum/(double)count;
        StringBuilder sb = new StringBuilder();
        sb.append("Class No.:").append(classNo).append("\n");
        sb.append("Height average:").append(average).append("\n");
        System.out.println(sb);
    }
    public void printHeight(int classNo){
        StringBuilder sb = new StringBuilder();
        sb.append("Class No.:").append(classNo).append("\n");
        for(int height : gradeHeights.get(classNo)){
            sb.append(height).append("\n");
        }
        System.out.println(sb);
    }
    public void setData(){
        int[][] data = {{170,180,173,175,177},{160,165,167,186},{158,177,187,176},{173,182,181},{170,180,165,177,172}};
        int[] classNum = {1,2,3,4,5};
        int[] studentNum = {5,4,4,3,5};
        int length = classNum.length;
        gradeHeights = new ArrayList<>(length+1);
        gradeHeights.add(new ArrayList<>()); // 0반
        for(int i = 0; i < length; i++){
            ArrayList<Integer> input =new ArrayList<>(studentNum[i]);
            for(int height : data[i]){
                input.add(height);
            }
            gradeHeights.add(input);
        }
    }
}

