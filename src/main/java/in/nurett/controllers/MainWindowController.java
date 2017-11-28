package in.nurett.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindowController {
    public TextField ConnectionsFilter;
    public TreeView Connections;
    public SplitPane ResultSplit;
    public SplitPane TreeSplit;
    public VBox TreeVBox;

    public void initialize(){
        Scene scene = ResultSplit.getScene();

    }
}
