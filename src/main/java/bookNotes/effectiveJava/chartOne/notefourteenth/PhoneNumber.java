/*package bookNotes.effectiveJava.chartOne.notefourteenth;

import java.util.Comparator;

public class PhoneNumber implements Comparable<PhoneNumber> {
    private int areaCode;
    private int prefix;
    private int lineNum;
    private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode).thenComparingInt((PhoneNumber pn) -> pn.prefix).thenComparingInt((PhoneNumber pn) -> pn.lineNum);


    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }
}*/
