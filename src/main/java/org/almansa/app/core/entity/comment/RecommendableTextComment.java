package org.almansa.app.core.entity.comment;

import java.util.Date;

import org.almansa.app.core.PostDefaultInfomation;
import org.almansa.app.core.Recommendable;
import org.almansa.app.core.MemberDefaultInfomation;

public class RecommendableTextComment extends DefaultTextComment implements Recommendable {

    private RecommendRecordList recommends;
    
    public RecommendableTextComment(Date creationDate, String contents, PostDefaultInfomation ownerPostInfomation,
            MemberDefaultInfomation writerInfomation, RecommendRecordList recommends) {
        super(creationDate, contents, ownerPostInfomation, writerInfomation);
        this.recommends = recommends;
    }

    @Override
    public int getRecommendCount() {        
        return recommends.getRecommendCount();
    }

    @Override
    public boolean isAbleToRecommend(Long memberId) {
        return recommends.isAbleToRecommend(memberId);
    }
}
