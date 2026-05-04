package com.mining.graphics.service.support.intersection;

import com.mining.graphics.model.coordinates.CoordinatesIntersection;
import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.excavation.ModelIntersection;
import com.mining.graphics.model.support.excavation.AnchorsExcavation;
import com.mining.graphics.model.support.intersection.AnchorsIntersection;
import com.mining.graphics.service.support.excavation.CalculateCoordinatesAnchorsExcavation;
import com.mining.graphics.service.support.excavation.ServiceAnchorsExcavation;

public class CalculateCoordinatesAnchorsIntersection {

    private final ModelIntersection modelIntersection;
    private final CoordinatesIntersection coordinatesIntersection;
    private final AnchorsIntersection anchorsIntersection;

    public CalculateCoordinatesAnchorsIntersection(
            ModelIntersection modelIntersection,
            CoordinatesIntersection modelCoordinatesIntersection,
            AnchorsIntersection anchorsIntersection) {
        this.modelIntersection = modelIntersection;
        this.coordinatesIntersection = modelCoordinatesIntersection;
        this.anchorsIntersection = anchorsIntersection;
    }

    public double[][] getAnchorPlanRound12() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanRound(
                coordinatesIntersection.getRoundingParameters12(),
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
                coordinatesIntersection.getRoundingParameters13(),
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
                coordinatesIntersection.getRoundingParameters21(),
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
                coordinatesIntersection.getRoundingParameters23(),
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
                coordinatesIntersection.getRoundingParameters31(),
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
                coordinatesIntersection.getRoundingParameters32(),
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
                coordinatesIntersection.getLineParametersRight1(),
                anchorsIntersection.getDistanceBetweenRows1(),
                anchorsIntersection.getLengthAnchor1()
        );
    }

    public double[][] getAnchorPlanLine13() {
        double[][] roundXY = getAnchorPlanRound13();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                coordinatesIntersection.getLineParametersLeft1(),
                anchorsIntersection.getDistanceBetweenRows1(),
                anchorsIntersection.getLengthAnchor1()
        );
    }

    public double[][] getAnchorPlanLine21() {
        double[][] roundXY = getAnchorPlanRound21();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                coordinatesIntersection.getLineParametersLeft2(),
                anchorsIntersection.getDistanceBetweenRows2(),
                anchorsIntersection.getLengthAnchor2()
        );
    }

    public double[][] getAnchorPlanLine23() {
        double[][] roundXY = getAnchorPlanRound23();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                coordinatesIntersection.getLineParametersRight2(),
                anchorsIntersection.getDistanceBetweenRows2(),
                anchorsIntersection.getLengthAnchor2()
        );
    }

    public double[][] getAnchorPlanLine31() {
        double[][] roundXY = getAnchorPlanRound31();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                coordinatesIntersection.getLineParametersRight3(),
                anchorsIntersection.getDistanceBetweenRows3(),
                anchorsIntersection.getLengthAnchor3()
        );
    }

    public double[][] getAnchorPlanLine32() {
        double[][] roundXY = getAnchorPlanRound32();
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorPlanLine(
                roundXY,
                coordinatesIntersection.getLineParametersLeft3(),
                anchorsIntersection.getDistanceBetweenRows3(),
                anchorsIntersection.getLengthAnchor3()
        );
    }

    public double[][] getAnchorProjection2() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorProjection(
                coordinatesIntersection.getIncreasedWidth1(),
                coordinatesIntersection.getIncreasedHeight1(),
                modelIntersection.getFormIndicationIntersection(),
                modelIntersection.getWidth1(),
                modelIntersection.getHeight1(),
                modelIntersection.getFormIndication1(),
                coordinatesIntersection.getXCalculateCoordinatePointContact21(),
                coordinatesIntersection.getYCalculateCoordinatePointContact21(),
                coordinatesIntersection.getAngleBetweenCenterRoofAndPointContactRadians21(),
                coordinatesIntersection.getXStartRounding21(),
                -modelIntersection.getHeight2(),
                anchorsIntersection.getDistanceBetweenRows2(),
                anchorsIntersection.getDistanceLowerAnchor1(),
                anchorsIntersection.getStep1(),
                anchorsIntersection.getLengthAnchor2()
        );
    }

    public double[][] getAnchorProjection3() {
        return ServiceAnchorsIntersection.calculateCoordinatesAnchorProjection(
                coordinatesIntersection.getIncreasedWidth1(),
                coordinatesIntersection.getIncreasedHeight1(),
                modelIntersection.getFormIndicationIntersection(),
                modelIntersection.getWidth1(),
                modelIntersection.getHeight1(),
                modelIntersection.getFormIndication1(),
                coordinatesIntersection.getXCalculateCoordinatePointContact31(),
                coordinatesIntersection.getYCalculateCoordinatePointContact31(),
                coordinatesIntersection.getAngleBetweenCenterRoofAndPointContactRadians31(),
                coordinatesIntersection.getXStartRounding31(),
                -modelIntersection.getHeight3(),
                anchorsIntersection.getDistanceBetweenRows3(),
                anchorsIntersection.getDistanceLowerAnchor1(),
                anchorsIntersection.getStep1(),
                anchorsIntersection.getLengthAnchor3()
        );
    }

    public double[][] getCrossSectionAnchors2() {
        ServiceAnchorsExcavation anchorsService = new ServiceAnchorsExcavation();
        CalculateCoordinatesAnchorsExcavation calculator =
                new CalculateCoordinatesAnchorsExcavation(anchorsService);

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
        ServiceAnchorsExcavation anchorsService = new ServiceAnchorsExcavation();
        CalculateCoordinatesAnchorsExcavation calculator =
                new CalculateCoordinatesAnchorsExcavation(anchorsService);

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