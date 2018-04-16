package org.almansa.app.core.entity.comment;

import java.util.Date;

import org.almansa.app.core.Immutable;
import org.almansa.app.core.MemberDefaultInfomation;

public class RecommendRecord implements Immutable{
    MemberDefaultInfomation recommender;
    Date recommendDate;
           
    public RecommendRecord(MemberDefaultInfomation recommender, Date recommendDate) {
        super();
        this.recommender = recommender;
        this.recommendDate = recommendDate;
    }

    public MemberDefaultInfomation getRecommender() {
        return recommender;
    }

    public Date getRecommendDate() {
        return recommendDate;
    }
}

