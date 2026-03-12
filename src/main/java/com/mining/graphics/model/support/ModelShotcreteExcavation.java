package com.mining.graphics.model.support;

import com.mining.graphics.model.excavation.ModelExcavation;

public class ModelShotcreteExcavation extends ModelExcavation {
    public double tsh = 0.15; //толщина набрызгбетона в метрах
    public int tshsc = (int) (tsh * GRAPHICS_SCALE); //толщина набрызгбетона в масштабе
}
