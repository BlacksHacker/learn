package bookNotes.effectiveJava.chartOne.noteThird;

//共有静态域类型
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis(){

    }
}


//静态工厂
 class God{
    private static final God INSTANCE = new God();
    private God(){

    }
    public static God getInstance(){
        return INSTANCE;
    }
}

//单元素枚举
enum Godness{
    INSTANCE;
}
