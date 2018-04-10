package castle;

import java.util.Scanner;
public class Nextline1 {
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  String s1,s2;
  Scanner sc=new Scanner(System.in);
  System.out.print("请输入第一个字符串：");
  s1=sc.nextLine();
  System.out.print("请输入第二个字符串：");
  s2=sc.next();
  System.out.println("输入的字符串是："+s1+"  "+s2);
 }
}