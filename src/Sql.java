package snippet;

import java.awt.Container;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Sql extends JFrame implements ActionListener{//���ڽӿ�
	   JFrame mm=new JFrame("Hey��Baby!");
	   JTextField t2=new JTextField(null,15);//�����ı�
       JTextField t4=new JPasswordField(null,15);//��������
       public String zh=null;
       JRadioButton b=new JRadioButton("��ʦ");//ѡ��
	   JRadioButton b1=new JRadioButton("ѧ��");
	   JRadioButton b2=new JRadioButton("����Ա");
       public void jiemian(){
		          	mm.setSize(400,400);
		          	mm.setVisible(true);//��ʾ
		          	mm.setLocation(500,180);		   
		          	mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�
		          	JLabel t1=new JLabel("ID��:");//��ǩ
		          	JLabel t3=new JLabel("����:");
		          	JButton denglu=new JButton("��¼");
		          	denglu.setContentAreaFilled(false);//��ť͸��
		          	Container n=mm.getContentPane();//����
		      		n.setLayout(null);//����
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
		        	b1.setSelected(true);//ѡ�а�ť����
		        	b1.setSelected(false);	       
		        	rg.add(b);
		        	rg.add(b1);
		        	rg.add(b2);  
		            b.setContentAreaFilled(false);
		            b1.setContentAreaFilled(false);
		            b2.setContentAreaFilled(false);
		          	denglu.addActionListener(this);//��ǰ�����
	 		   }
public void actionPerformed(ActionEvent e) {//�������ӿ�
	 JButton denglu=(JButton)e.getSource();
	 if(b.isSelected()) { 
		zh=t2.getText();  
	    String mima=t4.getText();
	  try {  
			Class.forName("com.mysql.jdbc.Driver"); //���䣬����һ������               
Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//ִ�У��ɹ����������������������ݿ�
ResultSet r=s.executeQuery("select * from ��ʦ��Ϣ��   where ��ʦID='"+zh+"' and ��¼����='"+mima+"'"); //����sql�����ݿⷵ�ؽ����
		  		    r.last();//���������һ��		                                                                 
	         if(r.getRow()==1) {//?
	                 mm.setVisible(false);
	                 r.beforeFirst();
	     while(r.next()){  //�������
	         JOptionPane.showMessageDialog( null ,r.getString("��ʦ����")+"��ӭ��¼��ʦ����ϵͳ��" ) ;  //��ʾ��
	         }
	JFrame mmm=new JFrame();
	mmm.setSize(400,420);
	mmm.setVisible(true);
	mmm.setLocation(200,300);
	mmm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JLabel aaa=new JLabel("ѧ����Ϣ����:");JLabel aaa1=new JLabel("ѧ���ɼ�����:");
	aaa.setBounds(15,15,90,30); aaa1.setBounds(15,140,90,30);
	JButton b1=new JButton("��ʾѧ����Ϣ");b1.setBounds(40,45,140,30);
	JButton b2=new JButton("���ѧ����Ϣ");b2.setBounds(200,45,140,30);
	JButton b3=new JButton("�޸�ѧ����Ϣ");b3.setBounds(40,90,140,30);
	JButton b4=new JButton("ɾ��ѧ����Ϣ");b4.setBounds(200,90,140,30);
	JButton b5=new JButton("¼��ѧ���ɼ�");b5.setBounds(40,170,140,30);
	JButton b6=new JButton("�޸�ѧ���ɼ�");b6.setBounds(200,170,140,30);
	JButton b7=new JButton("ɾ��ѧ���ɼ�");b7.setBounds(40,215,140,30);
	JButton b8=new JButton("��ѯѧ���ɼ�");b8.setBounds(200,215,140,30);
	JButton b9=new JButton("���гɼ�����");b9.setBounds(40,260,140,30);	
	JButton b10=new JButton("�˳�ϵͳ");b10.setBounds(60,325,100,30);
	JButton b11=new JButton("�޸�����");b11.setBounds(220,325,100,30);
	JButton b12=new JButton("���Ƴɼ�����");b12.setBounds(200,260,140,30);	
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
	    		System.exit(0);   //����
	 		   } 
	         }
	    );
		((JComponent) mmm.getContentPane()).setOpaque(false); //͸��   ������
        java.net.URL url = Sql.class.getResource("δ����.jpg");//��ȡ·��
		ImageIcon img = new ImageIcon(url);//����ͼƬ
		JLabel background = new JLabel(img);//����
		mmm.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));//���ñ���   ��Сֵ
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	 }
	 else{   JOptionPane.showMessageDialog( null ,"��ʦID�������������������룡") ;      
	 }
	  }
	  catch(Exception e1)
	  {   
		  e1.printStackTrace();//��ӡ�쳣            
	  }
}
	}
public static void main(String args[]){
	  Sql app=new Sql();
	  app.jiemian();	  
}
}

//�����ݿ�����µ�ѧ����Ϣ��
class DataBase{        //  DataBase��
	
	public void  Add(String xh,String xm,String xb,String bj,String jg,String mm)throws SQLException  {//�����쳣			    
	   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	        Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select * from ѧ����Ϣ��   where ѧ��='"+xh+"'");
	   	    r.last();  
	   	    if(r.getRow()==1)                                                         
	   	    {  
	   	    	JOptionPane.showMessageDialog( null ,"��ѧ�ŵ�ѧ����Ϣ�Ѵ���");
	   	    	}       
	   	     else if(xh.equals(""))
	   	     {         //�ж��������ѧ���Ƿ�Ϊ��
	   	        JOptionPane.showMessageDialog( null ,"ѧ�Ų���Ϊ��");
	   	        }                
	   	    else{    
	   	    	s.executeUpdate(" insert into ѧ����Ϣ��  values ('"+xh+"','"+xm+"','"+xb+"','"+  bj+"','"+jg+"','"+mm+"')"); //����   
                s.close();
                c.close();
                JOptionPane.showMessageDialog( null ,"<html>"+"ѧ��:"+xh+"<br>"+"����:"+xm+"<br>" 
                +"�Ա�:"+xb+"<br>"+"�༶��:"+bj+"<br>" +"����:"+jg+"<br>" +"��¼����:"+mm+"<br>ѧ����¼��ӳɹ���" ) ; //����
                }
	       }
	     catch (ClassNotFoundException e)                                                       
	  	  {
	    	 JOptionPane.showMessageDialog( null , "��������쳣��" ) ;
	    	 }
	       }
	  
public void DisplayAll(ResultSet r){   //���ݱ�                                   		    
		    JFrame m=new JFrame("��ʾ����ѧ����Ϣ");
			m.setBounds(60,70,700,600);
			m.setVisible(true);
			JTextArea aa=new JTextArea();	//�����ı�
			aa.setBounds(0,0,700,600);
			Container c1=m.getContentPane();
			c1.setLayout(null);
			c1.add(aa);
		  try{      
			  r.last();
              aa.append("\tѧ��"+"\t"+"  ����"+"\t"+"�Ա�"+"\t"+"�༶"+"\t"+"����"+"\n");
			  r.beforeFirst();
		 while(r.next())
			   {  
				  aa.append("��"+r.getRow()+"�м�¼: ");
				  aa.append(r.getString("ѧ��"));
				  aa.append("\t"+r.getString("����"));
				  aa.append("\t"+r.getString("�Ա�"));
				  aa.append("\t"+r.getString("�༶"));
				  aa.append("\t"+r.getString("����")+"\n");
			   } 
			   }
		  catch(Exception e)
		  {	  
			  e.printStackTrace();}  
		  }

	  public void DisplayOne(String str22)throws Exception { 	   
		  try{
			    Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
	  			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	  		    ResultSet r=s.executeQuery("select ѧ�� ,����,�Ա�, �༶����  as �༶,����   "
	  		    		+ "from ѧ����Ϣ��   join �༶��Ϣ��  on �༶��Ϣ��.�༶��=ѧ����Ϣ��.�༶��   where ѧ��='"+str22+"'");   
	  		             //ִ�в�ѯ��SQL���
	                r.last();  			
	  		        int cc=r.getRow();
                if(cc==0){
                 	JOptionPane.showMessageDialog( null ,"δ��ѯ�������Ϣ��" ) ;   
                 	}                    
                else{r.beforeFirst();
	  			while(r.next())
	  			  {  
	  				JOptionPane.showMessageDialog( null ,"<html>"+"  ѧ��:"+r.getString("ѧ��")
	  						+"<br>"+"����:"+r.getString("����")+"<br>"+"�Ա�:"+r.getString("�Ա�")
	  						+"<br>" +"�༶:"+r.getString("�༶")+"<br>"+"����:"+r.getString("����")
	  						+"<br> �Ѳ�ѯ����ؼ�¼��" ) ;	
	  				 }
	  			} 
               }
	  	catch(Exception e)
	  	{   
	  		e.printStackTrace();
	  		}
		  }
 public void DeleteXh(String str11)         //ִ�а�ѧ��ɾ��ѧ����¼�Ĳ���
   { 
    	try {
	      Class.forName("com.mysql.jdbc.Driver");
		  Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
	    	   Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
               ResultSet r=s.executeQuery("select * from ѧ����Ϣ��   where ѧ��='"+str11+"'");   
		  	   r.last();
	           if(r.getRow()==1){              
                s.executeUpdate("delete from ѧ����Ϣ��  where ѧ��='"+str11+"'"); 
	             JOptionPane.showMessageDialog( null , "ѧ����¼ɾ���ɹ���" ) ;   
	        } 
	           else  {  
	        	   JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" ); 
	        	   }    
	     }
	    catch(Exception e)
	    { e.printStackTrace();
	    }
    	}
public void DeleteXm(String str13)         //ִ�а�����ɾ��ѧ����¼�Ĳ���
  {  try 
	     {
	         Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	    	Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select * from ѧ����Ϣ�� where ����='"+str13+"'");     
		  		    r.last();
		  	        if(r.getRow()==1)                                           
	    	   {
		  	        	s.executeUpdate("delete from ѧ����Ϣ��  where ����='"+str13+"'"); 
	    	            JOptionPane.showMessageDialog( null , "ѧ����¼ɾ���ɹ���" );
	    	            }       
               else{   
            	   JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" ) ; 
            	   }          
	     }
	  catch(Exception e)
	     { e.printStackTrace();
	     }
        }
public void UpdateXh(String xg,String str15,String str16)     //ѧ�Ÿ���  
    {
	    try {  
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
	    	Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select * from ѧ����Ϣ��   where ѧ��='"+xg+"'");     		  		    
            r.last();		
		  		  if(r.getRow()==1){
		  		     s.executeUpdate("update ѧ����Ϣ��   set "+str15+"='"+str16+"'  where ѧ��='"+xg+"'");   //ֱ��ִ��SQL����޸�                         
	                 JOptionPane.showMessageDialog( null , "ѧ����¼�޸ĳɹ���" ) ;       		  		 
	                 } 
		  		  else{
		             JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" ) ;        		  		
		             }; 
		             }
	     catch(Exception e){
	    JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" );        
	   } 
	    }
public void UpdateXm(String str18,String str19,String str20){//��������
	   try {  
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  		    ResultSet r=s.executeQuery("select * from ѧ����Ϣ��   where ����='"+str18+"'");     
		  		    r.last();		
		  		 if(r.getRow()==1){
		  		   s.executeUpdate("update ѧ����Ϣ��   set "+str19+"='"+str20+"'  where ����='"+str18+"'");   //ֱ��ִ��SQL����޸�                         
		           JOptionPane.showMessageDialog( null , "ѧ����¼�޸ĳɹ���" ) ;    
		   }
		  		 else{
                   JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" ) ;        		  			   
                   }; 
                   }
	     catch(Exception e){
	  JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" ) ;        
	   }
	   }
public void AddScore(String xh,String kch, String cj){//��ӷ���
 	    try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
	   	    Statement s=c.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   	    if(xh.equals("")||kch.equals("")||cj.equals("")){  
	   	    	JOptionPane.showMessageDialog( null ,"���������Ϊ��");     
	   	    }
	   	    else{ 
	   	    	ResultSet r=s.executeQuery("select * from �ɼ���Ϣ�� where ѧ��='"+xh+"' and �γ̺�='"+kch+"'");
	   	    r.last();  
	   	    int i=Integer.parseInt(cj);//ת��
	   	    if(r.getRow()==1) {  
	   	    	JOptionPane.showMessageDialog( null ,"��ѧ���ÿƳɼ��Ѵ���");
	   	    	}       
	   	     else{               
                s.executeUpdate(" insert into �ɼ���Ϣ��  values ('"+xh+"','"+kch+"','"+i+"')");      
                JOptionPane.showMessageDialog( null ,"<html>"+"ѧ��:"+xh+"<br>"
                +"�γ̺�:"+kch+"<br>"+"�ɼ�:"+cj+"<br> ѧ���ɼ���ӳɹ���" ) ; 
                } 
	   	    }
	   	    }
	     catch (Exception e){
	    	 JOptionPane.showMessageDialog( null , "�ɼ������ѧ�Ż��߿γ̺Ų����ڣ�" );
	    	 }  
 	    }
public void UpdateScore(String xh,String kch,String cj)  {//���·���
 	   try {  
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if(xh.equals("")||kch.equals("")||cj.equals("")){  
				JOptionPane.showMessageDialog( null ,"���������Ϊ��");      
				}
 	   	    else{
 	   	    	int i=Integer.parseInt(cj);
		  		ResultSet r=s.executeQuery("select * from �ɼ���Ϣ�� where ѧ��='"+xh+"' and �γ̺�='"+kch+"'");
	            r.last();	
	            if(r.getRow()==1){
		  		      s.executeUpdate("update  �ɼ���Ϣ��   set �ɼ�='"+i+"'  where ѧ��='"+xh+"' and �γ̺�='"+kch+"'");                          
	                  JOptionPane.showMessageDialog( null , "ѧ���ɼ��޸ĳɹ���" ) ;    }
		  		  else{
	                  JOptionPane.showMessageDialog( null ,"�ɼ����в�����ؼ�¼��" ) ;        
		  			};
	      }
			} 
 	   catch(Exception e){
	    JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" ) ; 
	    }
 	   }  
public void DeleteScore(String xh,String kch) {   //ɾ������    
    try {
    	Class.forName("com.mysql.jdbc.Driver");
	    Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	    Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    ResultSet r=s.executeQuery("select * from �ɼ���Ϣ��   where ѧ��='"+xh+"' and �γ̺�='"+kch+"'");		  	  
	    r.last();
		  		 if(r.getRow()==1){              
	    	         s.executeUpdate("delete from �ɼ���Ϣ��   where ѧ��='"+xh+"' and �γ̺�='"+kch+"'"); 
	    	         JOptionPane.showMessageDialog( null , "ѧ����¼ɾ���ɹ���" ) ; 
	    	         }
	else  {  
		JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" );  
		}   
	     }
    catch(Exception e)
	    {  e.printStackTrace();
	    }
    }
public void SearchScore(String xh){//��ѯ����
 	    JFrame m=new JFrame("ѧ��"+xh+"�ĸ��Ƴɼ�");
	    m.setBounds(60,70,326,320);
		m.setVisible(true);
		JTextArea aa=new JTextArea();
		aa.setBounds(0,0,326,320);
		Container c1=m.getContentPane();
		c1.setLayout(null);
		c1.add(aa);
 	  try {
		 Class.forName("com.mysql.jdbc.Driver");
         Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
	    	   Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  	   ResultSet r1= s.executeQuery("select ѧ��,�γ�����,�ɼ�     from �ɼ���Ϣ��    join  "
		  	   		+ "�γ���Ϣ��  on �ɼ���Ϣ��.�γ̺�=�γ���Ϣ��.�γ̺� " +" where ѧ��='"+xh+"'"); 
	    	         r1.last();
	    	         aa.append("��ѯ����ѧ��"+r1.getRow()+"�Ƴɼ�"+"\n");
	    	         r1.beforeFirst();
	    	         aa.append("     ѧ��"+"\t"+"       �γ����� "+"\t"+"  �ɼ�"+"\n");
				   while(r1.next()){
				      aa.append(r1.getString("ѧ��"));
					  aa.append("\t      "+r1.getString("�γ�����"));
					  aa.append("\t  "+r1.getString("�ɼ�")+"\n");
				   } 
				   }
	    catch(Exception e){
	        e.printStackTrace();  
	        }    
 	  }
public  void ListAll(String banji){//�ɼ���
	    JFrame m=new JFrame(banji+"�༶�ɼ�����");
		m.setBounds(60,70,413,319);
		m.setVisible(true);
		JTextArea aa=new JTextArea();
		aa.setBounds(0,0,413,319);
		Container c1=m.getContentPane();
		c1.setLayout(null);
		c1.add(aa);
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
	        Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
            String sql="execute ȫ������ '"+banji+"'";
	        ResultSet r1= s.executeQuery(sql); 
	        r1.last();
	        aa.append("\tѧ��"+"\t"+"����"+"\t"+"ƽ���� "+"\t"+"�ܷ�"+"\n");
	        r1.beforeFirst();
	        for(int i=1;r1.next();i++){ 
		       aa.append ("��"+i+"����");
			   aa.append (r1.getString("ѧ��"));
			   aa.append ("\t"+r1.getString("����"));
			   aa.append ("\t"+r1.getString("ƽ����"));
			   aa.append ("\t"+r1.getString("�ܷ�")+"\n" );
			  }  
	        }
	catch(Exception e){
	    e.printStackTrace();	
	    }
		}	  
public void ListOne(String str1,String str2){
	    JFrame m=new JFrame(str2+"��"+str1+"��"+"�ɼ�����");
		m.setBounds(60,70,326,320);
		m.setVisible(true);
		JTextArea aa=new JTextArea();
		aa.setBounds(0,0,326,320);
	    Container c1=m.getContentPane();
		c1.setLayout(null);
		c1.add(aa);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
		    Statement s=c.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    String sql="execute ���Ƴɼ����� '"+str1+"', "+" '"+str2+"'";
	  	    ResultSet r1= s.executeQuery(sql); 
	  	    r1.last();	         
	        aa.append("\t"+"ѧ��"+"\t"+"����"+"\t"+"�ɼ�"+"\n"); r1.beforeFirst(); 
		       for(int i=1;r1.next();i++) {
			       aa.append("��"+i+"����");
				   aa.append(r1.getString("ѧ��"));
				   aa.append("\t"+r1.getString("����"));
				   aa.append("\t"+r1.getString("�ɼ�") +"\n"); 
				   }
		       }
		catch(Exception e){
		    e.printStackTrace();	
		    } 
		}
public void AddTeacher(String id,String xm,String mm, String kch,String kcm){//��ʦ
	   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	   	    Statement s=c.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   if(id.equals("")||mm.equals("")||kch.equals("")||kcm.equals("")){  
		    JOptionPane.showMessageDialog( null ,"���������Ϊ��");      
		  }
       else{   
	        ResultSet r=s.executeQuery("select * from ��ʦ��Ϣ��     where ��ʦ��Ϣ��.��ʦID='"+id+"' ");
	   	    r.last();  
	      if(r.getRow()==1){                                                              
	   	    	JOptionPane.showMessageDialog( null ,"������Ľ�ʦID�Ѵ����Ѵ���");
	   	    	}       
	      else{   
	    	 s.executeUpdate(" insert into ��ʦ��Ϣ��  values ('"+id+"','"+xm+"','"+mm+"')"); 
	    	 s.executeUpdate(" insert into �γ���Ϣ��  values ('"+kch+"','"+kcm+"','"+id+"')");  
			 JOptionPane.showMessageDialog( null ,"<html>"+"��ʦID:"+id+"<br>"+"��ʦ����:"+kch+"<br>"+"��¼����:"
	    	 +kch+"<br>"+"�γ̺�:"+kch+"<br>" +"�γ���:"+kcm+"<br> ��ʦ��Ϣ��ӳɹ���" ) ; 
			 }  
	   	    }
	     }
	     catch (Exception e)  {                                               
	  	           e.printStackTrace();      
	  	           }   
	      }
public void  UpdateTeacher(String id,String shuxin,String xin){//���½�ʦ
	     try { 
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root");
	    	Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select * from ��ʦ��Ϣ��   where ��ʦID='"+id+"'");    		  		
            r.last();	
            if(r.getRow()==1) {
		  		 s.executeUpdate("update ��ʦ�γ���ϸ��Ϣ   set "+shuxin+"='"+xin+"'  where ��ʦID='"+id+"'");                         
		         JOptionPane.showMessageDialog( null , "��ʦ��Ϣ�޸ĳɹ���" ) ;  }
         else{JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" ) ;    
		  			};   }
	     catch(Exception e) { 
	         e.printStackTrace();        //δ����صļ�¼
	 }
	  }
public void DeleteTeacher(String id){         //ɾ��
         try{ 
             Class.forName("com.mysql.jdbc.Driver");
	         Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
 	         Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet r=s.executeQuery("select * from ��ʦ��Ϣ��   where ��ʦID='"+id+"'" );   
	  	     r.last();
	  	 if(r.getRow()==1){              
 	         s.executeUpdate("delete from ��ʦ��Ϣ��   where ��ʦID='"+id+"'"); 
 	         JOptionPane.showMessageDialog( null , "��ʦ��Ϣɾ���ɹ���" ) ;     
 	         }
	     else {  
		     JOptionPane.showMessageDialog( null ,"ѧ��ϵͳ�в�����ؼ�¼��" ); 
		     } 
	  	    }
         catch(Exception e){
            e.printStackTrace();
             }
           }
public void DisplayAllTeacher(){//��ʾ����
	        JFrame m=new JFrame("��ʦ��Ϣ�б�");
		    m.setBounds(60,70,433,319);
		    m.setVisible(true);
		    JTextArea aa=new JTextArea();
		    aa.setBounds(0,0,413,319);
		    Container c1=m.getContentPane();
		    c1.setLayout(null);
		    c1.add(aa);
	      try  { 
		       Class.forName("com.mysql.jdbc.Driver");
	           Connection c=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/ѧ������ϵͳ?useUnicode=true&characterEncoding=utf-8","root","root" );
	    	   Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		  	   ResultSet r=s.executeQuery("select * from ��ʦ�γ���ϸ��Ϣ  " );   
		  	   aa.append("  ��ʦID"+"\t"+"��ʦ����"+"\t"+"�γ̱��"+"\t"+"�γ�����"+"\t"+"��¼����"+"\n");
		  	   r.last();	
		  	   r.beforeFirst();
         	while(r.next()){
		  			aa.append("  "+r.getString("��ʦID"));
	                aa.append("\t"+r.getString("��ʦ����"));
                    aa.append("\t"+r.getString("�γ̺�"));
					aa.append("\t"+r.getString("�γ�����"));
					aa.append("\t"+r.getString("��¼����") +"\n"); }}
	    catch(Exception e)
	    {  e.printStackTrace();
	    }
	      }
}







