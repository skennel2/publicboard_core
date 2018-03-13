package org.almansa.app.core;

public class OwnerPostInfomationImpl implements OwnerPostInfomation {

    private Long ownerBoardKey;

    public OwnerPostInfomationImpl(Long ownerBoardKey) {
        super();
        this.ownerBoardKey = ownerBoardKey;
    }

    @Override
    public long getOwnerPostKey() {
        return ownerBoardKey;
    }

}