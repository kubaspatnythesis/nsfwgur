package cz.kubaspatny.nsfwgur.ui.activity;

import android.os.Build;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.kubaspatny.nsfwgur.R;
import cz.kubaspatny.nsfwgur.ui.adapter.CommentListItem;
import cz.kubaspatny.nsfwgur.ui.adapter.ImageDescriptionListItem;
import cz.kubaspatny.nsfwgur.ui.adapter.ListItem;
import cz.kubaspatny.nsfwgur.ui.adapter.ListItemAdapter;

import java.util.ArrayList;

public class GalleryPagerActivity extends AppCompatActivity {

    private ListView mListView;
    private View mStickyHeader;
    private boolean mIsSticked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_pager_2);

//        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = (ListView) findViewById(R.id.list1);
        ArrayList<ListItem> data_list1 = new ArrayList<>();
        ArrayList<ListItem> data_list2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data_list1.add(new ImageDescriptionListItem("This is image description number " + i));
            data_list2.add(new CommentListItem("This is comment [" + i + "]"));
        }

        ListItemAdapter adapter = new ListItemAdapter(this, data_list1, data_list2);
        mListView.setAdapter(adapter);

        mStickyHeader = findViewById(R.id.gallery_title_container);
        mStickyHeader.setBackgroundColor(getResources().getColor(R.color.window_background_dark));
        mStickyHeader.setVisibility(View.GONE);
        mStickyHeader.setOnTouchListener(
          new View.OnTouchListener() {
              @Override
              public boolean onTouch(View view,
                                     MotionEvent motionEvent) {
                  return true;
              }
          });
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) mStickyHeader.setElevation(8);
        TextView galleryTitle = (TextView) mStickyHeader.findViewById(R.id.gallery_title);
        TextView galleryPoster = (TextView) mStickyHeader.findViewById(R.id.gallery_poster);
        TextView galleryUpvotes = (TextView) mStickyHeader.findViewById(R.id.gallery_upvotes);
        TextView gallerySincePosted = (TextView) mStickyHeader.findViewById(R.id.gallery_since_posted);

        galleryTitle.setText("Since the Ice Cream Sandwich release, Roboto has been the standard typeface on Android. Since Froyo, Noto has been the standard typeface on Android for all languages not covered by Roboto.");
        galleryPoster.setText("ironman");
        galleryUpvotes.setText("11.8k");
        gallerySincePosted.setText("June 8, 2015");

        mListView.setOnScrollListener(
          new AbsListView.OnScrollListener() {

              @Override
              public void onScrollStateChanged(AbsListView absListView,
                                               int i) {

              }

              @Override
              public void onScroll(AbsListView view,
                                   int firstVisibleItem,
                                   int visibleItemCount,
                                   int totalItemCount) {
                  if (visibleItemCount == 0)
                      return;

                  boolean shouldStick = false;

                  int headerPosition = 20;

                  if(firstVisibleItem >= headerPosition){
                      shouldStick = true;
                  } else {
                      shouldStick = false;
                  }

                  if (shouldStick && !mIsSticked) {
                      mIsSticked = true;
                      mStickyHeader.setVisibility(View.VISIBLE);
                  } else if (!shouldStick && mIsSticked) {
                      mIsSticked = false;
                      mStickyHeader.setVisibility(View.INVISIBLE);
                  }

              }
          });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery_pager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
