package com.seungh1024.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerSample {
    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
//        sample.startServer();
        sample.startReplyServer();
    }

    public void startServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while (true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept();
                System.out.println("Server: accepted");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data = null;
                StringBuilder receivedData = new StringBuilder();
                while ((data = in.readLine()) != null) {
                    receivedData.append(data);
                }
                System.out.println("Received data: " + receivedData);

                in.close();
                stream.close();
                client.close();

                if (receivedData != null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("--------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void startReplyServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while (true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept();
                System.out.println("Server: accepted");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));


                String data = null;
                StringBuilder receivedData = new StringBuilder();
                System.out.println("before while");

                while (true) {
                    data = in.readLine();
                    System.out.println(data);
                    if(data.equals("stop")) break;
                    receivedData.append(data);
                }
                System.out.println("Received data: " + receivedData);


                System.out.println("Send Response");
                OutputStream outputStream = client.getOutputStream();
                BufferedOutputStream out = new BufferedOutputStream(outputStream);
                data = "OK";
                byte[] buffer = data.getBytes();
                System.out.println(client.isConnected());
                out.write(buffer);
                out.flush();
                System.out.println("send Response Success");

                Thread.sleep(1000);
                out.close();
                outputStream.close();
                in.close();
                stream.close();
                client.close();

                if (receivedData != null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("--------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
