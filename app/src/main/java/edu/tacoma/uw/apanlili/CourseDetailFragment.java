package edu.tacoma.uw.apanlili;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.tacoma.uw.apanlili.course.CourseContent;

import static edu.tacoma.uw.apanlili.course.CourseContent.DETAIL_PARAM;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class CourseDetailFragment extends Fragment {



    public static final String DETAIL_PARAM = "detail_param";
    private CourseContent.CourseItem mCourseItem;



    public CourseDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CourseDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseDetailFragment getCourseDetailFragment(CourseContent.CourseItem courseItem) {
        CourseDetailFragment fragment = new CourseDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(DETAIL_PARAM, courseItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCourseItem = (CourseContent.CourseItem)
                    getArguments().getSerializable(DETAIL_PARAM);
        }

    }

    public void updateCourseItemView(CourseContent.CourseItem item) {
        TextView courseIdTextView = (TextView) getActivity().findViewById(R.id.course_item_id);
        courseIdTextView.setText(item.id);
        TextView courseTitleTextView = (TextView) getActivity().findViewById(R.id.course_item_title);
        courseTitleTextView.setText(item.title);
        TextView courseShortDescTextView = (TextView) getActivity().findViewById(R.id.course_item_desc);
        courseShortDescTextView.setText(item.shortDesc);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_course_detail, container, false);
        if (mCourseItem == null) {
            mCourseItem = CourseContent.ITEMS.get(0);
        }
        TextView courseIdTextView = (TextView) v.findViewById(R.id.course_item_id);
        courseIdTextView.setText(mCourseItem.id);
        TextView courseTitleTextView = (TextView) v.findViewById(R.id.course_item_title);
        courseTitleTextView.setText(mCourseItem.title);
        TextView courseShortDescTextView = (TextView) v.findViewById(R.id.course_item_desc);
        courseShortDescTextView.setText(mCourseItem.shortDesc);

        return v;

    }




}
