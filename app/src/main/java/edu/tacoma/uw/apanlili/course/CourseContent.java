package edu.tacoma.uw.apanlili.course;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.tacoma.uw.apanlili.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CourseContent extends ListFragment {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CourseItem> ITEMS = new ArrayList<CourseItem>();
    public static final String DETAIL_PARAM = "detail_param";
    private CourseContent.CourseItem mCourseItem;


    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CourseItem> ITEM_MAP = new HashMap<String, CourseItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createCourseItem(i));
        }
    }

    private static void addItem(CourseItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CourseItem createCourseItem(int position) {
        return new CourseItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public void updateCourseItemView(CourseContent.CourseItem item) {
        TextView courseIdTextView = (TextView) getActivity().findViewById(R.id.course_item_id);
        courseIdTextView.setText(item.id);
        TextView courseTitleTextView = (TextView) getActivity().findViewById(R.id.course_item_title);
        courseTitleTextView.setText(item.title);
        TextView courseShortDescTextView = (TextView) getActivity().findViewById(R.id.course_item_desc);
        courseShortDescTextView.setText(item.shortDesc);

    }

    public void onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack(fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount()-2).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class CourseItem implements Serializable {
        public final String id;
        public final String content;
        public final String details;
        public final String title;
        public final String shortDesc;

        public CourseItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.title = (String)("item " + id);
            this.shortDesc = (String)("This is the description for item number " + id);
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
