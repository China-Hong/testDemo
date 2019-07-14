package com.example.proxy;

public class test implements home{

    @Override
    public void test() {
        System.out.println("ceshi");
    }

    public void test2() throws Exception{
        throw new Exception();
    }

    public boolean Find(int target, int [][] array) {
        boolean result = false;
        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j <array[i].length; j++) {
                System.out.println(array[i][j]);
                if (target == array[i][j]) {
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }

    public boolean fastFind(int target,int[][] array){
        int i=0;
        int j=array.length-1;
        while((j>=0)&&(i<array[0].length)){
            System.out.print(array[i][j]+"--");
            if(array[i][j]>target){  //如果该值大于目标值，则剔除一列
                j--;
            }
            else if(array[i][j]<target){ //如果该值小于目标值，则增加一行
                i++;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexold = str.length()-1; //indexold为为替换前的str下标
        int newlength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度
        int indexnew = newlength-1;//indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        for(;indexold>=0 && indexold<newlength;--indexold){
            if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }

    public String replaceSpace2(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
            int oldlength = str.length();
            int newLength = str.length()+2*spaceNum;
            int newIndex = newLength-1;
            str.setLength(newLength);
            for (int j = oldlength-1; j< newIndex && j >=0 ; j--) {
                if (str.charAt(j) == ' ') {
                    str.setCharAt(newIndex--, '0');
                    str.setCharAt(newIndex--, '2');
                    str.setCharAt(newIndex--, '%');
                } else {
                    str.setCharAt(newIndex--, str.charAt(j));
                }
            }
        return str.toString();
    }

    public static void main(String[] args) {
        test test = new test();
       /* int [][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target=7;
        System.out.println(test.fastFind(target,array));*/
       StringBuffer str = new StringBuffer("we are luck");
       System.out.println(test.replaceSpace2(str));
    }

}
