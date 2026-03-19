package com.danilo.coinmanager.helper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DataHelper {

    public static Timestamp dataHoraAtual() {
        LocalDateTime localDateTime = LocalDateTime.now();

        return Timestamp.valueOf(localDateTime);
    }

}
