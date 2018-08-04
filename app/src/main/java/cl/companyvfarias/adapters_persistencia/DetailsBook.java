package cl.companyvfarias.adapters_persistencia;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cl.companyvfarias.adapters_persistencia.models.Book;

public class DetailsBook extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_book);

        Book bookDetails= (Book) getIntent().getSerializableExtra("Book");

        TextView  isbnTv = findViewById(R.id.isbnTv);
        TextView  descriptionTv=findViewById(R.id.descriptionTv);

        isbnTv.setText(bookDetails.getIsbn());
        descriptionTv.setText(bookDetails.getDescription());




    }
}
