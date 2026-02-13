package com.mining.graphics.model.support;

import com.mining.graphics.model.excavation.ModelExcavation;

public class ModelShotcreteEx extends ModelExcavation {
    public double tsh = 0.15; //толщина набрызгбетона в метрах
    public int tshsc = (int) (tsh * scaleEx); //толщина набрызгбетона в масштабе
}
