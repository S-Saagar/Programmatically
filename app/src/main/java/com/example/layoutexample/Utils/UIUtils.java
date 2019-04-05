package com.example.layoutexample.Utils;

import android.content.Context;
import android.util.DisplayMetrics;

import com.example.layoutexample.App;

public class UIUtils {
    private Context context;

    private UIUtils() {
        this.context = App.getContext();
    }

    private static UIUtils UiUtils() {
        return new UIUtils();
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public float convertDpToPixel(float dp) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into dp
     * @return A float value to represent dp equivalent to px value
     */
    public float convertPixelsToDp(float px) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public float dpFromPx(final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public float pxFromDp(final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public float getDisplayDensity() {
        return context.getResources().getDisplayMetrics().density;
    }
}
