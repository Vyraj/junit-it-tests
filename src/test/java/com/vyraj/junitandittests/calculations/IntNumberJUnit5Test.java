package com.vyraj.junitandittests.calculations;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.lang.reflect.Method;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class IntNumberJUnit5Test implements IntNumberTearDown {

    private IntNumber intNumber;
    private IntNumber equalIntNumber;

    @BeforeAll
    static void logStarts() {
        log.info("!!!!!!=> Before " + IntNumberJUnit5Test.class.getSimpleName() + "class. <=!!!!!!\n");
    }

    @AfterAll
    static void logEnds() {
        log.info("!!!!!!=> After " + IntNumberJUnit5Test.class.getSimpleName() + "class. <=!!!!!!\n");
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        Optional<Method> testMethod = testInfo.getTestMethod();
        testMethod.ifPresentOrElse(value -> log.info("!!!!=> Before " + value.getName()+ "() method <=!!!!\n"),
                () -> log.info("!!!!=> Test method not found <=!!!!\n"));
        intNumber = new IntNumber(9);
        equalIntNumber = new IntNumber(4);
    }

    @Test
    @DisplayName("Checking isOdd Unit Test")
    void isOdd() {
        // given
        log.info("!!=> isOdd test <=!!");

        // when

        //then
        assertAll("isOdd tests asserts",
                () -> assertTrue(intNumber.isOdd()),
                () -> assertFalse(equalIntNumber.isOdd()));
    }
}
