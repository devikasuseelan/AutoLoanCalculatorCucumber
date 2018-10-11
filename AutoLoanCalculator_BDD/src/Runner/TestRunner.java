package Runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features= "featureFile",
                 glue= {"stepDefinition"},
                 format= { "html:test-output/"})

public class TestRunner {

}
