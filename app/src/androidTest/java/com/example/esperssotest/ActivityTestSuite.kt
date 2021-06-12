package com.example.esperssotest

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ActivityOneTest::class,
    ActivityTwoTest::class
)
class ActivityTestSuite