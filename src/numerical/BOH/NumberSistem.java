package numerical.BOH;

import java.util.function.Function;

public class NumberSistem {
    private final int base;
    private final String title;
    private final Function<Integer, String> convertFromDecimal;

    public NumberSistem(int base, String title,
            Function<Integer, String> convertFromDecimal) {
        this.title = title;
        this.base = base;
        this.convertFromDecimal = convertFromDecimal;
    }

    public String getTitle() {
        return title;
    }

    public int getBase() {
        return base;
    }

    public Function<Integer, String> convertFromDecimal() {
        return convertFromDecimal;
    }

}
