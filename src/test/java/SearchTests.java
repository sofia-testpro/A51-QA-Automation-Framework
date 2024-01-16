import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.SearchPage;

public class SearchTests extends BaseTest {
    //Story:
    //
    //As a user, I want to perform a search to find an existing song
    //Acceptance Criteria:
    //
    //After searching for existing songs, results if matched should be populated on the Search results page.
    //Results should be displayed on each section: Songs, Artist, Album. Also, data should be displayed in each section, no matter what we are looking for: a song, artist or album.
    //Show empty list if searched song\artist\album doesn't exist in the Koel app with the message "no results".
    //Ignore trailing\heading white spaces (Examples: "  chill song " should be searched as "chill song" or "  chill song", "chill song ").
    //Search should be case sensitive
    //User can clear the search query with keyboard and 'x' button. Search results should be cleared on the search field and the search page in each section: song, artist or album.

    @Test
    public void testMatchingSearchResults() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        SearchPage searchPage = new SearchPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mann@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        homePage.accessSearchField();
        searchPage.searchSend("day");




    }

}
