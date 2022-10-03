package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiMenuConfeccionista {

    public static final Target BTN_SOLICITAR_PARO =
            Target.the("Elemento para entar a la seccion de solicitud de paro")
                    .locatedBy("//div[@class='row no-gutters']/div/div[@class=' hm-tile-container']/span/span[@class='lb-label-text subtitle-3'][contains(text(),'Solicitud de Paros')]");

    public static final Target BTN_AGENDAR_CITAS =
            Target.the("Elemento para entar a la seccion para agendar las citas")
                    .locatedBy("//div[@class='row no-gutters']/div/div[@class=' hm-tile-container']/span/span[@class='lb-label-text subtitle-3'][contains(text(),'Agendar Citas')]");
}