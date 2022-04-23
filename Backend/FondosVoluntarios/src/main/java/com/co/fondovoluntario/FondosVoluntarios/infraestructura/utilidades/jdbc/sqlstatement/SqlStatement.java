package com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.jdbc.sqlstatement;

import java.lang.annotation.*;

/**
 * Anotación para declarar las consultas SQL
 *
 * @author Ceiba Software
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
public @interface SqlStatement {

    String value() default "";

    String namespace() default "";

}
