package com.ezest.javafx.components.combobox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ComboBoxApplication extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		FlowPane root = new FlowPane();
		root.setVgap(15);
	    root.setStyle("-fx-padding: 30");
	 
	    root.getChildren().add(new Label("Choose your destiny:"));
	 
	    final EMRComboBox<String> combo = new EMRComboBox<String>();
	    //combo.setComboWidth(200);
	    //combo.setStyle("-fx-border-color: black; -fx-border-width: 1");
	    
	    ObservableList<String> list = FXCollections.observableArrayList();
	    for(int i=1;i<100;i++){
	    	list.add("I am option "+i);
	    }
	    //combo.getItems().addAll("I am option 1", "You are option 2", "He is option 3");
	    combo.getItems().addAll(list);
	    combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>()
	    {
	        public void changed(ObservableValue<? extends Object> source, Object oldValue, Object newValue)
	        {
	            System.out.println("Your destiny: " + newValue);
	        }
	    });
	    root.getChildren().add(combo);
	    
	    Button submitBtn = new Button("Submit");
	    submitBtn.setPrefWidth(150);
	    submitBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent paramT) {
				System.out.println("----------------> "+combo.getValue());
			}
		});
	    
	    root.getChildren().addAll(submitBtn);
	    Scene scene = new Scene(root, 300, 200);
	    stage.setScene(scene);
	    scene.getStylesheets().add("styles/combobox.css");
	    stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
