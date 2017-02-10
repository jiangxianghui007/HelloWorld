package com.wincor.test;  
  
import java.io.BufferedReader;  
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class MyServer {  
    public static void main(String[] args) throws IOException {  
    	ServerSocket serverSocket =new ServerSocket(10086);//1024-65535的某个端口
    	//2、调用accept()方法开始监听，等待客户端的连接
    	boolean temp = true;
    	while(temp){
    		Socket socket = serverSocket.accept();
        	//3、获取输入流，并读取客户端信息
        	InputStream is = socket.getInputStream();
        	InputStreamReader isr =new InputStreamReader(is);
        	BufferedReader br =new BufferedReader(isr);
        	String info =null;
        	while((info=br.readLine())!=null){
        	System.out.println("Hello,我是服务器，客户端说："+info);
        	}
        	socket.shutdownInput();//关闭输入流
        	//4、获取输出流，响应客户端的请求
        	System.out.println("呵呵呵呵");
        	OutputStream os = socket.getOutputStream();
        	PrintWriter pw = new PrintWriter(os);
        	pw.write("我是世界上最帅的人");
        	pw.flush();
        	
        	pw.close();
        	os.close();
        	br.close();
        	isr.close();
        	is.close();
        	socket.close();
        	System.out.println("ttt");
    	}
    	
    	  
    	 
    	//5、关闭资源
    	
    	serverSocket.close();
    }  
} 