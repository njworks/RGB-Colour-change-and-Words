import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by N on 07/11/2016.
 */
public class CE203_2016_Ex2 {

    public static void main (String[] args){
    window_frame();
    }

    //main method
    public static void window_frame(){
        JFrame window = new JFrame("Exercise 2-Nelvin Joseph 1503054");

        //icon of window
        ImageIcon img = new ImageIcon(CE203_2016_Ex1.class.getResource("ex2.png"));
        window.setIconImage(img.getImage());

        JPanel bottom = new JPanel();
        JTextField text = new JTextField(40);           //textfield for input
        bottom.add(text, BorderLayout.CENTER);
        window.add(bottom, BorderLayout.PAGE_END);

        //display output
        JPanel middle = new JPanel(new BorderLayout());
        JTextArea textDisplay = new JTextArea("Enter a word to start");
        middle.add(textDisplay);
        middle.add(textDisplay);
        window.add(middle, BorderLayout.CENTER);

        JPanel top = new JPanel();
        JButton add = new JButton("ADD");                   //button for adding word
        JButton display = new JButton("SEARCH CHAR");       //buttons fot searching character
        JButton search = new JButton("SEARCH WORD");        //button for word search
        JButton remove_1 = new JButton("REMOVE");           //button-removes 1st occurrence of word
        JButton remove_all = new JButton("REMOVE ALL");     //button-remove all of that word
        JButton clear = new JButton("CLEAR ALL");           //button for clear list
        top.add(add, BorderLayout.CENTER);
        top.add(display, BorderLayout.CENTER);
        top.add(search, BorderLayout.CENTER);
        top.add(remove_1, BorderLayout.CENTER);
        top.add(remove_all, BorderLayout.CENTER);
        top.add(clear, BorderLayout.CENTER);
        window.add(top, BorderLayout.PAGE_START);

        ArrayList<String> saveList = new ArrayList<String>();      //the array list for storing

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,500);
        window.setVisible(true);

        //add word button action
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (text.getText().matches("[a-zA-Z]+")) {
                    saveList.add(text.getText());
                    textDisplay.setText("Word " + text.getText() + " has been added to the list");
                }
                else{
                    textDisplay.setText("Only alphabet characters");
                }
            }
        });

        //character search button action
        display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textDisplay.setText("");
                    for (String element : saveList) {
                        if (element.startsWith(text.getText())) {
                            textDisplay.append(element + "\n");
                        }
                    }
                }
                catch (Exception i){
                    textDisplay.setText("No words start with "+ text.getText());
                }

                    }


        });

        //search for word button function
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
                   for (String word : saveList) {
                       if (word.contains(text.getText())) {
                           int occurances = Collections.frequency(saveList, word);
                           textDisplay.setText("The word " + text.getText() + " is found " +
                                   occurances + " times");
                       }
                   }
               }
               catch (Exception i){
                   textDisplay.setText("No occurrence of "+ text.getText());
               }

            }
        });

        //removes the 1st occurrence of word action
        remove_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    for (String word_1 : saveList){
                        if (word_1.contains(text.getText())){
                            saveList.remove(word_1);

                        }
                        else{
                            textDisplay.setText("The word "+ text.getText()+ " doesn't exist");
                        }
                }
                }
               catch(Exception i){
                   textDisplay.setText("The 1st occurrence of word "+ text.getText()+
                           " removed");
                }
            }
        });

        //remove all occurrences of word
        remove_all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    for (String word_2 : saveList){
                        if (word_2.contains(text.getText())){
                            saveList.removeAll(Collections.singleton(word_2));

                        }
                        else{
                            textDisplay.setText("The word "+ text.getText()+" doesn't exist");
                        }
                    }
               }
               catch(Exception i){
                    textDisplay.setText("All occurrence of word "+ text.getText()+
                            " removed");
                }
            }
        });

        //clear list
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveList.clear();
                textDisplay.setText("List cleared");

            }
        });
    }
}
