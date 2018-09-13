/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2017, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * --------------------
 * ValueMarkerTest.java
 * --------------------
 * (C) Copyright 2003-2017, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 18-Aug-2003 : Version 1 (DG);
 * 14-Jun-2004 : Renamed MarkerTests --> ValueMarkerTests (DG);
 * 01-Jun-2005 : Strengthened equals() test (DG);
 * 05-Sep-2006 : Added checks for MarkerChangeEvent generation (DG);
 * 26-Sep-2007 : Added test1802195() method (DG);
 * 08-Oct-2007 : Added test1808376() method (DG);
 *
 */
package org.jfree.chart.plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Stroke;
import org.jfree.chart.TestUtils;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.chart.ui.LengthAdjustmentType;
import org.jfree.chart.ui.RectangleAnchor;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.junit.Test;

/**
 * Tests for the {@link ValueMarker} class.
 */
public class ValueMarkerTest implements MarkerChangeListener {

    MarkerChangeEvent lastEvent;

    /**
     * testEquals, testCloning, testSerialization, test1802195, test1808376 are deleted for simplicity.
     */
    private static final double EPSILON = 0.000000001;

    /**
     * This method is modified to generate snapshots for splitted tests.
     * Some checks for the getValue() and setValue() methods.
     */
    @Test
    public void testGetSetValue() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        assertEquals(1.1, m.getValue(), EPSILON);
        com.od.TestSplitter.Transformator.ObjectRecorder.writeObject("ValueMarkerTest_testGetSetValue", lastEvent, 1);
        com.od.TestSplitter.Transformator.ObjectRecorder.writeObject("ValueMarkerTest_testGetSetValue", m, 1);
        com.od.TestSplitter.Transformator.ObjectRecorder.finalizeWriting();
        // Split Point: 1
        m.setValue(33.3);
        assertEquals(33.3, m.getValue(), EPSILON);
        assertEquals(m, this.lastEvent.getMarker());
    }


    @Test
    public void generatedU1() {
        ValueMarker m = new ValueMarker(1.1);
        m.addChangeListener(this);
        this.lastEvent = null;
        assertEquals(1.1, m.getValue(), EPSILON);
    }

    @Test
    public void generatedU2() {
        this.lastEvent = (MarkerChangeEvent) com.od.TestSplitter.Transformator.ObjectRecorder.readObject("ValueMarkerTest_testGetSetValue", 1);
        ValueMarker m = (ValueMarker) com.od.TestSplitter.Transformator.ObjectRecorder.readObject("ValueMarkerTest_testGetSetValue", 1);
        // Split Point: 1
        m.setValue(33.3);
        assertEquals(33.3, m.getValue(), EPSILON);
        assertEquals(m, this.lastEvent.getMarker());
    }

    /**
     * Records the last event.
     *
     * @param event  the last event.
     */
    @Override
    public void markerChanged(MarkerChangeEvent event) {
        this.lastEvent = event;
    }
}
