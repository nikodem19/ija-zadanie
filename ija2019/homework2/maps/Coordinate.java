/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2019.homework2.maps;

/**
 *
 * @author Nikodém
 */
public class Coordinate extends java.lang.Object {
    private int x=0,y=0;
    
    public Coordinate(int x,int y) {
    this.x=x;
    this.y=y;
    }
    
    public int getX() {
    return this.x;
    }
    
    public int getY() {
    return this.y;
    }
    
    public static Coordinate create​(int x, int y) {
    if (x<0 || y<0) {
        return null;
        }    
    Coordinate newCoordinate = new Coordinate(x,y);
    return newCoordinate;
    }
    
    public int diffX(Coordinate c) {
    return this.x-c.x;
    }
    
    public int diffY(Coordinate c) {
    return this.y-c.y;
    }
    
    @Override
    public boolean equals(java.lang.Object obj) {

        if (obj == this) return true;
        if (!(obj instanceof Coordinate)) {
            return false;
        }

        Coordinate coordinate = (Coordinate) obj;

        return coordinate.getX()==(x)&&coordinate.getY()==(y);
    }
    
    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        return result;
    }
    
}
