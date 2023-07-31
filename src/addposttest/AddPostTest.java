package addposttest;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webpages.posts.PostFormPage;
import webpages.posts.PostListPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddPostTest {
	
	private static ChromeDriver driver;
	private static String urlLoginPage ="http://testblog.kurs-qa.cubes.edu.rs/login"; 
	private static WebDriverWait wait;
	private static PostFormPage postFormPage;
	private static PostListPage postListPage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pc\\OneDrive\\Desktop\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}	

	@Test
	public void tc_03LoginWithValidEmailAddressAndValidPassword() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin");
		
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/sliders");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/sliders/add");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/post-categories");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/sliders/post-categories/add");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/tags");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/tags/add");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/posts");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/comments");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/users");
		checkMeniLink("Sliders list", "http://testblog.kurs-qa.cubes.edu.rs/admin/add");
	}

	private void checkMeniLink(String string, String string2) {
		WebElement weLink = driver.findElement(By.xpath("//p{text()='\"+title+\"']"));
		weLink.click();
	}
	
	@Test 
	public void tc_04ClickOnPostsIcon(String title, String url) {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin");

        WebElement postsDropdown = driver.findElement(By.xpath("//li[@class='nav-link']/a[contains(text(), 'Posts')]"));

        postsDropdown.click();

        WebElement addNewPostOption = driver.findElement(By.xpath("//a[class='far fa-circle nav-icon'(text(), 'Add New Post')]"));

        WebElement postsListOption = driver.findElement(By.xpath("//a[class='far fa-circle nav-icon'(text(), 'Posts List')]"));

        assertTrue(addNewPostOption.isDisplayed());
        assertTrue(postsListOption.isDisplayed());
	}
	
	@Test
	public void tc_05ViewPostsList(String title, String url) {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts");

        WebElement postListOption = driver.findElement(By.xpath("//a[class='far fa-circle nav-icon'(text(), 'Post List')]"));
        postListOption.click();

        WebElement titleSearchOption = driver.findElement(By.xpath("//input.from-control[@name='title']"));
        WebElement authorSearchOption = driver.findElement(By.xpath("//id=\"select2-user_id-60-container[@name='author']"));
        WebElement categorySearchOption = driver.findElement(By.xpath("//select2-post_category_id-sv-container[@name='category']"));
        WebElement importantSearchOption = driver.findElement(By.xpath("//entities-filter-form[@name='important']"));
        WebElement statusSearchOption = driver.findElement(By.xpath("//entities-filter-form[@name='status']"));
        WebElement tagSearchOption = driver.findElement(By.xpath("//entities-filter-form[@name='tag']"));
      
        assertTrue(titleSearchOption.isDisplayed());
        assertTrue(authorSearchOption.isDisplayed());
        assertTrue(categorySearchOption.isDisplayed());
        assertTrue(importantSearchOption.isDisplayed());
        assertTrue(statusSearchOption.isDisplayed());
        assertTrue(tagSearchOption.isDisplayed());

        WebElement photoColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[2], 'Photo')]"));
        WebElement importantColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[3], 'Important')]"));
        WebElement statusColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[4], 'Status')]"));
        WebElement titleColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[5], 'Title')]"));
        WebElement authorColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[6], 'Author')]"));
        WebElement categoryColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[7], 'Category')]"));
        WebElement tagsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[8], 'Tags')]"));
        WebElement timeDateColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[9], 'Time and Date of Creation')]"));
        WebElement optionsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[10], 'Options')]"));
      
        assertTrue(photoColumn.isDisplayed());
        assertTrue(importantColumn.isDisplayed());
        assertTrue(statusColumn.isDisplayed());
        assertTrue(titleColumn.isDisplayed());
        assertTrue(authorColumn.isDisplayed());
        assertTrue(categoryColumn.isDisplayed());
        assertTrue(tagsColumn.isDisplayed());
        assertTrue(timeDateColumn.isDisplayed());
        assertTrue(optionsColumn.isDisplayed());

        WebElement eyeIcon = driver.findElement(By.xpath("//i[@class='fas fa-eye']"));
        WebElement editIcon = driver.findElement(By.xpath("//i[@class='fas fa-edit']"));
        WebElement trashIcon = driver.findElement(By.xpath("//i[@class='fas fa-trash']"));

        assertTrue(eyeIcon.isDisplayed());
        assertTrue(editIcon.isDisplayed());
        assertTrue(trashIcon.isDisplayed());
	}
	
	@Test
	public void tc_06DisplayingPageForAddingPost() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement addNewPostOption = driver.findElement(By.xpath("//a[class='far fa-circle nav-icon'(text(), 'Add New Post')]"));
        addNewPostOption.click();

        WebElement categoryField = driver.findElement(By.name("post_category_id"));
        WebElement titleField = driver.findElement(By.name("title"));
        WebElement descriptionField = driver.findElement(By.name("description"));
        WebElement importantField = driver.findElement(By.name("important"));
        WebElement tagsField = driver.findElement(By.name("tags"));
        WebElement photoUploadField = driver.findElement(By.name("photo"));
        WebElement contentField = driver.findElement(By.name("content"));
        WebElement saveButton = driver.findElement(By.xpath("//btn btn-primary[contains(text(), 'Save')]"));
        WebElement cancelButton = driver.findElement(By.xpath("//btn btn-primary[contains(text(), 'Cancel')]"));
      
        assertTrue(categoryField.isDisplayed());
        assertTrue(titleField.isDisplayed());
        assertTrue(descriptionField.isDisplayed());
        assertTrue(importantField.isDisplayed());
        assertTrue(tagsField.isDisplayed());
        assertTrue(photoUploadField.isDisplayed());
        assertTrue(contentField.isDisplayed());
        assertTrue(saveButton.isDisplayed());
        assertTrue(cancelButton.isDisplayed());
		
	}
	
	@Test
	public void tc_07SavePostAddedWithEmptyFields() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        driver.findElement(By.id("btn btn-primary")).click();

        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        assertEquals("This field is required.", errorMessage);
	}
	
	@Test
	public void tc_08SavePostAddedWithCategorySelected() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement categoryDropdown = driver.findElement(By.id("post_category_id"));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Category 1']"));
        categoryOption.click();
        
        WebElement categoryDropdown1 = driver.findElement(By.id("post_category_id"));
        categoryDropdown1.sendKeys("Duki");

        driver.findElement(By.id("btn btn-primary")).click();

        String titleErrorMessage = driver.findElement(By.id("form-control is-invalid")).getText();
        assertEquals("Title is required.", titleErrorMessage);

        String descriptionErrorMessage = driver.findElement(By.id("form-control is-invalid")).getText();
        assertEquals("Description is required.", descriptionErrorMessage);

        String tagErrorMessage = driver.findElement(By.id("error invalid-feedback")).getText();
        assertEquals("Tag is required.", tagErrorMessage);

	}
	
	@Test
	public void tc_09SavePostWithCategoryAndTitle() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement categoryDropdown = driver.findElement(By.id("post_category_id"));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Category 1']"));
        categoryOption.click();
        
        WebElement categoryDropdown1 = driver.findElement(By.id("post_category_id"));
        categoryDropdown1.sendKeys("Duki");

        WebElement titleField = driver.findElement(By.id("titleField"));
        titleField.sendKeys("What is Lorem Ipsum?");

        WebElement importanceCheckbox = driver.findElement(By.id("custom-control custom-radio custom-control-inline"));
        importanceCheckbox.click();
      
        driver.findElement(By.id("btn btn-primary")).click();

        String descriptionErrorMessage = driver.findElement(By.id("form-control is-invalid")).getText();
        assertEquals("Description is required.", descriptionErrorMessage);

        String tagErrorMessage = driver.findElement(By.id("error invalid-feedback")).getText();
        assertEquals("Tag is required.", tagErrorMessage);

	}
	
	@Test
	public void tc_10SavePostWithCategoryTitleAndDescriptionWithLessCharacters() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement categoryDropdown = driver.findElement(By.id("post_category_id"));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Category 1']"));
        categoryOption.click();
        
        WebElement categoryDropdown1 = driver.findElement(By.id("post_category_id"));
        categoryDropdown1.sendKeys("Duki");

        WebElement titleField = driver.findElement(By.id("titleField"));
        titleField.sendKeys("What is Lorem Ipsum?");

        WebElement importanceCheckbox = driver.findElement(By.id("custom-control custom-radio custom-control-inline"));
        importanceCheckbox.click();
      
        driver.findElement(By.id("btn btn-primary")).click();

        String titleErrorMessage = driver.findElement(By.id("form-control is-invalid")).getText();
        assertEquals("Please enter at least 20 characters.", titleErrorMessage);

        String descriptionErrorMessage = driver.findElement(By.id("form-control is-invalid")).getText();
        assertEquals("Please enter at least 50 characters.", descriptionErrorMessage);

        String tagErrorMessage = driver.findElement(By.id("error invalid-feedback")).getText();
        assertEquals("This field is required.", tagErrorMessage);

	}
	
	@Test
	public void tc_11SavePostWithCategoryTitleAndDescriptionWithHigherQuantityOfCharacters() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement categoryDropdown = driver.findElement(By.id("post_category_id"));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Category 1']"));
        categoryOption.click();
        
        WebElement categoryDropdown1 = driver.findElement(By.id("post_category_id"));
        categoryDropdown1.sendKeys("Duki");

        WebElement titleField = driver.findElement(By.id("form-control is-invalid"));
        titleField.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when "
        		+ "an unknown printer took a galley of type and scrambled it to make a type specimen book. "
        		+ "It has survived not only five centuries, but also the leap into electronic typesetting, "
        		+ "remaining essentially unchanged. It was popularised in the 1960s with the release of "
        		+ "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing "
        		+ "software like Aldus PageMaker including versions of Lorem Ipsum.");

        WebElement descriptionField = driver.findElement(By.id("form-control is-invalid"));
        descriptionField.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an "
        		+ "unknown printer took a galley of type and scrambled it to make a type specimen book. "
        		+ "It has survived not only five centuries, but also the leap into electronic typesetting, "
        		+ "remaining essentially unchanged. It was popularised in the 1960s with the release of "
        		+ "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing "
        		+ "software like Aldus PageMaker including versions of Lorem Ipsum.");

        WebElement importanceCheckbox = driver.findElement(By.id("importanceCheckbox"));
        importanceCheckbox.click();

        driver.findElement(By.id("btn btn-primary")).click();

        String titleErrorMessage = driver.findElement(By.id("form-control is-invalid")).getText();
        assertEquals("Please enter no more than 255 characters.", titleErrorMessage);

        String descriptionErrorMessage = driver.findElement(By.id("form-control is-invalid")).getText();
        assertEquals("Please enter no more than 500 characters.", descriptionErrorMessage);

        String tagErrorMessage = driver.findElement(By.id("error invalid-feedback")).getText();
        assertEquals("This field is required.", tagErrorMessage);

	}
	
	@Test
	public void tc_12SaveWithCategoryTitleAndDescriptionWithOptialNumberOfCharacters() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement categoryDropdown = driver.findElement(By.id("post_category_id"));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Category']"));
        categoryOption.click();
        
        WebElement categoryDropdown1 = driver.findElement(By.id("post_category_id"));
        categoryDropdown1.sendKeys("Duki");

        WebElement titleField = driver.findElement(By.id("form-control"));
        titleField.sendKeys("What is Lorem Ipsum?");

        WebElement descriptionField = driver.findElement(By.id("form-control"));
        descriptionField.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");

        driver.findElement(By.id("btn btn-primary")).click();

        String tagErrorMessage = driver.findElement(By.id("error invalid-feedback")).getText();
        assertEquals("This field is required.", tagErrorMessage);

	}
	
	@Test
	public void tc_13SavePostWithCategoryTitleDescriptionImportanceAndTags() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement categoryDropdown = driver.findElement(By.id("post_category_id"));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Category']"));
        categoryOption.click();
        
        WebElement categoryDropdown1 = driver.findElement(By.id("post_category_id"));
        categoryDropdown1.sendKeys("Duki");

        WebElement titleField = driver.findElement(By.id("form-control"));
        titleField.sendKeys("What is Lorem Ipsum?");

        WebElement descriptionField = driver.findElement(By.id("form-control"));
        descriptionField.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");

        driver.findElement(By.id("btn btn-primary")).click();

        WebElement photoUploadField = driver.findElement(By.name("photo"));
        photoUploadField.sendKeys("path/to/image.jpg");

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(), 'Save')]"));
        saveButton.click();

        WebElement contentErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'The content field is required')]"));
        assertEquals("The content field is required", contentErrorMessage.getText());
	}
	
	@Test
	public void tc_14SavePostWithCategoryTitleDescriptionImportanceTagsAndPicture() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement categoryDropdown = driver.findElement(By.id("post_category_id"));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Category']"));
        categoryOption.click();
        
        WebElement categoryDropdown1 = driver.findElement(By.id("post_category_id"));
        categoryDropdown1.sendKeys("Duki");

        WebElement titleField = driver.findElement(By.id("form-control"));
        titleField.sendKeys("What is Lorem Ipsum?");

        WebElement descriptionField = driver.findElement(By.id("form-control"));
        descriptionField.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");

        driver.findElement(By.id("btn btn-primary")).click();

        WebElement tagCheckbox = driver.findElement(By.id("tagCheckbox"));
        tagCheckbox.click();

        WebElement photoInput = driver.findElement(By.id("photoInput"));
        photoInput.sendKeys("desktop/image.jpg");

        driver.findElement(By.id("btn btn-primary")).click();

        String contentErrorMessage = driver.findElement(By.id("//div[contains(text(), 'The content field is required')]")).getText();
        assertEquals("The content field is required.", contentErrorMessage);
	}
	
	@Test
	public void tc_15SavePostWithCategoryTitleDescriptionImportanceTagsPictureAndContent() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");

        WebElement categoryDropdown = driver.findElement(By.id("post_category_id"));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Duki']"));
        categoryOption.click();

        WebElement titleField = driver.findElement(By.id("form-control"));
        titleField.sendKeys("What is Lorem Ipsum?");

        WebElement descriptionField = driver.findElement(By.id("form-control"));
        descriptionField.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");

        WebElement importanceCheckbox = driver.findElement(By.id("importanceCheckbox"));
        importanceCheckbox.click();

        WebElement tagCheckbox = driver.findElement(By.id("tagCheckbox"));
        tagCheckbox.click();

        WebElement photoInput = driver.findElement(By.id("photoInput"));
        photoInput.sendKeys("desktop/image.jpg");

        WebElement contentField = driver.findElement(By.id("contentField"));
        contentField.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
        		+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an "
        		+ "unknown printer took a galley of type and scrambled it to make a type specimen book. "
        		+ "It has survived not only five centuries, but also the leap into electronic typesetting, "
        		+ "remaining essentially unchanged. It was popularised in the 1960s with the release of "
        		+ "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing "
        		+ "software like Aldus PageMaker including versions of Lorem Ipsum.");

        driver.findElement(By.id("btn btn-primary")).click();

        driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts");

        boolean isPostFound = driver.findElements(By.xpath("//h2[contains(text(), 'What is Lorem Ipsum?')]")).size() > 0;
        assertTrue("The post should be found on the Post List page.", isPostFound);
	}
	
	@Test
	public void tc_16SearchNewlyAddedPostByTitle() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts");

        WebElement searchField = driver.findElement(By.id("input.form-control"));
        searchField.sendKeys("What is Lorem Ipsum?");

        WebElement photoColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[2], 'Photo')]"));
        WebElement importantColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[3], 'Important')]"));
        WebElement statusColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[4], 'Status')]"));
        WebElement titleColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[5], 'Title')]"));
        WebElement authorColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[6], 'Author')]"));
        WebElement categoryColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[7], 'Category')]"));
        WebElement tagsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[8], 'Tags')]"));
        WebElement timeDateColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[9], 'Time and Date of Creation')]"));
        WebElement optionsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[10], 'Options')]"));
        WebElement eyeIconElement = driver.findElement(By.xpath("//i[@class='fas fa-eye']"));
        WebElement writeIconElement = driver.findElement(By.xpath("//i[@class='fas fa-edit']"));
        WebElement trashIconElement = driver.findElement(By.xpath("//i[@class='fas fa-trash']"));

        WebElement postTitleElement = null;
		assertEquals("What is Lorem Ipsum?", postTitleElement.getText());
        WebElement postAuthorElement = null;
		assertEquals("Polaznik Kursa", postAuthorElement.getText());
        WebElement postCategoryElement = null;
		assertEquals("Duki", postCategoryElement.getText());
        WebElement postTagElement = null;
		assertEquals("Duki Test", postTagElement.getText());
        WebElement postPhotoElement = null;
		assertTrue(postPhotoElement.isDisplayed());
        WebElement postImportanceElement = null;
		assertEquals("No", postImportanceElement.getText());
        WebElement postStatusElement = null;
		assertEquals("Enabled", postStatusElement.getText());

        assertTrue(eyeIconElement.isDisplayed());
        assertTrue(writeIconElement.isDisplayed());
        assertTrue(trashIconElement.isDisplayed());
	}
	
	@Test
	public void tc_17SearchNewlyAddedPostByAuthor() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts");

        WebElement authorField = driver.findElement(By.id("id=\"select2-user_id-xm-container\""));
        authorField.sendKeys("Polaznik Kursa");

        WebElement photoColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[2], 'Photo')]"));
        WebElement importantColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[3], 'Important')]"));
        WebElement statusColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[4], 'Status')]"));
        WebElement titleColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[5], 'Title')]"));
        WebElement authorColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[6], 'Author')]"));
        WebElement categoryColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[7], 'Category')]"));
        WebElement tagsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[8], 'Tags')]"));
        WebElement timeDateColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[9], 'Time and Date of Creation')]"));
        WebElement optionsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[10], 'Options')]"));
        WebElement eyeIconElement = driver.findElement(By.xpath("//i[@class='fas fa-eye']"));
        WebElement writeIconElement = driver.findElement(By.xpath("//i[@class='fas fa-edit']"));
        WebElement trashIconElement = driver.findElement(By.xpath("//i[@class='fas fa-trash']"));

        WebElement postTitleElement = null;
		assertEquals("What is Lorem Ipsum?", postTitleElement.getText());
        WebElement postAuthorElement = null;
		assertEquals("Polaznik Kursa", postAuthorElement.getText());
        WebElement postCategoryElement = null;
		assertEquals("Duki", postCategoryElement.getText());
        WebElement postTagElement = null;
		assertEquals("Duki Test", postTagElement.getText());
        WebElement postPhotoElement = null;
		assertTrue(postPhotoElement.isDisplayed());
        WebElement postImportanceElement = null;
		assertEquals("No", postImportanceElement.getText());
        WebElement postStatusElement = null;
		assertEquals("Enabled", postStatusElement.getText());

        assertTrue(eyeIconElement.isDisplayed());
        assertTrue(writeIconElement.isDisplayed());
        assertTrue(trashIconElement.isDisplayed());
	}
	
	@Test
	public void tc_18SearchNewlyAAddedPostByCategory() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts");

        WebElement categoryDropdown = driver.findElement(By.id("id=\"select2-post_category_id-lp-container\""));
        categoryDropdown.click();
        WebElement categoryOption = driver.findElement(By.xpath("//option[text()='Duki']"));
        categoryOption.click();
        
        WebElement photoColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[2], 'Photo')]"));
        WebElement importantColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[3], 'Important')]"));
        WebElement statusColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[4], 'Status')]"));
        WebElement titleColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[5], 'Title')]"));
        WebElement authorColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[6], 'Author')]"));
        WebElement categoryColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[7], 'Category')]"));
        WebElement tagsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[8], 'Tags')]"));
        WebElement timeDateColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[9], 'Time and Date of Creation')]"));
        WebElement optionsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[10], 'Options')]"));
        WebElement eyeIconElement = driver.findElement(By.xpath("//i[@class='fas fa-eye']"));
        WebElement writeIconElement = driver.findElement(By.xpath("//i[@class='fas fa-edit']"));
        WebElement trashIconElement = driver.findElement(By.xpath("//i[@class='fas fa-trash']"));

        WebElement postTitleElement = null;
		assertEquals("What is Lorem Ipsum?", postTitleElement.getText());
        WebElement postAuthorElement = null;
		assertEquals("Polaznik Kursa", postAuthorElement.getText());
        WebElement postCategoryElement = null;
		assertEquals("Duki", postCategoryElement.getText());
        WebElement postTagElement = null;
		assertEquals("Duki Test", postTagElement.getText());
        WebElement postPhotoElement = null;
		assertTrue(postPhotoElement.isDisplayed());
        WebElement postImportanceElement = null;
		assertEquals("No", postImportanceElement.getText());
        WebElement postStatusElement = null;
		assertEquals("Enabled", postStatusElement.getText());

        assertTrue(eyeIconElement.isDisplayed());
        assertTrue(writeIconElement.isDisplayed());
        assertTrue(trashIconElement.isDisplayed());
	}
	
	@Test
	public void tc19SearchNewlyAddedPostByTag() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts");

        WebElement tagField = driver.findElement(By.id("<ul class=\"select2-selection__rendered\""));
        tagField.sendKeys("Duki Test");

        WebElement photoColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[2], 'Photo')]"));
        WebElement importantColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[3], 'Important')]"));
        WebElement statusColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[4], 'Status')]"));
        WebElement titleColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[5], 'Title')]"));
        WebElement authorColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[6], 'Author')]"));
        WebElement categoryColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[7], 'Category')]"));
        WebElement tagsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[8], 'Tags')]"));
        WebElement timeDateColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[9], 'Time and Date of Creation')]"));
        WebElement optionsColumn = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/thead/tr/th[10], 'Options')]"));
        WebElement eyeIconElement = driver.findElement(By.xpath("//i[@class='fas fa-eye']"));
        WebElement writeIconElement = driver.findElement(By.xpath("//i[@class='fas fa-edit']"));
        WebElement trashIconElement = driver.findElement(By.xpath("//i[@class='fas fa-trash']"));

        WebElement postTitleElement = null;
		assertEquals("What is Lorem Ipsum?", postTitleElement.getText());
        WebElement postAuthorElement = null;
		assertEquals("Polaznik Kursa", postAuthorElement.getText());
        WebElement postCategoryElement = null;
		assertEquals("Duki", postCategoryElement.getText());
        WebElement postTagElement = null;
		assertEquals("Duki Test", postTagElement.getText());
        WebElement postPhotoElement = null;
		assertTrue(postPhotoElement.isDisplayed());
        WebElement postImportanceElement = null;
		assertEquals("No", postImportanceElement.getText());
        WebElement postStatusElement = null;
		assertEquals("Enabled", postStatusElement.getText());

        assertTrue(eyeIconElement.isDisplayed());
        assertTrue(writeIconElement.isDisplayed());
        assertTrue(trashIconElement.isDisplayed());
	}
	
	@Test
	public void tc20ViewTheNewlyCreatedPos() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/posts/single-post/3180/what-is-lorem-ipsum");

        WebElement eyeIcon = driver.findElement(By.xpath("//i[@class='fas fa-eye']"));
        eyeIcon.click();

        WebElement categoryField = driver.findElement(By.xpath("//div[@class='div.widget.categories']/span[contains(@class, 'category')]"));
        WebElement titleField = driver.findElement(By.xpath("//div[@class='a.navbar-brand']/h2[contains(@class, 'title')]"));
        WebElement authorField = driver.findElement(By.xpath("//div[@class='author d-flex align-items-center flex-wrap']/span[contains(@class, 'author')]"));
        WebElement timeField = driver.findElement(By.xpath("//div[@class='div.date']/span[contains(@class, 'time')]"));
        WebElement viewsField = driver.findElement(By.xpath("//div[@class='div.views']/span[contains(@class, 'views')]"));
        WebElement commentsField = driver.findElement(By.xpath("//div[@class='usercomment.form-control']/span[contains(@class, 'comments')]"));
        WebElement textField = driver.findElement(By.xpath("//div[@class='post-details']/p[contains(@class, 'text')]"));
        WebElement tagsField = driver.findElement(By.xpath("//div[@class='div.widget.tags']/span[contains(@class, 'tags')]"));
       
        assertTrue(categoryField.isDisplayed());
        assertTrue(titleField.isDisplayed());
        assertTrue(authorField.isDisplayed());
        assertTrue(timeField.isDisplayed());
        assertTrue(viewsField.isDisplayed());
        assertTrue(commentsField.isDisplayed());
        assertTrue(textField.isDisplayed());
        assertTrue(tagsField.isDisplayed());
	}
	
	@Test
	public void tc21EditTheNewlyAddedPostEditContentOnly() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts");

        WebElement editIcon = driver.findElement(By.xpath("//i[@class='fas fa-edit']"));
        editIcon.click();

        WebElement contentField = driver.findElement(By.name("content"));
        contentField.clear();
        contentField.sendKeys("It is a long established fact that a reader will be distracted by the " +
                            "readable content of a page when looking at its layout. The point of using Lorem Ipsum " +
                            "is that it has a more-or-less normal distribution of letters, as opposed to using 'Content " +
                            "here, content here', making it look like readable English. Many desktop publishing packages " +
                            "and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem " +
                            "ipsum' will uncover many web sites still in their infancy. Various versions have evolved " +
                            "over the years, sometimes by accident, sometimes on purpose (injected humor and the like).");

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(), 'Save')]"));
        saveButton.click();

        WebElement updatedContent = driver.findElement(By.xpath("//div[@class='post-content']//p[contains(@class, 'text')]"));
        String expectedContent = "It is a long established fact that a reader will be distracted by the " +
                                 "readable content of a page when looking at its layout. The point of using Lorem Ipsum " +
                                 "is that it has a more-or-less normal distribution of letters, as opposed to using 'Content " +
                                 "here, content here', making it look like readable English. Many desktop publishing packages " +
                                 "and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem " +
                                 "ipsum' will uncover many web sites still in their infancy. Various versions have evolved " +
                                 "over the years, sometimes by accident, sometimes on purpose (injected humor and the like).";
        assertEquals(expectedContent, updatedContent.getText());
        
    }
	

	@Test
	public void tc22DeleteThePost() {
		
		driver.get("https://testblog.kurs-qa.cubes.edu.rs/admin/posts");

        WebElement trashIcon = driver.findElement(By.xpath("//i[@class='fas fa-trash']"));
        trashIcon.click();

        WebElement deletePostTitle = driver.findElement(By.xpath("//div[@class='modal-title']"));
        assertEquals("Delete Post", deletePostTitle.getText());

        WebElement postName = driver.findElement(By.xpath("//div[@class='modal-body']//h4"));
        assertEquals("What is Lorem Ipsum?", postName.getText());

        WebElement deleteButton = driver.findElement(By.xpath("//btn btn-danger, 'Delete')]"));
        deleteButton.click();

        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
