package org.almansa.app.core;

public class WriterInfomationImpl implements WriterInfomation {

    private long writerId;
    private String writerLoginId;

    public WriterInfomationImpl(long writerId, String writerLoginId) {
        super();
        this.writerId = writerId;
        this.writerLoginId = writerLoginId;
    }

    public long getWriterId() {
        return writerId;
    }

    public String getWriterLoginId() {
        return writerLoginId;
    }
}