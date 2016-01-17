/*
 * Josh Marasigan
 * [Render]
 * <RenQueue.java>
 * */
package render;

import java.util.LinkedList;
import java.util.Queue;
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
/* ['QUEUE' SCENE CONTROLLER] */
/* -------------------------- */
public class RendQueue {
	
	// Class field to display Array Nodes.
	private static GridPane queuePane;
	private static int length;
	private static Queue<Integer> valueQueue = new LinkedList<Integer>();
	private static HBox gridDiv;
	private static ImageView grnArrow;
	private static ImageView redArrow;
	
	// Constructors
	public RendQueue(int len) {
		this.setLength(len);
	}
	
	// Getters and Setters
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		RendQueue.length = length;
	}
	
	// Method to Initialize all Nodes pertaining.
	public static void initQueueScene() {
		length = 0;
		Main.queueLeft = new VBox(20);
		Main.queueLeft.setEffect(new DropShadow());
		Main.queueLeft.setAlignment(Pos.CENTER);
		Main.queueLeft.setBackground(new Background(Main.queueBG));
		Main.queueLeft.setMinHeight(Main.mheight);
		Main.queueLeft.setMinWidth(Main.mwidth/2);
		Main.queueLeft.setPadding(new Insets(0, 30, 0, 0));
		
		Main.queueRight = new VBox(18);
		Main.queueRight.setAlignment(Pos.CENTER);
		Main.queueRight.setMinHeight(Main.mheight);
		Main.queueRight.setMinWidth(Main.mwidth/2);
		
		// Images
		Image gArrow = new Image("file:greenArrow.png");
		Image rArrow = new Image("file:redArrow.png");
        grnArrow = new ImageView(gArrow);
        redArrow = new ImageView(rArrow);
		
        // Label
		Text queueTitle = new Text("THE QUEUE (FIFO)");
		queueTitle.setStyle(
				"-fx-font: 15px Futura;" + 
				"-fx-font-weight: bold;" +
				"-fx-fill: #6A5ACD;");
		
		HBox queueTitleBox = new HBox();
		queueTitleBox.setMinHeight(50);
		queueTitleBox.setMaxWidth(230);
		queueTitleBox.setStyle(
				"-fx-border-style: solid;" + 
				"-fx-border-width: 5px;" +
				"-fx-border-color: #6A5ACD;");
		queueTitleBox.getChildren().add(queueTitle);
		queueTitleBox.setAlignment(Pos.CENTER);
		
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
		
		// Make Queue Label
		Label makeArrLabel = new Label("Format your Queue.");
		makeArrLabel.setTextFill(Color.WHITE);
		makeArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox makeAL = new HBox();
		makeAL.getChildren().add(makeArrLabel);
		makeAL.setAlignment(Pos.CENTER_RIGHT);
				
		// Get Add Node
		Label addArrLabel = new Label("Enqueue an Element.");
		addArrLabel.setTextFill(Color.WHITE);
		addArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox lab = new HBox();
		lab.getChildren().add(addArrLabel);
		lab.setAlignment(Pos.CENTER_RIGHT);
				
		TextField enqVal = new TextField();
		enqVal.setStyle(
				"-fx-max-height: 50px;" + 
				"-fx-max-width: 50px;" +
				"-fx-text-fill: #505050;" + 
				"-fx-font: 12px Futura;" + 
				"-fx-prompt-text-fill: #6A5ACD;");
		
		enqVal.setPromptText("Value");
		
		// Get Remove Node
		Label remArrLabel = new Label("Dequeue an Element.");
		remArrLabel.setTextFill(Color.WHITE);
		remArrLabel.setFont(Font.font ("Gill Sans", FontWeight.THIN, 20));
		
		HBox rLab = new HBox();
		rLab.getChildren().add(remArrLabel);
		rLab.setAlignment(Pos.CENTER_RIGHT);
				
		// Right Side
		queuePane = new GridPane();
	    queuePane.setHgap(10);
	    queuePane.setVgap(1);
	    queuePane.setPadding(new Insets(0, 0, 0, Main.mwidth/7 + 10));
		gridDiv = new HBox();
		gridDiv.getChildren().addAll(queuePane);
		
		// Temp Values for Grid
		randomPopulate();
		displayShell();

		// Event Handler for Queue
		Button rendQueue = new Button("FORMAT");
		rendQueue.setStyle("-fx-border-radius: 0;");
		rendQueue.setStyle("-fx-backround-radius: 0;");
		rendQueue.setStyle("-fx-background-color: #505050;");
		rendQueue.setTextFill(Color.WHITE);
				
		HBox getLen = new HBox(5);
		getLen.setAlignment(Pos.CENTER_RIGHT);
		getLen.getChildren().addAll(
				rendQueue);
		
		// Hover animation.
		rendQueue.setOnMouseEntered(e -> {
			rendQueue.setOpacity(.5);
		});
		rendQueue.setOnMouseExited(e -> {
			rendQueue.setOpacity(1);
		});
		
		// Event Handler for Queue
		Button enqBtn = new Button("ENQUEUE");
		enqBtn.setStyle("-fx-border-radius: 0;");
		enqBtn.setStyle("-fx-backround-radius: 0;");
		enqBtn.setStyle("-fx-background-color: #505050;");
		enqBtn.setTextFill(Color.WHITE);
		
		enqBtn.setOnMouseEntered(e -> {
			enqBtn.setOpacity(.5);
		});
		enqBtn.setOnMouseExited(e -> {
			enqBtn.setOpacity(1);
		});
		
		HBox getAdd = new HBox(8);
		getAdd.setAlignment(Pos.CENTER_RIGHT);
		getAdd.getChildren().addAll(
				enqVal,
				enqBtn);
		
		// Event Handler for Queue
		Button remqBtn = new Button("DEQUEUE");
		remqBtn.setStyle("-fx-border-radius: 0;");
		remqBtn.setStyle("-fx-backround-radius: 0;");
		remqBtn.setStyle("-fx-background-color: #505050;");
		remqBtn.setTextFill(Color.WHITE);
		
		remqBtn.setOnMouseEntered(e -> {
			remqBtn.setOpacity(.5);
		});
		remqBtn.setOnMouseExited(e -> {
			remqBtn.setOpacity(1);
		});
		
		HBox remBox = new HBox(5);
		remBox.setAlignment(Pos.CENTER_RIGHT);
		remBox.getChildren().addAll(remqBtn);
		
		// Left Div
		Main.queueLeft.getChildren().addAll(
				makeAL,
				getLen,
				lab,
				getAdd,
				rLab,
				remBox,
				boxBtn);
		
		// Right Div
		Main.queueRight.setAlignment(Pos.TOP_CENTER);
		Main.queueRight.setPadding(new Insets(20, 0, 0, 0));
		Main.queueRight.setMaxHeight(400);
		Main.queueRight.getChildren().addAll(
				queueTitleBox,
				queuePane);
		
		// Combine both Divs
		Main.queueDiv.setAlignment(Pos.CENTER);
		Main.queueDiv.setBackground(new Background(Main.queueBG1));
		Main.queueDiv.getChildren().addAll(
				Main.queueRight,
				Main.queueLeft); // Decided to switch sides.
		
		Main.queueScene = new Scene(
				Main.queueDiv,
				Main.mwidth,
				Main.mheight);
		
		/* --------------------------------- */
		/* [RendQueue Button Event Handlers] */
		/* --------------------------------- */
		
		// Display Shell for Queue.
		rendQueue.setOnAction(e -> {
			try {
				// Clear Grid before populating.
				queuePane.getChildren().clear();
				
				length = 0;
				valueQueue.clear();
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
					
					// Add value to queue.
					addToQueue(valTemp);
					
					// Clear Grid before populating.
					queuePane.getChildren().clear();
					
					// Populate Grid
					displayShell();
					populateShell();
		
					// Indicate Add Arrow
					if(length-1>0) {
						queuePane.add(grnArrow, 2, length-1);
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
		
		// Remove element from queue and scene.
		remqBtn.setOnAction(e -> {
			try {
				if(length == 1) {
					removeFromQueue();
					
					// Clear Grid before populating.
					queuePane.getChildren().clear();
					
					// Populate Grid
					displayShell();
					populateShell();
					
					queuePane.add(redArrow, 2, 0);
				}
				else if(length > 0){
					removeFromQueue();
					
					// Clear Grid before populating.
					queuePane.getChildren().clear();
					
					// Populate Grid
					displayShell();
					populateShell();
					
					if(length-1>0) {
						queuePane.add(redArrow, 2, length-1);
					}
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
			valueQueue.add(showInt);
			queuePane.add(hold, column, i);
			++length;
		}
	}
	
	// Event Handler to display Queue (Just Shell)
	private static void displayShell() {		
		// Add index markers to left of shell to queuePane.
		int column = 0;
		for(Integer row = 0; row < length; row++) {
			// Shell Div
			Text temp = new Text(row.toString());
			queuePane.add(temp, column, row);
		}
		
		// Add shells to queuePane.
		++column;
		for(int row = 0; row < length; row++) {
			// Shell Div
			HBox temp = new HBox();
			temp.setMinHeight(30);
			temp.setMinWidth(140);
			temp.setStyle("-fx-border-color: #dcdcdc;");
			queuePane.add(temp, column, row);
		}
		
		// Add index markers to left of shell to queuePane.
		column = 2;
		for(int row = 0; row < length; row++) {
			// Shell Div
			HBox temp = new HBox();
			temp.setMinHeight(30);
			temp.setMinWidth(100);
			queuePane.add(temp, column, row);
		}
	}
	
	// Event Handler to append input value to List
	private static void addToQueue(Integer val) {		
		// Local node fields to avoid Concurrency error.
		valueQueue.add(val);
		// SoundFX
		Main.clickFX.play();
		++length;
		return;
	}
	
	// Event Handler to remove value by Index from List
	private static void removeFromQueue() {		
		// Check if queue has value already at index.
		valueQueue.remove();
		// SoundFX
		Main.clickFX.play();
		--length;
		return;
	}
	
	// Event Handler to display Queue (Actual Values)
	private static void populateShell() {
		// Get element node population and append.		
		int column = 1;
		int row = 0;
		for(Integer tem : valueQueue) {
			Integer showInt = tem;
			HBox hold = new HBox();
			hold.getChildren().add(new Text(showInt.toString()));
			hold.setAlignment(Pos.CENTER);
			queuePane.add(hold, column, row);
			++row;
		}
	}
}
