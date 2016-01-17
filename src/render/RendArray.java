/*
 * Josh Marasigan
 * [Render]
 * <RendArray.java>
 * */
package render;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/* -------------------------- */
/* ['ARRAY' SCENE CONTROLLER] */
/* -------------------------- */
public class RendArray extends Node {
	
	// Class field to display Array Nodes.
	private static GridPane arrayPane;
	private static int length;
	private static ArrayList<Node> valueList = new ArrayList<Node>();
	private static HBox gridDiv;
	private static ImageView grnArrow;
	private static ImageView redArrow;
	
	// Constructors
	public RendArray(int len) {
		this.setLength(len);
	}
	
	// Getters and Setters
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		RendArray.length = length;
	}
	
	// Method to Initialize all Nodes pertaining.
	public static void initArrayScene() {
		Main.arrLeft = new VBox(20);
		Main.arrLeft.setEffect(new DropShadow());
		Main.arrLeft.setAlignment(Pos.CENTER);
		Main.arrLeft.setBackground(new Background(Main.arrBG));
		Main.arrLeft.setMinHeight(Main.mheight);
		Main.arrLeft.setMinWidth(Main.mwidth/2);
		Main.arrLeft.setPadding(new Insets(0, 30, 0, 0));
		
		Main.arrRight = new VBox(18);
		Main.arrRight.setAlignment(Pos.CENTER);
		Main.arrRight.setMinHeight(Main.mheight);
		Main.arrRight.setMinWidth(Main.mwidth/2);
		
		// Images
		Image gArrow = new Image("file:greenArrow.png");
		Image rArrow = new Image("file:redArrow.png");
        grnArrow = new ImageView(gArrow);
        redArrow = new ImageView(rArrow);
		
        // Label
		Text arrTitle = new Text("THE ARRAY STRUCTURE");
		arrTitle.setStyle(
				"-fx-font: 15px Futura;" + 
				"-fx-font-weight: bold;" +
				"-fx-fill: #66CDAA;");
		
		HBox arrTitleBox = new HBox();
		arrTitleBox.setMinHeight(50);
		arrTitleBox.setMaxWidth(230);
		arrTitleBox.setStyle(
				"-fx-border-style: solid;" + 
				"-fx-border-width: 5px;" +
				"-fx-border-color: #66CDAA;");
		arrTitleBox.getChildren().add(arrTitle);
		arrTitleBox.setAlignment(Pos.CENTER);
		
		// Back Button
		Image back = new Image("file:backBtn.png");
		Button bBtn = new Button();
		bBtn.setPadding(Insets.EMPTY);
		bBtn.setStyle("-fx-background-color: transparent;");
		bBtn.setGraphic(new ImageView(back));
		bBtn.setOnMouseEntered(e -> {
			bBtn.setOpacity(.5);
		});
		bBtn.setOnMouseExited(e -> {
			bBtn.setOpacity(2);
		});
		bBtn.setOnAction(e -> {
			Main.stage.setScene(Main.structMenu);
		});
		HBox boxBtn = new HBox();
		boxBtn.setAlignment(Pos.CENTER_RIGHT);
		boxBtn.getChildren().add(bBtn);
		
		// Make Array Label
		Label makeArrLabel = new Label("Initialize your Array.");
		makeArrLabel.setTextFill(Color.WHITE);
		makeArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox makeAL = new HBox();
		makeAL.getChildren().add(makeArrLabel);
		makeAL.setAlignment(Pos.CENTER_RIGHT);
		
		// Get Max Length
		TextField maxLen = new TextField();
		maxLen.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 100px;" +
				"-fx-text-fill: #505050;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #66CDAA;");
		maxLen.setPromptText("Size, Max 10");
		
		// Get Add Node
		Label addArrLabel = new Label("Add an Element.");
		addArrLabel.setTextFill(Color.WHITE);
		addArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox lab = new HBox();
		lab.getChildren().add(addArrLabel);
		lab.setAlignment(Pos.CENTER_RIGHT);
		
		TextField addArrNode = new TextField();
		addArrNode.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 50px;" +
				"-fx-text-fill: #505050;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #66CDAA;");
		addArrNode.setPromptText("Index");
		
		TextField addArrVal = new TextField();
		addArrVal.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 50px;" +
				"-fx-text-fill: #505050;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #66CDAA;");
		
		addArrVal.setPromptText("Value");
		
		// Get Remove Node
		Label remArrLabel = new Label("Remove an Element.");
		remArrLabel.setTextFill(Color.WHITE);
		remArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox rLab = new HBox();
		rLab.getChildren().add(remArrLabel);
		rLab.setAlignment(Pos.CENTER_RIGHT);
		
		TextField remArrNode = new TextField();
		remArrNode.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 100px;" +
				"-fx-text-fill: #505050;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #66CDAA;");
		remArrNode.setPromptText("Index");
		
		// Right Side
		arrayPane = new GridPane();
	    arrayPane.setHgap(10);
	    arrayPane.setVgap(1);
	    arrayPane.setPadding(new Insets(0, 0, 0, Main.mwidth/7 + 10));
		gridDiv = new HBox();
		gridDiv.getChildren().addAll(arrayPane);
		
		// Temp Values for Grid
		randomPopulate();
		displayShell();

		// Event Handler for Array
		Button rendArray = new Button("NEW ARRAY");
		rendArray.setStyle("-fx-border-radius: 0;");
		rendArray.setStyle("-fx-backround-radius: 0;");
		rendArray.setStyle("-fx-background-color: #505050;");
		rendArray.setTextFill(Color.WHITE);
				
		HBox getLen = new HBox(5);
		getLen.setAlignment(Pos.CENTER_RIGHT);
		getLen.getChildren().addAll(
				maxLen,
				rendArray);
		
		// Hover animation.
		rendArray.setOnMouseEntered(e -> {
			rendArray.setOpacity(.5);
		});
		rendArray.setOnMouseExited(e -> {
			rendArray.setOpacity(1);
		});
		
		// Event Handler for Array
		Button addArrBtn = new Button("INSERT");
		addArrBtn.setStyle("-fx-border-radius: 0;");
		addArrBtn.setStyle("-fx-backround-radius: 0;");
		addArrBtn.setStyle("-fx-background-color: #505050;");
		addArrBtn.setTextFill(Color.WHITE);
		
		addArrBtn.setOnMouseEntered(e -> {
			addArrBtn.setOpacity(.5);
		});
		addArrBtn.setOnMouseExited(e -> {
			addArrBtn.setOpacity(1);
		});
		
		HBox getAdd = new HBox(8);
		getAdd.setAlignment(Pos.CENTER_RIGHT);
		getAdd.getChildren().addAll(
				addArrNode,
				addArrVal,
				addArrBtn);
		
		// Event Handler for Array
		Button remArrBtn = new Button("REMOVE");
		remArrBtn.setStyle("-fx-border-radius: 0;");
		remArrBtn.setStyle("-fx-backround-radius: 0;");
		remArrBtn.setStyle("-fx-background-color: #505050;");
		remArrBtn.setTextFill(Color.WHITE);
		
		remArrBtn.setOnMouseEntered(e -> {
			remArrBtn.setOpacity(.5);
		});
		remArrBtn.setOnMouseExited(e -> {
			remArrBtn.setOpacity(1);
		});
		
		HBox remBox = new HBox(5);
		remBox.setAlignment(Pos.CENTER_RIGHT);
		remBox.getChildren().addAll(remArrNode, remArrBtn);
		
		// Left Div
		Main.arrLeft.getChildren().addAll(
				boxBtn,
				makeAL,
				getLen,
				lab,
				getAdd,
				rLab,
				remBox);
		
		// Right Div
		Main.arrRight.setAlignment(Pos.TOP_CENTER);
		Main.arrRight.setPadding(new Insets(20, 0, 0, 0));
		Main.arrRight.setMaxHeight(400);
		Main.arrRight.getChildren().addAll(
				arrTitleBox,
				arrayPane);
		
		// Combine both Divs
		Main.arrDiv.setAlignment(Pos.CENTER);
		Main.arrDiv.setBackground(new Background(Main.arrBG1));
		Main.arrDiv.getChildren().addAll(
				Main.arrRight,
				Main.arrLeft); // Decided to switch sides.
		
		Main.arrayScene = new Scene(
				Main.arrDiv,
				Main.mwidth,
				Main.mheight);
		
		/* --------------------------------- */
		/* [RendArray Button Event Handlers] */
		/* --------------------------------- */
		
		// Display Shell for Array.
		rendArray.setOnAction(e -> {
			try {
				// Check input validity. Must be an integer!
				if((!maxLen.getText().isEmpty()) && (maxLen.getText() != null)) {
					
					// Clear Grid before populating.
					arrayPane.getChildren().clear();
					
					length = 0;
					valueList.clear();
					String input = maxLen.getText();
					length = Integer.parseInt(input);
					maxLen.setText(null);
					displayShell();
				}
				maxLen.clear();
			}
			catch (NumberFormatException e1) {
			     // Display Try Again
			}
			catch (Exception e2) {
				e2.printStackTrace(System.out);
			}
		});
		
		// Add and display new element.
		addArrBtn.setOnAction(e -> {
			try {
				// Check input validity. Must be an integer!
				if((!addArrNode.getText().isEmpty())
					&& (!addArrVal.getText().isEmpty())
					&& (addArrVal.getText() != null)
					&& (addArrNode.getText() != null))
				{	
					// Test and apply index input
					String indexInput = addArrNode.getText();
					Integer indexTemp = Integer.parseInt(indexInput);
					
					// Test and apply value input
					String valInput = addArrVal.getText();
					Integer valTemp = Integer.parseInt(valInput);
					
					// No Exceptions thrown. Check Validity
					// Cannot Add. Error.
					if((indexTemp < length) && (indexTemp >= 0)) {
						addToList(indexTemp, valTemp);
						
						// Clear Grid before populating.
						arrayPane.getChildren().clear();
						
						// Populate Grid
						displayShell();
						populateShell();
												
						// Indicate Add Arrow
						arrayPane.add(grnArrow, 2, indexTemp);
					}
				}
				addArrNode.clear();
				addArrVal.clear();
			}
			catch (NumberFormatException e1) {
			     // Display Try Again
			}
			catch (Exception e2) {
				e2.printStackTrace(System.out);
			}
		});
		
		// Remove element from array and scene.
		remArrBtn.setOnAction(e -> {
			try {
				// Check validity. Must be integer for index.
				if((!remArrNode.getText().isEmpty()) && (remArrNode.getText() != null)) {
					// Test and apply index input
					String indexInput = remArrNode.getText();
					Integer indexTemp = Integer.parseInt(indexInput);
					
					// If Cannot Remove. Out of bounds Error.
					if((indexTemp < length)
							&& (indexTemp >= 0)
							&& (isAnElement(indexTemp))
							){
						// Clear Grid before populating.
						arrayPane.getChildren().clear();
						
						// Popualte the List.
						removeFromList(indexTemp);
						displayShell();
						populateShell();
						
						// Indicate remove arrow
						arrayPane.add(redArrow, 2, indexTemp);
					}
				}
				remArrNode.clear();
			}
			catch (NumberFormatException e1) {
			     // Display Try Again
			}
			catch (Exception e2) {
				e2.printStackTrace(System.out);
			}
		});
	}
	
	// Add Random Values To Shell
	private static void randomPopulate() {
		// Get element node population and append.
		int column = 1;
		for(int i = 0; i < 9; ++i) {
			Integer showInt = new Integer((int) (Math.random()*101));
			HBox hold = new HBox();
			hold.getChildren().add(new Text(showInt.toString()));
			if(showInt > 45) {
				hold.setAlignment(Pos.CENTER);
				arrayPane.add(hold, column, i);
				valueList.add(new Node(i, showInt));
			}
		}
		// Initial Value
		length = 9;
	}
	
	// Event Handler to display Array (Just Shell)
	private static void displayShell() {
		// Add index markers to left of shell to arrayPane.
		int column = 0;
		for(Integer row = 0; row < length; row++) {
			// Shell Div
			Text temp = new Text(row.toString());
			arrayPane.add(temp, column, row);
		}
		
		// Add shells to arrayPane.
		++column;
		for(int row = 0; row < length; row++) {
			// Shell Div
			HBox temp = new HBox();
			temp.setMinHeight(30);
			temp.setMinWidth(140);
			temp.setStyle("-fx-border-color: #dcdcdc;");
			arrayPane.add(temp, column, row);
		}
		
		// Add index markers to left of shell to arrayPane.
		column = 2;
		for(int row = 0; row < length; row++) {
			// Shell Div
			HBox temp = new HBox();
			temp.setMinHeight(30);
			temp.setMinWidth(100);
			arrayPane.add(temp, column, row);
		}
	}
	
	// Event Handler to append input value to List
	private static void addToList(int ind, Integer val) {		
		// Local node fields to avoid Concurrency error.
		Node append = new Node(ind, val);
		
		// SoundFX
		Main.clickFX.play();
		
		// Check if array has value already at index.
		removeFromList(ind);
		
		// Base case.
		valueList.add(append);
	}
	
	// Check if in list
	private static boolean isAnElement(Integer ind) {
		// Check if array has value already at index.
		Node remove = null;
		for (Node temp : valueList) {
			if(temp.getIndex() == ind) {
				remove = temp;
				break;
			}
		}
		
		// Remove node if found
		if(remove != null) {
			return true;
		}
		return false;
	}
	
	// Event Handler to remove value by Index from List
	private static void removeFromList(Integer indexTemp) {		
		// Check if array has value already at index.
		Node remove = null;
		for (Node temp : valueList) {
			if(temp.getIndex() == indexTemp) {
				remove = temp;
				break;
			}
		}
		
		// SoundFX
		Main.clickFX.play();
		
		// Remove node if found
		if(remove != null) {
			valueList.remove(remove);
		}
		return;
	}
	
	// Event Handler to display Array (Actual Values)
	private static void populateShell() {
		// Get element node population and append.
		int column = 1;
		for(Node temp : valueList) {
			int row = temp.getIndex();
			Integer showInt = temp.getIntVal();
			HBox hold = new HBox();
			hold.getChildren().add(new Text(showInt.toString()));
			hold.setAlignment(Pos.CENTER);
			arrayPane.add(hold, column, row);
		}
	}
}
