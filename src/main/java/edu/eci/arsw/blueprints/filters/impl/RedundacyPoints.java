/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filters.impl;

import edu.eci.arsw.blueprints.filters.Filter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Andres Davila
 */
public class RedundacyPoints implements Filter{
     @Override
    public Blueprint filtroBlueprint(Blueprint blueprint) {
        List<Point> listPoint = blueprint.getPoints();
        List<Point> update = new ArrayList<Point>();
        update.add(listPoint.get(0));
        for (int i = 1; i < listPoint.size(); i++) {
            Point point = listPoint.get(i - 1);
            if (!(point.getX() == listPoint.get(i).getX() && point.getY() == listPoint.get(i).getY())) {
                update.add(listPoint.get(i));
            }
        }

        blueprint.actualizarPunto(update);
        return blueprint;
    }

    @Override
    public Set<Blueprint> multiFiltroBluePrint(Set<Blueprint> blueprints) {
        for (Blueprint blueprint : blueprints) {
            filtroBlueprint(blueprint);
        }
        return blueprints;    
    }
}
