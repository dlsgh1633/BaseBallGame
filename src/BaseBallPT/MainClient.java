package BaseBallPT;
import java.io.IOException;
import java.net.Socket;

public class MainClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{

			Socket c_socket = new Socket("192.168.0.6", 8081);

			ClientReceiveThread rec_thread = new ClientReceiveThread();
			rec_thread.setSocket(c_socket);

			Thread t = new Thread(rec_thread);

			t.start();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}