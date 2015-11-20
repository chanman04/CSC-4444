package csc4444.mike.dreamlink.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4444.mike.dreamlink.R;


/**
 * This is the class for Dream Interpretation. This activity is going to populate the view with the
 * user's Dream object they have created. We just need to hook up the Watson Service features to the
 * app. We will allow users to enter text in the EditText field and then parse it to a JSON object
 * this JSON object will be sent to Watson, he will choose the best answer to the question and then
 * send a JSON object back. This JSON object that is sent back will be parsed into text and displayed
 * in a Text View.
 */
public class DreamInterpreter extends Activity{

    @Bind(R.id.watson_submit_button) Button watsonSubmit;

    //String to store the EditText input
    public String questionText;
    public String answerText;


    public static final String mLogTag = "Inside WatsonQueryActivity: ";
    public static String mWatsonQueryString = "";
    public String mWatsonAnswerString = "";
    private boolean mIsQuerying = false;


    static interface WatsonQueryCallbacks {
        void onPreExecute();
        void onProgressUpdate(int percent);
        void onCancelled();
        void onPostExecute();
    }

    private DreamInterpreter mCallbacks;
    private WatsonQuery mQuery;

    public DreamInterpreter() {
    }


//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        mCallbacks = (DreamInterpreter) activity;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
        setContentView(R.layout.activity_dream_interpreter);
        ButterKnife.bind(this);

        if(mWatsonAnswerString.length() > 0) {
            TextView watsonQuestion = (TextView) findViewById(R.id.watson_answer_text);
            watsonQuestion.setText(mWatsonAnswerString);
        }

        // event binding for submit button
        watsonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsQuerying) {
                    mIsQuerying = true;
                    EditText watsonQuestion = (EditText) findViewById(R.id.watson_question_text);
                    if(watsonQuestion.getText() != null) {
                        mWatsonQueryString = watsonQuestion.getText().toString();
                    }
                    mQuery = new WatsonQuery();
                    mQuery.execute();
                }
//                hideSoftKeyboard(this);
            }
        });

        // hide keyboard when clicking off text edit element
        findViewById(R.id.rootLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                hideSoftKeyboard(this);
            }
        });

        findViewById(R.id.rootLayout).requestFocus();
    }

        //End of onCreate

    private class WatsonQuery extends AsyncTask<Void, Integer, String> {

        private SSLContext context;
        private HttpsURLConnection connection;
        private String jsonData;

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(Void... ignore) {

            // establish SSL trust (insecure for demo)
            try {
                context = SSLContext.getInstance("TLS");
                context.init(null, trustAllCerts, new java.security.SecureRandom());
            } catch (java.security.KeyManagementException e) {
                e.printStackTrace();
            } catch (java.security.NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            try {
                // Default HTTPS connection option values
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(R.string.user_watson_server_instance);
                String serverInstance = sb.toString();

                StringBuilder sbUser = new StringBuilder();
                sb.append("");
                sb.append(R.string.user_id);
                String userInstance = sb.toString();

                StringBuilder sbPass = new StringBuilder();
                sb.append("");
                sb.append(R.string.user_password);
                String passwordInstance = sb.toString();

                URL watsonURL = new URL(serverInstance);
                int timeoutConnection = 30000;
                connection = (HttpsURLConnection) watsonURL.openConnection();
                connection.setSSLSocketFactory(context.getSocketFactory());
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setUseCaches(false);
                connection.setConnectTimeout(timeoutConnection);
                connection.setReadTimeout(timeoutConnection);

                // Watson specific HTTP headers
                connection.setRequestProperty("X-SyncTimeout", "30");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("Authorization", "Basic " +userInstance + passwordInstance);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Cache-Control", "no-cache");

                OutputStream out = connection.getOutputStream();
                String query = "{\"question\": {\"questionText\": \"" + DreamInterpreter.mWatsonQueryString + "\"}}";
                out.write(query.getBytes());
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            int responseCode;
            try {
                if (connection != null) {
                    responseCode = connection.getResponseCode();
                    Log.i(DreamInterpreter.mLogTag, "Server Response Code: " + Integer.toString(responseCode));

                    switch(responseCode) {
                        case 200:
                            // successful HTTP response state
                            InputStream input = connection.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                            String line;
                            StringBuilder response = new StringBuilder();
                            while((line = reader.readLine()) != null) {
                                response.append(line);
                                response.append('\r');
                            }
                            reader.close();

                            Log.i(DreamInterpreter.mLogTag, "Watson Output: " + response.toString());
                            jsonData = response.toString();

                            break;
                        default:
                            // Do Stuff
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // received data, deliver JSON to PostExecute
            if(jsonData != null) {
                return jsonData;
            }

            // else, hit HTTP error, handle in PostExecute by doing null check
            return null;
        }

//        @Override
//        protected void onProgressUpdate(Integer... percent) {
//            if (mCallbacks != null) {
//                mCallbacks.onProgressUpdate(percent[0]);
//            }
//        }
//
//        @Override
//        protected void onCancelled() {
//            if (mCallbacks != null) {
//                mCallbacks.onCancelled();
//            }
//        }

        @Override
        protected void onPostExecute(String json) {
//            mIsQuerying = false;
//            if (mCallbacks != null) {
//                mCallbacks.onPostExecute();
//            }


            try {
                if(json != null) {
                    JSONObject watsonResponse = new JSONObject(json);
                    JSONObject question = watsonResponse.getJSONObject("question");
                    JSONArray evidenceArray = question.getJSONArray("evidencelist");
                    JSONObject mostLikelyValue = evidenceArray.getJSONObject(0);
                    DreamInterpreter dreamInt = new DreamInterpreter();
                    TextView answerText = (TextView) dreamInt.findViewById(R.id.watson_answer_text);
                    String mWatsonAnswerString = "";
                    mWatsonAnswerString = mostLikelyValue.get("text").toString();
                    answerText.setText(mWatsonAnswerString);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                // No valid answern
                printTryDifferentQuestion();
            }
        }

        /*
         *  Accepts all HTTPS certs. Do NOT use in production!!!
         */
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

        }};

        //End of WatsonQuery
    }


    private void printTryDifferentQuestion() {
        DreamInterpreter dreamInt = new DreamInterpreter();
        TextView textView = (TextView) dreamInt.findViewById(R.id.watson_answer_text);
        textView.setText("Please try a different question.");
    }

    private String getEncodedValues(String user_id, String user_password) {
        String textToEncode = user_id + ":" + user_password;
        byte[] data = null;
        try {
            data = textToEncode.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        return base64;
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if(activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }

 //End of class
    }

