package com.openjarvis.android;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Initial Android shell. The local inference runtime is intentionally not
 * represented as complete yet; it will be integrated and tested separately.
 */
public final class MainActivity extends Activity {
    private LinearLayout messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(18), dp(18), dp(18), dp(12));
        root.setBackgroundColor(0xFF10151D);

        TextView title = new TextView(this);
        title.setText("OpenJarvis");
        title.setTextColor(0xFFFFFFFF);
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Assistant Android • base locale");
        subtitle.setTextColor(0xFF9EADBD);
        subtitle.setTextSize(13);
        root.addView(subtitle);

        ScrollView scroll = new ScrollView(this);
        LinearLayout.LayoutParams scrollParams =
                new LinearLayout.LayoutParams(-1, 0, 1f);
        scrollParams.topMargin = dp(18);
        scroll.setLayoutParams(scrollParams);

        messages = new LinearLayout(this);
        messages.setOrientation(LinearLayout.VERTICAL);
        scroll.addView(messages);
        root.addView(scroll);

        addMessage("OpenJarvis Android est installé. Le moteur d'inférence local n'est pas encore intégré : cette version est la base de l'application, pas encore un assistant IA complet.");

        LinearLayout composer = new LinearLayout(this);
        composer.setOrientation(LinearLayout.HORIZONTAL);
        composer.setGravity(Gravity.CENTER_VERTICAL);

        EditText input = new EditText(this);
        input.setSingleLine(true);
        input.setHint("Écris un message…");
        input.setHintTextColor(0xFF8492A2);
        input.setTextColor(0xFFFFFFFF);
        input.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF5C91C8));
        composer.addView(input, new LinearLayout.LayoutParams(0, dp(52), 1f));

        Button send = new Button(this);
        send.setText("Envoyer");
        composer.addView(send);
        send.setOnClickListener(v -> {
            String text = input.getText().toString().trim();
            if (!text.isEmpty()) {
                addMessage("Toi : " + text);
                addMessage("Le moteur local sera connecté dans une prochaine étape. Aucun serveur distant n'est utilisé par cette base.");
                input.setText("");
            }
        });

        root.addView(composer);
        setContentView(root);
    }

    private void addMessage(String text) {
        TextView item = new TextView(this);
        item.setText(text);
        item.setTextColor(0xFFE7EDF5);
        item.setTextSize(15);
        item.setPadding(dp(14), dp(12), dp(14), dp(12));
        item.setBackgroundColor(0xFF202A36);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(-1, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.bottomMargin = dp(10);
        messages.addView(item, params);
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }
}
