package GUI_elements;
import java.awt.Dimension;

import javax.swing.*;

public class rightPanel extends JPanel{
    JTable table;
    public rightPanel(Dimension dimension){

        table = myTable.getTable();
        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setPreferredSize(dimension);

        add(scrollPaneTable);


        setSize(dimension);
    }
}
