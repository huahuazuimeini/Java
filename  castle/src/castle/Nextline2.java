package castle;

import java.util.Scanner;
public class Nextline2 {
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  String s1,s2;
  Scanner sc=new Scanner(System.in);
  System.out.print("�������һ���ַ�����");
  s1=sc.next();
  System.out.print("������ڶ����ַ�����");
  s2=sc.nextLine();//nextLine�����Զ���ȡ�˱�next����ȥ����Enter��Ϊ���Ľ�����
  System.out.println("������ַ����ǣ�"+s1+"  "+s2);
 }
}
//next����һ��Ҫ��ȡ����Ч�ַ���ſ��Խ������룬��������Ч�ַ�֮ǰ�����Ŀո����Tab����Enter
//���Ƚ�������next�����������Զ�����ȥ����ֻ����������Ч�ַ�֮��next���������Ž���������
//�ո����Tab����Enter������Ϊ�ָ�������������򵥵�˵��next�������Ҳ��������Դ�ɨ��������һ
//��������ǡ�������ǵ�ǰ������ָ�ģʽƥ���������Ϣ������next�������ܵõ����ո���ַ�����
//��nextLine���������Ľ�����ֻ��Enter������nextLine�����������ص���Enter��֮ǰ�������ַ���
//���ǿ��Եõ����ո���ַ����ġ�