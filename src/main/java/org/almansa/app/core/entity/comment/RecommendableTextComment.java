package org.almansa.app.core.entity.comment;

import java.util.Date;

import org.almansa.app.core.PostDefaultInfomation;
import org.almansa.app.core.Recommendable;
import org.almansa.app.core.MemberDefaultInfomation;

public class RecommendableTextComment extends DefaultTextComment implements Recommendable {

    private RecommendRecords recommends;
    
    public RecommendableTextComment(Date creationDate, String contents, PostDefaultInfomation ownerPostInfomation,
            MemberDefaultInfomation writerInfomation, RecommendRecords recommends) {
        super(creationDate, contents, ownerPostInfomation, writerInfomation);
        this.recommends = recommends;
    }

    @Override
    public int getRecommendCount() {        
        return recommends.getRecommendCount();
    }

    @Override
    public void recommend(MemberDefaultInfomation memberInfomation) {
        if(recommends.isAbleToRecommend(memberInfomation.getMemberId())) {
            
            RecommendRecord record = new RecommendRecord(memberInfomation, new Date());
            recommends.recommend(record);
        }
    }
}
