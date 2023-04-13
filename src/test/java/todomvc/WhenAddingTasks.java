package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenAddingTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @Before
    public void openApp(){
        todoList.openApplication();
    }

    @Test
    public void addingASingleTask(){
        //Add "Feed the Cat" to the list
        todoList.addItem("Feed The Cat");

        //Check that "Feed The Cat" appears in the list
        Serenity.reportThat("The todo list should contain 'Feed The Cat' ",
                () -> assertThat(todoList.items()).containsExactly("Feed The Cat")
        );

        //Check the list count is 1
        Serenity.reportThat("The todo list count should be 1",
                () -> assertThat(todoList.itemLeftCount()).isEqualTo(1)
        );
    }

    @Test
    public void addingMultipleTasks(){
        // Add "Feed The Cat" and "Walk the dog" to the list
        todoList.addItems("Feed the cat", "Walk the dog");

        //Check they all appear in the list
        Serenity.reportThat("The todo list should contain 'Feed the cat', 'Walk the dog' ",
                () -> assertThat(todoList.items()).containsExactly("Feed the cat", "Walk the dog")
        );

        //Check the list count is 2
        Serenity.reportThat("The todo list count should be 2",
                () -> assertThat(todoList.itemLeftCount()).isEqualTo(2)
        );
    }

}