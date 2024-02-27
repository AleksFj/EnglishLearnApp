package main.ui;

import main.program.utils.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import javax.swing.text.*;

public abstract class AFLessonPanel extends JPanel {

    private JPanel titleNamePanel;      // Panel for displaying the title or name; example: Complete Translation
    private JPanel translatedTextPanel; // Panel for displaying translated text; example: Sofia, is this food spicy?
    private JPanel originalTextPanel;   // Panel for displaying original text; example: София, эта еда острая?
    private JPanel enteredWordsPanel;   // Panel for displaying entered words
    private JPanel choiceWordsPanel;    // Panel for displaying selected words //example: [spicy] [he] [this] [apple]
                                        // [food] [beautiful] [Sofia] [is] [pasta]
    private JTextPane ruleText;
    private JLabel taskName;
    private JTextPane translatedText;
    private JTextPane originalText;
    private AFCustomButton[] choiceWordsButtons;
    private AFResultMessagePrinter resultText;
    private JTextField hiddenTextField;


    public AFLessonPanel() {
        //setLayout(new GridLayout(0, 1));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    protected JTextPane getRuleText() {
        if (ruleText == null) {
            ruleText = new JTextPane();
            ruleText.setContentType("text/html");
            ruleText.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(ruleText);
            add(scrollPane);
        }
        return ruleText;
    }

    protected void getTaskName(String text) {
        if (taskName == null) {
            taskName = new JLabel(text);
            taskName.setFont(Fonts.COURIERNEW_BOLD_32);

            if (titleNamePanel == null) {
                titleNamePanel = new JPanel();
                titleNamePanel.setLayout(new BoxLayout(titleNamePanel, BoxLayout.X_AXIS));
                //titleNamePanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 10));
                //titleNamePanel.setBorder(new LineBorder(Color.red));
                titleNamePanel.add(taskName);
                add(titleNamePanel);
            }
        }
    }

    protected void getOriginalText(String text) {
        if (originalText == null) {
            originalText = new JTextPane();
            originalText.setText(text);
            originalText.setFont(Fonts.COURIERNEW_PLAIN_32);
            originalText.setEditable(false);    //disallows editing
            originalText.setOpaque(false);  //removes the background
            originalText.setHighlighter(null);  //disables text selection
            //The caret is overridden by the paint method so you don't have to draw anything
            originalText.setCaret(new DefaultCaret(){
                @Override
                public void paint(Graphics g) {

                }
            });

            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

            // Получаем StyledDocument и применяем стиль для всего текста
            StyledDocument doc = originalText.getStyledDocument();
            doc.setParagraphAttributes(0, doc.getLength(), center, false);

            //add(originalText);
            if (originalTextPanel == null) {
                originalTextPanel = new JPanel(new GridLayout());
                //originalTextPanel.setBorder(new LineBorder(Color.red));
                originalTextPanel.add(originalText);
                add(originalTextPanel);
            }
        }
    }

    protected void getTranslationTextArea(String text) {
        if(translatedText == null) {
            translatedText = new JTextPane();
            translatedText.setFont(Fonts.COURIERNEW_PLAIN_32);

            if(translatedTextPanel == null) {
                translatedTextPanel = new JPanel(new GridLayout());
                //translatedTextPanel.setBorder(new LineBorder(Color.red));
                translatedTextPanel.add(translatedText);
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
                //enteredWordsPanel.setBorder(new LineBorder(Color.red));
                add(enteredWordsPanel);
            }

            //create a panel for all the words that the user can choose to compose a sentence
            if (choiceWordsPanel == null) {
                choiceWordsPanel = new JPanel();
                //choiceWordsPanel.setBorder(new LineBorder(Color.red));
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

    protected AFResultMessagePrinter getResultText() {
        if(resultText == null) {
            resultText = new AFResultMessagePrinter(this);
            //resultText.getPanel().setBorder(new LineBorder(Color.red));
        }

        return (resultText);
    }

    //creating text, with a TextField instead of a missing word
    protected void getTextWithEmptyField(ArrayList<String> parts) {
        translatedTextPanel = new JPanel();
        translatedTextPanel.setBorder(new LineBorder(Color.red));

        for (String part : parts) {
            if (part.contains("*")) {
                hiddenTextField = new JTextField(part.length());
                hiddenTextField.setFont(Fonts.COURIERNEW_PLAIN_32);
                translatedTextPanel.add(hiddenTextField);
            } else {
                JLabel label = new JLabel();
                label.setText(part);
                if(part.chars().anyMatch(Character::isLetter)) {
                    label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                }
                label.setFont(Fonts.COURIERNEW_PLAIN_32);
                translatedTextPanel.add(label);
            }
        }

        add(translatedTextPanel);
    }

    protected String getHiddenText() {
        return hiddenTextField.getText();
    }

    protected String getTranslatedText() {
        return translatedText.getText();
    }

    public abstract boolean checkLesson();
}
