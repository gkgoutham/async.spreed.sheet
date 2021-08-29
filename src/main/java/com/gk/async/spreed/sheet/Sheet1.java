package com.gk.async.spreed.sheet;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.concurrent.Callable;

public class Sheet1 implements  Callable<Sheet> {

    private Workbook workbook;
    public Sheet1(Workbook workbook) {
        this.workbook = workbook;
    }


    @Override
    public Sheet call() throws Exception {
        Sheet sheet =this.workbook.createSheet("I am Sheet 1");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sheet;
    }
}
