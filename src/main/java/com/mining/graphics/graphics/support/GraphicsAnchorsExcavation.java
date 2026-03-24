package com.mining.graphics.graphics.support;

import com.mining.graphics.graphics.elementssupport.AnchorsRenderer;
import com.mining.graphics.service.support.ServiceAnchorsExcavation;

import java.awt.*;

public class GraphicsAnchorsExcavation extends ServiceAnchorsExcavation {

//    public void prepareAnchorCalculations() {
//        calculateCrossSectionAnchors(width, height, formIndication, GRAPHICS_SCALE, "ROOF and WALL");
//        calculateLongSectionAnchors(height, length, distanceBetweenRows);
//        calculateBasePlate(plateSize);
//        calculateParametersExcavationScale(width, height, length, formIndication, GRAPHICS_SCALE);
//    }
//
//    public void drawAllAnchors(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        drawCrossSectionAnchors(g2d);
//        drawLongSectionAnchors(g2d);
//        drawBasePlate(g2d);
//    }
//
//    public void drawAllAnchorsTest(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        testDrawLongSectionAnchors(g);
//        testDrawLowerAnchor(g);
//    }
//
//    /**
//     * Это графический метод построения анкеров в поперечном сечении горной выработки.
//     */
//    public void drawCrossSectionAnchors(Graphics2D g) {
//        for (int i = 0; i <= numberCrossSectionAnchors - 1; i++) {
//            int x1 = (int) Math.round(crossSectionAnchorsXY[i][0] * GRAPHICS_SCALE);
//            int y1 = (int) Math.round(crossSectionAnchorsXY[i][1] * GRAPHICS_SCALE);
//            int x2 = (int) Math.round(crossSectionAnchorsXY[i][2] * GRAPHICS_SCALE);
//            int y2 = (int) Math.round(crossSectionAnchorsXY[i][3] * GRAPHICS_SCALE);
//
//            AnchorsRenderer.drawAnchorMonolithicCompositions(g, x1, y1, x2, y2);
//            //AnchorsRenderer.drawExpansionAnchor(g, x1, y1, x2, y2);
//        }
//    }
//
//    /**
//     * Это графический метод построения опорных плит в продольном сечении горной выработки.
//     */
//    public void drawBasePlate(Graphics g) {
//        g.translate(DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION, 0);
//
//        for (int i = 0; i <= numberBasePlateLongSection - 1; i++) {
//            g.drawRect((int) (Math.round((basePlateXY[i][0]) * GRAPHICS_SCALE)), (int) (Math.round((basePlateXY[i][1]) * GRAPHICS_SCALE)), (int) (Math.round(plateSize * GRAPHICS_SCALE)), (int) (Math.round(plateSize * GRAPHICS_SCALE)));
//        }
//        g.translate(-DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION, 0);
//    }
//
//    /**
//     * Это графический метод построения анкеров в продольном сечении горной выработки.
//     */
//    public void drawLongSectionAnchors(Graphics2D g) {
//        g.translate(DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION, 0);
//
//        for (int i = 0; i <= numberLongSectionAnchors - 1; i++) {
//            int x1 = (int) (Math.round(longSectionAnchorsXY[i][0] * GRAPHICS_SCALE));
//            int y1 = (int) (Math.round(longSectionAnchorsXY[i][1] * GRAPHICS_SCALE));
//            int x2 = (int) (Math.round(longSectionAnchorsXY[i][2] * GRAPHICS_SCALE));
//            int y2 = (int) (Math.round(longSectionAnchorsXY[i][3] * GRAPHICS_SCALE));
//            AnchorsRenderer.drawAnchorMonolithicCompositions(g, x1, y1, x2, y2);
//            //AnchorsRenderer.drawExpansionAnchor(g, x1, y1, x2, y2);
//        }
//
//        g.translate(-DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION, 0);
//    }
//
//    /**
//     * Это графический метод проверки построения анкеров в продольном сечении горной выработки.
//     */
//    public void testDrawLongSectionAnchors(Graphics g) {
//        g.translate(DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION, 0);
//
//        g.drawLine((int) (Math.round(crossSectionAnchorsXY[0][2] * GRAPHICS_SCALE) - DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION), (int) (Math.round(crossSectionAnchorsXY[0][3] * GRAPHICS_SCALE)), (int) (Math.round(longSectionAnchorsXY[0][2] * GRAPHICS_SCALE)), (int) (Math.round(longSectionAnchorsXY[0][3] * GRAPHICS_SCALE)));
//
//        g.translate(-DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION, 0);
//    }
//
//    /**
//     * Это графический метод проверки построения анкеров.
//     */
//    public void testDrawLowerAnchor(Graphics g) {
//        g.drawLine(0, (int) (Math.round(crossSectionAnchorsXY[0][1] * GRAPHICS_SCALE)), (int) (Math.round(DISTANCE_BETWEEN_CROSS_AND_LONG_SECTION + length * GRAPHICS_SCALE)), (int) (Math.round(crossSectionAnchorsXY[0][1] * GRAPHICS_SCALE)));
//        g.drawLine(-scaleWidth / 2, (int) (Math.round(-distanceLowerAnchor * GRAPHICS_SCALE)), scaleWidth / 2, (int) (Math.round(-distanceLowerAnchor * GRAPHICS_SCALE)));
//        g.drawLine(-scaleWidth / 2, (int) (Math.round((-distanceLowerAnchor - step / 2.0) * GRAPHICS_SCALE)), scaleWidth / 2, (int) (Math.round((-distanceLowerAnchor - step / 2.0) * GRAPHICS_SCALE)));
//    }
}
