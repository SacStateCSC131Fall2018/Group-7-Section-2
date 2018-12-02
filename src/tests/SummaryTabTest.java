package tests;
import pirex.SummaryTab;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SummaryTabTest {

	@Test
	void testConstructor() {
		try {
			new SummaryTab();
		} catch(Exception e) {
			assertTrue(false);
		}
	}

}
