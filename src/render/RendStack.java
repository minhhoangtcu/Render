/*
 * Josh Marasigan
 * [Render]
 * <RenStack.java>
 * */
package render;

import java.util.Stack;

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

public class RendStack {
	
	// Class field to display Array Nodes.
	private static GridPane stackPane;
	private static int length;
	private static Stack<Integer> valueStack = new Stack<Integer>();
	private static HBox gridDiv;
	private static ImageView grnArrow;
	private static ImageView redArrow;
	
	// Constructors
	public RendStack(int len) {
		this.setLength(len);
	}
	
	// Getters and Setters
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		RendStack.length = length;
	}
	
	// Method to Initialize all Nodes pertaining.
	public static void initStackScene() {
		length = 0;
		Main.stackLeft = new VBox(20);
		Main.stackLeft.setEffect(new DropShadow());
		Main.stackLeft.setAlignment(Pos.CENTER);
		Main.stackLeft.setBackground(new Background(Main.stackBG));
		Main.stackLeft.setMinHeight(Main.mheight);
		Main.stackLeft.setMinWidth(Main.mwidth/2);
		Main.stackLeft.setPadding(new Insets(0, 0, 0, 30));
		
		Main.stackRight = new VBox(18);
		Main.stackRight.setAlignment(Pos.CENTER);
		Main.stackRight.setMinHeight(Main.mheight);
		Main.stackRight.setMinWidth(Main.mwidth/2);
		
		// Images
		Image gArrow = new Image("file:greenArrow.png");
		Image rArrow = new Image("file:redArrow.png");
        grnArrow = new ImageView(gArrow);
        redArrow = new ImageView(rArrow);
		
        // Label
		Text stackTitle = new Text("THE STACK (FILO)");
		stackTitle.setStyle(
				"-fx-font: 15px Futura;" + 
				"-fx-font-weight: bold;" +
				"-fx-fill: #6495ed;");
		
		HBox stackTitleBox = new HBox();
		stackTitleBox.setMinHeight(50);
		stackTitleBox.setMaxWidth(230);
		stackTitleBox.setStyle(
				"-fx-border-style: solid;" + 
				"-fx-border-width: 5px;" +
				"-fx-border-color: #6495ed;");
		stackTitleBox.getChildren().add(stackTitle);
		stackTitleBox.setAlignment(Pos.CENTER);
		
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
		boxBtn.setAlignment(Pos.CENTER_LEFT);
		boxBtn.getChildren().add(bBtn);
		
		// Make Stack Label
		Label makeArrLabel = new Label("Format your Stack.");
		makeArrLabel.setTextFill(Color.WHITE);
		makeArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox makeAL = new HBox();
		makeAL.getChildren().add(makeArrLabel);
		makeAL.setAlignment(Pos.CENTER_LEFT);
				
		// Get Add Node
		Label addArrLabel = new Label("Push an Element.");
		addArrLabel.setTextFill(Color.WHITE);
		addArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox lab = new HBox();
		lab.getChildren().add(addArrLabel);
		lab.setAlignment(Pos.CENTER_LEFT);
				
		TextField enqVal = new TextField();
		enqVal.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 50px;" +
				"-fx-text-fill: #4682b4;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #6495ed;");
		
		enqVal.setPromptText("Value");
		
		// Get Remove Node
		Label remArrLabel = new Label("Pop an Element.");
		remArrLabel.setTextFill(Color.WHITE);
		remArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox rLab = new HBox();
		rLab.getChildren().add(remArrLabel);
		rLab.setAlignment(Pos.CENTER_LEFT);
				
		// Right Side
		stackPane = new GridPane();
	    stackPane.setHgap(10);
	    stackPane.setVgap(1);
	    stackPane.setPadding(new Insets(0, 0, 0, Main.mwidth/7 + 10));
		gridDiv = new HBox();
		gridDiv.getChildren().addAll(stackPane);
		
		// Temp Values for Grid
		randomPopulate();
		displayShell();

		// Event Handler for Stack
		Button rendStack = new Button("FORMAT");
		rendStack.setStyle("-fx-border-radius: 0;");
		rendStack.setStyle("-fx-backround-radius: 0;");
		rendStack.setStyle("-fx-background-color: #4682b4;");
		rendStack.setTextFill(Color.WHITE);
		
		HBox getLen = new HBox(5);
		getLen.setAlignment(Pos.CENTER_LEFT);
		getLen.getChildren().addAll(
				rendStack);
		
		// Hover animation.
		rendStack.setOnMouseEntered(e -> {
			rendStack.setOpacity(.5);
		});
		rendStack.setOnMouseExited(e -> {
			rendStack.setOpacity(1);
		});
		
		// Event Handler for Stack
		Button enqBtn = new Button("PUSH");
		enqBtn.setStyle("-fx-border-radius: 0;");
		enqBtn.setStyle("-fx-backround-radius: 0;");
		enqBtn.setStyle("-fx-background-color: #4682b4;");
		enqBtn.setTextFill(Color.WHITE);
		
		enqBtn.setOnMouseEntered(e -> {
			enqBtn.setOpacity(.5);
		});
		enqBtn.setOnMouseExited(e -> {
			enqBtn.setOpacity(1);
		});
		
		HBox getAdd = new HBox(8);
		getAdd.setAlignment(Pos.CENTER_LEFT);
		getAdd.getChildren().addAll(
				enqVal,
				enqBtn);
		
		// Event Handler for Stack
		Button remqBtn = new Button("POP");
		remqBtn.setStyle("-fx-border-radius: 0;");
		remqBtn.setStyle("-fx-backround-radius: 0;");
		remqBtn.setStyle("-fx-background-color: #4682b4;");
		remqBtn.setTextFill(Color.WHITE);
		
		remqBtn.setOnMouseEntered(e -> {
			remqBtn.setOpacity(.5);
		});
		remqBtn.setOnMouseExited(e -> {
			remqBtn.setOpacity(1);
		});
		
		HBox remBox = new HBox(5);
		remBox.setAlignment(Pos.CENTER_LEFT);
		remBox.getChildren().addAll(remqBtn);
		
		// Left Div
		Main.stackLeft.getChildren().addAll(
				boxBtn,
				makeAL,
				getLen,
				lab,
				getAdd,
				rLab,
				remBox);
		
		// Right Div
		Main.stackRight.setAlignment(Pos.TOP_CENTER);
		Main.stackRight.setPadding(new Insets(20, 0, 0, 0));
		Main.stackRight.setMaxHeight(400);
		Main.stackRight.getChildren().addAll(
				stackTitleBox,
				stackPane);
		
		// Combine both Divs
		Main.stackDiv.setAlignment(Pos.CENTER);
		Main.stackDiv.setBackground(new Background(Main.stackBG1));
		Main.stackDiv.getChildren().addAll(
				Main.stackLeft,
				Main.stackRight);
		
		Main.stackScene = new Scene(
				Main.stackDiv,
				Main.mwidth,
				Main.mheight);
		
		/* --------------------------------- */
		/* [RendStack Button Event Handlers] */
		/* --------------------------------- */
		
		// Display Shell for Stack.
		rendStack.setOnAction(e -> {
			try {
				// Clear Grid before populating.
				stackPane.getChildren().clear();
				
				length = 0;
				valueStack.clear();
				displayShell();
			}
			catch (NumberFormatException e1) {
			     // Display Try Again
			}
			catch (Exception e2) {
				e2.printStackTrace(System.out);
			}
		});
		
		// Add and display new element.
		enqBtn.setOnAction(e -> {
			try {
				// Check input validity. Must be an integer!
				if((!enqVal.getText().isEmpty())
					&& (enqVal.getText() != null)){	
					
					// Test and apply value input
					String valInput = enqVal.getText();
					Integer valTemp = Integer.parseInt(valInput);
					
					// Add value to stack.
					addToStack(valTemp);
					
					// Clear Grid before populating.
					stackPane.getChildren().clear();
					
					// Populate Grid
					displayShell();
					populateShell();
		
					// Indicate Add Arrow
					if(length-1>0) {
						stackPane.add(grnArrow, 2, length-1);
					}
				}
				enqVal.clear();
			}
			catch (NumberFormatException e1) {
			     // Display Try Again
			}
			catch (Exception e2) {
				e2.printStackTrace(System.out);
			}
		});
		
		// Remove element from stack and scene.
		remqBtn.setOnAction(e -> {
			try {
				if(length == 1) {
					removeFromStack();
					
					// Clear Grid before populating.
					stackPane.getChildren().clear();
					
					// Populate Grid
					displayShell();
					populateShell();
					
					stackPane.add(redArrow, 2, 0);
				}
				else if(length > 0){
					removeFromStack();
					
					// Clear Grid before populating.
					stackPane.getChildren().clear();
					
					// Populate Grid
					displayShell();
					populateShell();
					
					stackPane.add(redArrow, 2, 0);
				}
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
		int rand = (int) (Math.random()*10);
		for(int i = 0; i < rand; ++i) {
			Integer showInt = new Integer((int) (Math.random()*101));
			HBox hold = new HBox();
			hold.getChildren().add(new Text(showInt.toString()));
			hold.setAlignment(Pos.CENTER);
			valueStack.add(showInt);
			stackPane.add(hold, column, i);
			++length;
		}
	}
	
	// Event Handler to display Stack (Just Shell)
	private static void displayShell() {		
		// Add index markers to left of shell to stackPane.
		int column = 0;
		for(Integer row = 0; row < length; row++) {
			// Shell Div
			Text temp = new Text(row.toString());
			stackPane.add(temp, column, row);
		}
		
		// Add shells to stackPane.
		++column;
		for(int row = 0; row < length; row++) {
			// Shell Div
			HBox temp = new HBox();
			temp.setMinHeight(30);
			temp.setMinWidth(140);
			temp.setStyle("-fx-border-color: #dcdcdc;");
			stackPane.add(temp, column, row);
		}
		
		// Add index markers to left of shell to stackPane.
		column = 2;
		for(int row = 0; row < length; row++) {
			// Shell Div
			HBox temp = new HBox();
			temp.setMinHeight(30);
			temp.setMinWidth(100);
			stackPane.add(temp, column, row);
		}
	}
	
	// Event Handler to append input value to List
	private static void addToStack(Integer val) {		
		// Local node fields to avoid Concurrency error.
		valueStack.add(val);
		// SoundFX
		Main.anotherFX.play();
		++length;
		return;
	}
	
	// Event Handler to remove value by Index from List
	private static void removeFromStack() {		
		// Check if stack has value already at index.
		valueStack.remove(0);
		// SoundFX
		Main.clickFX.play();
		--length;
		return;
	}
	
	// Event Handler to display Stack (Actual Values)
	private static void populateShell() {
		// Get element node population and append.		
		int column = 1;
		int row = 0;
		for(Integer tem : valueStack) {
			Integer showInt = tem;
			HBox hold = new HBox();
			hold.getChildren().add(new Text(showInt.toString()));
			hold.setAlignment(Pos.CENTER);
			stackPane.add(hold, column, row);
			++row;
		}
	}
}
