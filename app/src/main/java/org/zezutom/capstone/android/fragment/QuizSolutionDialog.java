package org.zezutom.capstone.android.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import org.zezutom.capstone.android.R;

public class QuizSolutionDialog extends DialogFragment {

    public static final String EXPLANATION_KEY = "explanation";

    private View dialogView;

    private View.OnClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dialogView = inflater.inflate(R.layout.fragment_dialog_quiz_solution, container);
        setCancelable(false);
        TextView explanationView = (TextView) dialogView.findViewById(R.id.explanation);

        String explanation = getArguments().getString(EXPLANATION_KEY);
        explanationView.setText(explanation);

        if (listener != null) {
            onClick(R.id.vote_up, listener);
            onClick(R.id.vote_down, listener);
            onClick(R.id.close_dialog, listener);
        }

        final Window window = getDialog().getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setBackgroundDrawable(new ColorDrawable(0));

        dialogView.getBackground().setAlpha(200);
        return dialogView;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    private void onClick(int id, View.OnClickListener listener) {
        dialogView.findViewById(id).setOnClickListener(listener);
    }

}
