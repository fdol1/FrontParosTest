package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiTableroGestorParos {

    public static final String BTN_ORDEN_FABRICACION = "(//button[@class='ld-btn   ld-btn-secondary btn btn-secondary'])[3]";

    public static final Target SCL_COBRO =
            Target.the("Scrol para modificar el cobro a si/no")
                    .locatedBy("//select[@Class = 'ld-select']");

    public static final String BTN_GUARDAR_CAMBIO = "((//*[@class='col-6'])[2])//button[5]";

    public static final Target SCL_COBRO_VALUE_SI =
            Target.the("Opcion del scroll")
                    .locatedBy("((//div[@class='ld-table-col']//table//tbody//tr)[1]//td[37]//option)[2]");

public static final Target SCL_COBRO_VALUE_NO =
            Target.the("Opcion del scroll")
                    .locatedBy("((//div[@class='ld-table-col']//table//tbody//tr)[1]//td[37]//option)[3]");

    public static final Target TXT_MOTIVO_PARO =
            Target.the("Opcion del scroll")
                    .locatedBy("//tbody/tr[1]/td[39]/div[1]/div[1]/input[1]");

    public static final Target SPN_SPINNER =
            Target.the("Espiner de espera")
                    .locatedBy("//div[@class='spinner-border']");
}