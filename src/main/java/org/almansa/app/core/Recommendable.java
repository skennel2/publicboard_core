package org.almansa.app.core;

public interface Recommendable {
    int getRecommendCount();
    void recommend(MemberDefaultInfomation memberInfomation);
}
