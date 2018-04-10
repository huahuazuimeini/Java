package 词法分析;
public class 词法分析 {   
     
    /*  初始化数据  
      syn为单词种别码；  
      token为存放的单词自身字符串；  
      sum为整型常数。  
     */  
    static String prog;   
    static char ch;   
    static char[]token=new char[8];   
    static int syn,p,m,n,sum;   
    static //关键字表的初值  
    String[] rwtable={"begin","if","then","while","do","end"};   
       
    /**  
     * @param args  
     * @throws IOException   
     */  
    public static void main(String[] args) throws IOException {   
         //1、输入字符串   
         //prog="begin  x:=9; if x>0  then   x:=2*x+1/3;end #";  
         //1、从文件中读取字符串   
        prog=dofile.readFileByChars("src/data.txt");   
         //2、扫描输出   
         p=0;   
         do{   
             scaner();   
             switch(syn){   
             case 11:System.out.print("("+syn+" , ");//单词符号：Digit digit*  
                     System.out.print(sum);   
                     System.out.println(")");   
                break;   
             case -1:System.out.println("error!");   
                break;   
             default:   
                     System.out.print("(");   
                     System.out.print(syn);    
                     System.out.print(" , ");   
                     String str=new String(token);   
                     System.out.print(str);   
                     System.out.println(")");   
             }   
         }while(syn!=0);   
            
            
    }   
    //扫描程序   
    private static void scaner() throws IOException {          
//      1、初始化   
        for(int i=0;i<8;i++)   
            token[i]=' ';   
//      2、读字母   
        ch=prog.charAt(p++);   
        while(ch==' '){//如果是空格，则取下一个字符  
            ch=prog.charAt(p++);   
        }   
//      3、开始执行扫描   
//          1、是字母   
//                     读标识符，查保留字表   
//                         查到，换成属性字表，写到输出流  
//                         没查到， 查名表，换成属性字，写到输出流  
        if(ch>='a'&&ch<='z'){   
            m=0;   
            //获取完整单词   
            while((ch>='a'&&ch<='z')||(ch>='0'&&ch<='9')){   
                token[m++]=ch;   
                ch=prog.charAt(p++);   
            }   
            token[m++]='\0';   
            --p;   
            syn=10;//单词符号为letter(letter|digit)*  
            //判断是哪个关键字   
            String newStr=new String(token);   
            newStr=newStr.trim();   
            //System.out.println("newStr:"+newStr);  
            for(n=0;n<6;n++){   
                //System.out.println("rwtable:"+rwtable[n]);  
                if(newStr.equals(rwtable[n])){   
                    syn=n+1;   
                    System.out.println("syn 的值是："+syn);   
                    break;   
                }   
            }   
            token[m++]='\0';   
        }   
//          2、是数字   
//                         取数字，查常量表，换成属性字表，写到输出流  
        else if(ch>='0'&&ch<='9'){   
            while(ch>='0'&&ch<='9'){   
                sum=sum*10+ch-'0';   
                ch=prog.charAt(p++);   
            }   
            --p;   
            syn=11;//digitdigit*  
            token[m++]='\0';   
        }   
//          3、是特殊符号   
//                         查特殊符号表，换成属性字。写到输出流  
//          4、错误error   
//      4、是否分析结束   
//              未结束，到2   
//              结束，到出口   
        else    
        switch(ch){   
            case'<':   
                m=0;   
                token[m++]=ch;   
                ch=prog.charAt(p++);   
                if(ch=='>'){   
                    syn=21;//<>  
                }   
                else if(ch=='='){   
                    syn=22;//<=  
                    token[m++]=ch;   
                }   
                else{   
                    syn=20;//<  
                    --p;   
                }   
            break;   
            case'>':   
                token[m++]=ch;   
                ch=prog.charAt(p++);   
                if(ch=='='){   
                    syn=24;//>=  
                }   
                else{   
                    syn=23;//>  
                    --p;   
                }   
                break;   
            case':':   
                token[m++]=ch;   
                ch=prog.charAt(p++);   
                if(ch=='='){   
                    syn=18;//:=  
                    token[m++]=ch;   
                }   
                else{   
                    syn=17;//:  
                    --p;   
                }   
            break;   
            case'+':   
                syn=13;token[0]=ch;token[1]='\0';break;   
            case'-':   
                syn=14;token[0]=ch;token[1]='\0';break;   
            case'*':   
                syn=15;token[0]=ch;token[1]='\0';break;   
            case'/':   
                syn=16;token[0]=ch;token[1]='\0';break;   
            case'=':   
                syn=25;token[0]=ch;token[1]='\0';break;   
            case';':   
                syn=26;token[0]=ch;token[1]='\0';break;   
            case'(':   
                syn=27;token[0]=ch;token[1]='\0';break;   
            case')':   
                syn=28;token[0]=ch;token[1]='\0';break;   
            case'#':   
                syn=0;token[0]=ch;token[1]='\0';break;   
            default:   
                syn=-1;    
                   
        }   
           
        File txt=new File("src/nihao.txt");   
           if(!txt.exists()){   
               txt.createNewFile();   
           }   
           byte[] bytes=new byte[token.length];//定义一个长度与需要转换的char数组相同的byte数组  
           for(int i=0;i<bytes.length ;i++){//循环将char的每个元素转换并存放在上面定义的byte数组中  
               byte b=(byte)token[i];//将每个char转换成byte  
               bytes[i]=b;//保存到数组中   
           }   
           FileOutputStream fos;   
        try {   
            fos = new FileOutputStream(txt,true);   
            fos.write(syn);   
            fos.write(bytes);   
               
               fos.close();   
        } catch (Exception e) {   
            e.printStackTrace();   
        }     
    }   
}
