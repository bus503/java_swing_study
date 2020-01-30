package java_swing_study.chap15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {
//서버 구동시키고 클라이언트를 수행해야한다
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		try {
			listener = new ServerSocket(9999);
			System.out.println("요술램프를 닦기 시작합니다.....");
			socket = listener.accept();
			System.out.println("지니가 나왔습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage = in. readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("알라딘이 bye로 연결을 종료하였습니다.");
					break;
				}
				System.out.println("지니" + inputMessage);
				System.out.print("자니 >>");
				String outputMessage = sc.nextLine();
				out.write(outputMessage + "\n");
				out.flush();
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				sc.close();
				socket.close();
				listener.close();
			}catch (IOException e) {
				System.out.println("알라딘과의 대화 중 오류가 발생하였습니다.");
			}
		}
	}

}
