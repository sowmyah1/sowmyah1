import org.example.HomePage;
import org.example.model.Item;
import org.example.pages.LauncherPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class SearchTest {
    @Test
    public void verifyIfSearchTermShowsRelevantResults() {

        //Arrange
        String searchItem = "Jeans";
        String searchKey = "Jean";
        WebDriver webDriver=null;
        LauncherPage launcherPage = new LauncherPage(webDriver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

//        Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();

        //Assert
        Assert.assertEquals(4, searchItems.size());
        Assertions.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));

    }

}
