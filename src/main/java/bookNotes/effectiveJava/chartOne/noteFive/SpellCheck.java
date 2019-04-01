package bookNotes.effectiveJava.chartOne.noteFive;

//采用依赖注入的方式导入底层资源，可以达到资源共享的目的
public class SpellCheck {
    private final Lexicon dictionary;

    public SpellCheck(Lexicon dictionary){
        this.dictionary = dictionary;
    }

    public boolean isValid(String str){
        return dictionary.check(str);
    }

    public static void main(String[] args) {
        Lexicon dictinary = new Lexicon();
        SpellCheck spellCheck = new SpellCheck(dictinary);
        spellCheck.isValid("Message");
    }
}

class Lexicon{
    public boolean check(String val){
        return true;
    }
}

//采用静态工厂，缺点是不能自定义底层资源，导致资源实例与其进行了绑定。推荐使用依赖注入。
class WordCheck{
    private static final Lexicon dictionary = new Lexicon();

    public static boolean isValid(String str){
        return dictionary.check(str);
    }

    public static void main(String[] args) {
        WordCheck.isValid("Message");
    }
}