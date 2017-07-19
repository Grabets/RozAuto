package Core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bogdan on 7/19/2017.
 */
public class Parser {
    public static final String INCOMING_EXPECTED_DATA = "^([А-Яа-я\\w,\\s]*)\\|\\s([А-Яа-я\\w,\\s]*)$";

    public Object[] parse (String s){
        Pattern pattern = Pattern.compile(Parser.INCOMING_EXPECTED_DATA);
        Matcher matcher = pattern.matcher(s);
        String incomingValue;
        String expectedValue;

        if (matcher.matches()) {
            incomingValue = matcher.group(1).trim();
            expectedValue = matcher.group(2).trim();
            return new Object[] {incomingValue, expectedValue};
        }
        return null;
    }

}
