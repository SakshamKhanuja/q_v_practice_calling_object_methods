package com.basic.quiz.practice_calling_object_methods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * App shows information of Red Cabbage.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializing the root view - LinearLayout (default orientation).
        LinearLayout rootView = getLinearLayout();

        // Adding 1st child to rootView.
        rootView.addView(makeCardView());

        setContentView(rootView);
    }

    /**
     * @return A LinearLayout with width set to "match_parent" and height set to "wrap_content".
     * Layout also has 16dps of padding on all sides.
     */
    private LinearLayout getLinearLayout() {
        LinearLayout layout = new LinearLayout(this);

        // Adding 16dps padding on all sides.
        int pixelsIn16dp = getSizeInPixels(16F);
        layout.setPadding(pixelsIn16dp, pixelsIn16dp, pixelsIn16dp, pixelsIn16dp);

        return layout;
    }


    /**
     * Contains information about Red Cabbage.
     *
     * @return a CardView containing information about Red Cabbage.
     */
    private CardView makeCardView() {
        CardView cardView = new CardView(this);

        // Making cardView to have width "match_parent" and height "wrap_content".
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        cardView.setLayoutParams(params);

        // Setting custom background color.
        cardView.setCardBackgroundColor(ContextCompat.getColor(this,
                R.color.colorCardBackground));

        // Make corners rounded - 12dp.
        cardView.setRadius(getSizeInPixels(12F));

        // Adding Root view containing all contents to this card.
        cardView.addView(makeCardViewContents());

        return cardView;
    }

    /**
     * @return A CardView containing information about Red Cabbage.
     */
    private LinearLayout makeCardViewContents() {
        // Add Root view to this card.
        LinearLayout rootView = getLinearLayout();

        // Add 1st child containing all labels.
        rootView.addView(getAboutLayout());

        // Add 2nd child containing the drawable.
        rootView.addView(getImage());

        return rootView;
    }

    /**
     * @return A ImageView of Red Cabbage which is placed in center_vertical direction.
     */
    private ImageView getImage() {
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(AppCompatResources.getDrawable(this,
                R.drawable.ic_cabbage_red));

        LinearLayout.LayoutParams imageViewParams =
                getCustomParams(getSizeInPixels(16F), 0);

        imageViewParams.gravity = Gravity.CENTER_VERTICAL;

        imageView.setLayoutParams(imageViewParams);
        return imageView;
    }

    /**
     * @return a LinearLayout containing details about Red Cabbage.
     */
    private LinearLayout getAboutLayout() {
        LinearLayout layout = new LinearLayout(this);

        // Make layout_width - 0dp, and layout_height - wrap_content, weight - 1
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        layout.setLayoutParams(layoutParams);

        // Set orientation to "vertical".
        layout.setOrientation(LinearLayout.VERTICAL);

        // Adding Title - Red Cabbage.
        TextView titleTextView = getBasicTextView(R.string.app_name, true,
                true, true);
        titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F);
        layout.addView(titleTextView);

        // Adding Description.
        TextView descriptionTextView = getBasicTextView(R.string.about_cabbage,
                true, false, false);
        layout.addView(descriptionTextView);

        // Adding Price.
        TextView priceTextView = getBasicTextView(R.string.price_details,
                false, true, true);
        layout.addView(priceTextView);

        return layout;
    }

    /**
     * Creates a TextView and apply the text, bottom layout margin, bold text and text color
     * attributes to it.
     *
     * @param id              is the string ID.
     * @param addBottomMargin if 'true', adds a bottom layout margin of 4 dips.
     * @param isTextBold      if 'true', makes the text 'bold'.
     * @param colorGray       if 'true', changes the color of text to dark gray.
     * @return a TextView with custom attributes.
     */
    private TextView getBasicTextView(int id, boolean addBottomMargin, boolean isTextBold,
                                      boolean colorGray) {
        TextView textView = new TextView(this);

        if (addBottomMargin) {
            textView.setLayoutParams(getCustomParams(0,
                    getSizeInPixels(4F)));
        }

        if (isTextBold) {
            textView.setTypeface(null, Typeface.BOLD);
        }

        if (colorGray) {
            textView.setTextColor(ContextCompat.getColor(this, R.color.colorImportant));
        }

        textView.setText(id);
        return textView;
    }

    /**
     * Adds a layout_margin to a View that is already placed in a LinearLayout.
     *
     * @param left   is the left margin size in pixels.
     * @param bottom is the bottom margin size in pixels.
     * @return LinearLayout.LayoutParams with custom margins.
     */
    private LinearLayout.LayoutParams getCustomParams(int left, int bottom) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(left, 0, 0, bottom);
        return layoutParams;
    }


    /**
     * Converts DP into its equivalent pixel based on the type of screen.
     *
     * @param sizeInDp is the argument.
     * @return the total number of pixels that equal to the entered dips.
     */
    private int getSizeInPixels(float sizeInDp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDp,
                getResources().getDisplayMetrics());
    }
}