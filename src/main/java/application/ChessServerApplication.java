package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import application.model.Queen;
import application.model.Rook;

@SpringBootApplication
public class ChessServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessServerApplication.class, args);
	}
}
