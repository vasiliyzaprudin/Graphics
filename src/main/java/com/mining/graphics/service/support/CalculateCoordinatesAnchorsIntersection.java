package com.mining.graphics.service.support;

import com.mining.graphics.model.excavation.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.AnchorsExcavation;
import com.mining.graphics.model.support.AnchorsIntersection;
import com.mining.graphics.model.test.ModelTest;
import com.mining.graphics.service.excavation.ServiceExcavation;


public class CalculateCoordinatesAnchorsIntersection {

    private final ModelIntersection modelIntersection;
    private final CoordinatesIntersection modelCoordinatesIntersection;
    private final AnchorsIntersection anchorsIntersection;
    private final ModelTest modelTest;

    public CalculateCoordinatesAnchorsIntersection(
            ModelIntersection modelIntersection,
            CoordinatesIntersection modelCoordinatesIntersection,
            AnchorsIntersection anchorsIntersection,
            ModelTest modelTest) {
        this.modelIntersection = modelIntersection;
        this.modelCoordinatesIntersection = modelCoordinatesIntersection;
        this.anchorsIntersection = anchorsIntersection;
        this.modelTest = modelTest;
    }

    public double[][] getAnchorPlanRound12() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters12(),
                modelIntersection.getWidth2(),
                modelIntersection.getHeight2(),
                modelIntersection.getFormIndication2(),
                anchorsIntersection.getDistanceBetweenRows1(),
                anchorsIntersection.getDistanceLowerAnchor2(),
                anchorsIntersection.getStep2(),
                anchorsIntersection.getLengthAnchor1()
        );
    }

    public double[][] getAnchorPlanRound13() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters13(),
                modelIntersection.getWidth2(),
                modelIntersection.getHeight2(),
                modelIntersection.getFormIndication1(),
                anchorsIntersection.getDistanceBetweenRows1(),
                anchorsIntersection.getDistanceLowerAnchor2(),
                anchorsIntersection.getStep2(),
                anchorsIntersection.getLengthAnchor1()
        );
    }

    public double[][] getAnchorPlanRound21() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters21(),
                modelIntersection.getWidth1(),
                modelIntersection.getHeight1(),
                modelIntersection.getFormIndication1(),
                anchorsIntersection.getDistanceBetweenRows2(),
                anchorsIntersection.getDistanceLowerAnchor1(),
                anchorsIntersection.getStep1(),
                anchorsIntersection.getLengthAnchor2()
        );
    }

    public double[][] getAnchorPlanRound23() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters23(),
                modelIntersection.getWidth1(),
                modelIntersection.getHeight1(),
                modelIntersection.getFormIndication1(),
                anchorsIntersection.getDistanceBetweenRows2(),
                anchorsIntersection.getDistanceLowerAnchor1(),
                anchorsIntersection.getStep1(),
                anchorsIntersection.getLengthAnchor2()
        );
    }

    public double[][] getAnchorPlanRound31() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters31(),
                modelIntersection.getWidth1(),
                modelIntersection.getHeight1(),
                modelIntersection.getFormIndication1(),
                anchorsIntersection.getDistanceBetweenRows3(),
                anchorsIntersection.getDistanceLowerAnchor1(),
                anchorsIntersection.getStep1(),
                anchorsIntersection.getLengthAnchor3()
        );
    }

    public double[][] getAnchorPlanRound32() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                modelCoordinatesIntersection.getRoundingParameters32(),
                modelIntersection.getWidth1(),
                modelIntersection.getHeight1(),
                modelIntersection.getFormIndication1(),
                anchorsIntersection.getDistanceBetweenRows3(),
                anchorsIntersection.getDistanceLowerAnchor1(),
                anchorsIntersection.getStep1(),
                anchorsIntersection.getLengthAnchor3()
        );
    }

    public double[][] getAnchorPlanLine12() {
        double[][] roundXY = getAnchorPlanRound12();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                modelCoordinatesIntersection.getLineParametersRight1(),
                anchorsIntersection.getDistanceBetweenRows1(),
                anchorsIntersection.getLengthAnchor1()
        );
    }

    public double[][] getAnchorPlanLine13() {
        double[][] roundXY = getAnchorPlanRound13();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                modelCoordinatesIntersection.getLineParametersLeft1(),
                anchorsIntersection.getDistanceBetweenRows1(),
                anchorsIntersection.getLengthAnchor1()
        );
    }

    public double[][] getAnchorPlanLine21() {
        double[][] roundXY = getAnchorPlanRound21();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                modelCoordinatesIntersection.getLineParametersLeft2(),
                anchorsIntersection.getDistanceBetweenRows2(),
                anchorsIntersection.getLengthAnchor2()
        );
    }

    public double[][] getAnchorPlanLine23() {
        double[][] roundXY = getAnchorPlanRound23();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                modelCoordinatesIntersection.getLineParametersRight2(),
                anchorsIntersection.getDistanceBetweenRows2(),
                anchorsIntersection.getLengthAnchor2()
        );
    }

    public double[][] getAnchorPlanLine31() {
        double[][] roundXY = getAnchorPlanRound31();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                modelCoordinatesIntersection.getLineParametersRight3(),
                anchorsIntersection.getDistanceBetweenRows3(),
                anchorsIntersection.getLengthAnchor3()
        );
    }

    public double[][] getAnchorPlanLine32() {
        double[][] roundXY = getAnchorPlanRound32();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                modelCoordinatesIntersection.getLineParametersLeft3(),
                anchorsIntersection.getDistanceBetweenRows3(),
                anchorsIntersection.getLengthAnchor3()
        );
    }

    public double[][] getAnchorProjection2() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorProjection(
                modelCoordinatesIntersection.getIncreasedWidth1(),
                modelCoordinatesIntersection.getIncreasedHeight1(),
                modelIntersection.getFormIndicationIntersection(),
                modelIntersection.getWidth1(),
                modelIntersection.getHeight1(),
                modelIntersection.getFormIndication1(),
                modelCoordinatesIntersection.getXCalculateCoordinatePointContact21(),
                modelCoordinatesIntersection.getYCalculateCoordinatePointContact21(),
                modelCoordinatesIntersection.getAngleBetweenCenterRoofAndPointContactRadians21(),
                modelCoordinatesIntersection.getXStartRounding21(),
                -modelIntersection.getHeight2(),
                anchorsIntersection.getDistanceBetweenRows2(),
                anchorsIntersection.getDistanceLowerAnchor1(),
                anchorsIntersection.getStep1(),
                anchorsIntersection.getLengthAnchor2()
        );
    }

    public double[][] getAnchorProjection3() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorProjection(
                modelCoordinatesIntersection.getIncreasedWidth1(),
                modelCoordinatesIntersection.getIncreasedHeight1(),
                modelIntersection.getFormIndicationIntersection(),
                modelIntersection.getWidth1(),
                modelIntersection.getHeight1(),
                modelIntersection.getFormIndication1(),
                modelCoordinatesIntersection.getXCalculateCoordinatePointContact31(),
                modelCoordinatesIntersection.getYCalculateCoordinatePointContact31(),
                modelCoordinatesIntersection.getAngleBetweenCenterRoofAndPointContactRadians31(),
                modelCoordinatesIntersection.getXStartRounding31(),
                -modelIntersection.getHeight3(),
                anchorsIntersection.getDistanceBetweenRows3(),
                anchorsIntersection.getDistanceLowerAnchor1(),
                anchorsIntersection.getStep1(),
                anchorsIntersection.getLengthAnchor3()
        );
    }


    public double[][] getTestLine1() {
        return ServiceAnchorsIntersection.testPlanStartXY(
                modelCoordinatesIntersection.getXIntersectionAxisAndStope1(),
                modelCoordinatesIntersection.getYIntersectionAxisAndStope1(),
                anchorsIntersection.getDistanceBetweenRows1(),
                modelTest.getLengthLineTestAnchorsPlanIntersection()
        );
    }

    public double[][] getTestLine2() {
        return ServiceAnchorsIntersection.testPlanStartXY(
                modelCoordinatesIntersection.getXIntersectionAxisAndStope2(),
                modelCoordinatesIntersection.getYIntersectionAxisAndStope2(),
                anchorsIntersection.getDistanceBetweenRows2(),
                modelTest.getLengthLineTestAnchorsPlanIntersection()
        );
    }

    public double[][] getTestLine3() {
        return ServiceAnchorsIntersection.testPlanStartXY(
                modelCoordinatesIntersection.getXIntersectionAxisAndStope3(),
                modelCoordinatesIntersection.getYIntersectionAxisAndStope3(),
                anchorsIntersection.getDistanceBetweenRows3(),
                modelTest.getLengthLineTestAnchorsPlanIntersection()
        );
    }

    public double[][] getCrossSectionAnchors2() {
        ServiceExcavation excavationService = new ServiceExcavation();
        ServiceAnchorsExcavation anchorsService = new ServiceAnchorsExcavation();
        CalculateCoordinatesAnchorsExcavation calculator =
                new CalculateCoordinatesAnchorsExcavation(excavationService, anchorsService);

        ModelExcavation modelExcavation2 = new ModelExcavation();
        modelExcavation2.setWidth(modelIntersection.getWidth2());
        modelExcavation2.setHeight(modelIntersection.getHeight2());
        modelExcavation2.setFormIndication(modelIntersection.getFormIndication2());

        AnchorsExcavation anchorsExcavation2 = new AnchorsExcavation();
        anchorsExcavation2.setStep(anchorsIntersection.getStep2());
        anchorsExcavation2.setLengthAnchor(anchorsIntersection.getLengthAnchor2());
        anchorsExcavation2.setDistanceLowerAnchor(anchorsIntersection.getDistanceLowerAnchor2());

        calculator.calculateCrossSectionAnchors(modelExcavation2, anchorsExcavation2);

        return anchorsExcavation2.getCrossSectionAnchorsXY();
    }

    public double[][] getCrossSectionAnchors3() {
        ServiceExcavation excavationService = new ServiceExcavation();
        ServiceAnchorsExcavation anchorsService = new ServiceAnchorsExcavation();
        CalculateCoordinatesAnchorsExcavation calculator =
                new CalculateCoordinatesAnchorsExcavation(excavationService, anchorsService);

        ModelExcavation modelExcavation3 = new ModelExcavation();
        modelExcavation3.setWidth(modelIntersection.getWidth3());
        modelExcavation3.setHeight(modelIntersection.getHeight3());
        modelExcavation3.setFormIndication(modelIntersection.getFormIndication3());

        AnchorsExcavation anchorsExcavation3 = new AnchorsExcavation();
        anchorsExcavation3.setStep(anchorsIntersection.getStep3());
        anchorsExcavation3.setLengthAnchor(anchorsIntersection.getLengthAnchor3());
        anchorsExcavation3.setDistanceLowerAnchor(anchorsIntersection.getDistanceLowerAnchor3());

        calculator.calculateCrossSectionAnchors(modelExcavation3, anchorsExcavation3);

        return anchorsExcavation3.getCrossSectionAnchorsXY();
    }
}