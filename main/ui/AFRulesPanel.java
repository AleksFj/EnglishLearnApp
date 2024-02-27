package main.ui;

import main.program.tasks.Rules;

public class AFRulesPanel extends AFLessonPanel {
    private final Rules rules;

    public AFRulesPanel(Rules rules) {
        this.rules = rules;
        getRuleText().setText(rules.getText());
    }

    @Override
    public boolean checkLesson() {
        return true;
    }
}
