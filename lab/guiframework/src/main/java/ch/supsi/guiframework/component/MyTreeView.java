package ch.supsi.guiframework.component;

import javafx.scene.control.TreeView;


abstract public class MyTreeView {

    private TreeView treeView;

    protected MyTreeView() {
        // set actual framework tree view component
        this.treeView = new TreeView();
    }

    public TreeView getTreeView() {
        return treeView;
    }

    public void setRoot(MyTreeItem root) {
        treeView.setRoot(root.getTreeItem());
    }

}
