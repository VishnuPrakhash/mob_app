package com.stacktips.speechtotext;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView mVoiceInputTv;
    private ImageButton mSpeakBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVoiceInputTv = (TextView) findViewById(R.id.voiceInput);
        mSpeakBtn = (ImageButton) findViewById(R.id.btnSpeak);
        mSpeakBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        });
    }

    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hello, How can I help you?");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                // create hash map
                HashMap newmap = new HashMap();

                // populate hash map
                // Ingredients
                newmap.put("sugar", "If your product contains high amount sugar, It can cause you cavities, increased fatigue, sugar addiction and obesity. Why don't you go for some other products with jaggery" + "\n");
                newmap.put("refined wheat flour", "If your product contains refined wheat flour (Maida) which is rich in carbohydrates and will quickly rise blood sugar even though it doesn't taste like sugar. Diabetic Patients stay away from this"+ "\n");

                // Shampoos
                // Below ten shampoos have the same set of highly toxic ingredients
                newmap.put("himalaya shampoo", "This shampoo nearly has 10 toxic chemicals in its ingredients. Like Ammonium lauryl sulphate, Acrylates copolymer, Dimethicone, amodimethicone, laureth-23, polyquaternium-7, fragrance,PEG-150, Climbazole, disodium EDTA, BHT, Methylchloroisothiazolinone, methylisothiazolinone,PEG-45MZ" + "\n" + "Know more:" + "\n" +
                                "Methylisothiazolinone, or MIT as it is sometimes known, is a preservative used in cosmetics and beauty products. It is a powerful biocide, or chemical substance capable of killing living organisms, usually in a selective way." + "\n" + "Methylisothiazolinone (MIT) and Methylchloroisothiazolinone (CMIT) may be hard to pronounce, but they can be even harder on the body. These common preservatives are found in many liquid personal care products, and have been linked to lung toxicity[1], allergic reactions and possible neurotoxicity[2]." + "\n"+ "Below list of shampoo has these same toxic ingredients: " + "\n" + "garnier shampoo" + "\n" +
                        "tresseme shampoo" + "\n" + "head and shoulder shampoo " + "\n" + "loreal pro-v shampoo " + "\n" + "pantene shampoo " + "\n" + "dove shampoo " + "\n" + "clinic plus shampoo " + "\n" + "sun silk shampoo" + "\n" + "clear shampoo " + "\n" + "himalaya shampoo " + "\n");
                newmap.put("tresseme shampoo", newmap.get("himalaya shampoo"));
                newmap.put("head and shoulder shampoo", newmap.get("himalaya shampoo"));
                newmap.put("loreal pro-v shampoo", newmap.get("himalaya shampoo"));
                newmap.put("pantene shampoo", newmap.get("himalaya shampoo"));
                newmap.put("dove shampoo", newmap.get("himalaya shampoo"));
                newmap.put("clinic plus shampoo", newmap.get("himalaya shampoo"));
                newmap.put("sun silk shampoo", newmap.get("himalaya shampoo"));
                newmap.put("clear shampoo", newmap.get("himalaya shampoo"));
                newmap.put("garnier shampoo", newmap.get("himalaya shampoo"));

                // Beverages
                newmap.put("Coffee Day Zest - Badam Pista Milk", "This coffee day zest has 3 toxic ingredients. sugar, milk solids, stabilizer(E 1400)" + "\n" + "Know more:" + "\n" +
                        "Sugar : Empty calories and no essential nutrients; bad for teeth as it provides easily digestible energy for the bad bacteria in mouth" + "\n" + "Milk Solids : contains fats - can cause ill effects of cholestrol like weight gain, high BP, and in the worse cases it leads to problems related to heart. " + "\n");

                newmap.put("Coffee Day Zest - Flavored Cocoa Powder", "This coffee day zest has one toxic(Sugar) and 4 moderate(Glucose, salt, INS 300, INS 322 and Emulsifier - Soya Lecithin) ingredients." + "\n" + "Know more:" + "\n" + "Glucose : Glucose powder can cause allergic reaction, like rash; hives; itching; red, swollen, blistered, or peeling skin with or without fever; wheezing; tightness in the chest or throat; trouble breathing, swallowing, or talking; unusual hoarseness; or swelling of the mouth, face, lips, tongue, or throat. Very bad dizziness or passing out." + "\n" + "INS 322 : Higher doses of INS 322 can cause various problems and side effects which include gastrointestinal problems, diarrhea, either weight gain or loss of appetite, rashes, headache, nausea, dizziness, vomiting." + "\n");

                // Biscuits
                newmap.put("Britannia Bourbon Biscuits", "This Biscuits nearly has 7 toxic adulterate in its ingredients. Like Refined Wheat Flour, Sugar, Edible Vegetable Oil, Milk solids, Natural Colour(E150a, E150d), Synthetic Food colour(E102, E110, E122, E133)" + "\n" + "Know more:" + "\n" +
                                "Natural Colour(E150a, E150d) : E150a - May cause skin burns and permanent eye damage. Toxic material which may cause life threatening effects even in small amounts and with short exposure. May cause serious and prolonged health effects on short or long term exposure. May cause irritation (redness, rash) or less serious toxicity." + "\n" +
                        "E150d -  Intestinal problems may occur after ingestion of large amounts " + "\n" + "Synthetic Food colour(E102, E110, E122, E133) : E102 - Tartrazine is a synthetic yellow azo dye derived from coal tar and has been banned in several countries (Austria, Norway) because of serious side effects such as causing potentially lethal asthma attacks and nettle rash, hives, DNA damage, tumors of the thyroid and ADHD." + "\n" + "E110 - Can cause runny nose, nasal congestion, hives, allergies, kidney tumors, chromosomal damage, hyperactivity, abdominal pain, nausea and vomiting, indigestion and a lott of appetite or taste for food" + "\n" +
                        "E122 - can cause allergic reactions, rashes – such as hives – as well as skin swelling. People with asthma often react badly to it. " + "\n" + "E133 - can cause can cause symptoms such as headaches, nausea, dizziness, muscle pain, palpitations and even pain. " + "\n");

                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if(newmap.get(result.get(0)) !=  null){
                        mVoiceInputTv.setText("\n"+ result.get(0) + "\n" + newmap.get(result.get(0)).toString());
                    }
                    else {
                        Intent myIntent = new Intent(this, Main2Activity.class);
                        myIntent.putExtra("map", newmap);
                        startActivity(myIntent);
                    }
                }
                break;
            }

        }
    }
}
