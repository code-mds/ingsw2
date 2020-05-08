package ch.supsi.guiframework.component;

import javafx.scene.control.TreeItem;


public class MyTreeItem<T> {

    private TreeItem<T> treeItem;

    public MyTreeItem(T value) {
        this.treeItem = new TreeItem<>(value);
    }

    public TreeItem<T> getTreeItem() {
        return treeItem;
    }

    public boolean add(MyTreeItem child) {
        return treeItem.getChildren().add(child.treeItem);
    }

    public T getValue() {
        return treeItem.getValue();
    }

    public void setValue(T value) {
        treeItem.setValue(value);
    }

}
