package org.almansa.app.core;

public interface Recommendable {
    int getRecommendCount();
    boolean isAbleToRecommend(Long memberId);
}
