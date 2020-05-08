package ch.supsi.guiframework.component;


import ch.supsi.guiframework.command.Command;
import ch.supsi.guiframework.model.AbstractModelObject;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

abstract public class MyAbstractTableView {

    private TableView tableView;

    protected MyAbstractTableView() {
        this.setActualComponent(new TableView());
    }

    public TableView getActualComponent() {
        return tableView;
    }

    protected void setActualComponent(TableView tableView) {
        this.tableView = tableView;
    }

    // TODO
    public TableView getActualComponentById(String id) { return null; }

    public void setEditable(boolean isEditable) {
        tableView.setEditable(isEditable);
    }

    public void setItems(ObservableList<?> items) {
        tableView.setItems(items);
    }

    public void addColumn(String columnHeader) {
        tableView.getColumns().add(new TableColumn<>(columnHeader));
    }

    public void addColumns(String... columnHeaders) {
        for (String columnHeader : columnHeaders) {
            this.addColumn(columnHeader);
        }
    }

    public void clear() {
        tableView.getColumns().clear();
        tableView.setItems(null);
    }

    public void setCellValueFactory(int index, String name) {
        ObservableList<TableColumn> observableList = tableView.getColumns();
        ((TableColumn)observableList.get(index)).setCellValueFactory(
                new PropertyValueFactory(name)
        );
    }

    public void setSingleSelectionMode() {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void setMultipleSelectionMode() {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void setSingleSelectionCommand(Command command) {
        if (command != null) {
            tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
                    System.out.println("selected row at index..." + selectedIndex);
                    AbstractModelObject abstractModelObject = (AbstractModelObject)tableView.getSelectionModel().getSelectedItem();
                    System.out.println("selected object id..." + abstractModelObject.getId());
                }
            });
        }
    }

}
