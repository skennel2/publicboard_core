package org.almansa.app.core.entity.comment;

import java.util.Date;

import org.almansa.app.core.Immutable;

public class RecommendRecord implements Immutable{
    Long recommenderId;
    Date recommendDate;
           
    public RecommendRecord(Long recommenderId, Date recommendDate) {
        super();
        this.recommenderId = recommenderId;
        this.recommendDate = recommendDate;
    }

    public Long getRecommenderId() {
        return recommenderId;
    }

    public Date getRecommendDate() {
        return recommendDate;
    }
}

