package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenDeletingATask {

    @Managed(driver = "Chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @Before
    public void openApp(){
        todoList.openApplication();
    }
    @Test
    public void deletedItemsShouldDissapearFromTheList(){
        //Add "Feed the cat" and "Walk the dog" to the list
        todoList.addItems("Feed the cat", "Walk the dog");

        //Delete "Feed the cat"
        todoList.deleteItem("Feed the cat");

        //Check that only "Walk the dog" appears
        Serenity.reportThat("Only 'Walk the dog' should appear",
                () -> assertThat(todoList.items()).containsExactly("Walk the dog")
        );
    }

}
