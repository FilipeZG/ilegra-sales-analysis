package com.ilegra.domain;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public enum FilePath {

    IN {

        @Override
        public Path getPath() {
            return Paths.get(System.getProperty("user.home") + File.separator + "data" + File.separator + "in");
        }

    },
    OUT {

        @Override
        public Path getPath() {
            return Paths.get(System.getProperty("user.home") + File.separator + "data" + File.separator + "out");
        }

    };

    public abstract Path getPath();

}
