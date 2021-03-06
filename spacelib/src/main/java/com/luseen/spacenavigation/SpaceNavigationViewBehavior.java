package com.luseen.spacenavigation;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Chatikyan on 13.10.2016.
 */
class SpaceNavigationViewBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    public SpaceNavigationViewBehavior(Context context, AttributeSet attrs) {
        super();
    }

    public SpaceNavigationViewBehavior() {
        super();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, V child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final V child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}
