package org.almansa.app.core;

public class OwnerBoardInfomationImpl implements OwnerBoardInfomation {

    public long ownerBoardKey;

    public OwnerBoardInfomationImpl(long ownerBoardKey) {
        super();
        this.ownerBoardKey = ownerBoardKey;
    }

    @Override
    public long getOwnerBoardKey(){
        return ownerBoardKey;
    }
}