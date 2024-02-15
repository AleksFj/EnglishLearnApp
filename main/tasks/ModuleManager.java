package main.tasks;


public class ModuleManager {
    public static Module createModule(String title) {
        return new Module(title);
    }

    public static void createDefaultSubjects() {
        Module articles = createModule("Articles a/an, the.")
                .add(new Rules(Rules.getArticleRules()))
                .add(new TranslateSentence(
                        "София, эта еда острая?",
                        new String[]{"Sofia", "is", "this", "food", "spicy"},
                        new String[]{"beautiful", "pasta", "he", "apple"}))
                .add(new CompleteTranslation(
                        "София, эта еда острая?",
                        "Sofia, is this food spicy?"))
                .add(new TranslateText());


        Module toBe = createModule("Verb to be.")
                .add(new Rules(Rules.getToBeRules()))
                .add(new CompleteTranslation())
                .add(new CompleteTranslation())
                .add(new TranslateSentence())
                .add(new TranslateText());


        Module thereIsAre = createModule("There is/are")
                .add(new Rules(Rules.getThereIsAreRules()))
                .add(new CompleteTranslation())
                .add(new CompleteTranslation())
                .add(new TranslateSentence())
                .add(new TranslateSentence())
                .add(new TranslateText());


        Module personalPronouns = createModule("Personal pronouns I, We, You, They, He, She, It")
                .add(new Rules(Rules.getPersonalPronounsRules()))
                .add(new CompleteTranslation())
                .add(new CompleteTranslation())
                .add(new TranslateSentence())
                .add(new TranslateSentence())
                .add(new TranslateSentence())
                .add(new TranslateText());


        ModuleContainer.addModule(articles);
        ModuleContainer.addModule(toBe);
        ModuleContainer.addModule(thereIsAre);
        ModuleContainer.addModule(personalPronouns);
    }
}
