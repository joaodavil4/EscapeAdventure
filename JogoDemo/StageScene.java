package JogoDemo;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StageScene extends Application { //O MAIN TA NO FINAL DA CLASSE
	private Stage primaryStage;
	private Scene cenaPrincipal;	
	private TextField comando;
	private TextArea descricao;
	private List<Image> images;
	private ImageView imgView;

	private Engine engine;
	
	@Override
	public void start(Stage primaryStage) { //construtor
		this.primaryStage = primaryStage;

		engine = new Engine(this);
		
		GridPane gp = new GridPane();

		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));
		
		images = new ArrayList<>();

		images.add(new Image("file:NAVE-ESPACIAL.jpg")); //0
		images.add(new Image("file:BuracoNegro.jpg"));   //1
		images.add(new Image("file:Saturno.jpg"));		 //2
		images.add(new Image("file:NoFuel.jpg"));		 //3
		images.add(new Image("file:BadAliens.jpg"));     //4
		images.add(new Image("file:Cela.jpg"));          //5
		images.add(new Image("file:AlienEntediado.jpg"));//6
		images.add(new Image("file:Curiosity.jpg"));     //7
		images.add(new Image("file:TheEnd.jpg"));        //8
		
		imgView = new ImageView();
		imgView.setImage(images.get(0)); //primeira imagem
		imgView.setFitWidth(480);
		imgView.setPreserveRatio(true);
		imgView.setSmooth(true);
		imgView.setCache(true);
		
		//imagem
		HBox boxImg = new HBox(10);
		boxImg.getChildren().add(imgView);
		boxImg.setAlignment(Pos.CENTER);
		gp.add(boxImg,0,0);
		
		//TEXTO
		descricao = new TextArea();
		descricao.setEditable(false);
		gp.add(descricao, 0, 1);
		//botao
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.CENTER);
		Label lbCmd = new Label("O que você quer fazer?");
		hbBtn.getChildren().add(lbCmd);
		comando = new TextField();
		hbBtn.getChildren().add(comando);
		Button btOk = new Button("Ok");
		btOk.setOnAction(e -> engine.joga(comando.getText()));
		hbBtn.getChildren().add(btOk);
		gp.add(hbBtn, 0, 2);

		cenaPrincipal = new Scene(gp);

		primaryStage.setTitle("Adventure at Space");
		primaryStage.setScene(cenaPrincipal);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		engine.joga("start");
	}
	
    public void exibeTexto(String texto) {
    	descricao.appendText(texto);
    	descricao.setScrollTop(Double.MAX_VALUE);
    	comando.setText("");
    }

    public void setImagem(int i) {      //aqui escolhe qual imagem mostrar
        imgView.setImage(images.get(i)); 	
    }

	public static void main(String[] args) {
		launch(args);
	}
	
	

}
