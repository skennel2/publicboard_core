package org.almansa.app.core;

public class PostDefaultInfomationImpl implements PostDefaultInfomation {

    private Long ownerBoardKey;

    public PostDefaultInfomationImpl(Long ownerBoardKey) {
        super();
        this.ownerBoardKey = ownerBoardKey;
    }

    @Override
    public long getPostId() {
        return ownerBoardKey;
    }

}