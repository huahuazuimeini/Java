package castle;

import java.util.Scanner;
public class Nextline2 {
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  String s1,s2;
  Scanner sc=new Scanner(System.in);
  System.out.print("请输入第一个字符串：");
  s1=sc.next();
  System.out.print("请输入第二个字符串：");
  s2=sc.nextLine();//nextLine（）自动读取了被next（）去掉的Enter作为他的结束符
  System.out.println("输入的字符串是："+s1+"  "+s2);
 }
}
//next（）一定要读取到有效字符后才可以结束输入，对输入有效字符之前遇到的空格键、Tab键或Enter
//键等结束符，next（）方法会自动将其去掉，只有在输入有效字符之后，next（）方法才将其后输入的
//空格键、Tab键或Enter键等视为分隔符或结束符。简单地说，next（）查找并返回来自此扫描器的下一
//个完整标记。完整标记的前后是与分隔模式匹配的输入信息，所以next方法不能得到带空格的字符串。
//而nextLine（）方法的结束符只是Enter键，即nextLine（）方法返回的是Enter键之前的所有字符，
//它是可以得到带空格的字符串的。