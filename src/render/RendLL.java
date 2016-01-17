/*
 * Josh Marasigan
 * [Render]
 * <RendLL.java>
 * */
package render;

import java.util.LinkedList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/* -------------------------------- */
/* ['LINKED LIST' SCENE CONTROLLER] */
/* -------------------------------- */
public class RendLL extends Node {
	
	// Class field to display linked list Nodes.
	private static GridPane linkPane;
	private static int index;
	private static LinkedList<Node> valueList = new LinkedList<Node>();
	private static HBox gridDiv;
	private static ImageView grnArrow;
	private static ImageView redArrow;
	private static int current;
	
	// Method to Initialize all Nodes pertaining.
	public static void initLinkedScene() {
		Main.linkLeft = new VBox(20);
		Main.linkLeft.setEffect(new DropShadow());
		Main.linkLeft.setAlignment(Pos.CENTER);
		Main.linkLeft.setBackground(new Background(Main.linkBG));
		Main.linkLeft.setMinHeight(Main.mheight);
		Main.linkLeft.setMinWidth(Main.mwidth/2);
		Main.linkLeft.setPadding(new Insets(0, 0, 0, 30));
		
		Main.linkRight = new VBox(18);
		Main.linkRight.setAlignment(Pos.CENTER);
		Main.linkRight.setMinHeight(Main.mheight);
		Main.linkRight.setMinWidth(Main.mwidth/2);
		
		// Images
		Image gArrow = new Image("file:greenArrow.png");
		Image rArrow = new Image("file:redArrow.png");
        grnArrow = new ImageView(gArrow);
        redArrow = new ImageView(rArrow);
		
        // Label
		Text linkTitle = new Text("THE LINKED LIST");
		linkTitle.setStyle(
				"-fx-font: 15px Futura;" + 
				"-fx-font-weight: bold;" +
				"-fx-fill: #FFEBCD;");
		
		HBox linkTitleBox = new HBox();
		linkTitleBox.setMinHeight(50);
		linkTitleBox.setMaxWidth(230);
		linkTitleBox.setStyle(
				"-fx-border-style: solid;" + 
				"-fx-border-width: 5px;" +
				"-fx-border-color: #FFEBCD;");
		linkTitleBox.getChildren().add(linkTitle);
		linkTitleBox.setAlignment(Pos.CENTER);
		
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
		
		// Get Add Node
		Label addlinkLabel = new Label("Add a Node.");
		addlinkLabel.setTextFill(Color.WHITE);
		addlinkLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox lab = new HBox();
		lab.getChildren().add(addlinkLabel);
		lab.setAlignment(Pos.CENTER_LEFT);
		
		TextField addlinkNode = new TextField();
		addlinkNode.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 50px;" +
				"-fx-text-fill: #505050;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #66CDAA;");
		addlinkNode.setPromptText("Index");
		
		TextField addlinkVal = new TextField();
		addlinkVal.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 50px;" +
				"-fx-text-fill: #505050;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #66CDAA;");
		
		addlinkVal.setPromptText("Value");
		
		// Get Remove Node
		Label remlinkLabel = new Label("Remove a Node.");
		remlinkLabel.setTextFill(Color.WHITE);
		remlinkLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox rLab = new HBox();
		rLab.getChildren().add(remlinkLabel);
		rLab.setAlignment(Pos.CENTER_LEFT);
		
		TextField remlinkNode = new TextField();
		remlinkNode.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 100px;" +
				"-fx-text-fill: #505050;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #66CDAA;");
		remlinkNode.setPromptText("Index");
		
		// Right Side
		linkPane = new GridPane();
	    linkPane.setHgap(10);
	    linkPane.setVgap(1);
	    linkPane.setPadding(new Insets(0, 0, 0, Main.mwidth/7 + 10));
		gridDiv = new HBox();
		gridDiv.getChildren().addAll(linkPane);
		
		// Event Handler for linked list
		Button addlinkBtn = new Button("INSERT");
		addlinkBtn.setStyle("-fx-border-radius: 0;");
		addlinkBtn.setStyle("-fx-backround-radius: 0;");
		addlinkBtn.setStyle("-fx-background-color: #505050;");
		addlinkBtn.setTextFill(Color.WHITE);
		
		addlinkBtn.setOnMouseEntered(e -> {
			addlinkBtn.setOpacity(.5);
		});
		addlinkBtn.setOnMouseExited(e -> {
			addlinkBtn.setOpacity(1);
		});
		
		HBox getAdd = new HBox(8);
		getAdd.setAlignment(Pos.CENTER_LEFT);
		getAdd.getChildren().addAll(
				addlinkNode,
				addlinkVal,
				addlinkBtn);
		
		// Event Handler for linked list
		Button remlinkBtn = new Button("REMOVE");
		remlinkBtn.setStyle("-fx-border-radius: 0;");
		remlinkBtn.setStyle("-fx-backround-radius: 0;");
		remlinkBtn.setStyle("-fx-background-color: #505050;");
		remlinkBtn.setTextFill(Color.WHITE);
		
		remlinkBtn.setOnMouseEntered(e -> {
			remlinkBtn.setOpacity(.5);
		});
		remlinkBtn.setOnMouseExited(e -> {
			remlinkBtn.setOpacity(1);
		});
		
		// Sample Nodes
		initLL();
		
		HBox remBox = new HBox(5);
		remBox.setAlignment(Pos.CENTER_LEFT);
		remBox.getChildren().addAll(remlinkNode, remlinkBtn);
		
		// Left Div
		Main.linkLeft.getChildren().addAll(
				boxBtn,
				lab,
				getAdd,
				rLab,
				remBox);
		
		// Right Div
		Main.linkRight.setAlignment(Pos.TOP_CENTER);
		Main.linkRight.setPadding(new Insets(20, 0, 0, 0));
		Main.linkRight.setMaxHeight(400);
		Main.linkRight.getChildren().addAll(
				linkTitleBox,
				linkPane);
		
		// Combine both Divs
		Main.linkDiv.setAlignment(Pos.CENTER);
		Main.linkDiv.setBackground(new Background(Main.linkBG1));
		Main.linkDiv.getChildren().addAll(
				Main.linkLeft,
				Main.linkRight);
				
		Main.linkScene = new Scene(
				Main.linkDiv,
				Main.mwidth,
				Main.mheight);
		
		/* ------------------------------- */
		/*  [RendLL Button Event Handlers] */
		/* ------------------------------- */
		
		// Add and display new element.
		addlinkBtn.setOnAction(e -> {
			try {
				// Check input validity. Must be an integer!
				if((!addlinkNode.getText().isEmpty())
					&& (!addlinkVal.getText().isEmpty())
					&& (addlinkVal.getText() != null)
					&& (addlinkNode.getText() != null))
				{	
					// Test and apply index input
					String indexInput = addlinkNode.getText();
					Integer indexTemp = Integer.parseInt(indexInput);
					
					// Test and apply value input
					String valInput = addlinkVal.getText();
					Integer valTemp = Integer.parseInt(valInput);
					
					addToList(indexTemp, valTemp);
					
					// SoundFX
					Main.clickFX.play();
					
					// Clear Grid before populating.
					linkPane.getChildren().clear();
					
					// Populate Grid
					drawLines();
					displayShell();
					populateShell();
					
					// Indicate Add Arrow
					if(current >= 0){
						linkPane.add(grnArrow, 3, current);
					}
				}
				addlinkNode.clear();
				addlinkVal.clear();
			}
			catch (NumberFormatException e1) {
			     // Display Try Again
			}
			catch (Exception e2) {
				e2.printStackTrace(System.out);
			}
		});
		
		// Remove element from linked list and scene.
		remlinkBtn.setOnAction(e -> {
			try {
				// Check validity. Must be integer for index.
				if((!remlinkNode.getText().isEmpty()) && (remlinkNode.getText() != null)) {
					// Test and apply index input
					String indexInput = remlinkNode.getText();
					Integer indexTemp = Integer.parseInt(indexInput);
					
					// Find node valid
					boolean check = false;
					for(Node tem : valueList) {
						if(tem.getIndex() == indexTemp) {
							check = true;
						}
					}
					
					// Remove from list.
					if(check) {
						// Remove node
						current = 0;
						for(Node tem : valueList) {
							if(tem.getIndex() == indexTemp) {
								break;
							}
							current++;
						}
						
						// SoundFX
						Main.clickFX.play();
						
						valueList.remove(current);
						--index;
						
						// Clear Grid before populating.
						linkPane.getChildren().clear();
						
						// Populate Grid
						drawLines();
						displayShell();
						populateShell();
						
						// Indicate Add Arrow
						if(current>=0){
							linkPane.add(redArrow, 3, current);
						}
					}
				}
				remlinkNode.clear();
			}
			catch (NumberFormatException e1) {
			     // Display Try Again
			}
			catch (Exception e2) {
				e2.printStackTrace(System.out);
			}
		});
	}
	
	// Event Handler to display linked list (Just Shell)
	private static void displayShell() {
		// Add node shells for each node in List
		Node[] array = valueList.toArray(new Node[index]);
		
		int column = 0;
		for(int i = 0; i < array.length; ++i) {			
			// Node shell
			Circle nodeS = new Circle();
			nodeS.setRadius(20);
			nodeS.setFill(Color.CORAL);
			
			// Shell Div
			HBox tempBox = new HBox();
			tempBox.setAlignment(Pos.CENTER);
			tempBox.getChildren().add(nodeS);
			tempBox.setMinHeight(50);
			tempBox.setMinWidth(50);
			linkPane.add(tempBox, column + 2, i);
		}
	}
	
	// Initialize for example
	private static void initLL() {
		// Populate List randomly
		int n = (int) (Math.random()*5);
		for(int i = 0; i < n; ++i) {
			addToList(n, (int) (Math.random()*101));
		}
		
		// Clear Grid before populating.
		linkPane.getChildren().clear();
		
		// Populate Grid
		drawLines();
		displayShell();
		populateShell();
	}
	
	// Event Handler to append input value to List
	private static void addToList(int ind, Integer val) {		
		// Local node fields to avoid Concurrency error.
		Node append = new Node(ind, val);
		
		// Check to see where in LL to go.
		current = 0;
		for(Node temp : valueList) {
			if(temp.getIndex() >= ind) {
				break;
			}
			current++;
		}
		valueList.add(current, append);
		++index;
		return;
	}
	
	// Event Handler to display linked list (Actual Values)
	private static void populateShell() {
		// Add node shells for each node in List
		Node[] array = valueList.toArray(new Node[index]);
		
		int column = 0;
		for(int i = 0; i < array.length; ++i) {
			String coord = new String("[" + array[i].getIndex() + "]");
			String val = new String(array[i].getIntVal().toString());
			
			HBox hold = new HBox();
			hold.getChildren().add(new Text(coord));
			hold.setAlignment(Pos.CENTER);
			
			HBox holv = new HBox();
			holv.getChildren().addAll(new Text(val));
			holv.setAlignment(Pos.CENTER);
			
			linkPane.add(hold, column, i);
			linkPane.add(new Text("="), column + 1, i);
			linkPane.add(holv, column + 2, i);
		}
	}
	
	// Draw lines to link the nodes
	private static void drawLines() {
		// No list
		if(index <= 1) {
			return;
		}
		int row = 0;
        VBox lindraw = new VBox();
        lindraw.setMaxWidth(10);
        lindraw.setMaxHeight(20);
        lindraw.setStyle("-fx-background-color: darkslategrey;");
        GridPane.setConstraints(lindraw, 2, 1, 1, 1, HPos.CENTER, VPos.BOTTOM);
        linkPane.add(lindraw, 2, row);
		
        for(int row1 = 1; row1 < index-1; ++row1) {
        	VBox tem = new VBox();
        	tem.setMaxWidth(10);
        	tem.setMaxHeight(100);
        	GridPane.setConstraints(tem, 2, row1, 1, 1, HPos.CENTER, VPos.CENTER);
        	tem.setStyle("-fx-background-color: darkslategrey;");
            linkPane.add(tem, 2, row1);
        }
        
        if(index-1 == 0) {return;}

        VBox lindraw1 = new VBox();
        lindraw1.setMaxWidth(10);
        lindraw1.setMaxHeight(20);
        lindraw1.setStyle("-fx-background-color: darkslategrey;");
        GridPane.setConstraints(lindraw1, 2, index-1, 1, 1, HPos.CENTER, VPos.TOP);
        linkPane.add(lindraw1, 2, index-1);
	}
	
}
