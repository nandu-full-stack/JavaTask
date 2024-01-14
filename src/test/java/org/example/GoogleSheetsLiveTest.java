package org.example;

import Util.SheetsServiceUtil;
import com.google.api.services.sheets.v4.Sheets;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.api.services.sheets.v4.model.ValueRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GoogleSheetsLiveTest {
    private static final Logger logger = LoggerFactory.getLogger(GoogleSheetsLiveTest.class);

    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1JAcHWPZquwYwSCLYl-ddfnrcmtpiDqSgMLlTApC-5qI";

    @BeforeClass
    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }

    @Test
    public void whenWriteSheet_thenReadSheetOk() throws IOException {
        Configurator.initialize(null, "log4j2.xml");

        String rangeToRead = "A2:E";
        ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, rangeToRead).execute();

        List<List<Object>> values = response.getValues();


        Collections.sort(values, Comparator.comparing(row -> Integer.parseInt((String) row.get(1)), Comparator.reverseOrder()));

        for (List<Object> row : values) {
            logger.info(row.toString());
        }
    }
}