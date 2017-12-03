import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**

/**
 * Created by N on 06/11/2016.
 */
public class CE203_2016_Ex1 {

    public static void main (String[] args){
        window_border();
    }
    //each variable text fields
    static JTextField textfield1 = new JTextField(10);
    static JTextField textfield2 = new JTextField(10);
    static JTextField textfield3 = new JTextField(10);
    static JPanel middlePanel = new JPanel(new BorderLayout());
    static JLabel text;                                          //the text label in center
    static JButton submit = new JButton("Submit");               //submit button
    static Color newColor;                                       //the new color

    //each variable for rgb
    static int red;
    static int green;
    static int blue;

    //method for submit button
    public static void submitPerform() {
        try {
            String text1 = textfield1.getText();
           red = Integer.parseInt(text1);

            String text2 = textfield2.getText();
            green= Integer.parseInt(text2);

            String text3 = textfield3.getText();
            blue = Integer.parseInt(text3);


            newColor = new Color(red, green, blue);
            text.setForeground(newColor);
        }
        catch(Exception e){
            if(textfield1.getText().equals("") || textfield2.getText().equals("")  ||
                    textfield3.getText().equals("") ){
                text.setText("Enter integer for every field");
            }
            else if (red >255 || green > 255 || blue > 255) {
                text.setText("Only integers between 0 and 255");
                if (red>255){
                    red = 255;
                    textfield1.setText("255");
                }
                if (green>255){
                    textfield2.setText("255");
                    green = 255;
                }
                if (blue>255){
                    textfield3.setText("255");
                    blue = 255;
                }

            }
            else if (red < 0 || green < 0 || blue < 0) {
                text.setText("Only integers between 0 and 255");
                if (red<0){
                    red = 200;
                    textfield1.setText("200");

                }
                if (green<0){
                    green = 200;
                    textfield2.setText("200");

                }
                if (blue<0){
                    blue = 200;
                    textfield3.setText("200");

                }
            }
            else {
                textfield1.setText("");
                textfield2.setText("");
                textfield3.setText("");
                text.setText("Only integers between 0 and 255");
            }
        }

    }

    //method for reset button function
    public static void resetPerform(){
        text.setText("CE203 Assignment 1, submitted by: Nelvin");
        text.setForeground(Color.red);
    }


    //the window method
    public static void window_border(){
        JFrame window = new JFrame("Exercise 1-Nelvin");

        //icon of window
        ImageIcon img = new ImageIcon(CE203_2016_Ex1.class.getResource("ex1.png"));
        window.setIconImage(img.getImage());

        //main text output
        text = new JLabel("CE203 Assignment 1, submitted by: Nelvin");
        text.setForeground(Color.red);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);
        middlePanel.add(text);
        window.add(middlePanel, BorderLayout.CENTER);

        //text fields
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(textfield1, BorderLayout.CENTER);
        bottomPanel.add(textfield2, BorderLayout.CENTER);
        bottomPanel.add(textfield3, BorderLayout.CENTER);
        window.add(bottomPanel, BorderLayout.PAGE_END);
        bottomPanel.add(submit, BorderLayout.CENTER);

        //Reset button
        JButton reset = new JButton("Reset");
        JPanel topPanel = new JPanel();
        topPanel.add(reset, BorderLayout.PAGE_START);
        window.add(topPanel, BorderLayout.NORTH);

        //Window values
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,500);
        window.setVisible(true);

        //submit button action
        submit.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                submitPerform();


            }
        } );
        // reset button action
        reset.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent i){
                resetPerform();

            }
        } );
    }


}

