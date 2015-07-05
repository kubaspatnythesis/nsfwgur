package cz.kubaspatny.nsfwgur.ui.adapter;

/**
 * Created by jakubspatny on 05/07/15.
 */
public class ImageDescriptionListItem extends ListItem {

    private String mImageDesctiption;

    public ImageDescriptionListItem() {
    }

    public ImageDescriptionListItem(String imageDesctiption) {
        mImageDesctiption = imageDesctiption;
    }

    public String getImageDesctiption() {
        return mImageDesctiption;
    }

    public void setImageDesctiption(String imageDesctiption) {
        mImageDesctiption = imageDesctiption;
    }

    @Override
    public ListItemType getListItemType() {
        return ListItemType.IMAGE_DESCRIPTION;
    }

}
