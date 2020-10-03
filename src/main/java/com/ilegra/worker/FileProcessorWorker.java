package com.ilegra.worker;

import com.ilegra.domain.FilePath;
import com.ilegra.model.ResultData;
import com.ilegra.processor.DataProcessor;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorWorker extends Thread {

    private static Logger logger = Logger.getLogger(FileProcessorWorker.class);

    private Path file;
    private DataProcessor dataProcessor;

    private FileProcessorWorker(Path file) {
        this.file = file;
        this.dataProcessor = new DataProcessor();
    }

    @Override
    public void run() {
        logger.info(String.format("Processing file %s", file.getFileName()));

        try {
            ResultData resultData = dataProcessor.processFile(FilePath.IN.getPath().resolve(file));
            saveResultData(resultData);

            logger.info(String.format("File %s processing completed", file.getFileName()));
        } catch (Exception e) {
            logger.error(String.format("Error on processing file %s: ", file.getFileName()), e);
        }
    }

    private void saveResultData(ResultData resultData) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(FilePath.OUT.getPath().resolve(file))) {
            writer.write(String.format("Client amount: %s\n", resultData.getClientAmount()));
            writer.write(String.format("Salesman amount: %s\n", resultData.getSalesmanAmount()));
            writer.write(String.format("Most expensive sale: %s\n", resultData.getSaleId()));
            writer.write(String.format("Worst salesman: %s", resultData.getWorstSalesman()));
        }
    }

    public static void startNewProcess(Path file) {
        if (file.toString().endsWith(".dat"))
            new FileProcessorWorker(file).start();
    }

}
