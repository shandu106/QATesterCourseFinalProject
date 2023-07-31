package webpages.posts;


import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostFormPage {
	
	
	private WebDriver driver;
	private static String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add";
	
	@FindBy(name="title")
	private WebElement wePostTitle;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement weButtonSave;
	@FindBy(xpath="//a[@href='https://testblog.kurs-qa.cubes.edu.rs/admin/posts']")
	private WebElement weButtonCancel;
	
	public PostFormPage(WebDriver driver) {
		this.driver = driver;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void addNewPost(String postTitle) {
		wePostTitle.sendKeys(postTitle);
		weButtonSave.click();
	}
	
	public String addNewRandomPost() {
		Random random = new Random();
		String postTitle = "Tag "+random.nextInt(100);
		wePostTitle.sendKeys(postTitle);
		weButtonSave.click();
		return postTitle;
	}
	
	

}
