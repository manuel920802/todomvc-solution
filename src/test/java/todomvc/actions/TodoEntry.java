package todomvc.actions;

public class TodoEntry {
    public static final String COMPLETE_CHECKBOX = "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    public static final String ITEM_LABEL = "//label[.='{0}']";
    public static final String DELETE_ICON = "//label[.='{0}']/following-sibling::button[@class='destroy']";
}