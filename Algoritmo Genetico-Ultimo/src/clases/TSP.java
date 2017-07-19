/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Magdiel
 */
public class TSP {
    private String name;
    private String type;
    private String comment;
    private String dimension;
    private String edgeWeightType;
    private String edgeWeightFormat;
    private String displayDataType;
    private int [][] distancia = new int [29][29];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getEdgeWeightType() {
        return edgeWeightType;
    }

    public void setEdgeWeightType(String edgeWeightType) {
        this.edgeWeightType = edgeWeightType;
    }

    public String getEdgeWeightFormat() {
        return edgeWeightFormat;
    }

    public void setEdgeWeightFormat(String edgeWeightFormat) {
        this.edgeWeightFormat = edgeWeightFormat;
    }

    public String getDisplayDataType() {
        return displayDataType;
    }

    public void setDisplayDataType(String displayDataType) {
        this.displayDataType = displayDataType;
    }

    public int[][] getDistancia() {
        return distancia;
    }

    public void setDistancia(int[][] distancia) {
        this.distancia = distancia;
    }
   
}
