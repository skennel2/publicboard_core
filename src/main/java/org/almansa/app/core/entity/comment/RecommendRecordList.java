package org.almansa.app.core.entity.comment;

import java.util.ArrayList;
import java.util.List;

import org.almansa.app.core.Immutable;

public class RecommendRecordList implements Immutable{
    List<RecommendRecord> recommends;
           
    public RecommendRecordList(List<RecommendRecord> recommends) {
        super();
                
        this.recommends = recommends;
    }
    
    public RecommendRecordList() {
        super();
        this.recommends = new ArrayList<RecommendRecord>();
    }

    public boolean isAbleToRecommend(Long memberId) {
        if(memberId == null) {
            return false;
        }
        
        return !recommends.stream()
        	.filter((record)-> record.getRecommenderId().equals(memberId))
        	.findFirst()
        	.isPresent();     
    }
    
    public int getRecommendCount() {
        return recommends.size();
    }

    @Override
    public String toString() {
        return "RecommendRecordList [recommends=" + recommends + "]";
    }       
}