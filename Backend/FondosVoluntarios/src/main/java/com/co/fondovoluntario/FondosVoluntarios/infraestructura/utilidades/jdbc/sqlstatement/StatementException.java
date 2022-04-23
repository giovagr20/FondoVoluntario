package com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.jdbc.sqlstatement;

import java.io.Serial;

/**
 * Excepci�n que se puede presentar al procesar los archivos SQL
 *
 * @author Ceiba Software
 */
public class StatementException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public StatementException(String message) {
        super(message);
    }

}
