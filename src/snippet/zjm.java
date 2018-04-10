package snippet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class zjm extends JFrame implements ActionListener
{
	final JFrame dl=new JFrame("欢迎来到宿舍管理系统！");
	final JTextField t1=new JTextField();
	JPasswordField t2=new JPasswordField ();//设置密码输入域，使用密文
	JButton b1=new JButton("登陆");
	JButton b2=new JButton("取消");
	
	public static void main (String[] args) //主函数
	{ 
		zjm e=new zjm();   //声明对象
		e.denglu();       //调用denglu函数，进入登录界面
		
	 }
	
	public void actionPerformed(ActionEvent e)//登录事件的动作
	{
		if(e.getSource()==b1) 
		{
			String zh=t1.getText();//提取用户输入的账号
			@SuppressWarnings("deprecation")
			String mm=t2.getText();//提取用户输入的密码
			if(zh.equals("huahua")||zh.equals("beibei"))
			{
				if((zh.equals("huahua")&&mm.equals("123456"))||(zh.equals("beibei")&&mm.equals("654321")))
			    {
					zjm();  //登录成功，进入主界面
					dl.setVisible(false);//隐藏登录界面
			    }
				
				else
				{
					JOptionPane.showMessageDialog( null ,"密码错误！"); //提示输入的密码有误
					t2.setText(null);//账号输入正确但密码输入错误时，保留输入的账号，消去密码
				}
			}
			else 
			{    
				JOptionPane.showMessageDialog( null ,"账号错误！"); 
				t1.setText(null);
				t2.setText(null);//账号输入错误时，消去输入的账号和密码
			}
		}
		
		
	  }
			
	
	
	  public void denglu()//denglu函数，创建登录界面
	  {
		
		  dl.setLocation(300,100);
          dl.setSize(600,500);
          dl.setResizable(false);
          dl.setVisible(true);
          JPanel p=new JPanel(){          
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("图片.jpg");
                 g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
                }//添加背景
             };
          dl.add(p);
          p.setLayout(null);                
          t1.setBounds(120,220, 150, 35);        
          p.add(t1);
          t2.setBounds(120, 265, 150, 35);
          p.add(t2);        
          b1.setBounds(170, 320, 60, 40);
          b1.addActionListener(this);
          p.add(b1);        
          b2.setBounds(250, 320, 60, 40);
          p.add(b2);
          b2.addActionListener(new ActionListener()  //点击取消时，退出程序              
	         { 
	            public void actionPerformed( ActionEvent e)               
	             {
	        	  	 System.exit(0);
	             }
	          } );
          
	  }
	  
	  public void zjm ()//创建主界面
	  {
		
         JFrame zjm=new JFrame("欢迎使用宿舍管理系统！");
         zjm.setLocation(300,100);
         zjm.setSize(500,300);
         zjm.setResizable(false);
         zjm.setVisible(true);
         JPanel  c=new JPanel(){
             public void paintComponent(Graphics g) {
                 ImageIcon icon =
                         new ImageIcon("E:\\1.jpg");
                  g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
             }
           };
         zjm.add(c);
         c.setLayout(null);              
         JButton b1=new JButton("显示信息");
         J_ActionListener1 a1=new J_ActionListener1();
         b1.setBounds(80, 30, 100, 30);
         b1.addActionListener(a1);
         c.add(b1);
         JButton b2=new JButton("添加信息");
         J_ActionListener2 a2=new J_ActionListener2();
         b2.setBounds(195, 60, 100, 30);
         b2.addActionListener(a2);
         c.add(b2);
         JButton b3=new JButton("修改信息");
         J_ActionListener3 a3=new J_ActionListener3();
         b3.setBounds(310, 90, 100, 30);
         b3.addActionListener(a3);
         c.add(b3);
         JButton b4=new JButton("删除信息");
         J_ActionListener4 a4=new J_ActionListener4();
         b4.setBounds(310, 130, 100, 30);
         b4.addActionListener(a4);
         c.add(b4);
         JButton b5=new JButton("关于系统");
         J_ActionListener5 a5=new J_ActionListener5();
         b5.setBounds(195, 160, 100, 30);
         b5.addActionListener(a5);
         c.add(b5);
         JButton b6=new JButton("退出系统");
         b6.setBounds(80, 190, 100, 30);
         b6.addActionListener(new ActionListener()//点击取消时，退出程序  
           {
			  public void actionPerformed(ActionEvent arg0)
			  {	
				System.exit(0);
			  }
        	 
           });
         c.add(b6);              
	 }

}



class DataBase         //  DataBase类
{
      public void AddXs(String xh,String xm,String xb,String xy,String bj,String sjh,String ssh)
      throws SQLException   //添加一条学生信息，参数依次是学号、姓名、性别、学院、班级、手机号、宿舍号
      {    	   
		 try {//连接数据库
			    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	   	        Statement s=c.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select *  from 学生   where 学号='"+xh+"' ");                
	   	        r.last();	   	       	   	       
	   	        if(xh.equals(""))//如果没输入学号
	   	        	JOptionPane.showMessageDialog( null ,"学号不能为空!"); 
	   	        else if(r.getRow()==1)//如果输入系统中已经存在的学号
                   JOptionPane.showMessageDialog( null ,"该学号的学生信息已存在！"); 
	   	               
	     	    else{ //输入数据成功
	 s.executeUpdate("insert into 学生  values('"+xh+"','"+xm+"','"+xb+"','"+ xy+"','"+bj+"','"+sjh+"','"+ssh+"')");
	      		        	     	    		    			         
		              JOptionPane.showMessageDialog( null ,"<html>"
			                                       +"学   号:"+xh+"<br>"          
			        		                       +"姓   名:"+xm+"<br>"
                                                   +"性   别:"+xb+"<br>"
                                                   +"学   院:"+xy+"<br>"
                                                   +"班   级:"+bj+"<br>"
                                                   +"手机号:"+sjh+"<br>"
                                                   +"宿舍号:"+ssh+"<br> 学生记录添加成功！" ) ; 
		             }
	   	        r.close();
	   	        s.close();
	   	        c.close();
	   	        
	         }
          catch(Exception e)                                                       
	            {//输入数据不合格或不满足参照完整性
        	        JOptionPane.showMessageDialog( null ,"<html>"+"学生记录添加异常！"
                        +"<br>"+"请检查输入数据或者先更新宿舍信息！" ) ;
	            }
	    }

       public void AddSs(String ssh,String sgm,String sgdh)
	   throws SQLException { //添加一条宿舍记录，参数依次是宿舍号、宿管名、宿管电话   	   
		    try {
		    	    Class.forName("com.mysql.jdbc.Driver");
                    Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
		   	        Statement s=c.createStatement( 
		   	                             ResultSet.TYPE_SCROLL_SENSITIVE,
	 			                         ResultSet.CONCUR_UPDATABLE);
	                ResultSet r=s.executeQuery("select * from 宿舍   where 宿舍号='"+ssh+"'");
		   	        r.last();  
		   	        if(ssh.equals(""))
		   	        	JOptionPane.showMessageDialog( null ,"宿舍号不能为空!");
		   	              
		   	        else   if(r.getRow()==1) 
		   	        	JOptionPane.showMessageDialog( null ,"该宿舍的宿舍信息已存在!");            
		     	    else{ 
		     	    	   s.executeUpdate(" insert into 宿舍  values ('"+ssh+"','"+sgm+"','"+sgdh+"')");    				           
			               JOptionPane.showMessageDialog( null ,"<html>"+"宿  舍  号:"+ssh+"<br>" 
	                                                                    +"宿  管  名:"+sgm+"<br>"
	                                                                    +"宿管电话:"+sgdh+"<br> 宿舍记录添加成功！" ) ;
			            }
		   	        r.close();
		   	        s.close();
		   	        c.close();
		           }
	          catch(Exception e)                                                       
		            {
	        	       JOptionPane.showMessageDialog( null ,"<html>"+"宿舍记录添加异常！"
                            +"<br>"+"请检查输入数据！" ) ;
		            }
		 }
	  
        public  void  DisplayAllXs(ResultSet  r)//显示所有学生信息
         {     
	           final JFrame das=new JFrame("显示所有学生信息");
               das.setBounds(200, 100, 600, 400);
               das.setVisible(true);
               JPanel p=new JPanel();
               p.setLayout(null);
               das.add(p);
               JTextArea ta=new JTextArea();
               ta.setBounds(20, 20, 550, 250);
               ta.setOpaque(false);
               p.add(ta);
               JButton b=new JButton("确定");
               b.setBounds(400, 300, 60, 40);b.setContentAreaFilled(false);
               b.addActionListener(new ActionListener()                   
                { 
                   public void actionPerformed( ActionEvent e)               
                    {     	  
     	               das.setVisible(false);
                    }
                } );
               p.add(b); 
		       try{    
			        r.last();
			        ta.append("查询得"+r.getRow()+"条记录！\n");
			        r.beforeFirst();
			        ta.append("          学号  "+"                "+"姓名  "+"    "+"性别 "+"      "+
					   "学院  "+"            "+"班级  "+"                 "+" 手机号 "+"               "+
					   "宿舍号 "+"\n");
			        while(r.next())
			        {   				   
				         ta.append(r.getString("学号")+"        ");
				         ta.append(r.getString("姓名")+"        ");
				         ta.append(r.getString("性别")+"        ");
				         ta.append(r.getString("学院")+"        ");
				         ta.append(r.getString("班级")+"        ");
				         ta.append(r.getString("手机号")+"        ");
				         ta.append(r.getString("宿舍号")+"        "+"\n");				  
			         }
		       }
		       catch(Exception e) 
		       {	 
		    	   JOptionPane.showMessageDialog( null , "学生记录查询异常！" ) ;  
		       }
         }
  
        public  void  DisplayAllSs(ResultSet  r)//显示所有宿舍信息
        {     
        	final JFrame das=new JFrame("显示所有宿舍信息");
            das.setBounds(500, 100, 400, 400);
            das.setVisible(true);
            JPanel p=new JPanel();
            p.setLayout(null);
            das.add(p);
            JTextArea ta=new JTextArea();
            ta.setBounds(20, 20, 250, 250);
            ta.setOpaque(false); 
            p.add(ta);
            JButton b=new JButton("确定");
            b.setBounds(300, 300, 60, 40);
            b.addActionListener(new ActionListener()                   
	           { 
	              public void actionPerformed( ActionEvent e)               
	              {	        	  
	        	      das.setVisible(false);
	              }
	           });
            p.add(b);
		    try{    
			      r.last();
			      ta.append("查询得"+r.getRow()+"条记录！\n");
			      r.beforeFirst();
			      ta.append(" 宿舍号"+"          "+"宿管名"+"         "+"宿管电话"+"          "+"\n");
			      while(r.next())
			       {   				 
				      ta.append(r.getString("宿舍号")+"          ");
				      ta.append(r.getString("宿管名")+"          ");
				      ta.append(r.getString("宿管电话")+"\n");
			       }   
		      }
		     catch(Exception e)  {	 
		    	 JOptionPane.showMessageDialog( null , "宿舍记录查询异常！" ) ;  }
       }
  
       public void DisplayOneXs(String str) throws Exception    
       //显示一条学生信息
	   {      
	   
	      try
	  	   {  
	  		    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	  			Statement s=c.createStatement(  
	  			              ResultSet.TYPE_SCROLL_SENSITIVE,
	  			              ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select * from 学生   where 学号='"+str+"'");   	  		  
                r.last();  			
	  		    int cc=r.getRow();
                if(cc==0)
                     JOptionPane.showMessageDialog( null ,"未查询到相关信息！" ) ;  
                else
                {  
                	r.beforeFirst();
                    while(r.next())
                     {   JOptionPane.showMessageDialog( null ,"<html>"
                                     +"学号:"+r.getString("学号")+"<br>"          
	                                 +"姓名:"+r.getString("姓名")+"<br>"
                                     +"性别:"+r.getString("性别")+"<br>"
                                     +"学院:"+r.getString("学院")+"<br>"
                                     +"班级:"+r.getString("班级")+"<br>"
                                     +"手机号:"+r.getString("手机号")+"<br>"
                                     +"宿舍号:"+r.getString("宿舍号")+"<br> 已查询到相关信息！" ) ; 
                      }
	  	        }
                r.close();
	   	        s.close();
	   	        c.close();
           }
	  	   catch(Exception e)
	  	       { JOptionPane.showMessageDialog( null , "学生记录查询异常！" ) ;}	       
	   }
   
      public void DisplayOneSs(String str) throws Exception    
      //显示一条宿舍信息
	  {
	      
	  	  try
	  	   {
	  		    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	  			Statement s=c.createStatement(  
	  			              ResultSet.TYPE_SCROLL_SENSITIVE,
	  			              ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select * from 宿舍   where 宿舍号='"+str+"'");   	  		  
                r.last();  			
	  		    int cc=r.getRow();	  		  
                if(cc==0)
                       {  	JOptionPane.showMessageDialog( null ,"未查询到相关信息！" ) ;  }   
                else
                       {  r.beforeFirst();
                          while(r.next())
                             {   JOptionPane.showMessageDialog( null ,"<html>"
                                     +"宿舍号:"+r.getString("宿舍号")+"<br>"          
	                                 +"宿管名:"+r.getString("宿管名")+"<br>"
                                     +"宿管电话:"+r.getString("宿管电话")+"<br> 已查询到相关信息！" ) ; 
                             }
	  	               }
                r.close();
	   	        s.close();
	   	        c.close();
              }
	  	   catch(Exception e)
	  	     { JOptionPane.showMessageDialog( null , "宿舍记录查询异常！" ) ;}
	    }
   
      public void Display(String str) throws Exception  
      //显示一个宿舍的所有学生信息，参数是宿舍号
	  {
	       final JFrame das=new JFrame("显示所有学生信息");
           das.setBounds(200, 100, 500, 200);
           das.setVisible(true);
           JPanel p=new JPanel();
           p.setLayout(null);
           das.add(p);
           JTextArea ta=new JTextArea();
           ta.setBounds(20, 20, 450, 100);
           ta.setOpaque(false);
           p.add(ta);
           JButton b=new JButton("确定");
           b.setBounds(300, 120, 60, 40);
           b.addActionListener(new ActionListener()                   
             { 
                public void actionPerformed( ActionEvent e)               
               {	  
	               das.setVisible(false);
               }
             });
          p.add(b); 	   
	  	  try
	  	   {
	  		    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	  			Statement s=c.createStatement(  
	  			              ResultSet.TYPE_SCROLL_SENSITIVE,
	  			              ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select * from 学生   where 宿舍号='"+str+"'"); 
               
                r.last();  	
                ta.append("查询得"+r.getRow()+"条记录！\n");
                r.beforeFirst();
               
			    ta.append("宿舍号： "+str+"\n"+"          学号  "+"                "+"姓名  "+"    "+"性别 "+"      "+
					   "学院  "+"            "+"班级  "+"                 "+" 手机号 "+"\n");
					   
			    while(r.next())
			     {   
				   
				   ta.append(r.getString("学号")+"        ");
				   ta.append(r.getString("姓名")+"        ");
				   ta.append(r.getString("性别")+"        ");
				   ta.append(r.getString("学院")+"        ");
				   ta.append(r.getString("班级")+"        ");
				   ta.append(r.getString("手机号")+"        "+"\n");
				  
				  
			     }
               r.close();
	   	       s.close();
	   	       c.close();
            }
	  	   catch(Exception e)
	  	       {JOptionPane.showMessageDialog( null , "查询异常！" ) ;}
	   }

      public void DeleteXs(String str)   //删除一条学生信息，参数是学号           
       {
	      try 
	        {
	    	   Class.forName("com.mysql.jdbc.Driver");
               Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	    	   Statement s=c.createStatement(
	    	                ResultSet.TYPE_SCROLL_SENSITIVE,
		  	                ResultSet.CONCUR_UPDATABLE);
		  	   ResultSet r=s.executeQuery("select * from 学生   where 学号='"+str+"'");   
		  	   r.last();
		       if(r.getRow()==1)
		          {              	    	        
		    	   s.executeUpdate("delete from 学生  where 学号='"+str+"'"); 
	               JOptionPane.showMessageDialog( null , "学生记录删除成功！" ) ;    
		  	      }
               else { JOptionPane.showMessageDialog( null ,"无相关记录！" );  } 
		       r.close();
	   	       s.close();
	   	       c.close();
		   }
	      catch(Exception e)
	           { JOptionPane.showMessageDialog( null , "学生记录删除异常！" ) ;}
	   }

      public void DeleteSs(String str)      //删除一条宿舍信息，参数是宿舍号     
       {
	      try 
	        {
		        Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	    	    Statement s=c.createStatement(
	    	          ResultSet.TYPE_SCROLL_SENSITIVE,
		  	          ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select * from 宿舍   where 宿舍号='"+str+"'");            	                      
		        r.last();		   		   
		  	    if(r.getRow()==0)                                            
				     JOptionPane.showMessageDialog( null , "无相关记录！" ) ;
		        else
		  		 {
		    	     s.executeUpdate("delete from 宿舍   where 宿舍号='"+str+"'"); 
                     JOptionPane.showMessageDialog( null , "宿舍记录删除成功！" ) ;
                 } 
		  	    r.close();
   	            s.close();
   	            c.close();
		    }
          catch(Exception e)
	        {JOptionPane.showMessageDialog( null , "宿舍还有同学，无法删除！" ) ;}
       }

       public void UpdateXs(String xh,String sx,String xz)   
       //更新一条学生记录，参数依次是学号、属性、新值   
        {
	       try 
	       {  
	    	    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
	    	    Statement s=c.createStatement(
	    			ResultSet.TYPE_SCROLL_SENSITIVE,
		  			ResultSet.CONCUR_UPDATABLE);
		  	    ResultSet r=s.executeQuery("select * from 学生   where 学号='"+xh+"'");		  	              
                r.last();
                if(r.getRow()==1)
                  {     
                       	s.executeUpdate("update 学生   set "+sx+"='"+xz+"' where 学号='"+xh+"'");                   
                        JOptionPane.showMessageDialog( null , "学生记录修改成功！" ) ;  
                  }
               else {JOptionPane.showMessageDialog( null ,"学生记录中并无相关记录！" ) ;}
               r.close();
	   	       s.close();
	   	       c.close();
	        }
	        catch(Exception e)
	        {
	    	   JOptionPane.showMessageDialog( null ,"<html>"+"学生记录更新异常！"
                       +"<br>"+"请检查输入数据或者先更新宿舍的信息！" ) ;   
	        } 
        }
       
       public void UpdateSs(String ssh,String sx,String xz)   
       //更新一条宿舍记录，参数依次是宿舍号、属性、新值
       {
	       try
	       {  
	    	  Class.forName("com.mysql.jdbc.Driver");
              Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
			  Statement s=c.createStatement(
	    			ResultSet.TYPE_SCROLL_SENSITIVE,
		  			ResultSet.CONCUR_UPDATABLE);
		  	   ResultSet r=s.executeQuery("select * from 宿舍   where 宿舍号='"+ssh+"'");   		  		   
               r.last();		
		  	   if(r.getRow()==1)
		  		  {   
		  		      s.executeUpdate("update 宿舍   set "+sx+"='"+xz+"'  where 宿舍号='"+ssh+"'");                      
		              JOptionPane.showMessageDialog( null , "宿舍记录修改成功！" ) ;          
		  		  }
		  	   else{
                      JOptionPane.showMessageDialog( null ,"宿舍记录中并无相关记录！" ) ;        
		  		   }
		  	    r.close();
	   	        s.close();
	   	        c.close();
		  	 }
	        catch(Exception e)
             { 
	    	       JOptionPane.showMessageDialog( null ,"<html>"+"宿舍记录更新异常！"
                                        +"<br>"+"请检查输入数据或者先更新该宿舍学生的信息！" ) ;     
             }
       }
}

class J_ActionListener1 extends JFrame implements ActionListener  
//显示信息
{     	    
	  public void actionPerformed(ActionEvent e)        	 
	  {  
	        JButton b1=(JButton)e.getSource();
	        Object aa= JOptionPane.showInputDialog(null, "请选择按何种方式查询","选择", 
	                  JOptionPane.QUESTION_MESSAGE,null,new String []{"显示所有学生记录","显示所有宿舍记录",
	            		 "查询某个学生记录","查询某个宿舍记录","查询某个宿舍的所有学生记录"},"显示所有学生记录");
	        
	        if(aa==null) return;
	        else if(aa=="显示所有学生记录")
	        {            		    
		       try {  
		            try {
						   Class.forName("com.mysql.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             Connection c=DriverManager.getConnection                                                   
		                 ("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
			         Statement s=c.createStatement(  
		                           ResultSet.TYPE_SCROLL_SENSITIVE,
		                           ResultSet.CONCUR_UPDATABLE);
	                 ResultSet r=s.executeQuery("select * from 学生");  
	                 DataBase a =new  DataBase();         
                     a.DisplayAllXs(r);
                     r.close();
          	   	     s.close();
          	   	     c.close();
                    }                  			
                 catch (SQLException e1) { }
			 }
	         else if(aa=="显示所有宿舍记录")
	         {            		    
		         try {  
		            try {
						     Class.forName("com.mysql.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             Connection c=DriverManager.getConnection
		            		 ("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");
			         Statement s=c.createStatement(  
		                            ResultSet.TYPE_SCROLL_SENSITIVE,
		                            ResultSet.CONCUR_UPDATABLE);
	                 ResultSet r=s.executeQuery("select * from 宿舍");  
	                 DataBase a =new  DataBase();         
                     a.DisplayAllSs(r);
                     r.close();
          	   	     s.close();
          	   	     c.close();
                  }                  			
                  catch (SQLException e1) { } 
			   }
		       else if(aa=="查询某个学生记录")
		       {	
		    	  try{
		    		   String str=JOptionPane.showInputDialog("请输入要查询的记录的学号，如“201013137101”");
		    		   if(str==null)                                                       
		    		   {                                                                 
		    			   return;                                                       
		    		   }                                                     
		    		   if(str.equals(" ")   )                                                    
		    		   {                                                              
		    			   return;                                                    
		    		   } 
                       Class.forName("com.mysql.jdbc.Driver");
		               Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root");   
		               Statement s=c.createStatement(  
	                             ResultSet.TYPE_SCROLL_SENSITIVE,
	                             ResultSet.CONCUR_UPDATABLE);
		               DataBase a=new DataBase();             
	                      
	                   a.DisplayOneXs(str);                     
			           } 
		               catch (Exception e1) { }
	           }
		       else if(aa=="查询某个宿舍记录")
		       {	
		    	  try{
		    		   String str=JOptionPane.showInputDialog("请输入要查询的记录的宿舍号，如“南二321”");
		    		   if(str==null)                                                       
		    		   {                                                                 
		    			   return;                                                       
		    		   }                                                     
		    		   if   (str.equals( " ")   )                                                    
		    		   {                                                              
		    	         
		    			   return;                                                    
		    			} 
		    		   Class.forName("com.mysql.jdbc.Driver");
		                Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root"); 
		               Statement s=c.createStatement(  
	                             ResultSet.TYPE_SCROLL_SENSITIVE,
	                             ResultSet.CONCUR_UPDATABLE);
		               DataBase a=new DataBase();             
	                      
	                   a.DisplayOneSs(str);                     
			           } 
		            catch (Exception e1) { }
	           }
		       else 
		       {	
		    	   try{
		    		   String str=JOptionPane.showInputDialog("请输入要查询的记录的宿舍号，如“南二321”");
		    		   if(str==null)                                                       
		    		   {                                                                 
		    			   return;                                                       
		    		   }                                                     
		    		   if (str.equals( " ")   )                                                    
		    		   {                                                              
		    	         
		    			   return;                                                    
		    			} 
		    		   Class.forName("com.mysql.jdbc.Driver");
		                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/学生宿舍管理系统?useUnicode=true&characterEncoding=utf-8","root","root"); 
		               Statement s=c.createStatement(  
	                             ResultSet.TYPE_SCROLL_SENSITIVE,
	                             ResultSet.CONCUR_UPDATABLE);
		               DataBase a=new DataBase();             
	                      
	                   a.Display(str);                     
			           } 
		               catch (Exception e1) { }
	            }
			          
	      }
	
}
	


class J_ActionListener2 extends JFrame implements ActionListener
//添加信息
{  
	   final DataBase a=new DataBase();
       public void tianjia1()
	   {		    
	        final JFrame tianjia1=new JFrame();
	        tianjia1.setTitle("添加学生记录,请输入数据:") ;  //创建框架的标题
	        tianjia1.setSize(450,300);
	        tianjia1.setLocation(200, 100) ;       
	        tianjia1.setResizable(false);                            
	        tianjia1.setVisible(true);                    	        
         	JPanel c=new JPanel(){
	                public void paintComponent(Graphics g) {
	                    ImageIcon icon =
	                            new ImageIcon("E:\\2.jpg");
	                     g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
	                }
	            };
            c.setLayout(null);
            tianjia1.add(c);        
	 	    JLabel jlb1 = new JLabel("学号：") ;       //创建"学号"的标签
	 		jlb1.setBounds(20,20,50,40) ;	 		
	        c.add(jlb1) ;                           		
	        JLabel jlb2 = new JLabel("姓名：") ;        
	        jlb2.setBounds(210,20,50,40) ;
	        c.add(jlb2) ;
		    JLabel jlb3 = new JLabel("性别：") ;
 		    jlb3.setBounds(20,70,50,40) ;
 		    c.add(jlb3) ;
	 	    JLabel jlb4 = new JLabel("学院：") ;
	 	    jlb4.setBounds(210,70,50,40) ;
		    c.add(jlb4) ;
		    JLabel jlb5 = new JLabel("班级：") ;
	 	    jlb5.setBounds(20,120,50,40) ;
	 	    c.add(jlb5) ;
		    JLabel jlb6 = new JLabel("手机号") ;
		    jlb6.setBounds(210,120,50,40) ;
	 	    c.add(jlb6) ;
	 	    JLabel jlb7 = new JLabel("宿舍号") ;
		    jlb7.setBounds(20,170,50,40) ;
		    c.add(jlb7) ;
	 	    final JTextField jtf1 = new JTextField();             
	        final JTextField jtf2 = new JTextField();
	        final JTextField jtf3 = new JTextField();
	        final JTextField jtf4 = new JTextField();
	        final JTextField jtf5 = new JTextField();
	        final JTextField jtf6 = new JTextField();
            final JTextField jtf7 = new JTextField();
            JButton btn1 = null ;
            JButton btn2 = null ;
		    jtf1.setBounds(90,20,100,40) ;
		    jtf1.setOpaque(false);
 		    c.add(jtf1) ;
 		    jtf2.setBounds(280,20,100,40) ;
 		    jtf2.setOpaque(false);
	 	    c.add(jtf2) ;
	 	    jtf3.setBounds(90,70,100,40) ;
	 	    jtf3.setOpaque(false);
		    c.add(jtf3) ;
		    jtf4.setBounds(280,70,100,40) ;
		    jtf4.setOpaque(false);
	 	    c.add(jtf4) ;
	 	    jtf5.setBounds(90,120,100,40) ;
	 	    jtf5.setOpaque(false);
		    c.add(jtf5) ;
		    jtf6.setBounds(280,120,100,40) ;
		    jtf6.setOpaque(false);
	 	    c.add(jtf6) ;
	 	    jtf7.setBounds(90,170,100,40) ;
	 	    jtf7.setOpaque(false);
		    c.add(jtf7) ;
		    btn1 = new JButton("添加") ;               		
	 	    btn1.setBounds(240,170,60,40) ;                             
	 	    c.add(btn1) ;                                            
		    btn1.addActionListener(new ActionListener()                    
		      { 
			     public void actionPerformed( ActionEvent e)               
			     {
			         JButton tj=(JButton)e.getSource();
			         String xh=jtf1.getText();                   
			         String xm=jtf2.getText();
			         String xb=jtf3.getText();
			         String xy=jtf4.getText();
			         String bj=jtf5.getText();
			         String sjh=jtf6.getText();
			         String ssh=jtf7.getText();
			         try {
							a.AddXs(xh,xm,xb,xy,bj,sjh,ssh);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}      
			         tianjia1.setVisible(false);
			       }
	             });	
	 		    
	 		  btn2 = new JButton("取消") ;               		
			  btn2.setBounds(320,170,60,40) ;             
			  c.add(btn2) ;                           
			  btn2.addActionListener(new ActionListener()                   
			   { 
			      public void actionPerformed( ActionEvent e)               
			       {
			        	tianjia1.setVisible(false);
			       }
			   });	 		  	 		    
	     }
	    public void tianjia2()
	   //添加宿舍记录
	    {
		   final JFrame tianjia2=new JFrame();
        
	    
		   tianjia2.setTitle("添加宿舍记录，请输入数据:") ;             
		   tianjia2.setLocation(300, 100) ;
		   tianjia2.setSize(300, 250);
		   tianjia2.setResizable(false);                            
		   tianjia2.setVisible(true); 
	    
	        JPanel c=new JPanel(){
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("E:\\3.jpg");
                 g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
                }
              };
	        c.setLayout(null);
	        tianjia2.add(c);
            JLabel jlb1 = new JLabel("宿舍号：") ;       
		    jlb1.setBounds(40,20,70,40) ;              		
            c.add(jlb1) ;                           		
            JLabel jlb2 = new JLabel("宿管名：") ;        
		    jlb2.setBounds(40,70,70,40) ;
            c.add(jlb2) ;
		    JLabel jlb3 = new JLabel("宿管电话：") ;
		    jlb3.setBounds(40,120,70,40) ;
		    c.add(jlb3) ;
		    final JTextField jtf1 = new JTextField();             
			final JTextField jtf2 = new JTextField();
			final JTextField jtf3 = new JTextField();
			JButton btn1 = null ;
			JButton btn2 = null ;
		    jtf1.setBounds(130,20,100,40) ;
		    jtf1.setOpaque(false);
		    c.add(jtf1) ;
		    jtf2.setBounds(130,70,100,40) ;
		    jtf2.setOpaque(false);
		    c.add(jtf2) ;
		    jtf3.setBounds(130,120,100,40) ;
		    jtf3.setOpaque(false);
		    c.add(jtf3) ;
		    btn1 = new JButton("添加") ;               		
		    btn1.setBounds(150,170,60,40) ;             
		    c.add(btn1) ;                           
		    btn1.addActionListener(new ActionListener()                    //为”添加“按钮添加事件触发
		      { 
		          public void actionPerformed( ActionEvent e)               // 当添加的按钮被点击时执行
		          {
		        	  JButton tj=(JButton)e.getSource();
		        	  String ssh=jtf1.getText();                      //获取文本框的数据
		        	  String sgm=jtf2.getText();
		        	  String ssdh=jtf3.getText();
		        	  
		        	  try {
						a.AddSs(ssh,sgm,ssdh);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}      
		        	  tianjia2.setVisible(false);;}
             });
		    btn2 = new JButton("取消") ;               		
		    btn2.setBounds(220,170,60,40) ;             
		    c.add(btn2) ;                           
		    btn2.addActionListener(new ActionListener()                    //为”添加“按钮添加事件触发
		      { 
		          public void actionPerformed( ActionEvent e)               // 当添加的按钮被点击时执行
		          {
		        	  
		        	  tianjia2.setVisible(false);
		         }
		      } );
	      }
	                       
	        
	      public void actionPerformed(ActionEvent e)
	      {   
	    	  JButton b2=(JButton)e.getSource();          		
	    	  Object aa= JOptionPane.showInputDialog(null, "请选择添加对象","选择", 
	    	          JOptionPane.QUESTION_MESSAGE,null,new String []{"学生","宿舍",
	    	         		 },"学生");
	    	         		
	    	  if(aa=="学生")
	    	  {
	    		  this.tianjia1(); 
	    	  }
	    	  if(aa=="宿舍")
	    	  {
	    		  this.tianjia2(); 
	    	  }
		  }
}



class J_ActionListener3 extends JFrame implements ActionListener         
//修改已有信息
{           
	    final DataBase a=new DataBase();
	    String b=null;
	    
	    public void xiugai1()
	     {  
        	
        	final JFrame xiugai1=new JFrame();
    	    JButton xg1=new JButton("修改");
    	    JButton xg2=new JButton("取消");
    	    final JTextField jtf1 = new JTextField() ;                     
            final JTextField jtf2 = new JTextField() ;
            final JTextField jtf3 = new JTextField() ;           
            JLabel jlb1 = new JLabel(b) ;            
            JLabel jlb2 = new JLabel("请输入要修改的属性") ;                
            JLabel jlb3 = new JLabel("请输入新的数据") ;
        	xiugai1.setTitle("请输入数据:") ;          
	    	xiugai1.setSize(400,300) ;
	    	xiugai1.setLocation(500,200);
	    	xiugai1.setResizable(false);
	    	xiugai1.setVisible(true);	        
	       	JPanel c=new JPanel(){
	            public void paintComponent(Graphics g) {
	                ImageIcon icon =
	                        new ImageIcon("E:\\4.jpg");
	                 g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
	            }
	        };
			c.setLayout(null);
			xiugai1.add(c);
			
			jlb1.setBounds(20,20,150,40);
			c.add(jlb1);
			jlb2.setBounds(20,70,150,40);
			c.add(jlb2);
			jlb3.setBounds(20,120,150,40);
			c.add(jlb3);
			jtf1.setBounds(150,20,200,40);
			jtf1.setOpaque(false);
			c.add(jtf1);
			jtf2.setBounds(150,70,200,40);
			jtf2.setOpaque(false);
			c.add(jtf2);
			jtf3.setBounds(150,120,200,40);
			jtf3.setOpaque(false);
			c.add(jtf3);
			xg1.setBounds(210,170,70,40);        
			c.add(xg1);
			xg1.addActionListener(new ActionListener()                   
		      { 
		          public void actionPerformed( ActionEvent e)              
		          {
		        	  JButton xg=(JButton)e.getSource();
		        	  String xh=jtf1.getText();                   
		        	  String sx=jtf2.getText();
		        	  String xz=jtf3.getText();
		        	  a.UpdateXs(xh,sx,xz);      
		        	  xiugai1.setVisible(false);
		          }
             });
			xg2.setBounds(290,170,70,40);        
			c.add(xg2);
			xg2.addActionListener(new ActionListener()                    
		      { 
		          public void actionPerformed( ActionEvent e)               
		          {
		        	        
		        	  xiugai1.setVisible(false);
		        	  }
               });
	      }
	    
	     public void xiugai2()
	     {  
             final JFrame xiugai2=new JFrame();
   	         JButton xg1=new JButton("修改");
   	         JButton xg2=new JButton("取消");
   	         final JTextField jtf1 = new JTextField() ;                     
             final JTextField jtf2 = new JTextField() ;
             final JTextField jtf3 = new JTextField() ;
             JLabel jlb1 = new JLabel(b) ;            
             JLabel jlb2 = new JLabel("请输入要修改的属性") ;                
             JLabel jlb3 = new JLabel("请输入新的数据") ;
       	     xiugai2.setTitle("请输入数据:") ;          
	    	 xiugai2.setSize(400,300) ;
	    	 xiugai2.setLocation(500,200);
	    	 xiugai2.setResizable(false);
	    	 xiugai2.setVisible(true);
	        
	       	 JPanel c=new JPanel(){
	            public void paintComponent(Graphics g) {
	                ImageIcon icon =
	                        new ImageIcon("E:\\4.jpg");
	                 g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
	              }
	           };
			c.setLayout(null);
			xiugai2.add(c);			
			jlb1.setBounds(20,20,150,40);
			c.add(jlb1);
			jlb2.setBounds(20,70,150,40);
			c.add(jlb2);
			jlb3.setBounds(20,120,150,40);
			c.add(jlb3);
			jtf1.setBounds(150,20,200,40);
			jtf1.setOpaque(false);
			c.add(jtf1);
			jtf2.setBounds(150,70,200,40);
			jtf2.setOpaque(false);
			c.add(jtf2);
			jtf3.setBounds(150,120,200,40);
			jtf3.setOpaque(false);
			c.add(jtf3);
			xg1.setBounds(210,170,70,40);        
			c.add(xg1);
			xg1.addActionListener(new ActionListener()                   
		      { 
		          public void actionPerformed( ActionEvent e)              
		          {
		        	  JButton xg=(JButton)e.getSource();
		        	  String ssh=jtf1.getText();                   
		        	  String sx=jtf2.getText();
		        	  String xz=jtf3.getText();
		        	  a.UpdateSs(ssh,sx,xz);      
		        	  xiugai2.setVisible(false);
		          }
              });
			xg2.setBounds(290,170,70,40);        
			c.add(xg2);
			xg2.addActionListener(new ActionListener()                    
		      { 
		          public void actionPerformed( ActionEvent e)               
		          {
		        	        
		        	  xiugai2.setVisible(false);
		          }
              });
	     }
	    
	    public void actionPerformed(ActionEvent e)
	    {	
	    	JButton b3=(JButton)e.getSource();
	        Object aa= JOptionPane.showInputDialog(null, "请选择修改对象","选择",             
	        		//弹出窗口让用户选择按何种方式进行修改
                                                    JOptionPane.QUESTION_MESSAGE,null,
                                                   new String []{"学生","宿舍"},"学生");
	        
	        if(aa==null) return;
	        else if(aa=="学生")                
	        { 
	        	b="请输入学号";	
	         	this.xiugai1();
	         }               
	             	            
	        else                      
	        {  
	        	b="请输入宿舍号";
	            this.xiugai2();
	        }

	    }
}	

class J_ActionListener4 implements ActionListener
//删除记录                     
{
    public void actionPerformed(ActionEvent e)
	        {   
    	        JButton b4=(JButton)e.getSource();
	            DataBase a=new DataBase();           //实例化DataBase类
	            Object aa= JOptionPane.showInputDialog(null, "请选择删除对象","选择",JOptionPane.QUESTION_MESSAGE,    
	            		//弹出窗口让用户选择按何种方式进行删除
	            		                               null,new String []{"学生","宿舍"},"学生");
	            if(aa==null) return;
	            else if(aa=="学生")
                    { 
                	    String str=JOptionPane.showInputDialog("请输入要删除的记录的学号"); 
                	    if(str==null) return;
    	                a.DeleteXs(str);            
                    }  	
                 else{   
                	        String str=JOptionPane.showInputDialog("请输入要删除的记录的宿舍号");
                	        if(str==null) return;
	                        a.DeleteSs(str);           
                      }
	          }
 }


class J_ActionListener5 implements ActionListener                  
//关于管理系统  
{
	   public void actionPerformed(ActionEvent e)                   //按钮被点击执行
	    {  JButton b5=(JButton)e.getSource();
	       JOptionPane.showMessageDialog( null ,"               花花出品                        \n" +
	       		"              2016/12/03                         " ) ;
        }
}