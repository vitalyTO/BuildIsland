package sample;

import com.sun.javafx.geom.Point2D;
import com.sun.javaws.jnl.ResourcesDesc;

import javax.swing.text.Segment;
import java.awt.geom.Line2D;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class BuildIsland {

    private static Random r = new Random();
    private static DecimalFormat df = new DecimalFormat("#.#");
    public static final int N = 15;
    public static final int Width = 800;
    private static final Point finalPoint = new Point(rand(Width),0);

    private static double giveNormalNum(double n){
        return Double.parseDouble(df.format(n));
    }
    private static boolean rT(double a, double b){ return a==b;}

    private static double getDistance(float[] p1, float[] p2){ //determines the distances between the vectors
        double one = Math.pow((p2[0]-p1[0]),2);
        double two = Math.pow((p2[1]-p1[1]),2);
        return giveNormalNum(Math.sqrt(one+two));
    }

    private static int rand(int upTo){
        return r.nextInt(upTo)+1;
    }

    private static Point getMove(int upTo) { return new Point(rand(upTo),rand(upTo)); }

    private static float[] cSt(IslandStack<Point> moveList, int i){
        try{
            float[] a = {moveList.extract(i).getX(), moveList.extract(i).getY()};
            return a;
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static void printStack(IslandStack<Point> moveList){
        for(int i=moveList.topIndex;i>=0;i--){
            System.out.println("X: "+moveList.extract(i).getX()+", Y: "+moveList.extract(i).getY());
        }
    }

    private static boolean determineCollinear(IslandStack<Point> mL){ //returns true if none of the vertices are collinear
        //p1 = lastindex -> this would be FINAL POINT every time a new move gets added and checked against
        //p2 = middle index
        //p3 = first index of stack
        int l = mL.topIndex;
        double d1 = getDistance(cSt(mL,l), cSt(mL,l-1));
        double d2 = getDistance(cSt(mL,l-1), cSt(mL,l-2));
        double d3 = getDistance(cSt(mL,l), cSt(mL,l-2));

        return (rT(d1, d2) || rT(d1, d3) || rT(d2, d3));
    }

    private static boolean deterI(IslandStack<Point> moveList, int check) {
        if(check>0) {
            int l = moveList.topIndex;
            float[] p1 = cSt(moveList, l); //the two points of the new line just created; check it aginst every other one
            float[] p2 = cSt(moveList, l - 1);
            float[] p3 = cSt(moveList, check);
            float[] p4 = cSt(moveList, check - 1);

            Line2D line1 = new Line2D.Float(p1[0], p1[1], p2[0], p2[1]);
            Line2D line2 = new Line2D.Float(p3[0], p3[1], p4[0], p4[1]);
            double l1 = p3[0];
            double l2 = p3[1];
            //true if intersect
            return line1.intersectsLine(line2) || line2.contains(l1,l2) || deterI(moveList, check - 1);
        }
        else return false;
    }

    private static String prA(int[] a){
        return (Arrays.toString(a));
    }

    private static boolean lineRule(IslandStack<Point> moveList){
        int l = moveList.topIndex;
        int check = l - 2;
        return (determineCollinear(moveList)||(l > 2 && deterI(moveList,check)));
    }

    private static IslandStack<Point> nextMove(IslandStack<Point> moveList, int upTo) {

        if(moveList.topIndex<=(upTo-3)) {
            moveList.push(getMove(upTo));

            if(lineRule(moveList)){
                moveList.pop();
                return nextMove(moveList,upTo);
            }

            else if(!moveList.isFull()) {
                moveList.push(finalPoint);
                if(lineRule(moveList)) {
                    moveList.pop();
                    moveList.pop();
                    return nextMove(moveList, upTo);
                }
                else {
                    moveList.pop();
                    return nextMove(moveList, upTo);
                }
            }

            else {
                moveList.pop();
                moveList.push(finalPoint);
                return moveList;
            }
        }
        else return moveList;
    }

    public static IslandStack<Point> getPointSet(){
        IslandStack<Point> moveList = new IslandStack<>(N);
        moveList.push(new Point(0,rand(Width)));
        moveList.push(getMove(Width));
        nextMove(moveList,Width);
        return moveList;

    }
}
