package com.yangshm.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

final class Handler implements Runnable {
    static final int MAXIN = 1024, MAXOUT = 1024, READING = 0, SENDING = 1;
    final SocketChannel socket;
    final SelectionKey sk;
    ByteBuffer input = ByteBuffer.allocate(MAXIN);
    ByteBuffer output = ByteBuffer.allocate(MAXOUT);
    int state = READING;

    Handler(Selector s, SocketChannel c) throws IOException {
        this.socket = c;
        c.configureBlocking(false);
        sk = socket.register(s, 0);
        sk.interestOps(SelectionKey.OP_READ);
        s.wakeup();
    }

    boolean inputIsComplete() {
        return true;
    }

    boolean outputIsComplete() {
        return true;
    }

    void process() {
    }

    @Override
    public void run() {
        try {
            if (state == READING) {
                read();
            } else if (state == SENDING) {
                send();
            }
        } catch (IOException e) {
        }
    }

    void read() throws IOException {
        socket.read(input);
        if (inputIsComplete()) {
            process();
            state = SENDING;
            sk.interestOps(SelectionKey.OP_WRITE);
        }
    }

    void send() throws IOException {
        socket.write(input);
        if (outputIsComplete()) {
            sk.cancel();
        }
    }
}
