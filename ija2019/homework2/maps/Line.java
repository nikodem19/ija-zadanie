/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2019.homework2.maps;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nikodém
 */
public interface Line {
   
    public boolean addStop​(Stop stop);
    public boolean addStreet​(Street street);
    public List<SimpleImmutableEntry<Street,Stop>> getRoute();
    public static Line defaultLine​(java.lang.String id) {
    return new Line() {
        
        private String ID=id;
        private List<SimpleImmutableEntry<Street,Stop>> route= new ArrayList();
        
        
        @Override
        public boolean addStop(Stop stop) {
            if(route.isEmpty() ) {
            this.route.add(new SimpleImmutableEntry<Street, Stop>(stop.getStreet(), stop));
            return true;
            }
            else {
                if (stop.getStreet().follows(this.route.get(this.route.size() - 1).getKey())) {
                    this.route.add(new SimpleImmutableEntry<Street, Stop>(stop.getStreet(), stop));
                    return true; 
                }
                else {
                    return false;
                }   
            }
        }

        @Override
        public boolean addStreet(Street street) {
            if(route.isEmpty() ) {
            this.route.add(new SimpleImmutableEntry<Street, Stop>(street, null));
            return true;
            }
            else {
                if (street.follows(this.route.get(this.route.size() - 1).getKey())) {
                    this.route.add(new SimpleImmutableEntry<Street, Stop>(street, null));
                    return true; 
                }
                else {
                    return false;
                }   
            }
        }

        @Override
        public List<SimpleImmutableEntry<Street, Stop>> getRoute() {
            return new ArrayList(route);
        }  
    } ;  
    }
}
