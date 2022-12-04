package steps;

import assertion.Validation;
import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LessonPage;
import pages.SearchPage;
import utilities.images.Screenshots;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchSteps extends BaseTest {
    private static LessonPage lessonPage;
    private static HomePage homePage;
    private static SearchPage searchPage;
    @Given("user open Nagwa home page")
    public void user_open_nagwa_home_page() {
        homePage=new HomePage(getDriver());
    }
    @Given("user choose {string} language")
    public void user_choose_language(String language) {
        homePage.setLanguage(language);
    }
    @When("user search for {string} lesson on search bar")
    public void user_search_for_lesson_on_search_bar(String input) {
        searchPage=homePage.clickOnSearch()
                .searchFor(input)
                .submit();
    }
    @When("a list with all lessons that match the {string} will appear")
    public void a_list_with_all_lessons_that_match_the_will_appear(String string) {
        Validation
                .using(getDriver())
                .shouldHaveTitle("Search")
                .shouldContain(searchPage.secondLink,string);
    }
    @When("user click on link {int} in the search results")
    public void user_click_on_link_in_the_search_results(int number) {
        lessonPage =searchPage.clickOnLink(number);
    }
    @When("user go to the worksheet section")
    public void user_go_to_the_worksheet_section() {
        lessonPage.goToWorksheet();
    }
    @Then("{string} home page will open")
    public void home_page_will_open(String string) {
        Validation.using(getDriver())
                .pageContainTitle(string);
    }
    @Then("all the questions are displayed")
    public void the_count_number_of_questions_displayed_on_it_equals_to() {
        System.out.println("Number of the questions found is "+" "+lessonPage.getQuestionsCount());
        Screenshots.captureFullPage(getDriver(),"worksheet-home-page");
        assertThat(lessonPage.getQuestionsCount())
                .isNotZero();
        ExtentCucumberAdapter.getCurrentStep().log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshots.getBase64Screenshot(getDriver())).build());
    }

}
