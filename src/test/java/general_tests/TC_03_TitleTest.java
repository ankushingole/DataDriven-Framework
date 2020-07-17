package general_tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class TC_03_TitleTest extends BaseClass {

	@Test 
	public void googleTitleTest() {

		String actTitle=driver.getTitle();
		System.out.println(actTitle);
	}
}
