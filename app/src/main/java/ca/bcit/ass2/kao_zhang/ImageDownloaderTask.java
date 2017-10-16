package ca.bcit.ass2.kao_zhang;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Lel on 2017-10-10.
 */

class ImageDownloaderTask //extends AsyncTask<String, Void, Bitmap>
{
    /*
    private final WeakReference<WebView> webViewReference;

    public ImageDownloaderTask(WebView webView) {
        webViewReference = new WeakReference<WebView>(webView);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return downloadBitmap(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (isCancelled()) {
            bitmap = null;
        }

        if (webViewReference != null) {
            WebView webView = webViewReference.get();
            if (webView != null) {
                if (bitmap != null) {
                    webView.setImageBitmap(bitmap);
                } else {
                    Drawable placeholder = webView.getContext().getResources().getDrawable(R.drawable.mac);
                    webView.setImageDrawable(placeholder);
                }
            }
        }
    }

    private Bitmap downloadBitmap(String url) {
        HttpURLConnection urlConnection = null;
        try {
            URL uri = new URL(url);
            urlConnection = (HttpURLConnection) uri.openConnection();
            int statusCode = urlConnection.getResponseCode();
            if (statusCode !=  HttpURLConnection.HTTP_OK) {
                return null;
            }

            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream != null) {
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (Exception e) {
            urlConnection.disconnect();
            Log.w("ImageDownloader", "Error downloading image from " + url);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }
    */
}
