package com.meucarro.util;

import com.meucarro.exception.RegraNegocioException;

import java.time.*;

public class Conversor {




    public Long parseLong(LocalDate timestamp_cadastro) {
        try {

          return  timestamp_cadastro.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();

        } catch (Exception e) {
            throw new RegraNegocioException("Falha ao realizar a conversao de data" + e.getMessage());
        }

    }


    public LocalDate parseLocalDate(Long timestamp_cadastro) {
        try {
            LocalDate date =
                    Instant.ofEpochMilli(timestamp_cadastro)
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
            return  date;

        } catch (Exception e) {
            throw new RegraNegocioException("Falha ao realizar a conversao de data" + e.getMessage());
        }

    }
}