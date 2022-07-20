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
public interface Stop {
    public java.lang.String getId();
    public Coordinate getCoordinate();
    public void setStreet​(Street s);
    public Street getStreet();
    public static Stop defaultStop​(java.lang.String id, Coordinate c) {
        return new Stop() {
            
            private String ID=id;
            Coordinate coors=c;
            Street s=null;
            
            @Override
            public String getId() {
                return this.ID;
            }

            @Override
            public Coordinate getCoordinate() {
                return this.coors;   
            }

            @Override
            public void setStreet(Street s) {
                this.s=s;
            }

            @Override
            public Street getStreet() {
                return this.s;
            }
            
            @Override
            public String toString() {
                return "stop(" + this.ID + ")";
            }
            
        };
    }
}
