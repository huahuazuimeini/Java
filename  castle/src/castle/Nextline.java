package castle;

import java.util.Scanner;
public class Nextline {
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  String s1,s2;
  Scanner sc=new Scanner(System.in);
  System.out.print("�������һ���ַ�����");
  s1=sc.next();
  sc.nextLine();
  System.out.print("������ڶ����ַ�����");
  s2=sc.nextLine();
  System.out.println("������ַ����ǣ�"+s1+"  "+s2);
 }
}

//��double nextDouble()  �� float nextFloat() �� int nextInt() ����nextLine��������ʱ������������⣬
//����İ취�ǣ���ÿһ�� next������nextDouble()  �� nextFloat()��nextInt() �����֮���һ��nextLine����
//��䣬����next����ȥ����Enter���������˵���