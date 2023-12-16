import javax.swing.JFrame;
import javax.swing.JPanel;
import Actions.LoadData;
import GUI_elements.*;
import java.awt.Dimension;

import java.awt.GridLayout;

public class Gui extends JFrame{
    Dimension screenDimension = new Dimension(900, 500);
    Dimension leftDimension = new Dimension(300,700);
    Dimension rightDimension = new Dimension(400,700);

    JPanel rightPanel,leftPanel;
    public Gui(){
        setLayout(new GridLayout(1,2));

        leftPanel = new leftPanel(leftDimension);
        add(leftPanel);


        rightPanel = new rightPanel(rightDimension);
        add(rightPanel);

    

        
        setSize(screenDimension);
        setVisible(true);
        setTitle("task application");

        LoadData.loadTask();
        
    }

}
