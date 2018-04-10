package castle;

import java.util.Scanner;
public class Nextline {
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  String s1,s2;
  Scanner sc=new Scanner(System.in);
  System.out.print("请输入第一个字符串：");
  s1=sc.next();
  sc.nextLine();
  System.out.print("请输入第二个字符串：");
  s2=sc.nextLine();
  System.out.println("输入的字符串是："+s1+"  "+s2);
 }
}

//如double nextDouble()  ， float nextFloat() ， int nextInt() 等与nextLine（）连用时都存在这个问题，
//解决的办法是：在每一个 next（）、nextDouble()  、 nextFloat()、nextInt() 等语句之后加一个nextLine（）
//语句，将被next（）去掉的Enter结束符过滤掉。