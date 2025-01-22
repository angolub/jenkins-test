import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.Account;

import java.util.List;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expected;

    public AccountTest(
            String name,
            boolean expected
    ) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Alina Golub", true},
                {null, false},
                {"Al", false},
                {"Alina Golub123456789", false},
                {" AlinaGolub", false},
                {"AlinaGolub ", false},
                {"Alina  Golub", false},
                {"Alina Gol ub", false}
        };
    }

    @Test
    public void checkNameToEmboss() {
        Account account = new Account(this.name);
        Assert.assertEquals(this.expected, account.checkNameToEmboss());
    }
}
