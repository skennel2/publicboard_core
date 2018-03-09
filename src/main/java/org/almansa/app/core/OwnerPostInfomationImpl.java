package org.almansa.app.core;

public class OwnerPostInfomationImpl implements OwnerBoardInfomation {

    private long ownerBoardKey;

    public OwnerPostInfomationImpl(long ownerBoardKey) {
        super();
        this.ownerBoardKey = ownerBoardKey;
    }

    @Override
    public long getOwnerBoardKey() {
        // TODO Auto-generated method stub
        return ownerBoardKey;
    }
}