package org.almansa.app.core.entity.comment;

import java.util.ArrayList;
import java.util.List;

import org.almansa.app.core.Immutable;

public class RecommendRecordList implements Immutable{
    List<RecommendRecord> recommends;
           
    public RecommendRecordList(List<RecommendRecord> recommends) {
        super();
        if(recommends == null){
            this.recommends = new ArrayList<RecommendRecord>();
        }else {
            this.recommends = recommends;
        }
    }
    
    public RecommendRecordList() {
        super();
        this.recommends = new ArrayList<RecommendRecord>();
    }

    public boolean isAbleToRecommend(Long memberId) {
        if(memberId == null) {
            return false;
        }
        
        for (RecommendRecord recommendRecord : recommends) {
            if(recommendRecord.getRecommenderId() == memberId) {
                return false;
            }
        }
        
        return true;
    }
    
    public int getRecommendCount() {
        return recommends.size();
    }

    @Override
    public String toString() {
        return "RecommendRecordList [recommends=" + recommends + "]";
    }       
}