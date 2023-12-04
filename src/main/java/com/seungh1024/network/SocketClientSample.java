package com.seungh1024.network;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class SocketClientSample {
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        sample.sendSocketSample();
    }

    public void sendSocketSample() {
        for (int i = 0; i < 3; i++) {
//            sendSocketData("I liked java at " + new Date());
            sendAndReceiveSocketData("I liked java at " + new Date());
        }
//        sendSocketData("EXIT");
        sendAndReceiveSocketData("EXIT");
    }

    public void sendSocketData(String data) {
        Socket socket = null;
        try {
            System.out.println("Client: Connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client: Connect status = " + socket.isConnected());
            Thread.sleep(1000);
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("Client: Sent data = " + data);

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendAndReceiveSocketData(String data) {
        Socket socket = null;
        try {
            System.out.println("Client: Connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client: Connect status = " + socket.isConnected());
            Thread.sleep(2000);
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);
            data +="\n";
            byte[] bytes = data.getBytes();
            out.write(bytes);
            out.flush();
            out.write("stop\n".getBytes());
            out.flush();



            System.out.println("Client: Sent data = " + data);

            System.out.println(socket.isConnected());


            System.out.println("Client: receive from Server");
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream in = new BufferedInputStream(inputStream);
            byte[] readByte = new byte[256];
            in.read(readByte);


            System.out.println("Receive Response = " + new String(readByte).trim());
            stream.close();
            in.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
