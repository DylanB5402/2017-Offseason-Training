package src;

/**
 * Created by Matt on 11/1/16.
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class Formula
{
    String name, code;
    int reliability, originality, power, deviation, price;
    String requirements;
    String description;
    ArrayList<Subject> subjects;

    public Formula(String NAME, String CODE, int RE, int OR, int POWER, int DEV, int PRICE, String DES,
                   String REQ, ArrayList<Subject> examples)
    {
        name = NAME;
        code = CODE;
        reliability = RE;
        originality = OR;
        power = POWER;
        deviation = DEV;
        price = PRICE;
        requirements = "NULL";
        description = DES;
        subjects = examples;
    }

    public Formula(String NAME, String CODE, int RE, int OR, int POWER, int DEV, int PRICE, String DES, ArrayList<Subject> examples)
    {
        name = NAME;
        code = CODE;
        reliability = RE;
        originality = OR;
        power = POWER;
        deviation = DEV;
        price = PRICE;
        requirements = "NULL";
        description = DES;
        subjects = examples;
    }

    public String getName() {return name;}

    public String getCode() {return code;}

    public int getReliability() {return reliability;}

    public int getOriginality() {return originality;}

    public int getPower() {return power;}

    public int getDeviation() {return deviation;}

    public int getPrice() {return price;}

    public String getDescription() {return description;}

    public String getRequirements() {return requirements;}

    public JPanel formulaPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JPanel top_panel = new JPanel();                            //top panel with info and requirements
        top_panel.setLayout(new GridLayout(1,2));
        JPanel info = new JPanel();
        info.setLayout(new GridLayout(6,1));
        info.add(new JLabel(name + "-" + code));
        info.add(new JLabel("Reliability: " + reliability));
        info.add(new JLabel("Originality: " + originality));
        info.add(new JLabel("Power: " + power));
        info.add(new JLabel("Deviation: " + deviation));
        info.add(new JLabel("Price: " + price));
        top_panel.add(info);
        JTextArea area = new JTextArea(requirements);
        area.setLineWrap(true);
        top_panel.add(area);

        JPanel mid_panel = new JPanel();                            //mid panel with the description(s)
        JTextArea text = new JTextArea(description);
        text.setLineWrap(true);
        mid_panel.add(text);

        JPanel bot_panel = new JPanel();                            //bot panel with the example subjects

        panel.add(top_panel);
        panel.add(mid_panel);
        panel.add(bot_panel);
        return panel;
    }

    //finish the bottom panel buttons to lead to the subjects
}
