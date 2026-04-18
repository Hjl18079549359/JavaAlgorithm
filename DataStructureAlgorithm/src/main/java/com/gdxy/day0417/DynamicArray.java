package com.gdxy.day0417;

public class DynamicArray {
    private int size=0;//逻辑大小
    private int capacity=8;//容量
    private int[] arr={};

    public void addLast(int element){
//        arr[size]=element;
//        size++;
        add(size,element);
    }
//插入元素
    public void add(int index,int element){
        checkAndGrow();
//        添加逻辑
        if(index>=0 && index<size){
            System.arraycopy(arr,index,arr,index+1,size-index);
        }
        arr[index]=element;
        size++;
    }
    //        容量检查
    private void checkAndGrow() {
        if (size==0){
            arr=new int[capacity];
        }else if(size==capacity){
//            扩容
            capacity+=capacity>>1;//">>"考虑符号位，“>>>”不考虑符号位
            int[] temp=new int[capacity];
            System.arraycopy(arr,0,temp,0,size);
            arr=temp;
        }
    }

    public int get(int index){
        return arr[index];
    }
//    删除
    public int remove(int index){
        int removed=arr[index];
        if(index<size-1){
            System.arraycopy(arr,index+1,arr,index,size-index-1);
        }
        size--;
        return removed;
    }
}
