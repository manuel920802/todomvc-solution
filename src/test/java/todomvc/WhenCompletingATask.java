package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

@RunWith(SerenityRunner.class)
public class WhenCompletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;
    @Steps
    TodoListActions todoList;

    @Before
    public void openApp(){
        todoList.openApplication();
    }
    @Test
    public void activeTasksShouldNotShowCompletedTasks(){
        //Add "Feed the cat" and walk the dog to the list
        todoList.addItems("Feed the cat", "Walk the dog");

        //Complete "Feed the cat"
        todoList.completeItem("Feed the cat");

        //Filter by "Active"
        todoList.filterBy("Active");

        //Check that only "Walk the dog appears"
        Serenity.reportThat("Only 'Walk the dog' should appear ",
                () -> Assertions.assertThat(todoList.items()).containsExactly("Walk the dog")
        );
    }

    @Test
    public void completedTasksShouldNotShownActiveTasks(){
        // Add "Feed the cat" and "Walk the dog" to the list
        todoList.addItems("Feed the cat", "Walk the dog");

        //Complete "Feed the cat"
        todoList.completeItem("Feed the cat");

        //Filter by "Completed"
        todoList.filterBy("Completed");

        //Check that only "Feed the cat" appears
        Serenity.reportThat("Only 'Walk the dog' should appear ",
                () -> Assertions.assertThat(todoList.items()).containsExactly("Feed the cat")
        );
    }
}

