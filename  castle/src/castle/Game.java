package castle;

import java.util.Scanner;

public class Game {
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;  
        //	���췿��
        outside = new Room("�Ǳ���");
        lobby = new Room("����");
        pub = new Room("С�ư�");
        study = new Room("�鷿");
        bedroom = new Room("����");
        //	��ʼ������ĳ���      �϶�����
        outside.setExits(null, lobby, study, pub);
        lobby.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        study.setExits(outside, bedroom, null, null);
        bedroom.setExits(null, null, null, study);

        currentRoom = outside;  //	�ӳǱ����⿪ʼ
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("��ӭ�����Ǳ���");
        System.out.println("����һ���������ĵ���Ϸ��");
        System.out.println("�����Ҫ������������ 'help' ��");
        System.out.println();
        showPrompt();
    }

    // ����Ϊ�û�����

    private void printHelp() 
    {
        System.out.print("��������������У�go bye help");
        System.out.println("�磺go east");
    }

    private void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExit(direction);//��ֵ
        
        if (nextRoom == null) {//�ж�
            System.out.println("����û���ţ�");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }
    public void showPrompt(){
        System.out.println("����" + currentRoom);
        System.out.print("������: ");
        System.out.println(currentRoom.getExitDesc());
    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);//������
		Game game = new Game();
		game.printWelcome();

        while ( true ) {
        		String line = in.nextLine();//��ȡ������ַ� enter����
        		String[] words = line.split(" ");//��ȡһ���ַ�  ���ص����б� ����Ϊ�ָ���
        		if ( words[0].equals("help") ) {
        			game.printHelp();
        		} else if (words[0].equals("go") ) {
        			game.goRoom(words[1]);
        		} else if ( words[0].equals("bye") ) {
        			break;
        		}
        }
        
        System.out.println("��л���Ĺ��١��ټ���");
        in.close();
	}

}