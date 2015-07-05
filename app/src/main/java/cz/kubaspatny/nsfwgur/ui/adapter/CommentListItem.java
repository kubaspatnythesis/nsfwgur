package cz.kubaspatny.nsfwgur.ui.adapter;

/**
 * Created by jakubspatny on 05/07/15.
 */
public class CommentListItem extends ListItem {

    private String mCommentText;

    public CommentListItem() {
    }

    public CommentListItem(String commentText) {
        mCommentText = commentText;
    }

    public String getCommentText() {
        return mCommentText;
    }

    public void setCommentText(String commentText) {
        mCommentText = commentText;
    }

    @Override
    public ListItemType getListItemType() {
        return ListItemType.COMMENT;
    }

}
