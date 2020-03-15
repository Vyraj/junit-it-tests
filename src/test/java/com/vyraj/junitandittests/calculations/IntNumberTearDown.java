package com.vyraj.junitandittests.calculations;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;

import java.lang.reflect.Method;
import java.util.Optional;

interface IntNumberTearDown {

    @Slf4j
    final class LogHolder {}

    @AfterEach
    default void tearDown(TestInfo testInfo) {
        Optional<Method> testMethod = testInfo.getTestMethod();
        testMethod.ifPresentOrElse(value -> LogHolder.log.info("!!!!=> After " + value.getName()+ "() method <=!!!!\n"),
                () -> LogHolder.log.info("!!!!=> Test method not found <=!!!!\n"));

    }
}
