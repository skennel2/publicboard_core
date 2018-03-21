package org.almansa.app.core;

public class MemberDefaultInfomationImpl implements MemberDefaultInfomation {

    private Long writerId;
    private String writerLoginId;

    public MemberDefaultInfomationImpl(Long writerId, String writerLoginId) {
        super();
        this.writerId = writerId;
        this.writerLoginId = writerLoginId;
    }

    public long getMemberId() {
        return writerId;
    }

    public String getMemberLoginId() {
        return writerLoginId;
    }
}