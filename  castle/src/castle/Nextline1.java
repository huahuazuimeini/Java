package castle;

import java.util.Scanner;
public class Nextline1 {
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  String s1,s2;
  Scanner sc=new Scanner(System.in);
  System.out.print("�������һ���ַ�����");
  s1=sc.nextLine();
  System.out.print("������ڶ����ַ�����");
  s2=sc.next();
  System.out.println("������ַ����ǣ�"+s1+"  "+s2);
 }
}