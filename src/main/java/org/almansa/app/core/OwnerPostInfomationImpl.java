package org.almansa.app.core;

public class OwnerPostInfomationImpl implements OwnerPostInfomation {

    private long ownerBoardKey;

    public OwnerPostInfomationImpl(long ownerBoardKey) {
        super();
        this.ownerBoardKey = ownerBoardKey;
    }

    @Override
    public long getOwnerPostKey() {
        return ownerBoardKey;
    }

}