package com.hrms.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",//run yapacagimiz feature in pathini buraya yapistiriyoruz.
                    glue = "com/hrms/stepdefinitions",dryRun = false,
                    tags="@dtWithHeader",strict = true,
                    plugin={"pretty",
                    "html:target/cucumber-default-reports",
                    "rerun:target/FailedTests.txt",
                        "json:target/cucumber.json"})//sonrada nerden run yapacaksa oraya yapistiriyoruz
                   //tagleri feature filelarina koyuyoruz. burdan run diyince sadece tag li olanlari run yapiyor
                    //dryrun unimplemented methodlari consoleda reveal yapiyor eger true dersek
                    //strict undefined steplere gelince fail yapacak, stict not popular. genelde dryrun kullaniliyor
                    //pretty codu console da stepleri print yapiyor
                    //json file format , run yapinca data store yapiyor.based on key values, based on objects. it will generate nomatter what it pass or fail.




public class TestRunner {

}
