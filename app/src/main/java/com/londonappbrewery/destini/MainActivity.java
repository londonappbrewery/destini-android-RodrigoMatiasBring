package com.londonappbrewery.destini;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.londonappbrewery.destini.path.PathStoryAnswer;
import com.londonappbrewery.destini.path.PathStoryWaypoint;

public class MainActivity extends AppCompatActivity {

    private TextView mStoryText;
    private int mStoryIndex;
    private Button mAnswer1Button;
    private Button mAnswer2Button;

    private final PathStoryWaypoint[] mStoryWaypoints = new PathStoryWaypoint[] {
            new PathStoryWaypoint(R.string.T1_Story,
                    new PathStoryAnswer(R.string.T1_Ans1, R.string.T3_Story),
                    new PathStoryAnswer(R.string.T1_Ans2, R.string.T2_Story)),
            new PathStoryWaypoint(R.string.T2_Story,
                    new PathStoryAnswer(R.string.T2_Ans1, R.string.T3_Story),
                    new PathStoryAnswer(R.string.T2_Ans2, R.string.T4_End)),
            new PathStoryWaypoint(R.string.T3_Story,
                    new PathStoryAnswer(R.string.T3_Ans1, R.string.T6_End),
                    new PathStoryAnswer(R.string.T3_Ans2, R.string.T5_End)),
            new PathStoryWaypoint(R.string.T4_End),
            new PathStoryWaypoint(R.string.T5_End),
            new PathStoryWaypoint(R.string.T6_End)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryText = findViewById(R.id.storyTextView);
        mAnswer1Button = findViewById(R.id.buttonTop);
        mAnswer2Button = findViewById(R.id.buttonBottom);

        if (savedInstanceState != null) {
            // Unnecessary comment here...
            mStoryIndex = savedInstanceState.getInt("StoryIndexKey");
        }

        updateText();

        mAnswer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStoryIndex = findIndexByTextID(mStoryWaypoints[mStoryIndex].getAnswer1().getNextID());
                updateText();
            }
        });

        mAnswer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStoryIndex = findIndexByTextID(mStoryWaypoints[mStoryIndex].getAnswer2().getNextID());
                updateText();
            }
        });
    }

    private void updateText() {
        mStoryText.setText(mStoryWaypoints[mStoryIndex].getTextID());
        if (mStoryWaypoints[mStoryIndex].getAnswer1() != null) {
            mAnswer1Button.setText(mStoryWaypoints[mStoryIndex].getAnswer1().getTextID());
            mAnswer2Button.setText(mStoryWaypoints[mStoryIndex].getAnswer2().getTextID());
        } else {
            mAnswer1Button.setVisibility(View.GONE);
            mAnswer2Button.setVisibility(View.GONE);
        }
    }

    private int findIndexByTextID(int textID) {
        for (int i = 0; i < mStoryWaypoints.length; i++) {
            if (textID == mStoryWaypoints[i].getTextID()) {
                return i;
            }
        }
        throw new Resources.NotFoundException();
    }
}
