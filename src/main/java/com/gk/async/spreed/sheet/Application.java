package com.gk.async.spreed.sheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Application {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Sheet>> resultList = new ArrayList<>();
        Workbook wb = new HSSFWorkbook();
        Sheet1 sheet1 = new Sheet1(wb);
        Future<Sheet> result = executor.submit(sheet1);
        resultList.add(result);
        Sheet2 sheet2 = new Sheet2(wb);
        result = executor.submit(sheet2);
        resultList.add(result);

        int size = 0;
        System.out.println(LocalDateTime.now());
        try (OutputStream fileOut = new FileOutputStream("Javatpoint.xls")) {
            for (Future<Sheet> future : resultList) {
                Sheet sh = future.get();

                System.out.println("Future result is - " + " - " + sh.getSheetName() + "; And Task done is " + future.isDone());

                if (future.isDone()) {
                    size++;
                }
            }
            if (size == resultList.size()) {
                wb.setSheetOrder("I am Sheet 2", 0);
                wb.write(fileOut);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(LocalDateTime.now());
        //shut down the executor service now
        executor.shutdown();

        System.out.print("Hello");

    }


}
