package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiSolicitudDeParos {

    public static final Target TXT_BUSCAR_ORDEN =
            Target.the("Elemento para buscar la orden")
                    .locatedBy("//input[@placeholder='Buscar solicitud de paro']");

    public static final Target CKBX_ITEM =
            Target.the("Campo para marcar el item y ver lo elementos")
                    .locatedBy("//tbody/tr/td/div/input");

    public static final Target SCL_CAUSA_PARO =
            Target.the("Opcion con la lista de causales de un paro")
                    .locatedBy("//select[@Class = 'ld-select']");

    public static final Target SCL_CAUSA_PARO_VALUE =
            Target.the("Item de la lista de causales de paros")
                    .locatedBy("//select[@Class = 'ld-select']/option[contains(text(), '{0}')]");

    public static final Target BTN_ENVIAR =
            Target.the("Boton para enviar el cambio")
                    .locatedBy("//span[contains(text(),'Enviar')]");

    public static final Target BTN_GUARDAR_CAMBIO1 =
            Target.the("Boton para guardar el cambio en la modificacion del paro")
                    .locatedBy("((//*[@class='col-6'])[2])//button[5]");

    public static final String BTN_GUARDAR_MODIFICACION_PARO = "(//button[@class='ld-btn   ld-btn-primary btn btn-primary'])[2]";

    public static final Target BTN_CONTINUAR =
            Target.the("Boton para confirmar el cambio de la modificacion del paro")
                    .locatedBy("//span[contains(text(),'Continuar')]");

    public static final Target MENSAJE_DE_IFORMACION =
            Target.the("Mensaje que confirm el cambio en la modificacion del paro")
                    .locatedBy("//span[contains(text(),'{0}')]");

    public static final Target TXT_CANTIDAD_INSUMOS =
            Target.the("Campo donde s ingresa la cantidad de telas")
                    .locatedBy("//input[@Class = 'ld-field-control form-control']");

    public static final Target BTN_OBSERVACION =
            Target.the("Boton para realizar observacion del paro")
                    .locatedBy("//button[@Class='ld-btn ld-btn-view  ld-btn-primary btn btn-primary']");

    public static final Target TXT_OBSERVACION =
            Target.the("Campo para dejar observacion del paro")
                    .locatedBy("//textarea[@Class='ld-field-control form-control']");

    public static final Target BTN_GUARDAR_OBSERVACION =
            Target.the("Boton para guardar la observacion")
                    .locatedBy("//span[contains(text(),'Guardar')]");

    public static final Target SCL_PROCESO_SOLICITADO =
            Target.the("Opcion para cambiar el proceso solicitado")
                    .locatedBy("//tbody/tr[1]/td[11]/select[1]");

    public static final Target SCL_PROCESO_SOLICITADO_VALUE =
            Target.the("Opcion para seleccionar el proceso solicitado")
                    .locatedBy("((((//div[@class='ld-table-col'])[2]//table//tbody//tr)[1]//td)[11]//select//option)[2]");

    public static final String SCL_PROCESO_SOLICITADO_VALUE2 = "//select[@Class = 'ld-select']/option[contains(text(), 'ESTAMPACIÓN PRENDAS/TELAS')]";
}