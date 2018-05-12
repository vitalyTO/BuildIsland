package sample;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.shape.Line;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;



public class Controller {
    //private static final int N = 10;

    /*private XYChart.Series<Integer,Integer> getMoveData(XYChart.Series<Integer, Integer> series, IslandStack<Point> moveList){
        for(int i = 0; i<=moveList.topIndex; i++){
            int x = moveList.extract(i).getX();
            int y = moveList.extract(i).getY();
            series.getData().add(new XYChart.Data<>(x,y));
        }
        return series;
    }*/



    /*public void btn(javafx.event.ActionEvent event){
        //IslandStack<Point> moveList = initStack();
        lineChart.getData().clear();
        XYChart.Series<Integer,Integer> series = new XYChart.Series<>();
        //series = getMoveData(series,moveList);
        lineChart.getData().add(series);
    }*/

}
