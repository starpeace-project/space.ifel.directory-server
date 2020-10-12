package space.ifel.directoryserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import space.ifel.directoryserver.server.ServerThread;

@Slf4j
@SpringBootApplication
public class DirectoryServerApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(DirectoryServerApplication.class, args);
		ServerSocket server = new ServerSocket(9999);
		log.info("M=main, msg=Server started");
		while (true) {
			Socket client = server.accept(); //Wait for client connection, if no connection is obtained, wait at this step
			new Thread(new ServerThread(client)).start(); //Open a thread for each client connection
		}
	}

}
