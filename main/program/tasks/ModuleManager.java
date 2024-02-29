package main.program.tasks;


import main.program.utils.Constants;
import main.program.utils.FileManager;
import main.program.utils.FileScanner;

import java.io.File;
import java.util.List;

public class ModuleManager {
    public static Module createModule(String title) {
        return new Module(title);
    }

    public static void createDefaultSubjects() {
        Module articles = createModule("Articles a/an, the.")
                .add(new Rules(Rules.getArticleRules()))
                .add(new TranslateText(new TranslationPair(
                        "I bought a new phone yesterday.",
                        "Я купил новый телефон вчера.")))
                .add(new TranslateText(new TranslationPair(
                        "Do you have the time?",
                        "У вас есть время?")))
                .add(new TranslateText(new TranslationPair(
                        "She doesn't have a car.",
                        "У нее нет машины.")))
                .add(new TranslateSentence(new TranslationPair(
                        "We went to the beach last weekend.",
                        "Мы поехали на пляж на прошлых выходных."),
                        new RandomWords().addToOriginal("a", "an")))
                .add(new TranslateSentence(new TranslationPair(
                        "Did you see a movie at the cinema?",
                        "Ты смотрел фильм в кинотеатре?"),
                        new RandomWords().addToOriginal("an")))
                .add(new TranslateSentence(new TranslationPair(
                        "He hasn't read the book yet.",
                        "Он еще не прочитал книгу."),
                        new RandomWords().addToOriginal("a", "an")))
                .add(new CompleteTranslation(new TranslationPair(
                        "She found an interesting article in a magazine.",
                        "Она нашла интересную статью в журнале.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "Have you visited the museum downtown?",
                        "Ты посетил музей в центре города?")))
                .add(new CompleteTranslation(new TranslationPair(
                        "They don't like the food at the restaurant.",
                        "Им не нравится еда в ресторане.")))
                .shuffle();


        Module toBe = createModule("Verb to be.")
                .add(new Rules(Rules.getToBeRules()))
                .add(new TranslateText(new TranslationPair(
                        "I am happy today.",
                        "Я сегодня счастлив.")))
                .add(new TranslateText(new TranslationPair(
                        "Are you ready for the exam?",
                        "Ты готов к экзамену?")))
                .add(new TranslateText(new TranslationPair(
                        "She is not here right now.",
                        "Она сейчас здесь не находится.")))
                .add(new TranslateSentence(new TranslationPair(
                        "They are my friends.",
                        "Они мои друзья."),
                        new RandomWords()))
                .add(new TranslateSentence(new TranslationPair(
                        "Is he at home?",
                        "Он дома?"),
                        new RandomWords()))
                .add(new TranslateSentence(new TranslationPair(
                        "We are not hungry.",
                        "Мы не голодны."),
                        new RandomWords()))
                .add(new CompleteTranslation(new TranslationPair(
                        "The weather is nice today.",
                        "Сегодня погода хорошая.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "Are they siblings?",
                        "Они братья и сестры?")))
                .add(new CompleteTranslation(new TranslationPair(
                        "It is not easy to learn a new language.",
                        "Это не легко изучать новый язык.")))
                .shuffle();


        Module thereIsAre = createModule("There is/are")
                .add(new Rules(Rules.getThereIsAreRules()))
                .add(new TranslateText(new TranslationPair(
                        "There is a park near my house.",
                        "Рядом с моим домом есть парк.")))
                .add(new TranslateText(new TranslationPair(
                        "Is there a supermarket in this neighborhood?",
                        "Есть ли в этом районе супермаркет?")))
                .add(new TranslateText(new TranslationPair(
                        "There aren't any shops open at this late hour.",
                        "В этот поздний час нет открытых магазинов.")))
                .add(new TranslateSentence(new TranslationPair(
                        "There are many interesting books in the library.",
                        "В библиотеке много интересных книг."),
                        new RandomWords()))
                .add(new TranslateSentence(new TranslationPair(
                        "Are there any good restaurants in this area?",
                        "Есть ли в этом районе хорошие рестораны?"),
                        new RandomWords()))
                .add(new TranslateSentence(new TranslationPair(
                        "There isn't enough time to finish the project by tomorrow.",
                        "Времени недостаточно, чтобы закончить проект к завтрашнему дню."),
                        new RandomWords()))
                .add(new CompleteTranslation(new TranslationPair(
                        "There is a new movie playing at the cinema tonight.",
                        "Сегодня в кинотеатре идет новый фильм.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "Are there any empty seats on the bus?",
                        "Есть ли свободные места в автобусе?")))
                .add(new CompleteTranslation(new TranslationPair(
                        "There aren't many people at the party yet.",
                        "На вечеринке пока мало людей.")))
                .shuffle();


        Module personalPronouns = createModule("Personal pronouns I, We, You, They, He, She, It")
                .add(new Rules(Rules.getPersonalPronounsRules()))
                .add(new CompleteTranslation(new TranslationPair(
                        "I like to read books in my free time.", "Я люблю читать книги в свободное время.")))
                .add(new TranslateSentence(new TranslationPair(
                        "Do I have to finish this today?", "Мне нужно закончить это сегодня?"),
                        new RandomWords()))
                .add(new TranslateText(new TranslationPair(
                        "I don't know the answer.", "Я не знаю ответа.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "We are going to the beach next weekend.", "Мы собираемся на пляж на следующих выходных.")))
                .add(new TranslateSentence(new TranslationPair(
                        "Are we invited to the party?", "Мы приглашены на вечеринку?"),
                        new RandomWords()))
                .add(new TranslateText(new TranslationPair(
                        "We aren't ready for the presentation yet.", "Мы еще не готовы к презентации.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "You are my best friend.", "Ты мой лучший друг.")))
                .add(new TranslateSentence(new TranslationPair(
                        "Are you coming to the party?", "Ты идешь на вечеринку?"),
                        new RandomWords()))
                .add(new TranslateText(new TranslationPair(
                        "You don't have to worry about it.", "Ты не должен беспокоиться об этом.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "They live in a big house.", "Они живут в большом доме.")))
                .add(new TranslateSentence(new TranslationPair(
                        "Do they have any pets?", "У них есть домашние животные?"),
                        new RandomWords()))
                .add(new TranslateText(new TranslationPair(
                        "They aren't coming to the meeting today.", "Они сегодня не идут на собрание.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "He is my brother.", "Он - мой брат.")))
                .add(new TranslateSentence(new TranslationPair(
                        "Is he coming to the party?", "Он идет на вечеринку?"),
                        new RandomWords()))
                .add(new TranslateText(new TranslationPair(
                        "He doesn't like spicy food.", "Он не любит острую пищу.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "She works as a teacher.", "Она работает учителем.")))
                .add(new TranslateSentence(new TranslationPair(
                        "Is she busy right now?", "Она сейчас занята?"),
                        new RandomWords()))
                .add(new TranslateText(new TranslationPair(
                        "She isn't feeling well today.", "Она сегодня плохо себя чувствует.")))
                .add(new CompleteTranslation(new TranslationPair(
                        "It is raining outside.", "На улице идет дождь.")))
                .add(new TranslateSentence(new TranslationPair(
                        "Is it going to snow tomorrow?", "Завтра будет снег?"),
                        new RandomWords()))
                .add(new TranslateText(new TranslationPair(
                        "It isn't working properly.", "Оно не работает правильно.")))
                .shuffle();


        ModuleContainer.removeAll();
        ModuleContainer.addModule(articles);
        ModuleContainer.addModule(toBe);
        ModuleContainer.addModule(thereIsAre);
        ModuleContainer.addModule(personalPronouns);

        //saveDefaultModules();
    }

    public static void loadFromFiles() {
        List<File> moduleFiles = FileScanner.scanFolder(Constants.LESSONS_DIR, "json");
        System.out.printf("%d additional lessons found\n", moduleFiles.size());

        moduleFiles.forEach(m -> {
            ModuleContainer.addModule(new FileManager().load(Module.class, m.getPath()));
            System.out.println(m.getPath() + " successfully added");
        });
    }

    private static void saveDefaultModules() {
        new FileManager().save(ModuleContainer.getModules().get(0), Constants.LESSONS_DIR + "articles");
        new FileManager().save(ModuleContainer.getModules().get(1), Constants.LESSONS_DIR + "to_be");
        new FileManager().save(ModuleContainer.getModules().get(2), Constants.LESSONS_DIR + "there_is_are");
        new FileManager().save(ModuleContainer.getModules().get(3), Constants.LESSONS_DIR + "personal_pronouns");
    }
}
