package src;

/**
 * Created by Matt on 11/1/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface extends JFrame implements ActionListener
    //next create the 'pop-up' windows for the subjects by having an if statement (if button label contains numbers and z=9)
{
    JPanel main_panel = new JPanel();
    JPanel welcome = new JPanel();
    Timer timer = new Timer(4500, this);
    Database database = new Database();
    ArrayList<Series> series = database.getSeries();
    ArrayList<Subject> subjects = database.getSubjects();
    ArrayList<Formula> formulae = database.getFormulae();
    JPanel homepage = homepage();
    String series_identifier;

    public Interface()
    {
        super("Division Formula Interface");
        setSize(1700,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        add(main_panel);
        createWelcome();
        main_panel.add(welcome);
        timer.start();
    }

    private void createWelcome()
    {
        final Font big_font = new Font("Arial", Font.BOLD, 30);
        welcome.setSize(1700,900);
        welcome.setLayout(new GridLayout(3,1));
        JLabel wlcm = new JLabel("Welcome to The Company Formula Directory...");
        JLabel second = new JLabel("Your business is very important to us");
        JLabel alpha = new JLabel("(prototype)");
        alpha.setHorizontalAlignment(JLabel.CENTER);
        second.setHorizontalAlignment(JLabel.CENTER);
        wlcm.setFont(big_font);
        welcome.add(wlcm);
        welcome.add(second);
        welcome.add(alpha);
    }

    private JPanel homepage()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        JPanel top_panel = new JPanel();                            //top panel should just contain a basic message
        JTextArea text = new JTextArea("         Congratulations on making it through the selection process! Now it is time for you to select which of our tested formulas you wish to purchase! " +
                "Our Formula Directory is a helpful tool that you can use to search our wide selection of tested samples and help you narrow down the possibilities best suited to your goals. " +
                "Take some time to look through all twenty-six of our categories and marvel at the future potential, although we must advise that customers select no more than three vials as " +
                "selecting more has caused an increase chance of deviations in testing. We also recommend that customers use the Balance formula (R0000) as one of their three vials to help further " +
                "lower the chances of deviation without affecting the resultant powers, but this is not necessary. Customers that have more than one vial that is not Balance should be aware that predicting " +
                "how the powers will manifest will be much more difficult. Environment also plays a roll when imbibing our mixtures, so notify staff as to your preferences. We have included a list of the PRT classifications, " +
                "ratings, and a brief description of each for reference, and staff will be on hand at all times to answer questions on specific formulas, the mixing process, or anything you need to make your decision!");
        text.setSize(1200,150);
        text.setLineWrap(true);
        top_panel.add(text);

        JPanel bot_panel = new JPanel();                            //bot panel with series buttons
        bot_panel.setLayout(new GridLayout(5,6));
        for (int i = 0; i<seriesButtons().size(); ++i)
        {
            bot_panel.add(seriesButtons().get(i));
        }

        panel.add(top_panel);
        panel.add(bot_panel);
        return panel;
    }

    private JPanel seriesPage(String input)
    {
        Series current = findSeries(input);
        series_identifier = current.getName();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        JPanel top_panel = new JPanel();                            //top panel should just contain a basic message
        JTextArea text = new JTextArea(current.getDescription());
        text.setSize(1200,150);
        text.setLineWrap(true);
        top_panel.add(text);

        JPanel bot_panel = new JPanel();                            //bot panel with formula buttons
        bot_panel.setLayout(new GridLayout(8,2));
        ArrayList<JButton> buttons = formulaButtons(current);
        for (int i = 0; i<buttons.size(); ++i)
        {
            bot_panel.add(buttons.get(i));
        }

        panel.add(top_panel);
        panel.add(bot_panel);
        return panel;
    }

    private JPanel formulaPage(String input)
    {
        Formula current = findFormula(input);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JPanel top_panel = new JPanel();                            //top panel should contain crucial info
        top_panel.setLayout(new GridLayout(1,2));
        JPanel top_left_panel = new JPanel();
        top_left_panel.setLayout(new GridLayout(6,1));
        top_left_panel.add(new JLabel(current.getName() + " " + current.getCode()));
        top_left_panel.add(new JLabel("Reliability: " + current.getReliability()));
        top_left_panel.add(new JLabel("Originality: " + current.getOriginality()));
        top_left_panel.add(new JLabel("Power: " + current.getPower()));
        top_left_panel.add(new JLabel("Deviation: " + current.getDeviation()));
        top_left_panel.add(new JLabel("Price: " + current.getPrice()));
        top_panel.add(top_left_panel);
        JTextArea requirements = new JTextArea(current.getRequirements());
        requirements.setLineWrap(true);
        top_panel.add(requirements);


        JPanel mid_panel = new JPanel();                            //mid panel with the description
        JTextArea text = new JTextArea(current.getDescription());
        text.setSize(1200,300);
        text.setLineWrap(true);
        mid_panel.add(text);

        JPanel bot_panel = new JPanel();                            //bot panel with subject buttons
        bot_panel.setLayout(new GridLayout(8,1));
        ArrayList<JButton> buttons = subjectButtons(current);
        for (int i = 0; i<buttons.size(); ++i)
        {
            bot_panel.add(buttons.get(i));
        }

        panel.add(top_panel);
        panel.add(mid_panel);
        panel.add(bot_panel);
        return panel;
    }

    private JFrame subjectPage(String input)
    {
        Subject current = findSubject(input);
        JFrame frame = new JFrame();                                //making the JFrame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,300);
        frame.setLocation(300,400);

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(2,1));

        JPanel top = new JPanel();                                  //contains ID, Rating, and Cost
        top.setLayout(new GridLayout());

        JPanel top_left = new JPanel();
        top_left.setLayout(new GridLayout(2,1));
        top_left.add(new JLabel("  " + current.getID()));

        top.add(top_left);
        top.add(new JLabel(current.getRating()));

        JTextArea bottom = new JTextArea(current.getDescription()); //contains description
        bottom.setLineWrap(true);

        main.add(top);
        main.add(bottom);
        frame.add(main);
        return frame;
    }

    private JFrame instructionPage()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,220);
        frame.setLocation(600,400);

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(1,1));

        JTextArea mix = new JTextArea("      Once you have selected your three vials, please inform a staff member and you will be escorted to meet with one of our trained consultants who will help you finalize " +
                "payment and use our most up to date stats to help predict the general nature of the resultant power and chance of deviation. If everything is satisfactory, we can begin the final " +
                "stages of processing! Depending on exactly what package you and the consultant believe is best, this may start the training with our coaches and psychologists or today may end in our " +
                "laboratory, mixing up our purchased samples and becoming a parahuman! We know this time can be overwhelming, so inform the staff if you need anything, and they will happily oblige.");
        mix.setLineWrap(true);
        mix.setEditable(false);
        main.add(mix);

        frame.add(main);
        return frame;
    }

    private JFrame powersInfoPage()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setLocation(200,50);

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(12,1));

        JTextArea mover = new JTextArea("Mover---A power classification denoting parahumans with the ability to transport themselves or others from one place to another. " +
                "These powers can manifest as anything from teleportation to gates to flight to increased mobility. Many movers have one or more subclassifications depending " +
                "on the specifics of their individual power.");
        mover.setLineWrap(true);
        mover.setBackground(Color.GRAY);
        mover.setEditable(false);
        main.add(mover);

        JTextArea shaker = new JTextArea("Shaker---A power classification involving the manipulation of the battlefield. Most shaker powers have an area of effect; auras to aid allies, explosive " +
                "projectiles, and creation of forcefields of varying sizes would all fall under the shaker category. Shakers most commonly have subclassifications of blaster, but all are possible.");
        shaker.setLineWrap(true);
        shaker.setEditable(false);
        main.add(shaker);

        JTextArea brute = new JTextArea("Brute---A power classification based solely around increasing a parahuman's durability and often strength. Pure brutes often lack offensive range, " +
                "making up for it in a melee. Non-brutes are recommended to remain out of reach. Brute powers are most commonly seen with subclassifications of mover or changer.");
        brute.setLineWrap(true);
        brute.setBackground(Color.GRAY);
        brute.setEditable(false);
        main.add(brute);

        JTextArea breaker = new JTextArea("Breaker---The most nebulous classification; breakers are parahumans that have at least one secondary 'form' they shift to in " +
                "order to use their powers (which break the laws of physics), though not to the extreme of Changers. Pure breakers are rare, but often the most dangerous as they're the hardest to understand and predict. " +
                "Breaker appears most often as a subclassification of shakers and strangers.");
        breaker.setLineWrap(true);
        breaker.setEditable(false);
        main.add(breaker);

        JTextArea master = new JTextArea("Master---One of the most feared classifications, masters control one or more entities. Parahumans with a Master classification tend to only " +
                "express other classifications through their minions (ex. exploding rodents could cause a shaker rating). The one exception is a master/stranger classification often seen in infiltration capes. " +
                "Masters are often priority targets in combat.");
        master.setLineWrap(true);
        master.setBackground(Color.GRAY);
        master.setEditable(false);
        main.add(master);

        JTextArea tinker = new JTextArea("Tinker---A power classification that describes those parahumans with the ability to fabricate technology far ahead of their time. All tinkers have a specialty " +
                "and all the technology they build will fall within it. Pure tinkers are the norm, with subclassifications based around whatever technology they create. Given time, tinkers are " +
                "the most versatile group of parahumans.");
        tinker.setLineWrap(true);
        tinker.setEditable(false);
        main.add(tinker);

        JTextArea blaster = new JTextArea("Blaster---A power classification used to signify a ranged, offensive ability. Although most commonly destructive, many blaster-class powers apply " +
                "various non-lethal effects (time slows, memory loss, etc.). Many blasters also earn a shaker rating for their destructive capabilities.");
        blaster.setLineWrap(true);
        blaster.setBackground(Color.GRAY);
        blaster.setEditable(false);
        main.add(blaster);

        JTextArea thinker = new JTextArea("Thinker---A power classification that encompasses enhanced knowledge, skills, and perception. Precognitives of various types are common in this " +
                "classification. Unlike the other classifications, many thinker powers do not have strong applications in combat situations. Pure thinkers are common, though all " +
                "subclassifications have been observed.");
        thinker.setLineWrap(true);
        thinker.setEditable(false);
        main.add(thinker);

        JTextArea striker = new JTextArea("Striker---A power classification used to flag parahumans that are dangerous at close range. Striker powers have a very limited range, many requiring touch. " +
                "Besides range, striker powers can be most anything, from empowering weapons or other objects to changing properties of a target or even materializing an object from nowhere.");
        striker.setLineWrap(true);
        striker.setBackground(Color.GRAY);
        striker.setEditable(false);
        main.add(striker);

        JTextArea changer = new JTextArea("Changer---An umbrella power classifciation that covers all parahumans with the ability to significantly modify their body. This is one of the rarest classifications, " +
                "along with the trump classification. Changer ratings are always accompanied by at least one more classification to describe the abilities the other form(s) may provide, making pure changers impossible.");
        changer.setLineWrap(true);
        changer.setEditable(false);
        main.add(changer);

        JTextArea trump = new JTextArea("Trump---The rarest (>4%) classification, many people would argue that trump-class parahumans (depending on the exact nature of their power) are among the most valuable. " +
                "Trump powers include powers that effect the powers of other parahumans or powers that change themselves in a variety of ways. Some can even temporarily grant powers to oneself or others (even non-powered humans). " +
                "Trump parahumans are the only threat for which unpowered assets should be the go-to for containment or elimination instead of parahumans.");
        trump.setLineWrap(true);
        trump.setBackground(Color.GRAY);
        trump.setEditable(false);
        main.add(trump);

        JTextArea stranger = new JTextArea("Stranger---A power classification designed for espionage; all stranger powers deal in stealth, infiltration, or subterfuge. This classification, unsurprisingly has " +
                "the largest percentage of powers whose uses are subtle enough to be used in civilian garb. They can involve changing oneself (invisibility, imitation) or others (hallucinations, altered perceptions). A subset of " +
                "stranger capes gain a vast enhancement to their abilities only when unobserved.");
        stranger.setLineWrap(true);
        stranger.setEditable(false);
        main.add(stranger);

        frame.add(main);
        return frame;
    }

    private JFrame ratingInfoPage()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800,670);
        frame.setLocation(200,50);

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(10,1));

        JTextArea one = new JTextArea("Level 1--Represents the lowest possible threat of a parahuman. An unexceptional individual may be able to cope with the ability " +
                "or walk away unharmed from an altercation in which the abilities in question are leveraged. The ability should be assumed a non-threat and need not be " +
                "identified if other matters prove more pressing.");
        one.setLineWrap(true);
        one.setBackground(Color.GRAY);
        one.setEditable(false);
        main.add(one);

        JTextArea two = new JTextArea("Level 2--An alert, exceptional, or trained individual should be able to address the ability in question, but it could prove " +
                "problematic. Team members should put standard countermeasures into effect when there are no other pressing matters. The exact countermeasures vary " +
                "depending on the classification of the parahuman's abilities.");
        two.setLineWrap(true);
        two.setEditable(false);
        main.add(two);

        JTextArea three = new JTextArea("Level 3--Civilians will not be able to handle the ability in question and several trained individuals may be required to deal " +
                "with the situation. Care should be taken to remove civilians from the area if possible and they should be discouraged from participating. Standard " +
                "countermeasures should be put into effect, even if the relevant powers are not the chief concern.");
        three.setLineWrap(true);
        three.setBackground(Color.GRAY);
        three.setEditable(false);
        main.add(three);

        JTextArea four = new JTextArea("Level 4--One full squad of operatives should be able to deal with the situation alone, but exceptional circumstance, context, " +
                "and environment may significantly bias things one way or the other. Assistance from a typical parahuman is enough to ensure a victory.");
        four.setLineWrap(true);
        four.setEditable(false);
        main.add(four);

        JTextArea five = new JTextArea("Level 5--A typical parahuman or one parahuman assisted by a squad of operatives should be able to deal with the power in question. " +
                "Operatives can and should engage until assistance arrives. Additional countermeasures based on classification also come into effect.");
        five.setLineWrap(true);
        five.setBackground(Color.GRAY);
        five.setEditable(false);
        main.add(five);

        JTextArea six = new JTextArea("Level 6--A typical parahuman or one parahuman assisted by a squad of operatives should be able to deal with the power in question. " +
                "Operatives should postpone engagement until assistance arrives if possible. Parahumans and operatives should assume traditional actions are going to be met " +
                "with at least minor complications. Acquiring further intel where possible is recommended, but not mandated.");
        six.setLineWrap(true);
        six.setEditable(false);
        main.add(six);

        JTextArea seven = new JTextArea("Level 7--Parahumans should engage in pairs or trios at a minimum and two fully equipped squads should be deployed. Acquiring further " +
                "intel is mandated, all acting parties should shift to the defensive or delay until intel can be acquired. Expect minor complications in all situations " +
                "and mild complications if engaged without intel.");
        seven.setLineWrap(true);
        seven.setBackground(Color.GRAY);
        seven.setEditable(false);
        main.add(seven);

        JTextArea eight = new JTextArea("Level 8--Evacuation should take priority for all squad members. Engaging should be avoided outside of specific missions and tasks. " +
                "Parahumans should engage only when supported by their teams to keep complications to a minimum. Failure to follow listed procedure is likely to put " +
                "civilians, parahumans and operatives in serious danger.");
        eight.setLineWrap(true);
        eight.setEditable(false);
        main.add(eight);

        JTextArea nine = new JTextArea("Level 9--Assume extreme complications, with standard tactics not applying, or the power in question having an additional factor " +
                "that exaggerates its effect. Parahumans and PRT should evacuate where possible, and should only engage when a specific mission and strategy has been " +
                "outlined. Major countermeasures should take effect.");
        nine.setLineWrap(true);
        nine.setBackground(Color.GRAY);
        nine.setEditable(false);
        main.add(nine);

        JTextArea ten = new JTextArea("Level 10,11,12--In the event of a serious confrontation, additional teams or specific high-rated individuals should be called " +
                "in to manage the crisis. Evacuation and intel are a priority.");
        ten.setLineWrap(true);
        ten.setEditable(false);
        main.add(ten);

        frame.add(main);
        return frame;
    }

    private JFrame seriesGuidePage()
    {
        JFrame frame = new JFrame();                                //making the JFrame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300,800);
        frame.setLocation(200,50);

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(27,1));
        JLabel title = new JLabel("One word descriptions of each series...");
        JLabel a = new JLabel("A: Style");
        JLabel b = new JLabel("B: Mentality");
        JLabel c = new JLabel("C: Breaker");
        JLabel d = new JLabel("D: Creator");
        JLabel e = new JLabel("E: Fantasia");
        JLabel f = new JLabel("F: Macabre");
        JLabel g = new JLabel("G: Trope");
        JLabel h = new JLabel("H: Mover");
        JLabel i = new JLabel("I: Brawler");
        JLabel j = new JLabel("J: Elemental");
        JLabel k = new JLabel("K: Technology");
        JLabel l = new JLabel("L: Computation");
        JLabel m = new JLabel("M: Biology");
        JLabel n = new JLabel("N: Talisman");
        JLabel o = new JLabel("O: 99999999");
        JLabel p = new JLabel("P: Permanence");
        JLabel q = new JLabel("Q: Spy");
        JLabel r = new JLabel("R: Recreation");
        JLabel s = new JLabel("S: Support");
        JLabel t = new JLabel("T: Change");
        JLabel u = new JLabel("U: Psychic");
        JLabel v = new JLabel("V: Killer");
        JLabel w = new JLabel("W: Exotic");
        JLabel x = new JLabel("X: Morph");
        JLabel y = new JLabel("Y: Gamble");
        JLabel z = new JLabel("Z: Powers");
        main.add(title);
        main.add(a);
        main.add(b);
        main.add(c);
        main.add(d);
        main.add(e);
        main.add(f);
        main.add(g);
        main.add(h);
        main.add(i);
        main.add(j);
        main.add(k);
        main.add(l);
        main.add(m);
        main.add(n);
        main.add(o);
        main.add(p);
        main.add(q);
        main.add(r);
        main.add(s);
        main.add(t);
        main.add(u);
        main.add(v);
        main.add(w);
        main.add(x);
        main.add(y);
        main.add(z);

        frame.add(main);
        return frame;
    }

    private ArrayList<JButton> seriesButtons()
    {
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        JButton instructionPage = new JButton("Instructions");
        JButton infoPage = new JButton("Classifications");
        JButton ratingInfoPage = new JButton("PRT Ratings");
        JButton guidePage = new JButton("Directory Guide");
        buttons.add(instructionPage);
        buttons.add(infoPage);
        buttons.add(ratingInfoPage);
        buttons.add(guidePage);
        instructionPage.addActionListener(this);
        infoPage.addActionListener(this);
        ratingInfoPage.addActionListener(this);
        guidePage.addActionListener(this);
        for (int i = 0; i < database.getSeries().size(); ++i)
        {
            JButton button = new JButton(database.getSeries().get(i).getName() + " Series");
            button.addActionListener(this);
            buttons.add(button);
        }
        return buttons;
    }

    private ArrayList<JButton> formulaButtons(Series series)
    {
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for (int i = 0; i < formulae.size(); ++i)
        {
            if (formulae.get(i).getCode().contains(series.getName()))
            {
                JButton button = new JButton(formulae.get(i).getName());
                button.addActionListener(this);
                buttons.add(button);
            }
        }
        JButton back_to_homepage = new JButton("Back");
        back_to_homepage.setActionCommand("ToHomepage");
        back_to_homepage.addActionListener(this);
        buttons.add(back_to_homepage);
        return buttons;
    }

    private ArrayList<JButton> subjectButtons(Formula formula)
    {
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for (int i = 0; i < subjects.size(); ++i)
        {
            if (subjects.get(i).getID().contains(formula.getCode()))
            {
                JButton button = new JButton(subjects.get(i).getID());
                button.addActionListener(this);
                buttons.add(button);
            }
        }
        JButton back_to_homepage = new JButton("Back");
        back_to_homepage.setActionCommand("formula");
        back_to_homepage.addActionListener(this);
        buttons.add(back_to_homepage);
        return buttons;
    }

    private Series findSeries(String this_one)
    {
        for (int i=0; i<series.size(); ++i)
        {
            if (series.get(i).getName().equals((this_one)))
            {
                return series.get(i);
            }
        }
        return series.get(series.size());
    }

    private Formula findFormula(String this_one)
    {
        for (int i=0; i<formulae.size(); ++i)
        {
            if (formulae.get(i).getName().equals((this_one)))
            {
                return formulae.get(i);
            }
        }
        return formulae.get(formulae.size());
    }

    private Subject findSubject(String this_one)
    {
        for (int i=0; i<subjects.size(); ++i)
        {
            if (subjects.get(i).getID().equals((this_one)))
            {
                return subjects.get(i);
            }
        }
        return subjects.get(subjects.size());
    }

    private boolean containsNumbers(String input)
    {
        boolean answer = false;
        if (input.contains("0") || input.contains("1") || input.contains("2") || input.contains("3") || input.contains("4") || input.contains("5") ||
                input.contains("6") || input.contains("7") || input.contains("8") || input.contains("9"))
        {
            answer = true;
        }
        return answer;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int z = 9;
        String input = e.getActionCommand();
        if (input == "ToHomepage")
        {
            main_panel.removeAll();
            main_panel.add(homepage);
            z=0;
            validate();
            repaint();
        }
        if (input == "Directory Guide")
        {
            JFrame frame = seriesGuidePage();
            z=0;
        }
        if (input == "Classifications")
        {
            JFrame frame = powersInfoPage();
            z=0;
        }
        if (input == "PRT Ratings")
        {
            JFrame frame = ratingInfoPage();
            z=0;
        }
        if  (input == "Instructions")
        {
            JFrame frame = instructionPage();
            z=0;
        }
        if (input == "formula")
        {
            main_panel.removeAll();
            main_panel.add(seriesPage(series_identifier));
            z=0;
            validate();
            repaint();
        }
        if (e.getSource() == timer)
        {
            main_panel.remove(welcome);
            main_panel.add(homepage);
            validate();
            repaint();
            timer.stop();
            z=0;
        }
        else
        {
            if (input.length() == 8 && input.contains("Series"))
            {
                char character = input.charAt(0);
                String newinput = character + "";
                main_panel.remove(homepage);
                main_panel.add(seriesPage(newinput));
                z=0;
                validate();
                repaint();
            }
        }
        if (z==9)
        {
            if (containsNumbers(input) == false)
            {
                main_panel.removeAll();
                main_panel.add(formulaPage(input));
                validate();
                repaint();
            }
            else
            {
                JFrame subject = subjectPage(input);
            }
        }
    }

    public static void main(String[] args)
    {
        Interface interface1 = new Interface();
    }
}
