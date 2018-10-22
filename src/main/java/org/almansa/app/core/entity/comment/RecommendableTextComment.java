package org.almansa.app.core.entity.comment;

import java.util.Date;

import org.almansa.app.core.Recommendable;

public class RecommendableTextComment extends DefaultTextComment implements Recommendable {

	private RecommendRecordList recommends;

	public RecommendableTextComment(Date creationDate, String contents, Long ownerPostId, Long writerId,
			RecommendRecordList recommends) {
		super(creationDate, contents, ownerPostId, writerId);
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
