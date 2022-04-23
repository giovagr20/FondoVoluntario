SELECT fv.nombre_fondo, fv.monto, fv.categoria
    FROM fondosvoluntarios.fondos fv
        WHERE fv.id = :id