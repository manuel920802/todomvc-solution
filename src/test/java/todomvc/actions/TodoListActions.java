package todomvc.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import java.util.Arrays;
import java.util.List;

import static todomvc.actions.TodoEntry.*;
import static todomvc.actions.TodoListForm.*;


public class TodoListActions extends UIInteractionSteps {

    @Step("Open the TodoMVC application")
    public void openApplication(){
        openPageNamed("home");
    }

    @Step("Add item {0}")
    public void addItem(String item){
        $(NEW_TODO_FIELD).typeAndEnter(item);
    }

    public void addItems(String... items){
        addItems(Arrays.asList(items));
    }

    @Step("Add items {0}")
    public void addItems(List<String> items){
        items.forEach(this::addItem);
    }

    public List<String> items(){
        return $$(ITEM_LABELS).texts();
    }

    public Integer itemLeftCount(){
        return Integer.parseInt($(ITEM_LEFT_COUNT).getText());
    }

    @Step("Complete item {0}")
    public void completeItem(String item){
        $(COMPLETE_CHECKBOX,item).click();
    }

    @Step("Filter tasks by {0}")
    public void filterBy(String filter){
        $(FILTER_BUTTON,filter).click();
    }

    @Step("Delete task {0}")
    public void deleteItem(String item){
        $(ITEM_LABEL,item).click();
        $(DELETE_ICON,item).click();
    }


}
