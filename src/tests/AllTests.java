package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CardTest.class, ComparisonTest.class, FlushTest.class, HandTest.class, NMOfAKindTest.class,
		NOfAKindTest.class, PlayerInputTest.class, RankTest.class })
public class AllTests {
}
