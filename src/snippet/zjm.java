package snippet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class zjm extends JFrame implements ActionListener
{
	final JFrame dl=new JFrame("��ӭ�����������ϵͳ��");
	final JTextField t1=new JTextField();
	JPasswordField t2=new JPasswordField ();//��������������ʹ������
	JButton b1=new JButton("��½");
	JButton b2=new JButton("ȡ��");
	
	public static void main (String[] args) //������
	{ 
		zjm e=new zjm();   //��������
		e.denglu();       //����denglu�����������¼����
		
	 }
	
	public void actionPerformed(ActionEvent e)//��¼�¼��Ķ���
	{
		if(e.getSource()==b1) 
		{
			String zh=t1.getText();//��ȡ�û�������˺�
			@SuppressWarnings("deprecation")
			String mm=t2.getText();//��ȡ�û����������
			if(zh.equals("huahua")||zh.equals("beibei"))
			{
				if((zh.equals("huahua")&&mm.equals("123456"))||(zh.equals("beibei")&&mm.equals("654321")))
			    {
					zjm();  //��¼�ɹ�������������
					dl.setVisible(false);//���ص�¼����
			    }
				
				else
				{
					JOptionPane.showMessageDialog( null ,"�������"); //��ʾ�������������
					t2.setText(null);//�˺�������ȷ�������������ʱ������������˺ţ���ȥ����
				}
			}
			else 
			{    
				JOptionPane.showMessageDialog( null ,"�˺Ŵ���"); 
				t1.setText(null);
				t2.setText(null);//�˺��������ʱ����ȥ������˺ź�����
			}
		}
		
		
	  }
			
	
	
	  public void denglu()//denglu������������¼����
	  {
		
		  dl.setLocation(300,100);
          dl.setSize(600,500);
          dl.setResizable(false);
          dl.setVisible(true);
          JPanel p=new JPanel(){          
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("ͼƬ.jpg");
                 g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
                }//��ӱ���
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
          b2.addActionListener(new ActionListener()  //���ȡ��ʱ���˳�����              
	         { 
	            public void actionPerformed( ActionEvent e)               
	             {
	        	  	 System.exit(0);
	             }
	          } );
          
	  }
	  
	  public void zjm ()//����������
	  {
		
         JFrame zjm=new JFrame("��ӭʹ���������ϵͳ��");
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
         JButton b1=new JButton("��ʾ��Ϣ");
         J_ActionListener1 a1=new J_ActionListener1();
         b1.setBounds(80, 30, 100, 30);
         b1.addActionListener(a1);
         c.add(b1);
         JButton b2=new JButton("�����Ϣ");
         J_ActionListener2 a2=new J_ActionListener2();
         b2.setBounds(195, 60, 100, 30);
         b2.addActionListener(a2);
         c.add(b2);
         JButton b3=new JButton("�޸���Ϣ");
         J_ActionListener3 a3=new J_ActionListener3();
         b3.setBounds(310, 90, 100, 30);
         b3.addActionListener(a3);
         c.add(b3);
         JButton b4=new JButton("ɾ����Ϣ");
         J_ActionListener4 a4=new J_ActionListener4();
         b4.setBounds(310, 130, 100, 30);
         b4.addActionListener(a4);
         c.add(b4);
         JButton b5=new JButton("����ϵͳ");
         J_ActionListener5 a5=new J_ActionListener5();
         b5.setBounds(195, 160, 100, 30);
         b5.addActionListener(a5);
         c.add(b5);
         JButton b6=new JButton("�˳�ϵͳ");
         b6.setBounds(80, 190, 100, 30);
         b6.addActionListener(new ActionListener()//���ȡ��ʱ���˳�����  
           {
			  public void actionPerformed(ActionEvent arg0)
			  {	
				System.exit(0);
			  }
        	 
           });
         c.add(b6);              
	 }

}



class DataBase         //  DataBase��
{
      public void AddXs(String xh,String xm,String xb,String xy,String bj,String sjh,String ssh)
      throws SQLException   //���һ��ѧ����Ϣ������������ѧ�š��������Ա�ѧԺ���༶���ֻ��š������
      {    	   
		 try {//�������ݿ�
			    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	   	        Statement s=c.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select *  from ѧ��   where ѧ��='"+xh+"' ");                
	   	        r.last();	   	       	   	       
	   	        if(xh.equals(""))//���û����ѧ��
	   	        	JOptionPane.showMessageDialog( null ,"ѧ�Ų���Ϊ��!"); 
	   	        else if(r.getRow()==1)//�������ϵͳ���Ѿ����ڵ�ѧ��
                   JOptionPane.showMessageDialog( null ,"��ѧ�ŵ�ѧ����Ϣ�Ѵ��ڣ�"); 
	   	               
	     	    else{ //�������ݳɹ�
	 s.executeUpdate("insert into ѧ��  values('"+xh+"','"+xm+"','"+xb+"','"+ xy+"','"+bj+"','"+sjh+"','"+ssh+"')");
	      		        	     	    		    			         
		              JOptionPane.showMessageDialog( null ,"<html>"
			                                       +"ѧ   ��:"+xh+"<br>"          
			        		                       +"��   ��:"+xm+"<br>"
                                                   +"��   ��:"+xb+"<br>"
                                                   +"ѧ   Ժ:"+xy+"<br>"
                                                   +"��   ��:"+bj+"<br>"
                                                   +"�ֻ���:"+sjh+"<br>"
                                                   +"�����:"+ssh+"<br> ѧ����¼��ӳɹ���" ) ; 
		             }
	   	        r.close();
	   	        s.close();
	   	        c.close();
	   	        
	         }
          catch(Exception e)                                                       
	            {//�������ݲ��ϸ���������������
        	        JOptionPane.showMessageDialog( null ,"<html>"+"ѧ����¼����쳣��"
                        +"<br>"+"�����������ݻ����ȸ���������Ϣ��" ) ;
	            }
	    }

       public void AddSs(String ssh,String sgm,String sgdh)
	   throws SQLException { //���һ�������¼����������������š��޹������޹ܵ绰   	   
		    try {
		    	    Class.forName("com.mysql.jdbc.Driver");
                    Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
		   	        Statement s=c.createStatement( 
		   	                             ResultSet.TYPE_SCROLL_SENSITIVE,
	 			                         ResultSet.CONCUR_UPDATABLE);
	                ResultSet r=s.executeQuery("select * from ����   where �����='"+ssh+"'");
		   	        r.last();  
		   	        if(ssh.equals(""))
		   	        	JOptionPane.showMessageDialog( null ,"����Ų���Ϊ��!");
		   	              
		   	        else   if(r.getRow()==1) 
		   	        	JOptionPane.showMessageDialog( null ,"�������������Ϣ�Ѵ���!");            
		     	    else{ 
		     	    	   s.executeUpdate(" insert into ����  values ('"+ssh+"','"+sgm+"','"+sgdh+"')");    				           
			               JOptionPane.showMessageDialog( null ,"<html>"+"��  ��  ��:"+ssh+"<br>" 
	                                                                    +"��  ��  ��:"+sgm+"<br>"
	                                                                    +"�޹ܵ绰:"+sgdh+"<br> �����¼��ӳɹ���" ) ;
			            }
		   	        r.close();
		   	        s.close();
		   	        c.close();
		           }
	          catch(Exception e)                                                       
		            {
	        	       JOptionPane.showMessageDialog( null ,"<html>"+"�����¼����쳣��"
                            +"<br>"+"�����������ݣ�" ) ;
		            }
		 }
	  
        public  void  DisplayAllXs(ResultSet  r)//��ʾ����ѧ����Ϣ
         {     
	           final JFrame das=new JFrame("��ʾ����ѧ����Ϣ");
               das.setBounds(200, 100, 600, 400);
               das.setVisible(true);
               JPanel p=new JPanel();
               p.setLayout(null);
               das.add(p);
               JTextArea ta=new JTextArea();
               ta.setBounds(20, 20, 550, 250);
               ta.setOpaque(false);
               p.add(ta);
               JButton b=new JButton("ȷ��");
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
			        ta.append("��ѯ��"+r.getRow()+"����¼��\n");
			        r.beforeFirst();
			        ta.append("          ѧ��  "+"                "+"����  "+"    "+"�Ա� "+"      "+
					   "ѧԺ  "+"            "+"�༶  "+"                 "+" �ֻ��� "+"               "+
					   "����� "+"\n");
			        while(r.next())
			        {   				   
				         ta.append(r.getString("ѧ��")+"        ");
				         ta.append(r.getString("����")+"        ");
				         ta.append(r.getString("�Ա�")+"        ");
				         ta.append(r.getString("ѧԺ")+"        ");
				         ta.append(r.getString("�༶")+"        ");
				         ta.append(r.getString("�ֻ���")+"        ");
				         ta.append(r.getString("�����")+"        "+"\n");				  
			         }
		       }
		       catch(Exception e) 
		       {	 
		    	   JOptionPane.showMessageDialog( null , "ѧ����¼��ѯ�쳣��" ) ;  
		       }
         }
  
        public  void  DisplayAllSs(ResultSet  r)//��ʾ����������Ϣ
        {     
        	final JFrame das=new JFrame("��ʾ����������Ϣ");
            das.setBounds(500, 100, 400, 400);
            das.setVisible(true);
            JPanel p=new JPanel();
            p.setLayout(null);
            das.add(p);
            JTextArea ta=new JTextArea();
            ta.setBounds(20, 20, 250, 250);
            ta.setOpaque(false); 
            p.add(ta);
            JButton b=new JButton("ȷ��");
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
			      ta.append("��ѯ��"+r.getRow()+"����¼��\n");
			      r.beforeFirst();
			      ta.append(" �����"+"          "+"�޹���"+"         "+"�޹ܵ绰"+"          "+"\n");
			      while(r.next())
			       {   				 
				      ta.append(r.getString("�����")+"          ");
				      ta.append(r.getString("�޹���")+"          ");
				      ta.append(r.getString("�޹ܵ绰")+"\n");
			       }   
		      }
		     catch(Exception e)  {	 
		    	 JOptionPane.showMessageDialog( null , "�����¼��ѯ�쳣��" ) ;  }
       }
  
       public void DisplayOneXs(String str) throws Exception    
       //��ʾһ��ѧ����Ϣ
	   {      
	   
	      try
	  	   {  
	  		    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	  			Statement s=c.createStatement(  
	  			              ResultSet.TYPE_SCROLL_SENSITIVE,
	  			              ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select * from ѧ��   where ѧ��='"+str+"'");   	  		  
                r.last();  			
	  		    int cc=r.getRow();
                if(cc==0)
                     JOptionPane.showMessageDialog( null ,"δ��ѯ�������Ϣ��" ) ;  
                else
                {  
                	r.beforeFirst();
                    while(r.next())
                     {   JOptionPane.showMessageDialog( null ,"<html>"
                                     +"ѧ��:"+r.getString("ѧ��")+"<br>"          
	                                 +"����:"+r.getString("����")+"<br>"
                                     +"�Ա�:"+r.getString("�Ա�")+"<br>"
                                     +"ѧԺ:"+r.getString("ѧԺ")+"<br>"
                                     +"�༶:"+r.getString("�༶")+"<br>"
                                     +"�ֻ���:"+r.getString("�ֻ���")+"<br>"
                                     +"�����:"+r.getString("�����")+"<br> �Ѳ�ѯ�������Ϣ��" ) ; 
                      }
	  	        }
                r.close();
	   	        s.close();
	   	        c.close();
           }
	  	   catch(Exception e)
	  	       { JOptionPane.showMessageDialog( null , "ѧ����¼��ѯ�쳣��" ) ;}	       
	   }
   
      public void DisplayOneSs(String str) throws Exception    
      //��ʾһ��������Ϣ
	  {
	      
	  	  try
	  	   {
	  		    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	  			Statement s=c.createStatement(  
	  			              ResultSet.TYPE_SCROLL_SENSITIVE,
	  			              ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select * from ����   where �����='"+str+"'");   	  		  
                r.last();  			
	  		    int cc=r.getRow();	  		  
                if(cc==0)
                       {  	JOptionPane.showMessageDialog( null ,"δ��ѯ�������Ϣ��" ) ;  }   
                else
                       {  r.beforeFirst();
                          while(r.next())
                             {   JOptionPane.showMessageDialog( null ,"<html>"
                                     +"�����:"+r.getString("�����")+"<br>"          
	                                 +"�޹���:"+r.getString("�޹���")+"<br>"
                                     +"�޹ܵ绰:"+r.getString("�޹ܵ绰")+"<br> �Ѳ�ѯ�������Ϣ��" ) ; 
                             }
	  	               }
                r.close();
	   	        s.close();
	   	        c.close();
              }
	  	   catch(Exception e)
	  	     { JOptionPane.showMessageDialog( null , "�����¼��ѯ�쳣��" ) ;}
	    }
   
      public void Display(String str) throws Exception  
      //��ʾһ�����������ѧ����Ϣ�������������
	  {
	       final JFrame das=new JFrame("��ʾ����ѧ����Ϣ");
           das.setBounds(200, 100, 500, 200);
           das.setVisible(true);
           JPanel p=new JPanel();
           p.setLayout(null);
           das.add(p);
           JTextArea ta=new JTextArea();
           ta.setBounds(20, 20, 450, 100);
           ta.setOpaque(false);
           p.add(ta);
           JButton b=new JButton("ȷ��");
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
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	  			Statement s=c.createStatement(  
	  			              ResultSet.TYPE_SCROLL_SENSITIVE,
	  			              ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select * from ѧ��   where �����='"+str+"'"); 
               
                r.last();  	
                ta.append("��ѯ��"+r.getRow()+"����¼��\n");
                r.beforeFirst();
               
			    ta.append("����ţ� "+str+"\n"+"          ѧ��  "+"                "+"����  "+"    "+"�Ա� "+"      "+
					   "ѧԺ  "+"            "+"�༶  "+"                 "+" �ֻ��� "+"\n");
					   
			    while(r.next())
			     {   
				   
				   ta.append(r.getString("ѧ��")+"        ");
				   ta.append(r.getString("����")+"        ");
				   ta.append(r.getString("�Ա�")+"        ");
				   ta.append(r.getString("ѧԺ")+"        ");
				   ta.append(r.getString("�༶")+"        ");
				   ta.append(r.getString("�ֻ���")+"        "+"\n");
				  
				  
			     }
               r.close();
	   	       s.close();
	   	       c.close();
            }
	  	   catch(Exception e)
	  	       {JOptionPane.showMessageDialog( null , "��ѯ�쳣��" ) ;}
	   }

      public void DeleteXs(String str)   //ɾ��һ��ѧ����Ϣ��������ѧ��           
       {
	      try 
	        {
	    	   Class.forName("com.mysql.jdbc.Driver");
               Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	    	   Statement s=c.createStatement(
	    	                ResultSet.TYPE_SCROLL_SENSITIVE,
		  	                ResultSet.CONCUR_UPDATABLE);
		  	   ResultSet r=s.executeQuery("select * from ѧ��   where ѧ��='"+str+"'");   
		  	   r.last();
		       if(r.getRow()==1)
		          {              	    	        
		    	   s.executeUpdate("delete from ѧ��  where ѧ��='"+str+"'"); 
	               JOptionPane.showMessageDialog( null , "ѧ����¼ɾ���ɹ���" ) ;    
		  	      }
               else { JOptionPane.showMessageDialog( null ,"����ؼ�¼��" );  } 
		       r.close();
	   	       s.close();
	   	       c.close();
		   }
	      catch(Exception e)
	           { JOptionPane.showMessageDialog( null , "ѧ����¼ɾ���쳣��" ) ;}
	   }

      public void DeleteSs(String str)      //ɾ��һ��������Ϣ�������������     
       {
	      try 
	        {
		        Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	    	    Statement s=c.createStatement(
	    	          ResultSet.TYPE_SCROLL_SENSITIVE,
		  	          ResultSet.CONCUR_UPDATABLE);
                ResultSet r=s.executeQuery("select * from ����   where �����='"+str+"'");            	                      
		        r.last();		   		   
		  	    if(r.getRow()==0)                                            
				     JOptionPane.showMessageDialog( null , "����ؼ�¼��" ) ;
		        else
		  		 {
		    	     s.executeUpdate("delete from ����   where �����='"+str+"'"); 
                     JOptionPane.showMessageDialog( null , "�����¼ɾ���ɹ���" ) ;
                 } 
		  	    r.close();
   	            s.close();
   	            c.close();
		    }
          catch(Exception e)
	        {JOptionPane.showMessageDialog( null , "���ỹ��ͬѧ���޷�ɾ����" ) ;}
       }

       public void UpdateXs(String xh,String sx,String xz)   
       //����һ��ѧ����¼������������ѧ�š����ԡ���ֵ   
        {
	       try 
	       {  
	    	    Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	    	    Statement s=c.createStatement(
	    			ResultSet.TYPE_SCROLL_SENSITIVE,
		  			ResultSet.CONCUR_UPDATABLE);
		  	    ResultSet r=s.executeQuery("select * from ѧ��   where ѧ��='"+xh+"'");		  	              
                r.last();
                if(r.getRow()==1)
                  {     
                       	s.executeUpdate("update ѧ��   set "+sx+"='"+xz+"' where ѧ��='"+xh+"'");                   
                        JOptionPane.showMessageDialog( null , "ѧ����¼�޸ĳɹ���" ) ;  
                  }
               else {JOptionPane.showMessageDialog( null ,"ѧ����¼�в�����ؼ�¼��" ) ;}
               r.close();
	   	       s.close();
	   	       c.close();
	        }
	        catch(Exception e)
	        {
	    	   JOptionPane.showMessageDialog( null ,"<html>"+"ѧ����¼�����쳣��"
                       +"<br>"+"�����������ݻ����ȸ����������Ϣ��" ) ;   
	        } 
        }
       
       public void UpdateSs(String ssh,String sx,String xz)   
       //����һ�������¼����������������š����ԡ���ֵ
       {
	       try
	       {  
	    	  Class.forName("com.mysql.jdbc.Driver");
              Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
			  Statement s=c.createStatement(
	    			ResultSet.TYPE_SCROLL_SENSITIVE,
		  			ResultSet.CONCUR_UPDATABLE);
		  	   ResultSet r=s.executeQuery("select * from ����   where �����='"+ssh+"'");   		  		   
               r.last();		
		  	   if(r.getRow()==1)
		  		  {   
		  		      s.executeUpdate("update ����   set "+sx+"='"+xz+"'  where �����='"+ssh+"'");                      
		              JOptionPane.showMessageDialog( null , "�����¼�޸ĳɹ���" ) ;          
		  		  }
		  	   else{
                      JOptionPane.showMessageDialog( null ,"�����¼�в�����ؼ�¼��" ) ;        
		  		   }
		  	    r.close();
	   	        s.close();
	   	        c.close();
		  	 }
	        catch(Exception e)
             { 
	    	       JOptionPane.showMessageDialog( null ,"<html>"+"�����¼�����쳣��"
                                        +"<br>"+"�����������ݻ����ȸ��¸�����ѧ������Ϣ��" ) ;     
             }
       }
}

class J_ActionListener1 extends JFrame implements ActionListener  
//��ʾ��Ϣ
{     	    
	  public void actionPerformed(ActionEvent e)        	 
	  {  
	        JButton b1=(JButton)e.getSource();
	        Object aa= JOptionPane.showInputDialog(null, "��ѡ�񰴺��ַ�ʽ��ѯ","ѡ��", 
	                  JOptionPane.QUESTION_MESSAGE,null,new String []{"��ʾ����ѧ����¼","��ʾ���������¼",
	            		 "��ѯĳ��ѧ����¼","��ѯĳ�������¼","��ѯĳ�����������ѧ����¼"},"��ʾ����ѧ����¼");
	        
	        if(aa==null) return;
	        else if(aa=="��ʾ����ѧ����¼")
	        {            		    
		       try {  
		            try {
						   Class.forName("com.mysql.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             Connection c=DriverManager.getConnection                                                   
		                 ("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
			         Statement s=c.createStatement(  
		                           ResultSet.TYPE_SCROLL_SENSITIVE,
		                           ResultSet.CONCUR_UPDATABLE);
	                 ResultSet r=s.executeQuery("select * from ѧ��");  
	                 DataBase a =new  DataBase();         
                     a.DisplayAllXs(r);
                     r.close();
          	   	     s.close();
          	   	     c.close();
                    }                  			
                 catch (SQLException e1) { }
			 }
	         else if(aa=="��ʾ���������¼")
	         {            		    
		         try {  
		            try {
						     Class.forName("com.mysql.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		             Connection c=DriverManager.getConnection
		            		 ("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
			         Statement s=c.createStatement(  
		                            ResultSet.TYPE_SCROLL_SENSITIVE,
		                            ResultSet.CONCUR_UPDATABLE);
	                 ResultSet r=s.executeQuery("select * from ����");  
	                 DataBase a =new  DataBase();         
                     a.DisplayAllSs(r);
                     r.close();
          	   	     s.close();
          	   	     c.close();
                  }                  			
                  catch (SQLException e1) { } 
			   }
		       else if(aa=="��ѯĳ��ѧ����¼")
		       {	
		    	  try{
		    		   String str=JOptionPane.showInputDialog("������Ҫ��ѯ�ļ�¼��ѧ�ţ��硰201013137101��");
		    		   if(str==null)                                                       
		    		   {                                                                 
		    			   return;                                                       
		    		   }                                                     
		    		   if(str.equals(" ")   )                                                    
		    		   {                                                              
		    			   return;                                                    
		    		   } 
                       Class.forName("com.mysql.jdbc.Driver");
		               Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");   
		               Statement s=c.createStatement(  
	                             ResultSet.TYPE_SCROLL_SENSITIVE,
	                             ResultSet.CONCUR_UPDATABLE);
		               DataBase a=new DataBase();             
	                      
	                   a.DisplayOneXs(str);                     
			           } 
		               catch (Exception e1) { }
	           }
		       else if(aa=="��ѯĳ�������¼")
		       {	
		    	  try{
		    		   String str=JOptionPane.showInputDialog("������Ҫ��ѯ�ļ�¼������ţ��硰�϶�321��");
		    		   if(str==null)                                                       
		    		   {                                                                 
		    			   return;                                                       
		    		   }                                                     
		    		   if   (str.equals( " ")   )                                                    
		    		   {                                                              
		    	         
		    			   return;                                                    
		    			} 
		    		   Class.forName("com.mysql.jdbc.Driver");
		                Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root"); 
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
		    		   String str=JOptionPane.showInputDialog("������Ҫ��ѯ�ļ�¼������ţ��硰�϶�321��");
		    		   if(str==null)                                                       
		    		   {                                                                 
		    			   return;                                                       
		    		   }                                                     
		    		   if (str.equals( " ")   )                                                    
		    		   {                                                              
		    	         
		    			   return;                                                    
		    			} 
		    		   Class.forName("com.mysql.jdbc.Driver");
		                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ѧ���������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root"); 
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
//�����Ϣ
{  
	   final DataBase a=new DataBase();
       public void tianjia1()
	   {		    
	        final JFrame tianjia1=new JFrame();
	        tianjia1.setTitle("���ѧ����¼,����������:") ;  //������ܵı���
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
	 	    JLabel jlb1 = new JLabel("ѧ�ţ�") ;       //����"ѧ��"�ı�ǩ
	 		jlb1.setBounds(20,20,50,40) ;	 		
	        c.add(jlb1) ;                           		
	        JLabel jlb2 = new JLabel("������") ;        
	        jlb2.setBounds(210,20,50,40) ;
	        c.add(jlb2) ;
		    JLabel jlb3 = new JLabel("�Ա�") ;
 		    jlb3.setBounds(20,70,50,40) ;
 		    c.add(jlb3) ;
	 	    JLabel jlb4 = new JLabel("ѧԺ��") ;
	 	    jlb4.setBounds(210,70,50,40) ;
		    c.add(jlb4) ;
		    JLabel jlb5 = new JLabel("�༶��") ;
	 	    jlb5.setBounds(20,120,50,40) ;
	 	    c.add(jlb5) ;
		    JLabel jlb6 = new JLabel("�ֻ���") ;
		    jlb6.setBounds(210,120,50,40) ;
	 	    c.add(jlb6) ;
	 	    JLabel jlb7 = new JLabel("�����") ;
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
		    btn1 = new JButton("���") ;               		
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
	 		    
	 		  btn2 = new JButton("ȡ��") ;               		
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
	   //��������¼
	    {
		   final JFrame tianjia2=new JFrame();
        
	    
		   tianjia2.setTitle("��������¼������������:") ;             
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
            JLabel jlb1 = new JLabel("����ţ�") ;       
		    jlb1.setBounds(40,20,70,40) ;              		
            c.add(jlb1) ;                           		
            JLabel jlb2 = new JLabel("�޹�����") ;        
		    jlb2.setBounds(40,70,70,40) ;
            c.add(jlb2) ;
		    JLabel jlb3 = new JLabel("�޹ܵ绰��") ;
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
		    btn1 = new JButton("���") ;               		
		    btn1.setBounds(150,170,60,40) ;             
		    c.add(btn1) ;                           
		    btn1.addActionListener(new ActionListener()                    //Ϊ����ӡ���ť����¼�����
		      { 
		          public void actionPerformed( ActionEvent e)               // ����ӵİ�ť�����ʱִ��
		          {
		        	  JButton tj=(JButton)e.getSource();
		        	  String ssh=jtf1.getText();                      //��ȡ�ı��������
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
		    btn2 = new JButton("ȡ��") ;               		
		    btn2.setBounds(220,170,60,40) ;             
		    c.add(btn2) ;                           
		    btn2.addActionListener(new ActionListener()                    //Ϊ����ӡ���ť����¼�����
		      { 
		          public void actionPerformed( ActionEvent e)               // ����ӵİ�ť�����ʱִ��
		          {
		        	  
		        	  tianjia2.setVisible(false);
		         }
		      } );
	      }
	                       
	        
	      public void actionPerformed(ActionEvent e)
	      {   
	    	  JButton b2=(JButton)e.getSource();          		
	    	  Object aa= JOptionPane.showInputDialog(null, "��ѡ����Ӷ���","ѡ��", 
	    	          JOptionPane.QUESTION_MESSAGE,null,new String []{"ѧ��","����",
	    	         		 },"ѧ��");
	    	         		
	    	  if(aa=="ѧ��")
	    	  {
	    		  this.tianjia1(); 
	    	  }
	    	  if(aa=="����")
	    	  {
	    		  this.tianjia2(); 
	    	  }
		  }
}



class J_ActionListener3 extends JFrame implements ActionListener         
//�޸�������Ϣ
{           
	    final DataBase a=new DataBase();
	    String b=null;
	    
	    public void xiugai1()
	     {  
        	
        	final JFrame xiugai1=new JFrame();
    	    JButton xg1=new JButton("�޸�");
    	    JButton xg2=new JButton("ȡ��");
    	    final JTextField jtf1 = new JTextField() ;                     
            final JTextField jtf2 = new JTextField() ;
            final JTextField jtf3 = new JTextField() ;           
            JLabel jlb1 = new JLabel(b) ;            
            JLabel jlb2 = new JLabel("������Ҫ�޸ĵ�����") ;                
            JLabel jlb3 = new JLabel("�������µ�����") ;
        	xiugai1.setTitle("����������:") ;          
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
   	         JButton xg1=new JButton("�޸�");
   	         JButton xg2=new JButton("ȡ��");
   	         final JTextField jtf1 = new JTextField() ;                     
             final JTextField jtf2 = new JTextField() ;
             final JTextField jtf3 = new JTextField() ;
             JLabel jlb1 = new JLabel(b) ;            
             JLabel jlb2 = new JLabel("������Ҫ�޸ĵ�����") ;                
             JLabel jlb3 = new JLabel("�������µ�����") ;
       	     xiugai2.setTitle("����������:") ;          
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
	        Object aa= JOptionPane.showInputDialog(null, "��ѡ���޸Ķ���","ѡ��",             
	        		//�����������û�ѡ�񰴺��ַ�ʽ�����޸�
                                                    JOptionPane.QUESTION_MESSAGE,null,
                                                   new String []{"ѧ��","����"},"ѧ��");
	        
	        if(aa==null) return;
	        else if(aa=="ѧ��")                
	        { 
	        	b="������ѧ��";	
	         	this.xiugai1();
	         }               
	             	            
	        else                      
	        {  
	        	b="�����������";
	            this.xiugai2();
	        }

	    }
}	

class J_ActionListener4 implements ActionListener
//ɾ����¼                     
{
    public void actionPerformed(ActionEvent e)
	        {   
    	        JButton b4=(JButton)e.getSource();
	            DataBase a=new DataBase();           //ʵ����DataBase��
	            Object aa= JOptionPane.showInputDialog(null, "��ѡ��ɾ������","ѡ��",JOptionPane.QUESTION_MESSAGE,    
	            		//�����������û�ѡ�񰴺��ַ�ʽ����ɾ��
	            		                               null,new String []{"ѧ��","����"},"ѧ��");
	            if(aa==null) return;
	            else if(aa=="ѧ��")
                    { 
                	    String str=JOptionPane.showInputDialog("������Ҫɾ���ļ�¼��ѧ��"); 
                	    if(str==null) return;
    	                a.DeleteXs(str);            
                    }  	
                 else{   
                	        String str=JOptionPane.showInputDialog("������Ҫɾ���ļ�¼�������");
                	        if(str==null) return;
	                        a.DeleteSs(str);           
                      }
	          }
 }


class J_ActionListener5 implements ActionListener                  
//���ڹ���ϵͳ  
{
	   public void actionPerformed(ActionEvent e)                   //��ť�����ִ��
	    {  JButton b5=(JButton)e.getSource();
	       JOptionPane.showMessageDialog( null ,"               ������Ʒ                        \n" +
	       		"              2016/12/03                         " ) ;
        }
}