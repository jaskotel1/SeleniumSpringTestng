package pl.spring.testng.driver;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetexplorer");

    private final String browser;
}
