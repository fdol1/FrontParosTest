package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiMenuGestorParo {

    public static final Target LBL_NOMBRE_USUARIO =
            Target.the("")
                    .locatedBy("//span[contains(text(), '{0}')]");

    public static final Target LBL_CONFECCIONES =
            Target.the("")
                    .locatedBy("//h2[contains(text(),'Confecciones')]");

    public static final Target BTN_TABLERO_PAROS =
            Target.the("")
                    .locatedBy("//div[@class='hm-app-container col-xl-3 col-lg-4 col-md-6 col-sm-12 col-12']");
}