package snippet;

import java.awt.Container;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Sql extends JFrame implements ActionListener{//窗口接口
	   JFrame mm=new JFrame("Hey，Baby!");
	   JTextField t2=new JTextField(null,15);//单行文本
       JTextField t4=new JPasswordField(null,15);//密码输入
       public String zh=null;
       JRadioButton b=new JRadioButton("教师");//选择
	   JRadioButton b1=new JRadioButton("学生");
	   JRadioButton b2=new JRadioButton("管理员");
       public void jiemian(){
		          	mm.setSize(400,400);
		          	mm.setVisible(true);//显示
		          	mm.setLocation(500,180);		   
		          	mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭
		          	JLabel t1=new JLabel("ID号:");//标签
		          	JLabel t3=new JLabel("密码:");
		          	JButton denglu=new JButton("登录");
		          	denglu.setContentAreaFilled(false);//按钮透明
		          	Container n=mm.getContentPane();//容器
		      		n.setLayout(null);//布局
		      		t1.setBounds(72,125,75,35);
		      		t2.setBounds(110,125,150,35);
		      		t3.setBounds(70,180,75,35);
		      		t4.setBounds(110,180,150,35);
		      		denglu.setBounds(132,245,70,30);
		      		n.add(t1);
		      		n.add(t2); 
		      		n.add(t3); 
		      		n.add(t4); 
		      		n.add(denglu);
		      		n.add(b);
		        	n.add(b1);
		        	n.add(b2);
		          	b.setBounds(140,85,70,30);
		        	b1.setBounds(80,85,70,30);
		        	b2.setBounds(200,85,70,30);
		        	ButtonGroup rg=new ButtonGroup(); 
		        	b.setSelected(false);
		        	b1.setSelected(true);//选中按钮对象
		        	b1.setSelected(false);	       
		        	rg.add(b);
		        	rg.add(b1);
		        	rg.add(b2);  
		            b.setContentAreaFilled(false);
		            b1.setContentAreaFilled(false);
		            b2.setContentAreaFilled(false);
		          	denglu.addActionListener(this);//当前类对象
	 		   }
public void actionPerformed(ActionEvent e) {//监听器接口
	 JButton denglu=(JButton)e.getSource();
	 if(b.isSelected()) { 
		zh=t2.getText();  
	    String mima=t4.getText();
	  try {  
			Class.forName("com.mysql.jdbc.Driver"); //反射，创建一个对象               
Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//执行，可滚动结果集，结果集更新数据库
ResultSet r=s.executeQuery("select * from 教师信息表   where 教师ID='"+zh+"' and 登录密码='"+mima+"'"); //发送sql到数据库返回结果集
		  		    r.last();//遍历，最后一个		                                                                 
	         if(r.getRow()==1) {//?
	                 mm.setVisible(false);
	                 r.beforeFirst();
	     while(r.next()){  //处理语句
	         JOptionPane.showMessageDialog( null ,r.getString("教师姓名")+"欢迎登录教师管理系统！" ) ;  //提示框
	         }
	JFrame mmm=new JFrame();
	mmm.setSize(400,420);
	mmm.setVisible(true);
	mmm.setLocation(200,300);
	mmm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JLabel aaa=new JLabel("学生信息管理:");JLabel aaa1=new JLabel("学生成绩管理:");
	aaa.setBounds(15,15,90,30); aaa1.setBounds(15,140,90,30);
	JButton b1=new JButton("显示学生信息");b1.setBounds(40,45,140,30);
	JButton b2=new JButton("添加学生信息");b2.setBounds(200,45,140,30);
	JButton b3=new JButton("修改学生信息");b3.setBounds(40,90,140,30);
	JButton b4=new JButton("删除学生信息");b4.setBounds(200,90,140,30);
	JButton b5=new JButton("录入学生成绩");b5.setBounds(40,170,140,30);
	JButton b6=new JButton("修改学生成绩");b6.setBounds(200,170,140,30);
	JButton b7=new JButton("删除学生成绩");b7.setBounds(40,215,140,30);
	JButton b8=new JButton("查询学生成绩");b8.setBounds(200,215,140,30);
	JButton b9=new JButton("所有成绩排名");b9.setBounds(40,260,140,30);	
	JButton b10=new JButton("退出系统");b10.setBounds(60,325,100,30);
	JButton b11=new JButton("修改密码");b11.setBounds(220,325,100,30);
	JButton b12=new JButton("单科成绩排名");b12.setBounds(200,260,140,30);	
	    Container n=mmm.getContentPane();
		n.setLayout(null);
        J_ActionListener1 a1=new J_ActionListener1();
		J_ActionListener2 a2=new J_ActionListener2(); 
		J_ActionListener3 a3=new J_ActionListener3(); 
		J_ActionListener4 a4=new J_ActionListener4(); 
		J_ActionListener5 a5=new J_ActionListener5(); 
		J_ActionListener6 a6=new J_ActionListener6(); 
        J_ActionListener7 a7=new J_ActionListener7(); 
		J_ActionListener8 a8=new J_ActionListener8(); 
        J_ActionListener9 a9=new J_ActionListener9(); 
		J_ActionListener10 a10=new J_ActionListener10(); 
	    J_ActionListener11 a11=new J_ActionListener11();
	    J_ActionListener12 a12=new J_ActionListener12(); 
	    n.add(aaa);
	    n.add(aaa1);
	    n.add(b1);
	    n.add(b2);
	    n.add(b3);
	    n.add(b4);
	    n.add(b5);
	    n.add(b6);
	    n.add(b7);
	    n.add(b8);
	    n.add(b9);
	    n.add(b10);
        n.add(b11);
        n.add(b12);
        b1.addActionListener(a1);
        b2.addActionListener(a2);
	    b3.addActionListener(a3);
	    b4.addActionListener(a4);
	    b5.addActionListener(a5);
		b6.addActionListener(a6);
		b7.addActionListener(a7);
	  	b8.addActionListener(a8);
        b9.addActionListener(a9); 
        b11.addActionListener(a11);
        b12.addActionListener(a12);
	    b10.addActionListener(new ActionListener()                  
	      {	
	    	public void actionPerformed(final ActionEvent e)
	 		   { 
	    		System.exit(0);   //结束
	 		   } 
	         }
	    );
		((JComponent) mmm.getContentPane()).setOpaque(false); //透明   、容器
        java.net.URL url = Sql.class.getResource("未命名.jpg");//获取路径
		ImageIcon img = new ImageIcon(url);//加载图片
		JLabel background = new JLabel(img);//背景
		mmm.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));//设置背景   最小值
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	 }
	 else{   JOptionPane.showMessageDialog( null ,"教师ID或密码有误！请重新输入！") ;      
	 }
	  }
	  catch(Exception e1)
	  {   
		  e1.printStackTrace();//打印异常            
	  }
}
	}
public static void main(String args[]){
	  Sql app=new Sql();
	  app.jiemian();	  
}
}

//向数据库添加新的学生信息：
class DataBase{        //  DataBase类
	
	public void  Add(String xh,String xm,String xb,String bj,String jg,String mm)throws SQLException  {//声明异常			    
	   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	        Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select * from 学籍信息表   where 学号='"+xh+"'");
	   	    r.last();  
	   	    if(r.getRow()==1)                                                         
	   	    {  
	   	    	JOptionPane.showMessageDialog( null ,"该学号的学生信息已存在");
	   	    	}       
	   	     else if(xh.equals(""))
	   	     {         //判断新输入的学号是否为空
	   	        JOptionPane.showMessageDialog( null ,"学号不能为空");
	   	        }                
	   	    else{    
	   	    	s.executeUpdate(" insert into 学籍信息表  values ('"+xh+"','"+xm+"','"+xb+"','"+  bj+"','"+jg+"','"+mm+"')"); //发送   
                s.close();
                c.close();
                JOptionPane.showMessageDialog( null ,"<html>"+"学号:"+xh+"<br>"+"姓名:"+xm+"<br>" 
                +"性别:"+xb+"<br>"+"班级号:"+bj+"<br>" +"籍贯:"+jg+"<br>" +"登录密码:"+mm+"<br>学生记录添加成功！" ) ; //返回
                }
	       }
	     catch (ClassNotFoundException e)                                                       
	  	  {
	    	 JOptionPane.showMessageDialog( null , "数据添加异常！" ) ;
	    	 }
	       }
	  
public void DisplayAll(ResultSet r){   //数据表                                   		    
		    JFrame m=new JFrame("显示所有学生信息");
			m.setBounds(60,70,700,600);
			m.setVisible(true);
			JTextArea aa=new JTextArea();	//多行文本
			aa.setBounds(0,0,700,600);
			Container c1=m.getContentPane();
			c1.setLayout(null);
			c1.add(aa);
		  try{      
			  r.last();
              aa.append("\t学号"+"\t"+"  姓名"+"\t"+"性别"+"\t"+"班级"+"\t"+"籍贯"+"\n");
			  r.beforeFirst();
		 while(r.next())
			   {  
				  aa.append("第"+r.getRow()+"行记录: ");
				  aa.append(r.getString("学号"));
				  aa.append("\t"+r.getString("姓名"));
				  aa.append("\t"+r.getString("性别"));
				  aa.append("\t"+r.getString("班级"));
				  aa.append("\t"+r.getString("籍贯")+"\n");
			   } 
			   }
		  catch(Exception e)
		  {	  
			  e.printStackTrace();}  
		  }

	  public void DisplayOne(String str22)throws Exception { 	   
		  try{
			    Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
	  			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	  		    ResultSet r=s.executeQuery("select 学号 ,姓名,性别, 班级名称  as 班级,籍贯   "
	  		    		+ "from 学籍信息表   join 班级信息表  on 班级信息表.班级号=学籍信息表.班级号   where 学号='"+str22+"'");   
	  		             //执行查询的SQL语句
	                r.last();  			
	  		        int cc=r.getRow();
                if(cc==0){
                 	JOptionPane.showMessageDialog( null ,"未查询到相关信息！" ) ;   
                 	}                    
                else{r.beforeFirst();
	  			while(r.next())
	  			  {  
	  				JOptionPane.showMessageDialog( null ,"<html>"+"  学号:"+r.getString("学号")
	  						+"<br>"+"姓名:"+r.getString("姓名")+"<br>"+"性别:"+r.getString("性别")
	  						+"<br>" +"班级:"+r.getString("班级")+"<br>"+"籍贯:"+r.getString("籍贯")
	  						+"<br> 已查询到相关记录！" ) ;	
	  				 }
	  			} 
               }
	  	catch(Exception e)
	  	{   
	  		e.printStackTrace();
	  		}
		  }
 public void DeleteXh(String str11)         //执行按学号删除学生记录的操作
   { 
    	try {
	      Class.forName("com.mysql.jdbc.Driver");
		  Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
	    	   Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
               ResultSet r=s.executeQuery("select * from 学籍信息表   where 学号='"+str11+"'");   
		  	   r.last();
	           if(r.getRow()==1){              
                s.executeUpdate("delete from 学籍信息表  where 学号='"+str11+"'"); 
	             JOptionPane.showMessageDialog( null , "学生记录删除成功！" ) ;   
	        } 
	           else  {  
	        	   JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" ); 
	        	   }    
	     }
	    catch(Exception e)
	    { e.printStackTrace();
	    }
    	}
public void DeleteXm(String str13)         //执行按姓名删除学生记录的操作
  {  try 
	     {
	         Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	    	Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select * from 学籍信息表 where 姓名='"+str13+"'");     
		  		    r.last();
		  	        if(r.getRow()==1)                                           
	    	   {
		  	        	s.executeUpdate("delete from 学籍信息表  where 姓名='"+str13+"'"); 
	    	            JOptionPane.showMessageDialog( null , "学生记录删除成功！" );
	    	            }       
               else{   
            	   JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" ) ; 
            	   }          
	     }
	  catch(Exception e)
	     { e.printStackTrace();
	     }
        }
public void UpdateXh(String xg,String str15,String str16)     //学号更新  
    {
	    try {  
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
	    	Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select * from 学籍信息表   where 学号='"+xg+"'");     		  		    
            r.last();		
		  		  if(r.getRow()==1){
		  		     s.executeUpdate("update 学籍信息表   set "+str15+"='"+str16+"'  where 学号='"+xg+"'");   //直接执行SQL语句修改                         
	                 JOptionPane.showMessageDialog( null , "学生记录修改成功！" ) ;       		  		 
	                 } 
		  		  else{
		             JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" ) ;        		  		
		             }; 
		             }
	     catch(Exception e){
	    JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" );        
	   } 
	    }
public void UpdateXm(String str18,String str19,String str20){//姓名更新
	   try {  
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  		    ResultSet r=s.executeQuery("select * from 学籍信息表   where 姓名='"+str18+"'");     
		  		    r.last();		
		  		 if(r.getRow()==1){
		  		   s.executeUpdate("update 学籍信息表   set "+str19+"='"+str20+"'  where 姓名='"+str18+"'");   //直接执行SQL语句修改                         
		           JOptionPane.showMessageDialog( null , "学生记录修改成功！" ) ;    
		   }
		  		 else{
                   JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" ) ;        		  			   
                   }; 
                   }
	     catch(Exception e){
	  JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" ) ;        
	   }
	   }
public void AddScore(String xh,String kch, String cj){//添加分数
 	    try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
	   	    Statement s=c.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   	    if(xh.equals("")||kch.equals("")||cj.equals("")){  
	   	    	JOptionPane.showMessageDialog( null ,"输入框不允许为空");     
	   	    }
	   	    else{ 
	   	    	ResultSet r=s.executeQuery("select * from 成绩信息表 where 学号='"+xh+"' and 课程号='"+kch+"'");
	   	    r.last();  
	   	    int i=Integer.parseInt(cj);//转化
	   	    if(r.getRow()==1) {  
	   	    	JOptionPane.showMessageDialog( null ,"该学生该科成绩已存在");
	   	    	}       
	   	     else{               
                s.executeUpdate(" insert into 成绩信息表  values ('"+xh+"','"+kch+"','"+i+"')");      
                JOptionPane.showMessageDialog( null ,"<html>"+"学号:"+xh+"<br>"
                +"课程号:"+kch+"<br>"+"成绩:"+cj+"<br> 学生成绩添加成功！" ) ; 
                } 
	   	    }
	   	    }
	     catch (Exception e){
	    	 JOptionPane.showMessageDialog( null , "成绩输入的学号或者课程号不存在！" );
	    	 }  
 	    }
public void UpdateScore(String xh,String kch,String cj)  {//更新分数
 	   try {  
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if(xh.equals("")||kch.equals("")||cj.equals("")){  
				JOptionPane.showMessageDialog( null ,"输入框不允许为空");      
				}
 	   	    else{
 	   	    	int i=Integer.parseInt(cj);
		  		ResultSet r=s.executeQuery("select * from 成绩信息表 where 学号='"+xh+"' and 课程号='"+kch+"'");
	            r.last();	
	            if(r.getRow()==1){
		  		      s.executeUpdate("update  成绩信息表   set 成绩='"+i+"'  where 学号='"+xh+"' and 课程号='"+kch+"'");                          
	                  JOptionPane.showMessageDialog( null , "学生成绩修改成功！" ) ;    }
		  		  else{
	                  JOptionPane.showMessageDialog( null ,"成绩表中并无相关记录！" ) ;        
		  			};
	      }
			} 
 	   catch(Exception e){
	    JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" ) ; 
	    }
 	   }  
public void DeleteScore(String xh,String kch) {   //删除分数    
    try {
    	Class.forName("com.mysql.jdbc.Driver");
	    Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	    Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    ResultSet r=s.executeQuery("select * from 成绩信息表   where 学号='"+xh+"' and 课程号='"+kch+"'");		  	  
	    r.last();
		  		 if(r.getRow()==1){              
	    	         s.executeUpdate("delete from 成绩信息表   where 学号='"+xh+"' and 课程号='"+kch+"'"); 
	    	         JOptionPane.showMessageDialog( null , "学生记录删除成功！" ) ; 
	    	         }
	else  {  
		JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" );  
		}   
	     }
    catch(Exception e)
	    {  e.printStackTrace();
	    }
    }
public void SearchScore(String xh){//查询分数
 	    JFrame m=new JFrame("学号"+xh+"的各科成绩");
	    m.setBounds(60,70,326,320);
		m.setVisible(true);
		JTextArea aa=new JTextArea();
		aa.setBounds(0,0,326,320);
		Container c1=m.getContentPane();
		c1.setLayout(null);
		c1.add(aa);
 	  try {
		 Class.forName("com.mysql.jdbc.Driver");
         Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
	    	   Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  	   ResultSet r1= s.executeQuery("select 学号,课程名称,成绩     from 成绩信息表    join  "
		  	   		+ "课程信息表  on 成绩信息表.课程号=课程信息表.课程号 " +" where 学号='"+xh+"'"); 
	    	         r1.last();
	    	         aa.append("查询到该学生"+r1.getRow()+"科成绩"+"\n");
	    	         r1.beforeFirst();
	    	         aa.append("     学号"+"\t"+"       课程名称 "+"\t"+"  成绩"+"\n");
				   while(r1.next()){
				      aa.append(r1.getString("学号"));
					  aa.append("\t      "+r1.getString("课程名称"));
					  aa.append("\t  "+r1.getString("成绩")+"\n");
				   } 
				   }
	    catch(Exception e){
	        e.printStackTrace();  
	        }    
 	  }
public  void ListAll(String banji){//成绩单
	    JFrame m=new JFrame(banji+"班级成绩排名");
		m.setBounds(60,70,413,319);
		m.setVisible(true);
		JTextArea aa=new JTextArea();
		aa.setBounds(0,0,413,319);
		Container c1=m.getContentPane();
		c1.setLayout(null);
		c1.add(aa);
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
	        Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
            String sql="execute 全班排名 '"+banji+"'";
	        ResultSet r1= s.executeQuery(sql); 
	        r1.last();
	        aa.append("\t学号"+"\t"+"姓名"+"\t"+"平均分 "+"\t"+"总分"+"\n");
	        r1.beforeFirst();
	        for(int i=1;r1.next();i++){ 
		       aa.append ("第"+i+"名：");
			   aa.append (r1.getString("学号"));
			   aa.append ("\t"+r1.getString("姓名"));
			   aa.append ("\t"+r1.getString("平均分"));
			   aa.append ("\t"+r1.getString("总分")+"\n" );
			  }  
	        }
	catch(Exception e){
	    e.printStackTrace();	
	    }
		}	  
public void ListOne(String str1,String str2){
	    JFrame m=new JFrame(str2+"班"+str1+"科"+"成绩排名");
		m.setBounds(60,70,326,320);
		m.setVisible(true);
		JTextArea aa=new JTextArea();
		aa.setBounds(0,0,326,320);
	    Container c1=m.getContentPane();
		c1.setLayout(null);
		c1.add(aa);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
		    Statement s=c.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    String sql="execute 单科成绩排名 '"+str1+"', "+" '"+str2+"'";
	  	    ResultSet r1= s.executeQuery(sql); 
	  	    r1.last();	         
	        aa.append("\t"+"学号"+"\t"+"姓名"+"\t"+"成绩"+"\n"); r1.beforeFirst(); 
		       for(int i=1;r1.next();i++) {
			       aa.append("第"+i+"名：");
				   aa.append(r1.getString("学号"));
				   aa.append("\t"+r1.getString("姓名"));
				   aa.append("\t"+r1.getString("成绩") +"\n"); 
				   }
		       }
		catch(Exception e){
		    e.printStackTrace();	
		    } 
		}
public void AddTeacher(String id,String xm,String mm, String kch,String kcm){//老师
	   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	   	    Statement s=c.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   if(id.equals("")||mm.equals("")||kch.equals("")||kcm.equals("")){  
		    JOptionPane.showMessageDialog( null ,"输入框不允许为空");      
		  }
       else{   
	        ResultSet r=s.executeQuery("select * from 教师信息表     where 教师信息表.教师ID='"+id+"' ");
	   	    r.last();  
	      if(r.getRow()==1){                                                              
	   	    	JOptionPane.showMessageDialog( null ,"您输入的教师ID已存在已存在");
	   	    	}       
	      else{   
	    	 s.executeUpdate(" insert into 教师信息表  values ('"+id+"','"+xm+"','"+mm+"')"); 
	    	 s.executeUpdate(" insert into 课程信息表  values ('"+kch+"','"+kcm+"','"+id+"')");  
			 JOptionPane.showMessageDialog( null ,"<html>"+"教师ID:"+id+"<br>"+"教师姓名:"+kch+"<br>"+"登录密码:"
	    	 +kch+"<br>"+"课程号:"+kch+"<br>" +"课程名:"+kcm+"<br> 教师信息添加成功！" ) ; 
			 }  
	   	    }
	     }
	     catch (Exception e)  {                                               
	  	           e.printStackTrace();      
	  	           }   
	      }
public void  UpdateTeacher(String id,String shuxin,String xin){//更新教师
	     try { 
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	    	Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select * from 教师信息表   where 教师ID='"+id+"'");    		  		
            r.last();	
            if(r.getRow()==1) {
		  		 s.executeUpdate("update 教师课程详细信息   set "+shuxin+"='"+xin+"'  where 教师ID='"+id+"'");                         
		         JOptionPane.showMessageDialog( null , "教师信息修改成功！" ) ;  }
         else{JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" ) ;    
		  			};   }
	     catch(Exception e) { 
	         e.printStackTrace();        //未有相关的记录
	 }
	  }
public void DeleteTeacher(String id){         //删除
         try{ 
             Class.forName("com.mysql.jdbc.Driver");
	         Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
 	         Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet r=s.executeQuery("select * from 教师信息表   where 教师ID='"+id+"'" );   
	  	     r.last();
	  	 if(r.getRow()==1){              
 	         s.executeUpdate("delete from 教师信息表   where 教师ID='"+id+"'"); 
 	         JOptionPane.showMessageDialog( null , "教师信息删除成功！" ) ;     
 	         }
	     else {  
		     JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！" ); 
		     } 
	  	    }
         catch(Exception e){
            e.printStackTrace();
             }
           }
public void DisplayAllTeacher(){//显示所有
	        JFrame m=new JFrame("教师信息列表");
		    m.setBounds(60,70,433,319);
		    m.setVisible(true);
		    JTextArea aa=new JTextArea();
		    aa.setBounds(0,0,413,319);
		    Container c1=m.getContentPane();
		    c1.setLayout(null);
		    c1.add(aa);
	      try  { 
		       Class.forName("com.mysql.jdbc.Driver");
	           Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生管理系统?useUnicode=true&characterEncoding=utf-8","root","root" );
	    	   Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  	   ResultSet r=s.executeQuery("select * from 教师课程详细信息  " );   
		  	   aa.append("  教师ID"+"\t"+"教师姓名"+"\t"+"课程编号"+"\t"+"课程名称"+"\t"+"登录密码"+"\n");
		  	   r.last();	
		  	   r.beforeFirst();
         	while(r.next()){
		  			aa.append("  "+r.getString("教师ID"));
	                aa.append("\t"+r.getString("教师姓名"));
                    aa.append("\t"+r.getString("课程号"));
					aa.append("\t"+r.getString("课程名称"));
					aa.append("\t"+r.getString("登录密码") +"\n"); }}
	    catch(Exception e)
	    {  e.printStackTrace();
	    }
	      }
}







