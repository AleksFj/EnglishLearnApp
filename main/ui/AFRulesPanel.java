package main.ui;

import main.tasks.Rules;

public class AFRulesPanel extends AFLessonPanel {
    private final Rules rules;

    public AFRulesPanel(Rules rules) {
        super();
        this.rules = rules;
        remove(title);
        text.setText(rules.getText());
    }

    @Override
    public boolean checkLesson() {
        return true;
    }
}
