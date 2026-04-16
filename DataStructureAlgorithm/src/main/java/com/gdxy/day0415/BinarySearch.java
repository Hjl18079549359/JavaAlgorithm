package com.gdxy.day0415;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 9;
        int ans = binarySearch(arr,target);
        System.out.println(ans);
    }
//基础版
    public static int binarySearch(int[] arr,int target){
        int i=0,j=arr.length-1;//i是数组开头，j是数组末尾
        while(i<=j){
            int mid=(i+j)>>>1;//这个等式默认是向下取整相当于Math.floor()
            if(target<arr[mid]){//目标元素在左边
                j=mid-1;
            }else if(arr[mid]<target){//目标元素在右边
                i=mid+1;
            }else {
                return mid;//找到了
            }
        }
        return -1;
    }

/*
* 问题1:为什么是i<=j  意味着区间内有未比较的元素  而不是i<j
* i<=j：i,j它们指向的元素也会参与比较
* i<j：i,j它们指向的元素不会参与比较
*
* 问题2:(i+j)/2有没有问题？
* 同一个二进制数1011 1111 1111 1111 1111 1111 1111 1110
* 不把最高位视为符号位，代表3221225470
* 把最高位视为符号位，代表-1073741826
* 为了避免这个问题使用无符号右移“>>>”,即(i+j)>>>1,相当于i+j除以2向下取整。
* 无符号右移“>>>”，适用于更多的语言，比如JavaScript
*
* 问题3:都写错小于符号有啥好处？
* 数组是升序，方便理解
* */
//改动版
    public static int binarySearchAlternative(int[] arr,int target){
        int i=0,j=arr.length;//j只是一个边界，绝不是目标元素，绝不参与比较       第一处
        while(i<j){//如果改成i<=j 则程序会进入死循环                         第二处
            int mid=(i+j)>>>1;
            if(target<arr[mid]){
                j=mid;              //                                  第三处
            }else if(arr[mid]<target){
                i=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    /*
    *平衡板
    * */
    public static int binarySearchPinhen(int[] arr,int target){
        int i=0,j=arr.length;//j只是一个边界，绝不是目标元素，绝不参与比较
        while(1<j-i){
            int mid=(i+j)>>>1;
            if(target<arr[mid]){//左
                j=mid;
            }else {//右
                i=mid;
            }
        }
        return (arr[i]==target) ? i:-1;
    }



/*
二分查找：Leftmost版本
*有重复元素，查找最近的（也就是最靠左的）
* */
    public static int binarySearchLeftmost(int[] arr,int target){
        int i=0,j=arr.length-1;
        int candidate=-1;
        while(i<=j){
            int mid=(i+j)>>>1;
            if(target<arr[mid]){
                j=mid-1;
            }else if(arr[mid]<target){
                i=mid+1;
            }else {
    //            记录候选位置
                candidate=mid;
                j=mid-1;
            }
        }
        return candidate;
    }

    /*
    * return: 返回>=target的最靠左索引
    *
    * */

    public static int binarySearchLeftmost1(int[] arr,int target){
        int i=0,j=arr.length-1;
        while(i<=j){
            int mid=(i+j)>>>1;
            if(target<=arr[mid]){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;//i>=target的最靠左索引
    }
    /*
    * 二分查找：Rightmost版本
    *有重复元素，查找最靠右的元素
    * */
    public static int binarySearchRightmost(int[] arr,int target){
        int i=0,j=arr.length-1;
        int candidate=-1;
        while(i<=j){
            int mid=(i+j)>>>1;
            if(target<arr[mid]){
                j=mid-1;
            }else if(arr[mid]<target){
                i=mid+1;
            }else {
                //            记录候选位置
                candidate=mid;
                i=mid+1;
            }
        }
        return candidate;
    }
    /*
    *return: 返回<=target的最靠右索引
    *
    * */
    public static int binarySearchRightmost1(int[] arr,int target){
        int i=0,j=arr.length-1;
        while(i<=j){
            int mid=(i+j)>>>1;
            if(target<arr[mid]){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i-1;//i-1小于等于target的最靠右索引
    }
}