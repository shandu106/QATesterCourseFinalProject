package webpages.posts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostListPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private static String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts";
	
	
	public PostListPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void deletePost(String postTitle) {
		
		WebElement weDeleteButton = driver.findElement(By.xpath("//strong[text()='"+postTitle+"']//ancestor::tr//td[5]//button"));
		weDeleteButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='btn btn-danger']")))); 
		
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	}

	public void openLinkParentInMenu(String title) {
			
	}

	public void clickOnLinkInMenu(String title) {	
		
	}

	public void openPage() {
		
	}

	public void clickOnNavigationLink(String title) {
		
	}

}
