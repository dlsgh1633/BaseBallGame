package BaseBallPT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerReceiveThread extends Thread{ // 부모 Thread 상속 받았다.
	// Socket 멤버 변수 선언
	private Socket m_Socket;

	private int[] com;

	private UserCheck u;
	
	public void run() {
		super.run();
		try { 

			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));

			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			String receiveString;
			while(true) 
			{
				receiveString = tmpbuf.readLine(); 

				System.out.println(receiveString);


				if(receiveString == null)
				{ 
					System.out.println("종료합니다.");
					break;
				}

				else 
				{
					System.out.println(receiveString);// 출력
					int num1=receiveString.charAt(0)-'0';
					int num2=receiveString.charAt(1)-'0';
					int num3=receiveString.charAt(2)-'0';
					int[] user = {num1, num2, num3};
					u.check(user, com);

					sendWriter.println(u.getValue());
					sendWriter.flush();
					
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
	public void setBaseballNumber(int[] _com)
	{
		this.com = _com;
	}

	public void setUserCheck(UserCheck _u)	
	{
		this.u = _u;
	}
}
