package bookNotes.effectiveJava.chartOne.notefifteenth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Store {
    private static final String[] PRIVATE_VALUES = {"APPLE", "BANANA"};
    //第一种，增加公有的不可变列表
    public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    //第二种，返回克隆
    public static final String[] values(){
        return PRIVATE_VALUES.clone();
    }

}