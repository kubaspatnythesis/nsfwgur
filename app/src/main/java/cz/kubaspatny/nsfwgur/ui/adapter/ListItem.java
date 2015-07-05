package cz.kubaspatny.nsfwgur.ui.adapter;

/**
 * Created by jakubspatny on 05/07/15.
 */
public abstract class ListItem {

    public enum ListItemType {
        IMAGE, IMAGE_DESCRIPTION, TITLE, COMMENT_SECTION_HEADER, COMMENT;
    }

    public abstract ListItemType getListItemType();

}
