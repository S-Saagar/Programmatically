package com.example.layoutexample.Utils;

import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import java.util.MissingFormatArgumentException;

public class LayoutHelper {

    private LayoutHelper() {

    }

    private LayoutHelper(LayoutHelperBuilder layoutHelperBuilder) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) layoutHelperBuilder.view.getLayoutParams();

        layoutParams.setMargins(layoutHelperBuilder.margin_start, layoutHelperBuilder.margin_top, layoutHelperBuilder.margin_end, layoutHelperBuilder.margin_bottom);

        layoutParams.goneTopMargin = layoutHelperBuilder.gone_margin_top;
        layoutParams.goneBottomMargin = layoutHelperBuilder.gone_margin_bottom;
        layoutParams.goneStartMargin = layoutHelperBuilder.gone_margin_start;
        layoutParams.goneEndMargin = layoutHelperBuilder.gone_margin_end;

        layoutParams.width = layoutHelperBuilder.width;
        layoutParams.height = layoutHelperBuilder.height;

        if (layoutHelperBuilder.v_bias > -1) {
            layoutParams.verticalBias = layoutHelperBuilder.v_bias;
        }

        if (layoutHelperBuilder.h_bias > -1) {
            layoutParams.horizontalBias = layoutHelperBuilder.h_bias;
        }

        if (layoutHelperBuilder.orientation > -1) {
            layoutParams.orientation = layoutHelperBuilder.orientation;
        }

        if (layoutHelperBuilder.guidePercent > -1) {
            layoutParams.guidePercent = layoutHelperBuilder.guidePercent;
        }

        if (!layoutHelperBuilder.ratio.equalsIgnoreCase("")) {
            layoutParams.dimensionRatio = layoutHelperBuilder.ratio;
        }

        if (layoutHelperBuilder.is_set_ss_id) {
            layoutParams.startToStart = layoutHelperBuilder.ss_id;
        }

        if (layoutHelperBuilder.is_set_ee_id) {
            layoutParams.endToEnd = layoutHelperBuilder.ee_id;
        }

        if (layoutHelperBuilder.is_set_tt_id) {
            layoutParams.topToTop = layoutHelperBuilder.tt_id;
        }

        if (layoutHelperBuilder.is_set_bb_id) {
            layoutParams.bottomToBottom = layoutHelperBuilder.bb_id;
        }

        if (layoutHelperBuilder.is_set_se_id) {
            layoutParams.startToEnd = layoutHelperBuilder.se_id;
        }

        if (layoutHelperBuilder.is_set_es_id) {
            layoutParams.endToStart = layoutHelperBuilder.es_id;
        }

        if (layoutHelperBuilder.is_set_tb_id) {
            layoutParams.topToBottom = layoutHelperBuilder.tb_id;
        }

        if (layoutHelperBuilder.is_set_bt_id) {
            layoutParams.bottomToTop = layoutHelperBuilder.bt_id;
        }
    }

    public static Height builder(@NonNull View view) {
        return new LayoutHelperBuilder(view);
    }

    public static class LayoutHelperBuilder implements Height, Width, Build {
        private View view;

        //Default ration is empty string
        private String ratio = "";

        //Default value -1 for check set or not
        private int orientation = -1;

        //Default value -1 for check set or not
        private float guidePercent = -1;

        //Default value -1 for check set or not
        private float v_bias = -1;
        private float h_bias = -1;

        private int height, width;
        private boolean is_set_height;
        private boolean is_set_width;

        private int tt_id;
        private boolean is_set_tt_id = false;
        private int tb_id;
        private boolean is_set_tb_id = false;

        private int bb_id;
        private boolean is_set_bb_id = false;
        private int bt_id;
        private boolean is_set_bt_id = false;

        private int ss_id;
        private boolean is_set_ss_id = false;
        private int se_id;
        private boolean is_set_se_id = false;

        private int ee_id;
        private boolean is_set_ee_id = false;
        private int es_id;
        private boolean is_set_es_id = false;

        //Default margins are Zero
        private int margin_start = 0, margin_end = 0, margin_top = 0, margin_bottom = 0;
        private int gone_margin_start = 0, gone_margin_end = 0, gone_margin_top = 0, gone_margin_bottom = 0;

        LayoutHelperBuilder(@NonNull View view) {
            this.view = view;
        }

        public Width height(int height) {
            if (height < -2) {
                throw new IllegalArgumentException("Invalid height");
            }
            this.height = height;
            is_set_height = true;
            return this;
        }

        public Build width(int width) {
            if (width < -2) {
                throw new IllegalArgumentException("Invalid width");
            }
            this.width = width;
            is_set_width = true;
            return this;
        }

        public Build margins(int start, int end, int top, int bottom) {
            this.margin_start = start;
            this.margin_end = end;
            this.margin_top = top;
            this.margin_bottom = bottom;
            return this;
        }

        @Override
        public Build goneMargins(int start, int end, int top, int bottom) {
            this.gone_margin_start = start;
            this.gone_margin_end = end;
            this.gone_margin_top = top;
            this.gone_margin_bottom = bottom;
            return this;
        }

        public Build topToTopOf(int id) {
            tt_id = id;
            is_set_tt_id = true;
            return this;
        }

        public Build bottomToBottomOf(int id) {
            bb_id = id;
            is_set_bb_id = true;
            return this;
        }

        public Build startToStartOf(int id) {
            ss_id = id;
            is_set_ss_id = true;
            return this;
        }

        public Build endToEndOf(int id) {
            ee_id = id;
            is_set_ee_id = true;
            return this;
        }

        public Build topToBottomOf(int id) {
            tb_id = id;
            is_set_tb_id = true;
            return this;
        }

        public Build bottomToTopOf(int id) {
            bt_id = id;
            is_set_bt_id = true;
            return this;
        }

        public Build startToEndOf(int id) {
            se_id = id;
            is_set_se_id = true;
            return this;
        }

        public Build endToStartOf(int id) {
            es_id = id;
            is_set_es_id = true;
            return this;
        }

        public Build guideLineOrientation(@IntRange(from = 0, to = 1) int guideLineOrientation) {
            this.orientation = guideLineOrientation;
            return this;
        }

        public Build guideLineGuidePercent(float guidePercent) {
            this.guidePercent = guidePercent;
            return this;
        }

        public Build verticalBias(float bias) {
            this.v_bias = bias;
            return this;
        }

        public Build horizontalBias(float bias) {
            this.h_bias = bias;
            return this;
        }

        public Build constraintRation(String ref, String width, String height) {
            this.ratio = rationStringBuilder(ref, width, height);
            return this;
        }

        private String rationStringBuilder(String withRef, String width, String height) {
            String pattern_1 = "[whHW]";
            if (!withRef.matches(pattern_1)) {
                throw new IllegalArgumentException("1st params in ratio builder is wrong");
            }
            String pattern_2 = "[0-9]";
            if (!width.matches(pattern_2) || !height.matches(pattern_2)) {
                throw new IllegalArgumentException("2st or 3rd params in ratio builder is wrong");
            }
            return withRef + "," + width + ":" + height;
        }

        public void build() {
            if (is_set_height && is_set_width) {
                new LayoutHelper(this);
            } else {
                throw new MissingFormatArgumentException("Height and width is required");
            }
        }
    }

    public interface Height {
        Width height(int height);
    }

    public interface Width {
        Build width(int width);
    }

    public interface Build {
        Build margins(int start, int end, int top, int bottom);

        Build goneMargins(int start, int end, int top, int bottom);

        Build topToTopOf(int id);

        Build bottomToBottomOf(int id);

        Build startToStartOf(int id);

        Build endToEndOf(int id);

        Build topToBottomOf(int id);

        Build bottomToTopOf(int id);

        Build startToEndOf(int id);

        Build endToStartOf(int id);

        Build constraintRation(String ref, String width, String height);

        Build guideLineOrientation(@IntRange(from = 0, to = 1) int orientation);

        Build guideLineGuidePercent(@FloatRange(from = 0.0, to = 1.0) float guidePercent);

        Build verticalBias(@FloatRange(from = 0.0, to = 1.0) float bias);

        Build horizontalBias(@FloatRange(from = 0.0, to = 1.0) float bias);

        void build();
    }
}