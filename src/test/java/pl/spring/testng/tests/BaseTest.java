package pl.spring.testng.tests;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import pl.spring.testng.SeleniumTestCaseContext;
import pl.spring.testng.SeleniumTestExecutionListener;

@SpringBootTest(classes = SeleniumTestCaseContext.class)
@TestExecutionListeners({ SeleniumTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class })
public class BaseTest extends AbstractTestNGSpringContextTests {

}
