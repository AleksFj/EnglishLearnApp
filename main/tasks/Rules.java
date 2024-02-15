package main.tasks;

//правила
public class Rules extends Task {

    private static final String htmlStart = "<html>" +
            "<body style='margin:50px 50px 0px 50px;font-family:Arial'>";
    private static final String htmlEnd = "</body>\n" +
            "   </html>";

    public Rules(String text) {
        this.text = text;
    }

    public static String getArticleRules() {
        return htmlStart +
                "<h1>Правила использования артиклей в английском языке</h1>\n" +
                "    \n" +
                "    <p>В английском языке существуют <strong>определённый</strong> и <strong>неопределённый</strong> артикли: <em>the</em>, <em>a</em> и <em>an</em>.</p>\n" +
                "    \n" +
                "    <h2>Неопределённый артикль</h2>\n" +
                "    \n" +
                "    <p><strong>Неопределённый артикль \"a\" и \"an\"</strong> используется перед существительными единственного числа, когда это существительное впервые упоминается и не имеет специфического определения.</p>\n" +
                "    \n" +
                "    <p>Например:</p>\n" +
                "    \n" +
                "    <ul>\n" +
                "        <li><em><strong>A</strong> dog</em> (собака)</li>\n" +
                "        <li><em><strong>An</strong> apple</em> (яблоко)</li>\n" +
                "    </ul>\n" +
                "    \n" +
                "    <h2>Определённый артикль</h2>\n" +
                "    \n" +
                "    <p><strong>Определённый артикль \"the\"</strong> используется перед существительными, когда они уже упоминались или если они явно определены.</p>\n" +
                "    \n" +
                "    <p>Например:</p>\n" +
                "    \n" +
                "    <ul>\n" +
                "        <li><em><strong>The</strong> dog</em> is barking. (Собака лает.)</li>\n" +
                "        <li><em><strong>The</strong> apple</em> is red. (Яблоко красное.)</li>\n" +
                "    </ul>\n" +
                "    \n" +
                "    <h2>Выбор между \"a\" и \"an\"</h2>\n" +
                "    \n" +
                "    <p>Определённый артикль выбирается в зависимости от звука, с которого начинается следующее слово:</p>\n" +
                "    \n" +
                "    <ul>\n" +
                "        <li><em><strong>A</strong> cat</em> (кошка)</li>\n" +
                "        <li><em><strong>An</strong> elephant</em> (слон)</li>\n" +
                "    </ul>\n" +
                "    \n" +
                "    <p>Исключение:</p>\n" +
                "    \n" +
                "    <ul>\n" +
                "        <li><em><strong>A</strong> university</em> (университет) - слово начинается с гласного, но звучит как согласный.</li>\n" +
                "    </ul>" + htmlEnd;
    }

    public static String getToBeRules() {
        return htmlStart +
                "<h1>Правила использования глагола \"to be\" в английском языке</h1>\n" +
                "<p>Глагол \"to be\" в английском языке является одним из наиболее употребительных и важных глаголов. " +
                "Он используется для обозначения состояния, идентификации или описания субъекта.</p>\n" +
                "<h2>Формы глагола \"to be\"</h2>\n" +
                "<p>Формы глагола \"to be\" в Present Simple:</p>\n" +
                "<ul>\n" +
                "<li>I am (я есть)</li>\n" +
                "<li>You are (ты есть)</li>\n" +
                "<li>He/She/It is (он/она/оно есть)</li>\n" +
                "<li>We are (мы есть)</li>\n" +
                "<li>They are (они есть)</li>\n" +
                "</ul>\n" +
                "<p>Формы глагола \"to be\" в Past Simple:</p>\n" +
                "<ul>\n" +
                "<li>I was (я был/была)</li>\n" +
                "<li>You were (ты был/была)</li>\n" +
                "<li>He/She/It was (он/она/оно был/была)</li>\n" +
                "<li>We were (мы были)</li>\n" +
                "<li>They were (они были)</li>\n" +
                "</ul>\n" +
                "<p>Формы глагола \"to be\" в Future Simple:</p>\n" +
                "<ul>\n" +
                "<li>I will be (я буду)</li>\n" +
                "<li>You will be (ты будешь)</li>\n" +
                "<li>He/She/It will be (он/она/оно будет)</li>\n" +
                "<li>We will be (мы будем)</li>\n" +
                "<li>They will be (они будут)</li>\n" +
                "</ul>\n" +
                "<p>Глагол \"to be\" также используется в разных временах, вопросительных и отрицательных предложениях " +
                "и в различных ситуациях, таких как выражение чувств, мнения, идентификации и т.д.</p>\n" +
                htmlEnd;
    }

    public static String getThereIsAreRules() {
        return htmlStart +
                "<h1>Правила использования конструкций \"There is/are\" в английском языке</h1>\n" +
                "<p>Конструкции \"There is/are\" в английском языке используются для обозначения наличия или существования " +
                "чего-либо в определенном месте или времени.</p>\n" +
                "<h2>Формы конструкций \"There is/are\"</h2>\n" +
                "<p>Формы конструкции \"There is\" (сингулярное число):</p>\n" +
                "<ul>\n" +
                "<li>There is a book on the table. (На столе есть книга.)</li>\n" +
                "<li>There is a cat in the garden. (В саду есть кошка.)</li>\n" +
                "<li>There is an apple in the fridge. (В холодильнике есть яблоко.)</li>\n" +
                "</ul>\n" +
                "<p>Формы конструкции \"There are\" (множественное число):</p>\n" +
                "<ul>\n" +
                "<li>There are flowers in the vase. (В вазе есть цветы.)</li>\n" +
                "<li>There are students in the classroom. (В классе есть студенты.)</li>\n" +
                "<li>There are cars on the street. (На улице есть машины.)</li>\n" +
                "</ul>\n" +
                "<p>Конструкции \"There is/are\" могут также использоваться в вопросительных и отрицательных предложениях " +
                "и представляют собой важный элемент повседневного английского языка.</p>\n" +
                htmlEnd;
    }

    public static String getPersonalPronounsRules() {
        return htmlStart +
                "<h1>Правила использования личных местоимений в английском языке</h1>\n" +
                "<p>Личные местоимения в английском языке используются для обозначения людей или вещей, о которых " +
                "идет речь в предложении. Они заменяют субъекты или объекты предложения и могут изменяться в зависимости " +
                "от лица, числа, рода и падежа.</p>\n" +
                "<h2>Субъектные и объектные формы</h2>\n" +
                "<p>Субъектные (именительные) формы:</p>\n" +
                "<ul>\n" +
                "<li>I (я)</li>\n" +
                "<li>We (мы)</li>\n" +
                "<li>You (ты, вы)</li>\n" +
                "<li>He (он)</li>\n" +
                "<li>She (она)</li>\n" +
                "<li>It (оно)</li>\n" +
                "<li>They (они)</li>\n" +
                "</ul>\n" +
                "<p>Объектные (винительные) формы:</p>\n" +
                "<ul>\n" +
                "<li>Me (меня, мне)</li>\n" +
                "<li>Us (нас, нам)</li>\n" +
                "<li>You (тебя, вас)</li>\n" +
                "<li>Him (его, ему)</li>\n" +
                "<li>Her (ее, ей)</li>\n" +
                "<li>It (его, ему)</li>\n" +
                "<li>Them (их, им)</li>\n" +
                "</ul>\n" +
                "<p>Личные местоимения используются в различных контекстах, в том числе в ситуациях, когда " +
                "необходимо обозначить субъект действия, в вопросительных и отрицательных предложениях, " +
                "а также в выражениях принадлежности и приветствия.</p>\n" +
                htmlEnd;
    }

    @Override
    public boolean isCorrect() {
        return true;
    }
}
