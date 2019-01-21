import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {

	  private Socket socket = null;
	  
	  public static void main(String[] args) throws UnknownHostException, 
	  IOException, ClassNotFoundException {
		  
		  Client client = new Client();
		  
		  String ip = "localhost";
		  int port = 3001;
		  client.socketConnect(ip,port);
		  
		  String msg = JOptionPane.showInputDialog("Escreva a mensagem");
		  System.out.println("Enviando :" +msg);
		  String retorno = client.echo(msg);
		  System.out.println("Recebendo :"+retorno);
	}

	private void socketConnect(String ip, int port) throws UnknownHostException, IOException{
		
		System.out.println("Conectando socket ...");
		this.socket = new Socket(ip,port);
	}
	public String echo(String msg){
		String retorno = "";
		try {
	    	
		      // out & in 
		      PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
		      BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
		 
		      // escreve string no socket e lê linha
		      out.println(msg);
		      retorno = in.readLine();
		      return retorno;
		                
		      } catch (IOException e) {
		      e.printStackTrace();
		    }
		               
		    return retorno;
		  }
	
	  private Socket getSocket() {
          return socket;
}
}
