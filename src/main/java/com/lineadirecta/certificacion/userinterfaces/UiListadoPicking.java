package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiListadoPicking {

    public static final Target LBL_COMPONENTE =
            Target.the("Campo del listado de picking")
                    .locatedBy("//table[@class='table ld-table table table-striped table-bordered table-hover']/tbody/tr/td[contains(text(),'{0}')]");

    public static final Target LBL_CATEGORIA =
            Target.the("")
                    .locatedBy("//table[@class='table ld-table table table-striped table-bordered table-hover']/tbody/tr/td/button/span[contains(text(),'{0}')]");

    public static final Target LBL_TEXTO_COMPONENTE =
            Target.the("")
                    .locatedBy("//table[@class='table ld-table table table-striped table-bordered table-hover']/tbody/tr/td[contains(text(),'{0}')]");

    public static final Target LBL_LOTE =
            Target.the("")
                    .locatedBy("//table[@class='table ld-table table table-striped table-bordered table-hover']/tbody/tr/td[contains(text(),'{0}')]");

    public static final Target LBL_UNIDAD_MEDIDA =
            Target.the("")
                    .locatedBy("//table[@class='table ld-table table table-striped table-bordered table-hover']/tbody/tr/td[contains(text(),'{0}')]");

    public static final Target LBL_CANTIDAD_OT =
            Target.the("")
                    .locatedBy("//table[@class='table ld-table table table-striped table-bordered table-hover']/tbody/tr/td[contains(text(),'{0}')]");
}