package pl.spring.testng;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SeleniumTestCaseContext {

    @Bean
    public TestScope testScope() {
        return new TestScope();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer scopeConfiguring = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap<>();
        scopes.put("test", testScope());
        scopeConfiguring.setScopes(scopes);
        return scopeConfiguring;
    }

}
