package com.londonappbrewery.destini.path;

public class PathStoryWaypoint {

    private final int mTextID;
    private PathStoryAnswer mAnswer1;
    private PathStoryAnswer mAnswer2;

    public PathStoryWaypoint(int textID) {
        mTextID = textID;
    }

    public PathStoryWaypoint(int textID, PathStoryAnswer answer1, PathStoryAnswer answer2) {
        mTextID = textID;
        mAnswer1 = answer1;
        mAnswer2 = answer2;
    }

    public int getTextID() {
        return mTextID;
    }

    public PathStoryAnswer getAnswer1() {
        return mAnswer1;
    }

    public PathStoryAnswer getAnswer2() {
        return mAnswer2;
    }
}
