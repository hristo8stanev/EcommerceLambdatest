package pages.registerpage;

import core.baseassertions.BaseAssertions;
import org.junit.jupiter.api.Assertions;

public class RegisterPageAssertions extends BaseAssertions<RegisterPageMap> {

    public void assertRegisterTitle(String value) {
        Assertions.assertEquals(elementsT().firstNameInput().getText(), 1);
    }
}

