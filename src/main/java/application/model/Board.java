package application.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Data
@Document(collection = "board")
@Builder
public class Board {

    @Id
    private final String id;
    @NotEmpty
    private final String whitePlayerName;
    @NotEmpty
    private final String blackPlayerName;

    private boolean whiteTurnToPlay;
    private Map<String, Piece> chessBoard;

    public String getPlayerNameByColor(Color color) {
        if (color.equals(Color.WHITE)) {
            return whitePlayerName;
        }
        return blackPlayerName;
    }
}
