/*
 * Josh Marasigan
 * [Render]
 * <Main.java>
 * */
package render;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	
	// Global field for main stage.
	public static Stage stage;
	public static Scene structMenu;
	
	// BG's for all Data Struct Scenes
	public static BackgroundImage myBG;
	public static BackgroundFill arrBG;
	public static BackgroundFill arrBG1;
	public static BackgroundFill menuBG;
	public static BackgroundFill menuBG1;
	public static BackgroundFill linkBG;
	public static BackgroundFill linkBG1;
	public static BackgroundFill queueBG;
	public static BackgroundFill queueBG1;
	public static BackgroundFill stackBG;
	public static BackgroundFill stackBG1;
	private static VBox titleDiv;
	
	// Ref for all classes
	public static int mheight = 400;
	public static int mwidth = 600;
	
	// All DataStruct's Scenes
	public static Scene arrayScene;
	public static Scene linkScene;
	public static Scene queueScene;
	public static Scene stackScene;
	public static Scene hashMapScene;
	public static Scene treeScene;
	
	// Base Div's for all Scenes
	public static HBox arrDiv;
	public static HBox linkDiv;
	public static HBox queueDiv;
	public static HBox stackDiv;
	public static HBox hashDiv;
	public static HBox treeDiv;
	
	// Globals for RendArray.java
	public static VBox arrRight;
	public static VBox arrLeft;
	
	// Globals for LL
	public static VBox linkRight;
	public static VBox linkLeft;
	
	// Globals for Queue
	public static VBox queueRight;
	public static VBox queueLeft;
	
	// Globals for Stack
	public static VBox stackRight;
	public static VBox stackLeft;
	
	// FX
	public static AudioClip clickFX;
	public static AudioClip anotherFX;
	
	@Override
	public void start(Stage arg0) {
		
		// Selection FX
		File fx = new File("C:\\Users\\Josh M\\Documents\\EE422C Workspace\\Render\\click.mp3");
		String push = fx.toURI().toString();
		clickFX = new AudioClip(push);
		
		File an1 = new File("C:\\Users\\Josh M\\Documents\\EE422C Workspace\\Render\\another.mp3");
		String djK = an1.toURI().toString();
		anotherFX = new AudioClip(djK);
		
		// Initialize stage
		stage = arg0;
		stage.setTitle("Render");
		stage.setMaxHeight(438);
		stage.setMaxWidth(600);
		stage.setMinHeight(438);
		stage.setMinWidth(600);
		
		// Logo
		Image logo = new Image("file:Render.png");
        ImageView logoBan = new ImageView(logo);
        logoBan.setEffect(new DropShadow());
		HBox logoBanner = new HBox();
		logoBanner.setMaxWidth(logoBan.getFitWidth());
		logoBanner.setPadding(new Insets(20, 0, 20, 0));
		logoBanner.setStyle(
				"-fx-border-style: solid;" + 
				"-fx-border-width: 5px;" +
				"-fx-border-color: #66CDAA;");
		logoBanner.getChildren().add(logoBan);
		
		// Background Images and Fills
		myBG = new BackgroundImage(
				new Image("file:RenderBG.png",mwidth,mheight,true,true), 
				BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		arrBG = new BackgroundFill(Color.MEDIUMAQUAMARINE, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		arrBG1 = new BackgroundFill(Color.HONEYDEW, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		menuBG = new BackgroundFill(Color.DARKCYAN, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		menuBG1 = new BackgroundFill(Color.LAVENDERBLUSH, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		linkBG = new BackgroundFill(Color.CORAL, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		linkBG1 = new BackgroundFill(Color.CADETBLUE, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		queueBG = new BackgroundFill(Color.SLATEBLUE, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		queueBG1 = new BackgroundFill(Color.SEASHELL, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		stackBG = new BackgroundFill(Color.CORNFLOWERBLUE, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		stackBG1 = new BackgroundFill(Color.BEIGE, new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
		
		Label l1 = new Label("A Datastructure Visualization Aid");
		l1.setStyle(
				"-fx-font: 15px Futura;" + 
				"-fx-fill: #66CDAA;");
			
		Button getStart = new Button("Get Started!");
		getStart.setMinHeight(50);
		getStart.setMaxWidth(150);
		getStart.setStyle(
				"-fx-border-style: solid;" + 
				"-fx-border-width: 0px 0px 3px 0px;" +
				"-fx-border-color: #66CDAA;" + 
				"-fx-font: 15px Futura;" + 
				"-fx-font-weight: bold;" +
				"-fx-fill: #66CDAA;" + 
				"-fx-background-color: transparent;");
		
		// Hover animation.
		getStart.setOnMouseEntered(e -> {
			getStart.setOpacity(.5);
		});
		getStart.setOnMouseExited(e -> {
			getStart.setOpacity(2);
		});
		
		titleDiv = new VBox(20);
		titleDiv.setBackground(new Background(myBG));		
		titleDiv.getChildren().addAll(
				logoBanner,
				l1,
				getStart);
		titleDiv.setAlignment(Pos.CENTER);
		
		// Set Scene
		Scene initial = new Scene(titleDiv, mwidth, mheight);
		stage.setScene(initial);
		stage.show();
		
		// Fillers
		Image fill = new Image("file:filler.png");
		ImageView fillViewA = new ImageView(fill);
		fillViewA.setFitHeight(100);
		fillViewA.setFitWidth(100);
		ImageView fillViewB = new ImageView(fill);
		fillViewB.setFitHeight(100);
		fillViewB.setFitWidth(100);
		ImageView fillViewC = new ImageView(fill);
		fillViewC.setFitHeight(100);
		fillViewC.setFitWidth(100);
		ImageView fillViewD = new ImageView(fill);
		fillViewD.setFitHeight(100);
		fillViewD.setFitWidth(100);
		
		// Datastrucutre menu scree.
		VBox row1 = new VBox();
		VBox row2 = new VBox();
		HBox menuDiv = new HBox();
		
		Image startA = new Image("file:Btn1.png");
		ImageView btA = new ImageView(startA);
		btA.setFitHeight(100);
		btA.setFitWidth(100);
		Button btn1 = new Button();
		btn1.setPadding(Insets.EMPTY);
		btn1.setStyle("-fx-background-color: transparent;");
		btn1.setGraphic(btA);
		
		btn1.setOnMouseEntered(e -> {
			btn1.setOpacity(.5);
		});
		btn1.setOnMouseExited(e -> {
			btn1.setOpacity(1);
		});
				
		Image startB = new Image("file:Btn2.png");
		ImageView btB = new ImageView(startB);
		btB.setFitHeight(100);
		btB.setFitWidth(100);
		Button btn2 = new Button();
		btn2.setPadding(Insets.EMPTY);
		btn2.setStyle("-fx-background-color: transparent;");
		btn2.setGraphic(btB);
		
		btn2.setOnMouseEntered(e -> {
			btn2.setOpacity(.5);
		});
		btn2.setOnMouseExited(e -> {
			btn2.setOpacity(1);
		});
		
		Image startC = new Image("file:Btn3.png");
		ImageView btC = new ImageView(startC);
		btC.setFitHeight(100);
		btC.setFitWidth(100);
		Button btn3 = new Button();
		btn3.setPadding(Insets.EMPTY);
		btn3.setStyle("-fx-background-color: transparent;");
		btn3.setGraphic(btC);
		
		btn3.setOnMouseEntered(e -> {
			btn3.setOpacity(.5);
		});
		btn3.setOnMouseExited(e -> {
			btn3.setOpacity(1);
		});
		
		Image startD = new Image("file:Btn4.png");
		ImageView btD = new ImageView(startD);
		btD.setFitHeight(100);
		btD.setFitWidth(100);
		Button btn4 = new Button();
		btn4.setPadding(Insets.EMPTY);
		btn4.setStyle("-fx-background-color: transparent;");
		btn4.setGraphic(btD);
		
		btn4.setOnMouseEntered(e -> {
			btn4.setOpacity(.5);
		});
		btn4.setOnMouseExited(e -> {
			btn4.setOpacity(1);
		});
		
		row1.getChildren().addAll(btn1, fillViewC, btn3, fillViewD);
		row2.getChildren().addAll(fillViewA, btn2, fillViewB, btn4);
		row1.setAlignment(Pos.CENTER);
		row2.setAlignment(Pos.CENTER);
		
		// Right Side
		menuDiv.getChildren().addAll(row1, row2);
		menuDiv.setAlignment(Pos.CENTER_RIGHT);
		menuDiv.setMinHeight(Main.mheight);
		menuDiv.setMinWidth(Main.mwidth/2 - 20);
		
		Text menuTitle = new Text("SELECT A DATA STRUCTURE");
		menuTitle.setStyle(
				"-fx-font: 15px Futura;" + 
				"-fx-font-weight: bold;" +
				"-fx-fill: #F8F8F8;");
		
		HBox menuMessage = new HBox();
		menuMessage.setMinHeight(50);
		menuMessage.setMaxWidth(230);
		menuMessage.setStyle(
				"-fx-border-style: solid;" + 
				"-fx-border-width: 5px;" +
				"-fx-border-color: #F8F8F8;");
		menuMessage.getChildren().add(menuTitle);
		menuMessage.setAlignment(Pos.CENTER);
		
		VBox menuLabel = new VBox();
		menuLabel.setEffect(new DropShadow());
		menuLabel.setAlignment(Pos.CENTER);
		menuLabel.setBackground(new Background(menuBG));
		menuLabel.setMinHeight(Main.mheight);
		menuLabel.setMinWidth(Main.mwidth/2 + 100);
		menuLabel.getChildren().add(menuMessage);
		
		// Total Div of Menu Scene
		HBox totalDiv = new HBox();
		totalDiv.setMinSize(mwidth, mheight);
		totalDiv.setAlignment(Pos.BASELINE_RIGHT);
		totalDiv.getChildren().addAll(menuDiv, menuLabel);
		totalDiv.setBackground(new Background(menuBG1));
		structMenu = new Scene(totalDiv, mwidth, mheight);
		
		// Second Scene
		getStart.setOnAction(e -> {
			stage.setScene(structMenu);
		});
		
		/* ---------------------------- */
		/* [SCENE NAVIGATION / BG INIT] */
		/* ---------------------------- */
		setSceneBG();
		
		btn1.setOnAction(e -> {
			stage.setScene(arrayScene);
		});
		btn2.setOnAction(e -> {
			stage.setScene(linkScene);
		});
		btn3.setOnAction(e -> {
			stage.setScene(queueScene);
		});
		btn4.setOnAction(e -> {
			stage.setScene(stackScene);
		});
		
		/* ------------------------------------------ */
		/* [INITIALIZE STRUCTURE'S INDIVIDUAL SCENES] */
		/* ------------------------------------------ */
		
		// Array Controller
		RendArray.initArrayScene();
		
		// Linked List Controller
		RendLL.initLinkedScene();
		
		// Queue Controller
		RendQueue.initQueueScene();
		
		// Stack Controller
		RendStack.initStackScene();
	}
	
	/* Add BG to all Scenes */
	private static void setSceneBG() {
		arrDiv = new HBox(2);
		arrDiv.setBackground(new Background(Main.myBG));
		arrDiv.setAlignment(Pos.CENTER);
		
		linkDiv = new HBox(2);
		linkDiv.setBackground(new Background(Main.myBG));
		linkDiv.setAlignment(Pos.CENTER);
		
		queueDiv = new HBox(2);
		queueDiv.setBackground(new Background(Main.myBG));
		queueDiv.setAlignment(Pos.CENTER);
		
		hashDiv = new HBox(2);
		hashDiv.setBackground(new Background(Main.myBG));
		hashDiv.setAlignment(Pos.CENTER);
		
		stackDiv = new HBox(2);
		stackDiv.setBackground(new Background(Main.myBG));
		stackDiv.setAlignment(Pos.CENTER);
		
		treeDiv = new HBox(2);
		treeDiv.setBackground(new Background(Main.myBG));
		treeDiv.setAlignment(Pos.CENTER);
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
