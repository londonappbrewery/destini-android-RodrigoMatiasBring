package com.londonappbrewery.destini.path;

public class PathStoryAnswer {

    private final int mTextID;
    private final int mNextID;

    public PathStoryAnswer(int textID, int nextID) {
        mTextID = textID;
        mNextID = nextID;
    }

    public int getTextID() {
        return mTextID;
    }

    public int getNextID() {
        return mNextID;
    }
}
