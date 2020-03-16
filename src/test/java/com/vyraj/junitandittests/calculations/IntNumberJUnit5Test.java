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
import static org.junit.jupiter.api.Assertions.assertEquals;
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

//    @Disabled  // annotation for disabling test
    @Test
    @DisplayName("Checking isOdd PlusInt Unit Test")
    void isOddPlusTest() {
        // given
        log.info("!!=> isOdd Plus test <=!!");

        // when

        //then
        assertAll("isOdd plus tests assertions",
                () -> assertTrue(intNumber.isOdd()),
                () -> assertFalse(equalIntNumber.isOdd()));
    }

    @Test
    @DisplayName("Checking isOdd ZeroInt Unit Test")
    void isOddZeroTest() {
        // given
        intNumber = new IntNumber(0);
        log.info("!!=> isOdd Zero test <=!!");

        // when

        //then
        assertAll("isOdd zero tests assertions",
                () -> assertFalse(intNumber.isOdd()));
    }

    @Test
    @DisplayName("Checking isOdd PlusInt Unit Test")
    void isOddMinusTest() {
        // given
        intNumber = new IntNumber(-9);
        equalIntNumber = new IntNumber(-4);
        log.info("!!=> isOdd Minus test <=!!");

        // when

        //then
        assertAll("isOdd minus tests assertions",
                () -> assertTrue(intNumber.isOdd()),
                () -> assertFalse(equalIntNumber.isOdd()));
    }

    @Test
    @DisplayName("Checking add Unit Test")
    void addTest() {
        // given
        log.info("!!=> add test <=!!");

        // when
        equalIntNumber.add(5);

        //then
        assertAll("add tests assertions",
                () -> assertEquals(9, equalIntNumber.getFirst()),
                () -> assertEquals(intNumber.getFirst(), equalIntNumber.getFirst()));
    }

    @Test
    @DisplayName("Checking subtract Unit Test")
    void subtractTest() {
        // given
        log.info("!!=> subtract test <=!!");

        // when
        intNumber.subtract(5);

        //then
        assertAll("subtract tests assertions",
                () -> assertEquals(4, intNumber.getFirst()),
                () -> assertEquals(equalIntNumber.getFirst(), intNumber.getFirst()));
    }

    @Test
    @DisplayName("Checking multiply Unit Test")
    void multiplyTest() {
        // given
        log.info("!!=> multiply test <=!!");

        // when
        intNumber.multiply(4);
        equalIntNumber.multiply(9);

        //then
        assertAll("multiply tests assertions",
                () -> assertEquals(36, intNumber.getFirst()),
                () -> assertEquals(36, equalIntNumber.getFirst()),
                () -> assertEquals(equalIntNumber.getFirst(), intNumber.getFirst()));
    }

    @Test
    @DisplayName("Checking divide Unit Test")
    void divideTest() {
        // given
        log.info("!!=> divide test <=!!");

        // when
        intNumber.divide(equalIntNumber.getFirst());

        //then
        assertAll("divide tests assertions",
                () -> assertEquals(2, intNumber.getFirst()));
    }

    @Test
    @DisplayName("Checking modulo PlusInt Unit Test")
    void moduloPlusTest() {
        // given
        log.info("!!=> modulo plus test <=!!");

        // when
        intNumber.modulo(equalIntNumber.getFirst()); // 9 % 4

        //then
        assertAll("modulo tests assertions",
                () -> assertEquals(1, intNumber.getFirst()));
    }

    @Test
    @DisplayName("Checking modulo MinusInt Unit Test")
    void moduloMinusTest() {
        // given
        log.info("!!=> modulo minus test <=!!");

        // when
        intNumber = new IntNumber(-9);
        intNumber.modulo(equalIntNumber.getFirst());  // -9 % 4

        //then
        assertAll("modulo tests assertions",
                () -> assertEquals(-1, intNumber.getFirst()));
    }

}
