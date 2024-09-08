package main;

import java.io.IOException;

public class FileException extends IOException {
    // 自定义基础文件异常
    public FileException(String message) {
        super(message);
    }

    // 自定义路径无效异常
    public static class InvalidFilePathException extends FileException {
        public InvalidFilePathException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }
}

