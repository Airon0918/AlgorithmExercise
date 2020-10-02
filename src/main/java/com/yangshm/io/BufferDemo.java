package com.yangshm.io;

import org.junit.Test;

public class BufferDemo {

    @Test
    public void channelTest() {
        String a = "aaa";
        String b = "bbb";
        String c = "aaa";
        a.compareTo(b);
        a.compareTo(c);
        b.compareTo(a);
    }
}
