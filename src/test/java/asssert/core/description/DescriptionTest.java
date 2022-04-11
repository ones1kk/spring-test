package asssert.core.description;

import static org.assertj.core.api.Assertions.assertThat;

import asssert.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DescriptionTest {

    @Test
    @DisplayName("Basic Feature Test(prototype)")
    void test1() {
        String actual = null;

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Assertion.assertThat(actual).as(() -> "hello it's kind of {}"));

        Assertions.assertThrows(RuntimeException.class,
            () -> Assertion.assertThat(actual).as(() -> "hello it's kind of {}", "test")
                .isNotNull());

        String message = Assertions.assertThrows(RuntimeException.class,
            () -> Assertion.assertThat(actual).as(() -> "hello it's kind of {}", "test")
                .isNotNull()).getMessage();

        assertThat(message).isEqualTo("hello it's kind of test");
    }

}