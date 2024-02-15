package main.ui;

import main.utils.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.border.EmptyBorder;

public abstract class AFLessonPanel extends JPanel {

    private JPanel taskNamePanel;
    private JPanel translationTextPanel;
    private JPanel translatedTextPanel;
    private JPanel enteredWordsPanel;
    private JPanel choiceWordsPanel;
    private JPanel resultTextPanel;

    private JTextPane ruleText;
    private JLabel taskName; //example: Complete Translation
    private JLabel translationText; //example: Sofia, is this food spicy?
    private JLabel translatedText; //example: София, эта еда острая?

    //example: [spicy] [he] [this] [apple] [food] [beautiful] [Sofia] [is] [pasta]
    private AFCustomButton[] choiceWordsButtons;
    private JLabel resultText; //example: Correct/Incorrect
    private JTextField hiddenTextField;


    public AFLessonPanel() {
        setLayout(new GridLayout(0, 1));
    }

    protected JTextPane getRuleText() {
        if (ruleText == null) {
            ruleText = new JTextPane();
            ruleText.setContentType("text/html");
            add(ruleText);
        }
        return ruleText;
    }

    protected void getTaskName(String text) {
        if (taskName == null) {
            taskName = new JLabel(text);
            taskName.setFont(Fonts.COURIERNEW_BOLD_32);

            if (taskNamePanel == null) {
                taskNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                taskNamePanel.add(taskName);
                add(taskNamePanel);
            }
        }
    }

    protected void getTranslationText(String text) {
        if (translationText == null) {
            translationText = new JLabel(text);
            translationText.setFont(Fonts.COURIERNEW_PLAIN_32);

            if (translatedTextPanel == null) {
                translatedTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                translatedTextPanel.add(translationText);
                add(translatedTextPanel);
            }
        }
    }

    //Creation of interactive buttons to make a proposal
    public void getChoiceWords(String[] words) {
        if (choiceWordsButtons == null) {
            //create an empty array of buttons from the number of incoming words
            choiceWordsButtons = new AFCustomButton[words.length];

            //create a panel for user-entered words, if not already created
            if (enteredWordsPanel == null) {
                enteredWordsPanel = new JPanel();
                add(enteredWordsPanel);
            }

            //create a panel for all the words that the user can choose to compose a sentence
            if (choiceWordsPanel == null) {
                choiceWordsPanel = new JPanel();
                add(choiceWordsPanel);
            }

            //creating buttons corresponding to incoming words
            for (int i = 0; i < choiceWordsButtons.length; ++i) {
                choiceWordsButtons[i] = new AFCustomButton(words[i]);
                AFCustomButton button = choiceWordsButtons[i];
                choiceWordsPanel.add(button);

                button.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JPanel parentPanel = (JPanel) button.getParent();
                        //here, when the user clicks on the button, it is checked which panel the button is on
                        //if the button is on the already entered words panel, it is placed on the selection panel
                        //and vice versa, if it is on the selection panel, it is placed on the typed words panel.
                        if (parentPanel == choiceWordsPanel) {
                            choiceWordsPanel.remove(button);
                            enteredWordsPanel.add(button);
                        } else if (parentPanel == enteredWordsPanel) {
                            enteredWordsPanel.remove(button);
                            choiceWordsPanel.add(button);
                        }

                        //GUI update and re-rendering
                        revalidate();
                        repaint();
                    }
                });
            }
        }
    }

    protected String[] getEnteredWords() {
        Component[] components = enteredWordsPanel.getComponents();
        String[] buttonTexts = new String[components.length];

        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JButton button) {
                buttonTexts[i] = button.getText();
            }
        }

        return buttonTexts;
    }

    protected JLabel getResultText() {
        if (resultText == null) {
            resultText = new JLabel();
            resultText.setFont(Fonts.COURIERNEW_BOLD_32);
            resultText.setBorder(new EmptyBorder(10, 50, 10, 50));

            if (resultTextPanel == null) {
                resultTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                resultTextPanel.add(resultText);
                add(resultTextPanel);
            }
        }

        return resultText;
    }

    //creating text, with a TextField instead of a missing word
    protected void getTextWithEmptyField(ArrayList<String> parts) {
        translatedTextPanel = new JPanel();

        for (String part : parts) {
            if (part.contains("*")) {
                hiddenTextField = new JTextField(part.length());
                hiddenTextField.setFont(Fonts.COURIERNEW_PLAIN_32);
                translatedTextPanel.add(hiddenTextField);
            } else {
                JLabel label = new JLabel(part);
                label.setFont(Fonts.COURIERNEW_PLAIN_32);
                translatedTextPanel.add(label);
            }
        }

        add(translatedTextPanel);
    }

    public abstract boolean checkLesson();
}
