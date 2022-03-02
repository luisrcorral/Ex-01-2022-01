// Example 1 - TC2024 2022 - Basic activity and Object managers.
// By Luis Corral

// This is the package we defined in the app wizard.
package com.example.ex_01_2022_01;

// These are the imports that are required to bring on several classes used in our code.
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// This is the definition of the activity class. The name must be the same than our file name
// (MainActivity.java). Please notice that this class inherits (extends) AppCompatActivity class.
public class MainActivity extends AppCompatActivity {

    // The following attributes are the definition of our object managers. They correspond to the
    // views (widgets) defined in our layout (XML) files. Be mindful that defining and using
    // these objects require the inclusion of the proper library (see above section "imports")
    private Button buttonOM;
    private EditText editTextOM;
    private TextView textViewOM;

    // The override annotation tells the compiler to consider this and more onCreate methods.
    // According to the activity lifecycle, onCreate is the first method executed when the
    // activity is launched.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This method, member of the AppCompatActivity class, renders the content of the
        // layout expressed in the parameter.
        setContentView(R.layout.activity_main);

        // In the following lines, we assign the object manager to the effective widget in the
        // layout file. Always consider that views in the XML file bear a name. This name is
        // used here to bind the association between the XML file and the Java object manager.
        buttonOM =  findViewById(R.id.myButton);
        editTextOM = findViewById(R.id.myInputText);
        textViewOM = findViewById(R.id.myTextView);

        // Using the button object manager, we declare here an event listener to the onClick event
        buttonOM.setOnClickListener(new View.OnClickListener() {

            // Many views may hold an onClick method. For this reason, the override
            // annotation is needed.
            @Override
            // This is the method that effectively defines what the view does when clicked
            public void onClick(View view) {
               String myTxt = "";
               // When the button is clicked, we extract the value of the EditText view. Due to
               // encapsulation and information hiding, we cannot access directly the attribute.
               // Instead, we need to use an access method. Note that such method (getText) returns
               // an Editable object, for this reason, we need to execute the toString callback.
               myTxt = editTextOM.getText().toString();

               // Similar than above, due to encapsulation principles, if we want to assign
               // a value to the attribute of an object, we bundle the value using a method.
               textViewOM.setText(myTxt);

            }
        });
    }
}