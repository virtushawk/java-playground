package com.virtushawk.app.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileRead {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("D:\\test.txt", "rw");

        FileChannel channel = aFile.getChannel();

        ByteBuffer charBuffer = ByteBuffer.allocate(100);

        int bytesRead = channel.read(charBuffer);

        System.out.print((char) charBuffer.get()); // r

        while (bytesRead != -1) {
            charBuffer.flip();  //make buffer ready for read

            while (charBuffer.hasRemaining()) {
                System.out.print((char) charBuffer.get()); // read 1 byte at a time
            }

            charBuffer.clear(); //make buffer ready for writing
            bytesRead = channel.read(charBuffer);
        }

        aFile.close();
    }
}
