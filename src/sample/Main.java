package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    protected static int N = 20; //Number of vertices
    protected static final int sWidth = 850;
    private static final int sHeight = sWidth;
    public static void main(String[] args) {
        launch(args);
    }

    Button b = new Button("New Graph");

    private Group root = new Group();
    private Canvas canvas = new Canvas(sWidth,sHeight);
    private GraphicsContext gc = canvas.getGraphicsContext2D();

    @Override
    public void start(Stage primaryStage) throws Exception{

        try{
            primaryStage.setTitle("Island Problem");
            root.getChildren().add(canvas);
            Scene scene = new Scene(root, sWidth,sHeight);

            IslandStack<Point> ms = BuildIsland.getPointSet();

            //newIsland.printStack(ms);

            for(int i=0;i<ms.topIndex;i++){
                int xs = ms.extract(i).getX();
                int ys = ms.extract(i).getY();
                int xe = ms.extract(i+1).getX();
                int ye = ms.extract(i+1).getY();
                //root.getChildren().add(setT(xe,ye));
                drawLine(gc,xs,ys,xe,ye);
            }

            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private double newY(double n){
        return (sWidth-n);
    }

    private Text setT(int xe, int ye){
        Text t = new Text();
        t.setX(xe+10);
        t.setY(newY(ye)-10);
        t.setText("x:"+xe+"y:"+ye);
        return t;
    }

    private void drawLine(GraphicsContext gc, double xs, double ys, double xe, double ye){
        Circle circle = new Circle(xe,newY(ye),3);
        gc.beginPath();
        gc.moveTo(xs,newY(ys));
        gc.lineTo(xe,newY(ye));
        //root.getChildren().add(circle);
        gc.stroke();
    }
}





//Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//scene.addEventFilter(MouseEvent.ANY, event -> postInfo());