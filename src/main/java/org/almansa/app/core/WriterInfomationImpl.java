package org.almansa.app.core;

public class WriterInfomationImpl implements WriterInfomation {

    private Long writerId;
    private String writerLoginId;

    public WriterInfomationImpl(Long writerId, String writerLoginId) {
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