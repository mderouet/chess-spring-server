package db;

import application.ChessServerApplication;
import application.model.Board;
import application.service.BoardService;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ChessServerApplication.class)
class MongoDbIntegrationTest {

    @Value("${spring.data.mongodb.database}")
    private String chessDbName;
    @Autowired
    private BoardService boardService;

    private MongoClient mongoClient = new MongoClient();

    @BeforeEach
    void cleanDatabase() {
        MongoDatabase db = mongoClient.getDatabase(chessDbName);
        db.drop();
    }

    @Test
    void create() {
        Board board1 = Board.builder()
                .blackPlayerName("promethee")
                .whitePlayerName("epimethee")
                .id("1")
                .build();

        boardService.createBoard(List.of(board1));
        Assertions.assertEquals(board1, mongoClient.getDatabase(chessDbName)
                .getCollection("board")
                .find()
                .map(this::fromDocument)
                .first());
    }

    private Board fromDocument(Document document) {
        return Board.builder()
                .id(document.getString("_id"))
                .blackPlayerName(document.getString("blackPlayerName"))
                .whitePlayerName(document.getString("whitePlayerName"))
                .build();
    }
}