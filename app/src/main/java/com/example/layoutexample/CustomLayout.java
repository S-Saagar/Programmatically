package com.example.layoutexample;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.layoutexample.Utils.LayoutHelper;

import static android.support.constraint.ConstraintSet.HORIZONTAL_GUIDELINE;
import static android.support.constraint.ConstraintSet.PARENT_ID;
import static android.support.constraint.ConstraintSet.VERTICAL_GUIDELINE;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class CustomLayout extends ConstraintLayout {
    private Context context;
    public CardView cardView_right;
    public CardView cardView_left;
    public Button button_right;
    public Button button_left;

    public CustomLayout(Context context) {
        super(context);
        this.context = context;
        initViews();
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {
        this.setBackgroundColor(getResources().getColor(R.color.colorGrayLight));
        setupBottomGuidLine();
        setupTopGuidLine();
        setupDevider();
        setupLeftCard();
        setupRightCard();
        setupGradientDivider();
    }

    private void setupGradientDivider() {
        LinearLayout linearLayout_divider = new LinearLayout(context);
        linearLayout_divider.setId(R.id.linear_divider);

        linearLayout_divider.setBackground(customDrawable());

        this.addView(linearLayout_divider);

        LayoutHelper.builder(linearLayout_divider)
                .height(MATCH_PARENT)
                .width(150)
                .startToStartOf(PARENT_ID)
                .endToEndOf(PARENT_ID)
                .topToTopOf(PARENT_ID)
                .bottomToBottomOf(PARENT_ID)
                .build();
    }

    private GradientDrawable customDrawable() {
        int[] colors = {getResources().getColor(R.color.colorGrayLight),
                getResources().getColor(R.color.colorGrayDark),
                getResources().getColor(R.color.colorGrayLight)};
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors);
        gd.setCornerRadius(0f);
        return gd;
    }

    private void setupRightCard() {
        cardView_right = new CardView(context);
        cardView_right.setAlpha(0.5f);
        cardView_right.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
        cardView_right.setCardElevation(15f);
        cardView_right.setRadius(12);
        cardView_right.setId(R.id.cardView_right);

        this.addView(cardView_right);

        int margin = 15;

        LayoutHelper.builder(cardView_right)
                .height(0)
                .width(0)
                .margins(margin, margin, margin, margin)
                .constraintRation("w", "1", "1")
                .topToBottomOf(R.id.guideline_top)
                .bottomToTopOf(R.id.guideline_bottom)
                .startToEndOf(R.id.guideline_divider)
                .endToEndOf(PARENT_ID)
                .build();

        button_right = setupCardChild(cardView_right);
    }

    private void setupLeftCard() {
        cardView_left = new CardView(context);
        cardView_left.setAlpha(0.5f);
        cardView_left.setCardBackgroundColor(getResources().getColor(R.color.colorBlack));
        cardView_left.setCardElevation(15f);
        cardView_left.setRadius(12);
        cardView_left.setId(R.id.cardView_left);

        this.addView(cardView_left);

        int margin = 15;

        LayoutHelper.builder(cardView_left)
                .height(0)
                .width(0)
                .margins(margin, margin, margin, margin)
                .constraintRation("w", "1", "1")
                .startToStartOf(PARENT_ID)
                .topToBottomOf(R.id.guideline_top)
                .bottomToTopOf(R.id.guideline_bottom)
                .endToStartOf(R.id.guideline_divider)
                .build();

        button_left = setupCardChild(cardView_left);
    }

    private Button setupCardChild(CardView cardView) {
        ConstraintLayout constraintLayout_right = new ConstraintLayout(context);
        cardView.addView(constraintLayout_right);

        Button button = new Button(context);
        button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        button.setText(cardView.getId() == R.id.cardView_right ? "Right button" : "Left button");
        button.setId(cardView.getId() == R.id.cardView_right ? R.id.button_right : R.id.button_left);
        button.setPadding(28, 0, 28, 0);

        constraintLayout_right.addView(button);

        LayoutHelper.builder(button).height((int) getResources().getDimension(R.dimen.button_height))
                .width(MATCH_PARENT)
                .margins(35, 35, 0, 0)
                .startToStartOf(PARENT_ID)
                .endToEndOf(PARENT_ID)
                .topToTopOf(PARENT_ID)
                .bottomToBottomOf(PARENT_ID)
                .build();

        return button;
    }

    private void setupDevider() {
        Guideline guideline_divider = new Guideline(context);
        guideline_divider.setId(R.id.guideline_divider);

        this.addView(guideline_divider);

        LayoutHelper.builder(guideline_divider)
                .height(WRAP_CONTENT)
                .width(WRAP_CONTENT)
                .guideLineOrientation(VERTICAL_GUIDELINE)
                .guideLineGuidePercent(0.5f)
                .build();
    }

    private void setupTopGuidLine() {
        Guideline guideline_top = new Guideline(context);
        guideline_top.setId(R.id.guideline_top);

        this.addView(guideline_top);

        LayoutHelper.builder(guideline_top)
                .height(WRAP_CONTENT)
                .width(WRAP_CONTENT)
                .guideLineOrientation(HORIZONTAL_GUIDELINE)
                .guideLineGuidePercent(0.2f)
                .build();
    }

    private void setupBottomGuidLine() {
        Guideline guideline_bottom = new Guideline(context);
        guideline_bottom.setId(R.id.guideline_bottom);

        this.addView(guideline_bottom);

        LayoutHelper.builder(guideline_bottom)
                .height(WRAP_CONTENT)
                .width(WRAP_CONTENT)
                .guideLineOrientation(HORIZONTAL_GUIDELINE)
                .guideLineGuidePercent(0.8f)
                .build();
    }
}
