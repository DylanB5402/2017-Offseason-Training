package src;

/**
 * Created by Matt on 11/1/16.
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Series
{
    String name;
    String description;
    ArrayList<Formula> formulas;

    public Series (String newname, String DES, ArrayList<Formula> FORMULI)
    {
        name = newname;
        description = DES;
        formulas = FORMULI;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public JPanel seriesPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        JPanel top_panel = new JPanel();                            //top panel containing description
        JTextArea text = new JTextArea(description);
        text.setLineWrap(true);
        top_panel.add(text);

        JPanel bot_panel = new JPanel();                            //bot panel containing formula buttons

        panel.add(top_panel);
        panel.add(bot_panel);
        return panel;
    }

    //finish the buttons to lead to the formulae
}
