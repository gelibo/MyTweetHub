// License: GPL. For details, see Readme.txt file.
package com.heal.dominic.MapInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapObjectImpl;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import com.heal.dominic.MainInterface.Application;

public class SourceMarker extends MapObjectImpl implements MapMarker {

    private Coordinate coord;
    private double radius;
    private STYLE markerStyle;

    /**
     * Constructs a new {@code MapMarkerCircle}.
     * @param coord Coordinates of the map marker
     * @param radius Radius of the map marker position
     */
    public SourceMarker(Coordinate coord, double radius) {
        this(null, null, coord, radius);
    }

    /**
     * Constructs a new {@code MapMarkerCircle}.
     * @param name Name of the map marker
     * @param coord Coordinates of the map marker
     * @param radius Radius of the map marker position
     */
    public SourceMarker(String name, Coordinate coord, double radius) {
        this(null, name, coord, radius);
    }

    /**
     * Constructs a new {@code MapMarkerCircle}.
     * @param layer Layer of the map marker
     * @param coord Coordinates of the map marker
     * @param radius Radius of the map marker position
     */
    public SourceMarker(Layer layer, Coordinate coord, double radius) {
        this(layer, null, coord, radius);
    }

    /**
     * Constructs a new {@code MapMarkerCircle}.
     * @param lat Latitude of the map marker
     * @param lon Longitude of the map marker
     * @param radius Radius of the map marker position
     */
    public SourceMarker(double lat, double lon, double radius) {
        this(null, null, new Coordinate(lat, lon), radius);
    }

    /**
     * Constructs a new {@code MapMarkerCircle}.
     * @param layer Layer of the map marker
     * @param lat Latitude of the map marker
     * @param lon Longitude of the map marker
     * @param radius Radius of the map marker position
     */
    public SourceMarker(Layer layer, double lat, double lon, double radius) {
        this(layer, null, new Coordinate(lat, lon), radius);
    }

    /**
     * Constructs a new {@code MapMarkerCircle}.
     * @param layer Layer of the map marker
     * @param name Name of the map marker
     * @param coord Coordinates of the map marker
     * @param radius Radius of the map marker position
     */
    public SourceMarker(Layer layer, String name, Coordinate coord, double radius) {
        this(layer, name, coord, radius, STYLE.VARIABLE, getDefaultStyle());
    }

    /**
     * Constructs a new {@code MapMarkerCircle}.
     * @param layer Layer of the map marker
     * @param name Name of the map marker
     * @param coord Coordinates of the map marker
     * @param radius Radius of the map marker position
     * @param markerStyle Marker style (fixed or variable)
     * @param style Graphical style
     */
    public SourceMarker(Layer layer, String name, Coordinate coord, double radius, STYLE markerStyle, Style style) {
        super(layer, name, style);
        this.markerStyle = markerStyle;
        this.coord = coord;
        this.radius = radius;
    }

    public SourceMarker(Layer layer, String name,Coordinate coord, Style style) {
    	  super(layer, name, style);
          this.coord = coord;
	}

	@Override
    public Coordinate getCoordinate() {
        return coord;
    }

    @Override
    public double getLat() {
        return coord.getLat();
    }

    @Override
    public double getLon() {
        return coord.getLon();
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public STYLE getMarkerStyle() {
        return markerStyle;
    }

    @Override
    public void paint(Graphics g, Point position, int radius) {

    	BufferedImage Image_Marker = null;
		try {
    		Image_Marker  = ImageIO.read(Application.class.getResource("/images/map-pins-source.png"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	g.drawImage(Image_Marker, position.x-15, position.y - 30,null); 
    	

        if (getLayer() == null || getLayer().isVisibleTexts()) paintText(g, position);
    }

    public static Style getDefaultStyle() {
        return new Style(Color.ORANGE, new Color(200, 200, 200, 200), null, getDefaultFont());
    }

    @Override
    public String toString() {
        return "MapMarker at " + getLat() + " " + getLon();
    }

    @Override
    public void setLat(double lat) {
        if (coord == null) coord = new Coordinate(lat, 0);
        else coord.setLat(lat);
    }

    @Override
    public void setLon(double lon) {
        if (coord == null) coord = new Coordinate(0, lon);
        else coord.setLon(lon);
    }
}
