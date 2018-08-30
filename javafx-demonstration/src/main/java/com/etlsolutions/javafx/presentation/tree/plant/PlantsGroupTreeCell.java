package com.etlsolutions.javafx.presentation.tree.plant;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ContextMenuBuilder;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.cell.TextFieldTreeCell;

/**
 *
 * @author zc
 */
public class PlantsGroupTreeCell extends TextFieldTreeCell<String> {
    private ContextMenu rootContextMenu;

    public PlantsGroupTreeCell() {
        // instantiate the root context menu
        rootContextMenu = 
            ContextMenuBuilder.create()
                .items(
                        MenuItemBuilder.create()
                            .text("Menu Item")
                            .onAction(
                                new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent arg0) {
                                        System.out.println("Menu Item Clicked!");                                           
                                    }
                                }
                            )
                            .build()
                    )
                .build();
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        // if the item is not empty and is a root...
        if (!empty && getTreeItem().getParent() == null) {
            setContextMenu(rootContextMenu);
        }
    }
}