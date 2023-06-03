package user;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUser {

    public static UserCreds random() {
        return new UserCreds(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru", "123456789", RandomStringUtils.randomAlphabetic(10));
    }
}
