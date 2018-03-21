package org.almansa.app.core.entity.comment;

import java.util.ArrayList;
import java.util.List;

public class RecommendRecords{
    List<RecommendRecord> recommends;
           
    public RecommendRecords(List<RecommendRecord> recommends) {
        super();
        if(recommends == null){
            this.recommends = new ArrayList<RecommendRecord>();
        }
        this.recommends = recommends;
    }
    
    public RecommendRecords() {
        super();
        this.recommends = new ArrayList<RecommendRecord>();
    }

    public boolean isAbleToRecommend(Long memberId) {
        if(memberId == null) {
            return false;
        }
        
        for (RecommendRecord recommendRecord : recommends) {
            if(recommendRecord.getRecommender().getMemberId() == memberId) {
                return false;
            }
        }
        
        return true;
    }
    
    public void recommend(RecommendRecord record) {
        if(!isAbleToRecommend(record.getRecommender().getMemberId())) {
            throw new RuntimeException("duplicated recommend");
        }
        
        recommends.add(record);
    }
    
    public int getRecommendCount() {
        return recommends.size();
    }
}