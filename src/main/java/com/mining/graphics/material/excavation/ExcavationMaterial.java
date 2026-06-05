package com.mining.graphics.material.excavation;

import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.excavation.AnchorsExcavation;
import com.mining.graphics.model.support.excavation.MeshExcavation;
import com.mining.graphics.service.support.excavation.ServiceMaterialSupportExcavation;

public class ExcavationMaterial {
    private final ModelExcavation modelExcavation;
    private final AnchorsExcavation anchorsExcavation;
    private final MeshExcavation meshExcavation;

    ExcavationMaterial(ModelExcavation modelExcavation, AnchorsExcavation anchorsExcavation, MeshExcavation meshExcavation) {
        this.modelExcavation = modelExcavation;
        this.anchorsExcavation = anchorsExcavation;
        this.meshExcavation = meshExcavation;
    }

    public int numberAnchorsInRow() {
        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();

        double distanceLowerAnchor = anchorsExcavation.getDistanceLowerAnchor();
        double step = anchorsExcavation.getStep();
        int numberAnchorsInRow = ServiceMaterialSupportExcavation.calculateNumberAnchorsInRow(width, height, formIndication, distanceLowerAnchor, step);
        System.out.println("numberAnchorsInRow = " + numberAnchorsInRow);

        return numberAnchorsInRow;
    }

    public int totalNumberAnchors() {
        int numberAnchorsInRow = numberAnchorsInRow();

        //todo в lengthExcavation вместо 0.0 подставить значение длины выработки, которую вводи руководитель проходческого участка
        double lengthExcavation = 0.0;

        int totalNumberAnchors = ServiceMaterialSupportExcavation.calculateTotalNumberAnchors(numberAnchorsInRow, lengthExcavation);

        return totalNumberAnchors;
    }

    public double areaMesh() {
        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();
        double meshVolume = meshExcavation.getMeshVolume();
        double distanceLowerAnchor = anchorsExcavation.getDistanceLowerAnchor();

        double meshLength = ServiceMaterialSupportExcavation.calculateMeshingLength(width, height, formIndication, distanceLowerAnchor);

        //todo в lengthExcavation вместо 0.0 подставить значение длины выработки, которую вводи руководитель проходческого участка
        double lengthExcavation = 0.0;

        double totalAreaMesh = ServiceMaterialSupportExcavation.calculateAreaMesh(meshLength, lengthExcavation);
        return totalAreaMesh;
    }

    public int numberMesh() {
        double areaMesh = areaMesh();
        double meshVolume = meshExcavation.getMeshVolume();
        int numberMesh = ServiceMaterialSupportExcavation.calculateTotalNumberMesh(areaMesh, meshVolume);

        return numberMesh;
    }

    public double shotcreteVolume() {
        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();

        double shotcreteLength = ServiceMaterialSupportExcavation.calculateShotcreteLength(width, height, formIndication);

        //todo в lengthExcavation вместо 0.0 подставить значение длины выработки, которую вводи руководитель проходческого участка
        double lengthExcavation = 0.0;

        double shotcreteVolume = ServiceMaterialSupportExcavation.calculateShotcreteVolume(shotcreteLength, lengthExcavation);

        return shotcreteVolume;
    }
}
