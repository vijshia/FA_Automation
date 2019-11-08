/**
 * 
 */
package com.FA.app.pages.fa;

import org.openqa.selenium.By;

import com.FA.app.pages.basePage;
import com.FA.framework.Log;

import ru.yandex.qatools.allure.annotations.Title;


/**
 * @author AJP16088
 *
 */
public class loginPage extends basePage {
	
	public loginPage() {
//		driver = WebContext.driver;
	}
	
	private By txt_userName = By.id("username");
	private By txt_FApassword = By.id("password");
	private By btn_FALogin = By.className("btn-submit");
	private By btn_FALogout = By.className("logbutton");
	private By frame_LoginPage = By.tagName("frame");
	
	@Title(value = "Login to FA is executing")
	public void LogintoFA(String username, String password, String url) throws Exception {

		enteringValues(txt_userName, username);
		enteringValues(txt_FApassword, password);
		waitforElementtobeClickable(btn_FALogin, 25);
		clickonButton(btn_FALogin);
		waitforURLtobeNavigated(url, 15);
		switchtoFrame(frame_LoginPage);
		waitforVisibilityofElementLocated(btn_FALogout, 20);
		Log.info(" *** FA Login Successful *** ");
	}	

}
