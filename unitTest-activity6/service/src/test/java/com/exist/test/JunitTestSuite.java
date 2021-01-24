package com.exist.test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestFunction.class,
   TestFunctionFail.class,
})

public class JunitTestSuite {   
}  	