package com.yangshm.zookeeper;

/**
 *
 */
public class SnowflakeIdGenerator {
    private static final long START_TIME = 1483200000000L;
    private static final int WORKER_ID_BITS = 13;
    private static final int SEQUENCE_BITS = 10;
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);
    private static final long APP_HOST_ID_SHIFT = SEQUENCE_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT = WORKER_ID_BITS + APP_HOST_ID_SHIFT;

    private long workerId;
    private long lastTimestamp = -1L;
    private long sequence = 0L;

    public static SnowflakeIdGenerator instance = new SnowflakeIdGenerator();

    public synchronized void init(long workerId) {
        if (workerId > MAX_WORKER_ID) {
            throw new IllegalArgumentException("");
        }
        instance.workerId = workerId;
    }

    public Long nextId() {
        return generateId();
    }

    private synchronized long generateId() {
        long current = System.currentTimeMillis();
        if (current < lastTimestamp) {
            return -1;
        }
        if (current == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == MAX_SEQUENCE) {
                current = this.nextMs(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = current;

        long time = (current - START_TIME) << TIMESTAMP_LEFT_SHIFT;
        long workerId = this.workerId << APP_HOST_ID_SHIFT;

        return time | workerId | sequence;
    }

    private long nextMs(long timeStamp) {
        long current = System.currentTimeMillis();
        while (current <= timeStamp) {
            current = System.currentTimeMillis();
        }
        return current;
    }

}
