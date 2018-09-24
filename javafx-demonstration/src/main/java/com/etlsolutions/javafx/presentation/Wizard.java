package com.etlsolutions.javafx.presentation;

import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author zc
 */
public abstract class Wizard extends StackPane {

    private static final int UNDEFINED = -1;

    private final Stage stage;
    private final WizardDataModel model;
    private final Stack<Integer> history;
    protected final ObservableList<WizardPage> pages;

    private int curPageIdx = UNDEFINED;

    public Wizard(Stage stage, WizardDataModel model) {

        this.stage = stage;
        this.model = model;
        history = new Stack<>();
        pages = FXCollections.observableArrayList();
    }

    public abstract boolean hasNextPage();

    public abstract int indexOf(Node page);

    public void nextPage() {
        if (hasNextPage()) {
            navigateTo(curPageIdx + 1, true);
        }
    }

    public void priorPage() {
        if (hasPriorPage()) {
            navigateTo(history.pop(), false);
        }
    }

    boolean hasPriorPage() {
        return !history.isEmpty();
    }

    private void navigateTo(int nextPageIdx, boolean pushHistory) {

        if (curPageIdx != UNDEFINED) {
            if (pushHistory) {
                history.push(curPageIdx);
            }
        }

        WizardPage nextPage = pages.get(nextPageIdx);
        curPageIdx = nextPageIdx;
        getChildren().clear();
        getChildren().add(nextPage);
        nextPage.manageButtons();
    }

    public void finish() {
        model.save();
        stage.close();
    }

    public void cancel() {
        stage.close();
    }
}
