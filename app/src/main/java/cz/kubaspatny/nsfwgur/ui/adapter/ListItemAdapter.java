package cz.kubaspatny.nsfwgur.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.koushikdutta.ion.Ion;
import cz.kubaspatny.nsfwgur.R;
import pl.droidsonroids.gif.GifImageView;

import java.util.List;

/**
 * Created by jakubspatny on 05/07/15.
 */
public class ListItemAdapter extends ArrayAdapter<ListItem> {

    private Context mContext;

    private List<ListItem> mGallery;
    private List<ListItem> mComments;

    public ListItemAdapter(Context context,
                           int resource,
                           List<ListItem> objects) {
        super(context, resource, objects);
    }

    public ListItemAdapter(Context context,
                           List<ListItem> gallery,
                           List<ListItem> comments) {
        super(context, -1, gallery);
        this.mContext = context;
        mGallery = gallery;
        mComments = comments;
    }

    @Override
    public int getCount() {
        return mGallery.size() + mComments.size() + 1;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(
          Context.LAYOUT_INFLATER_SERVICE);
        View rowView;

        if (position < mGallery.size()) {
            rowView = inflater.inflate(R.layout.list_image_description, parent, false);
            TextView imageDesc = (TextView)rowView.findViewById(R.id.image_description);
            imageDesc.setText(
              ((ImageDescriptionListItem)mGallery.get(position)).getImageDesctiption());

            if (position % 2 == 0){
                rowView = inflater.inflate(R.layout.list_gallery_image, parent, false);
                GifImageView imageView = (GifImageView) rowView.findViewById(R.id.gallery_image);
                Ion.with(imageView)
                   .placeholder(R.drawable.image)
                   .error(R.drawable.minions)
                   .load(
                     "http://cdn.business2community.com/wp-content/uploads/2015/05/despicable-me-minions4.gif4.gif");
            }

        } else if (position == mGallery.size()) {
            rowView = inflater.inflate(R.layout.gallery_title, parent, false);

            TextView galleryTitle = (TextView)rowView.findViewById(R.id.gallery_title);
            TextView galleryPoster = (TextView)rowView.findViewById(R.id.gallery_poster);
            TextView galleryUpvotes = (TextView)rowView.findViewById(R.id.gallery_upvotes);
            TextView gallerySincePosted = (TextView)rowView.findViewById(R.id.gallery_since_posted);

            galleryTitle.setText(
              "Since the Ice Cream Sandwich release, Roboto has been the standard typeface on Android.");
            galleryPoster.setText("ironman");
            galleryUpvotes.setText("11.8k");
            gallerySincePosted.setText("June 8, 2015");
        } else {
            rowView = inflater.inflate(R.layout.list_gallery_comment, parent, false);
            TextView comment = (TextView)rowView.findViewById(R.id.comment);
            TextView commentPoster = (TextView)rowView.findViewById(R.id.comment_poster);
            TextView commentUpvotes = (TextView)rowView.findViewById(R.id.comment_upvotes);
            TextView commentSincePosted = (TextView)rowView.findViewById(R.id.comment_since_posted);
            TextView commentReplies = (TextView)rowView.findViewById(R.id.comment_replies);

            comment.setText(
              ((CommentListItem)mComments.get(position - mGallery.size() - 1)).getCommentText());
            commentPoster.setText("kubasp");
            commentUpvotes.setText("1.6k");
            commentSincePosted.setText("6h");
            commentReplies.setText("10 replies");

        }

        return rowView;
    }


}
