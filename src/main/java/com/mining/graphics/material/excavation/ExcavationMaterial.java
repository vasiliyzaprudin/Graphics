package com.mining.graphics.material.excavation;

import com.mining.graphics.model.excavation.ModelExcavation;
import com.mining.graphics.model.support.excavation.AnchorsExcavation;
import com.mining.graphics.service.support.excavation.ServiceMaterialSupportExcavation;

public class ExcavationMaterial {
    private final ModelExcavation modelExcavation;
    private final AnchorsExcavation anchorsExcavation;

    ExcavationMaterial(ModelExcavation modelExcavation, AnchorsExcavation anchorsExcavation){
        this.modelExcavation = modelExcavation;
        this.anchorsExcavation = anchorsExcavation;
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

    public int totalNumberAnchorsExcavation (){
        int numberAnchorsInRow = numberAnchorsInRow();

        //todo в lengthExcavation вместо 0.0 подставить значение длины выработки, которую вводи руководитель проходческого участка
        double lengthExcavation = 0.0;

        int totalNumberAnchorsExcavation = ServiceMaterialSupportExcavation.calculateTotalNumberAnchorsExcavation (numberAnchorsInRow, lengthExcavation);

        return totalNumberAnchorsExcavation;
    }

    public int totalNumberMeshExcavation (){
        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();

        double meshLength = ServiceMaterialSupportExcavation.calculateTotalMeshingLength(width,height,formIndication);

        //todo в lengthExcavation вместо 0.0 подставить значение длины выработки, которую вводи руководитель проходческого участка
        double lengthExcavation = 0.0;

        int totalNumberMeshExcavation = ServiceMaterialSupportExcavation.calculateTotalNumberMesh(meshLength,lengthExcavation);
        return totalNumberMeshExcavation;
    }

    public double shotcreteVolume (){
        double width = modelExcavation.getWidth();
        double height = modelExcavation.getHeight();
        double formIndication = modelExcavation.getFormIndication();

        double shotcreteLength = ServiceMaterialSupportExcavation.calculateShotcreteLength(width,height,formIndication);

        //todo в lengthExcavation вместо 0.0 подставить значение длины выработки, которую вводи руководитель проходческого участка
        double lengthExcavation = 0.0;

        double shotcreteVolume = ServiceMaterialSupportExcavation.calculateShotcreteVolume(shotcreteLength, lengthExcavation);

        return shotcreteVolume;
    }
}
