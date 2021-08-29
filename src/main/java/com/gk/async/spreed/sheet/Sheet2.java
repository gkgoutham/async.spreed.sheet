package com.gk.async.spreed.sheet;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.concurrent.Callable;

public class Sheet2 implements Callable<Sheet> {

    private Workbook workbook;
    public Sheet2(Workbook workbook) {
        this.workbook = workbook;
    }


    @Override
    public Sheet call() throws Exception {
        Sheet sheet =this.workbook.createSheet("I am Sheet 2");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sheet;
    }
}
