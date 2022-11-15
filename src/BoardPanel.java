import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class BoardPanel extends JPanel{
    final List<TilePanel> boardTiles = null;

    public BoardPanel(){
        super(new GridLayout(8,8));
        //this.boardTiles = new ArrayList<>();
    }
    
}
