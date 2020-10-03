package com.ilegra.processor;

import com.ilegra.domain.FilePath;
import com.ilegra.worker.FileProcessorWorker;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;

public class FileProcessor {

    private static Logger logger = Logger.getLogger(FileProcessor.class);

    public void init() {
        try {
            watchNewFiles();
        } catch (Exception e) {
            logger.error("Error on watching new files: ", e);
        }
    }

    private void watchNewFiles() throws IOException, InterruptedException {
        validateIfPathExists(FilePath.IN.getPath());
        validateIfPathExists(FilePath.OUT.getPath());

        WatchService watchService = FileSystems.getDefault().newWatchService();
        FilePath.IN.getPath().register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        WatchKey key;

        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents())
                FileProcessorWorker.startNewProcess((Path) event.context());

            key.reset();
        }
    }

    private void validateIfPathExists(Path path) {
        if (!path.toFile().exists()) throw new RuntimeException(String.format("The directory %s doesn't exists", path.toAbsolutePath().toString()));
    }


}
