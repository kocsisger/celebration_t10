package hu.unideb.inf.celebration2;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class DownloadAsyncTask extends AsyncTask<Void, Integer, String> {

    WeakReference<Button> weakButton;
    WeakReference<ProgressBar> weakProgressBar;
    WeakReference<TextView> weakTextView;

    public DownloadAsyncTask(Button button, ProgressBar progressBar, TextView textView) {
        this.weakButton = new WeakReference<>(button);
        this.weakProgressBar = new WeakReference<>(progressBar);
        this.weakTextView = new WeakReference<>(textView);
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                publishProgress(i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        weakProgressBar.get().setProgress(values[0]);
    }
}
