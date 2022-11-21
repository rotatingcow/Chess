


import javax.swing.*;



import java.awt.*;

public class AlphaBetaChess {

    public static void main(String[] args) {
        JFrame gameFrame = new JFrame("Chess");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gameFrame.setSize(800,800);
        gameFrame.setLayout(new BorderLayout());

        
       //GUI ui = new GUI();
       //gameFrame.add(ui);
       
        Board backBoard = new Board();

        BoardPanel frontBoard;


        backBoard.resetBoard(true);

            //m_board.changeBoard("n2rnrk1/ppb1p1pp/2p2p2/8/5P2/5QPq/PP1PPK1P/NB1R2BR w - - 1 10",false);

        frontBoard = new BoardPanel(backBoard.getBoard());
            /*
            for(int i = 0; i < frontBoard.boardTiles.size(); i++ ){
                TilePanel element = frontBoard.boardTiles.get(i);
                System.out.println(element.getInfo());
            }
             */
        System.out.println(frontBoard.boardTiles.get(32).getClass());
        
        System.out.println(frontBoard.getSize());
        
        
        //frontBoard.setVisible(true);
        //gameFrame.pack();
        gameFrame.add(frontBoard, BorderLayout.CENTER);
      
        gameFrame.setVisible(true);

        System.out.println(gameFrame.getSize());
        System.out.println(gameFrame.getComponentCount());
        

    }
}
