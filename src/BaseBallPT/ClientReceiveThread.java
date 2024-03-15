package BaseBallPT;
// awt -> GUI 컴포넌트를 이용하는 자바 라이브러리

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientReceiveThread extends JFrame implements ActionListener, Runnable{

	private Socket m_Socket;

	Panel p;
	JTextField jt;
	JButton jb;


	public ClientReceiveThread(){

		Container c = getContentPane();

		c.setLayout(new BorderLayout());       

		p = new Panel();
		jt = new JTextField(15); 

		p.add(jt);
		jb = new JButton("입력"); 

		jb.addActionListener(this); 

		jb.setFont(new Font("맑음고딕",Font.BOLD,18));

		p.add(jb);

		c.add(p);

		setSize(400,400);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	}


	public void run() {

		try { 


			BufferedReader tmpbuf = new BufferedReader(
					new InputStreamReader(m_Socket.getInputStream())); 


			String receiveString;

			while(true) 
			{

				receiveString = tmpbuf.readLine();

				System.out.println(receiveString);

				if(receiveString == null)
				{ 
					System.out.println("종료합니다");
					break;  //탈출
				} 
				else
				{   
					System.out.println(receiveString);
					p.setData(receiveString.charAt(0)-'0', receiveString.charAt(1)-'0', 
							receiveString.charAt(2)-'0');

					p.repaint();
				} 
			}  
		}catch(IOException e) 
		{  
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void setSocket(Socket _socket)
	{ 

		m_Socket = _socket; 
	}


	public void actionPerformed(ActionEvent e) {
		PrintWriter sendWriter = null;
		try {

			sendWriter = new PrintWriter(m_Socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sendWriter.println(jt.getText());
		sendWriter.flush();
	}

}
