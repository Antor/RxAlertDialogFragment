package com.gravityray.rxalertdialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


import com.gravityray.rxeventemitter.RxEventEmitter;

import io.reactivex.Observable;


public class RxAlertDialogFragment extends DialogFragment {

    public static class Builder {
        private String tag;

        private String titleString;
        private Integer titleResId;

        private String messageString;
        private Integer messageResId;

        private String positiveButtonTextString;
        private Integer positiveButtonTextResId;

        private String negativeButtonTextString;
        private Integer negativeButtonTextResId;

        private String neutralButtonTextString;
        private Integer neutralButtonTextResId;

        private Boolean cancelable;

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder setTitle(String titleString) {
            this.titleString = titleString;
            return this;
        }

        public Builder setTitle(Integer titleResId) {
            this.titleResId = titleResId;
            return this;
        }

        public Builder setMessage(String messageString) {
            this.messageString = messageString;
            return this;
        }

        public Builder setMessage(Integer messageResId) {
            this.messageResId = messageResId;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonTextString) {
            this.positiveButtonTextString = positiveButtonTextString;
            return this;
        }

        public Builder setPositiveButton(Integer positiveButtonTextResId) {
            this.positiveButtonTextResId = positiveButtonTextResId;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonTextString) {
            this.negativeButtonTextString = negativeButtonTextString;
            return this;
        }

        public Builder setNegativeButton(Integer negativeButtonTextResId) {
            this.negativeButtonTextResId = negativeButtonTextResId;
            return this;
        }

        public Builder setNeutralButton(String neutralButtonTextString) {
            this.neutralButtonTextString = neutralButtonTextString;
            return this;
        }

        public Builder setNeutralButton(Integer neutralButtonTextResId) {
            this.neutralButtonTextResId = neutralButtonTextResId;
            return this;
        }

        public Builder setCancelable(Boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public RxAlertDialogFragment create() {
            RxAlertDialogFragment fragment = new RxAlertDialogFragment();

            Bundle args = new Bundle();

            args.putString(ARG_TAG, tag);
            if (titleString != null) {
                args.putString(ARG_TITLE_STRING, titleString);
            }
            if (titleResId != null) {
                args.putInt(ARG_TITLE_RES_ID, titleResId);
            }
            if (messageString != null) {
                args.putString(ARG_MESSAGE_STRING, messageString);
            }
            if (messageResId != null) {
                args.putInt(ARG_MESSAGE_RES_ID, messageResId);
            }
            if (positiveButtonTextString != null) {
                args.putString(ARG_POSITIVE_BUTTON_TEXT_STRING, positiveButtonTextString);
            }
            if (positiveButtonTextResId != null) {
                args.putInt(ARG_POSITIVE_BUTTON_TEXT_RES_ID, positiveButtonTextResId);
            }
            if (negativeButtonTextString != null) {
                args.putString(ARG_NEGATIVE_BUTTON_TEXT_STRING, negativeButtonTextString);
            }
            if (negativeButtonTextResId != null) {
                args.putInt(ARG_NEGATIVE_BUTTON_TEXT_RES_ID, negativeButtonTextResId);
            }
            if (neutralButtonTextString != null) {
                args.putString(ARG_NEUTRAL_BUTTON_TEXT_STRING, neutralButtonTextString);
            }
            if (neutralButtonTextResId != null) {
                args.putInt(ARG_NEUTRAL_BUTTON_TEXT_RES_ID, neutralButtonTextResId);
            }
            if (cancelable != null) {
                args.putBoolean(ARG_CANCELABLE, cancelable);
            }

            fragment.setArguments(args);

            return fragment;
        }
    }

    private static final String ARG_TAG = "tag";

    private static final String ARG_TITLE_STRING = "title_string";
    private static final String ARG_TITLE_RES_ID = "title_res_id";

    private static final String ARG_MESSAGE_STRING = "message_string";
    private static final String ARG_MESSAGE_RES_ID = "message_res_id";

    private static final String ARG_POSITIVE_BUTTON_TEXT_STRING = "positive_button_text_string";
    private static final String ARG_POSITIVE_BUTTON_TEXT_RES_ID = "positive_button_text_res_id";

    private static final String ARG_NEGATIVE_BUTTON_TEXT_STRING = "negative_button_text_string";
    private static final String ARG_NEGATIVE_BUTTON_TEXT_RES_ID = "negative_button_text_res_id";

    private static final String ARG_NEUTRAL_BUTTON_TEXT_STRING = "neutral_button_text_string";
    private static final String ARG_NEUTRAL_BUTTON_TEXT_RES_ID = "neutral_button_text_res_id";

    private static final String ARG_CANCELABLE = "cancelable";

    private String tag;

    private String titleString;
    private Integer titleResId;

    private String messageString;
    private Integer messageResId;

    private String positiveButtonTextString;
    private Integer positiveButtonTextResId;

    private String negativeButtonTextString;
    private Integer negativeButtonTextResId;

    private String neutralButtonTextString;
    private Integer neutralButtonTextResId;

    private Boolean cancelable;

    private final RxEventEmitter<String> onPositiveButtonClickEmitter;
    private final RxEventEmitter<String> onNegativeButtonClickEmitter;
    private final RxEventEmitter<String> onNeutralButtonClickEmitter;

    public RxAlertDialogFragment() {
        onPositiveButtonClickEmitter = new RxEventEmitter<>();
        onNegativeButtonClickEmitter = new RxEventEmitter<>();
        onNeutralButtonClickEmitter = new RxEventEmitter<>();
    }

    public Observable<String> getOnPositiveButtonClick() {
        return onPositiveButtonClickEmitter.observe();
    }

    public Observable<String> getOnNegativeButtonClick() {
        return onNegativeButtonClickEmitter.observe();
    }

    public Observable<String> getOnNeutralButtonClick() {
        return onNeutralButtonClickEmitter.observe();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tag = getArguments().getString(ARG_TAG);

        titleString = getArguments().containsKey(ARG_TITLE_STRING)
                ? getArguments().getString(ARG_TITLE_STRING)
                : null;
        titleResId = getArguments().containsKey(ARG_TITLE_RES_ID)
                ? getArguments().getInt(ARG_TITLE_RES_ID)
                : null;

        messageString = getArguments().containsKey(ARG_MESSAGE_STRING)
                ? getArguments().getString(ARG_MESSAGE_STRING)
                : null;
        messageResId = getArguments().containsKey(ARG_MESSAGE_RES_ID)
                ? getArguments().getInt(ARG_MESSAGE_RES_ID)
                : null;

        positiveButtonTextString = getArguments().containsKey(ARG_POSITIVE_BUTTON_TEXT_STRING)
                ? getArguments().getString(ARG_POSITIVE_BUTTON_TEXT_STRING)
                : null;
        positiveButtonTextResId = getArguments().containsKey(ARG_POSITIVE_BUTTON_TEXT_RES_ID)
                ? getArguments().getInt(ARG_POSITIVE_BUTTON_TEXT_RES_ID)
                : null;

        negativeButtonTextString = getArguments().containsKey(ARG_NEGATIVE_BUTTON_TEXT_STRING)
                ? getArguments().getString(ARG_NEGATIVE_BUTTON_TEXT_STRING)
                : null;
        negativeButtonTextResId = getArguments().containsKey(ARG_NEGATIVE_BUTTON_TEXT_RES_ID)
                ? getArguments().getInt(ARG_NEGATIVE_BUTTON_TEXT_RES_ID)
                : null;

        neutralButtonTextString = getArguments().containsKey(ARG_NEUTRAL_BUTTON_TEXT_STRING)
                ? getArguments().getString(ARG_NEUTRAL_BUTTON_TEXT_STRING)
                : null;
        neutralButtonTextResId = getArguments().containsKey(ARG_NEUTRAL_BUTTON_TEXT_RES_ID)
                ? getArguments().getInt(ARG_NEUTRAL_BUTTON_TEXT_RES_ID)
                : null;

        cancelable = getArguments().containsKey(RxAlertDialogFragment.ARG_CANCELABLE)
                ? getArguments().getBoolean(RxAlertDialogFragment.ARG_CANCELABLE)
                : null;

        if (cancelable != null) {
            setCancelable(cancelable);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        if (titleString != null) {
            builder.setTitle(titleString);
        }
        if (titleResId != null) {
            builder.setTitle(titleResId);
        }

        if (messageString != null) {
            builder.setMessage(messageString);
        }
        if (messageResId != null) {
            builder.setMessage(messageResId);
        }

        if (positiveButtonTextString != null) {
            builder.setPositiveButton(
                    positiveButtonTextString,
                    this::onPositiveButtonClick);
        }
        if (positiveButtonTextResId != null) {
            builder.setPositiveButton(
                    positiveButtonTextResId,
                    this::onPositiveButtonClick);
        }

        if (negativeButtonTextString != null) {
            builder.setNegativeButton(
                    negativeButtonTextString,
                    this::onNegativeButtonClick);
        }
        if (negativeButtonTextResId != null) {
            builder.setNegativeButton(
                    negativeButtonTextResId,
                    this::onNegativeButtonClick);
        }

        if (neutralButtonTextString != null) {
            builder.setNeutralButton(
                    neutralButtonTextString,
                    this::onNeutralButtonClick);
        }
        if (neutralButtonTextResId != null) {
            builder.setNeutralButton(
                    neutralButtonTextResId,
                    this::onNeutralButtonClick);
        }

        return builder.create();
    }

    private void onPositiveButtonClick(DialogInterface dialog, int which) {
        onPositiveButtonClickEmitter.onNext(tag);
    }

    private void onNegativeButtonClick(DialogInterface dialog, int which) {
        onNegativeButtonClickEmitter.onNext(tag);
    }

    private void onNeutralButtonClick(DialogInterface dialog, int which) {
        onNeutralButtonClickEmitter.onNext(tag);
    }
}
