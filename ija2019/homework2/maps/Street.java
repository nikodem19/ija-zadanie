/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2019.homework2.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Nikodém
 */
public interface Street {
    public java.lang.String getId();
    public java.util.List<Coordinate> getCoordinates();
    public Coordinate begin();
    public Coordinate end();
    public java.util.List<Stop> getStops();
    public boolean addStop​(Stop stop);
    public boolean follows​(Street s);
    public static Street defaultStreet​(java.lang.String id, Coordinate... coordinates) {
        for(int i=0;i<coordinates.length-1;i++) {
        if((coordinates[i].getX()!=coordinates[i+1].getX()) && (coordinates[i].getY()!=coordinates[i+1].getY())) {
            return null;
        }
        }
        return new Street() {
            
            public String ID=id;
            public ArrayList<Stop> stops=new ArrayList<>();
            public ArrayList<Coordinate> coors=new ArrayList<>(Arrays.asList(coordinates));
                       
            @Override
            public String getId() {
                return this.ID;
            }

            @Override
            public List<Coordinate> getCoordinates() {
                return this.coors;
            }

            @Override
            public Coordinate begin() {
                return this.coors.get(0);
            }

            @Override
            public Coordinate end() {
                return this.coors.get(coors.size()-1);
            }

            @Override
            public List<Stop> getStops() {
                return this.stops;
            }

            @Override
            public boolean addStop(Stop stop) { 
                 for(int i=0;i<coordinates.length-1;i++) {
        if((coordinates[i].getX()==coordinates[i+1].getX()) && (coordinates[i].getX()==stop.getCoordinate().getX())) {
            if( ((coordinates[i].getY()) <= (stop.getCoordinate().getY())) &&  ((stop.getCoordinate().getY()) <=(coordinates[i+1].getY())))  {
                stops.add(stop);
                stop.setStreet(this);
                return true;
            }
            if( ((coordinates[i].getY()) >= (stop.getCoordinate().getY())) &&  ((stop.getCoordinate().getY()) >=(coordinates[i+1].getY())))  {
                stops.add(stop);
                stop.setStreet(this);
                return true;
            }
            
        }
        if((coordinates[i].getY()==coordinates[i+1].getY()) && (coordinates[i].getY()==stop.getCoordinate().getY())) {
            if( ((coordinates[i].getX()) <= (stop.getCoordinate().getX())) &&  ((stop.getCoordinate().getX()) <=(coordinates[i+1].getX())))  {
                stops.add(stop);
                stop.setStreet(this);
                return true;
            }
            if( ((coordinates[i].getX()) >= (stop.getCoordinate().getX())) &&  ((stop.getCoordinate().getX()) >=(coordinates[i+1].getX())))  {
                stops.add(stop);
                stop.setStreet(this);
                return true;
            }
        }    
            }
                return false;
            }
            
            
            @Override
            public boolean follows(Street s) {
                if(this.end().equals(s.begin()))
                    return true;
                if(this.begin().equals(s.end()))
                    return true;
                return false;
            }
            
            
        };
    }
            
}
