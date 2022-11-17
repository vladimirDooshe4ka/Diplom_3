package Data;

import org.apache.commons.lang3.RandomStringUtils;

public class UserDataGenerate {

    public static String getRandomName(int countSymbols){
        return RandomStringUtils.randomAlphanumeric(countSymbols);
    }

    public static String getRandomEmail(int countSymbols){
        return RandomStringUtils.randomAlphanumeric(countSymbols) + "@gmail.com";
    }

    public static String getRandomPassword(int countSymbols){
        return RandomStringUtils.randomAlphanumeric(countSymbols);
    }
}
